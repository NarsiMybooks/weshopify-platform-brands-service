package com.weshopify.platform.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weshopify.platform.BrandsBean;
import com.weshopify.platform.entity.Brands;
import com.weshopify.platform.entity.Category;
import com.weshopify.platform.repo.WeshopifyBrandsRepo;

@Service
public class WeshopifyBrandsServiceImpl implements WeshopifyBrandsService {

	@Autowired
	private WeshopifyBrandsRepo brandsRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public BrandsBean createOrUpdateBrands(BrandsBean bransBean) {
		Brands brands = modelMapper.map(bransBean, Brands.class);
		List<Category> catList = new ArrayList<>();
		bransBean.getCatList().stream().forEach(catid->{
			//categoryRepo.findById(catId);
			Category category = new Category();
			category.setId(catid);
			catList.add(category);
		});
		brands.setCategories(catList);
		brands = brandsRepo.save(brands);
		bransBean = mapEntityToBean(brands);
		return bransBean;
	}

	@Override
	public List<BrandsBean> findAllBrands() {
		List<BrandsBean> brandsList = new ArrayList<>();
		brandsRepo.findAll().forEach(brands -> {
			brandsList.add(mapEntityToBean(brands));
		});
		return brandsList;
	}

	@Override
	public BrandsBean findBrandsById(int id) {
		Brands brand = brandsRepo.findById(id).get();
		return mapEntityToBean(brand);
	}

	@Override
	public BrandsBean findBrandsByName(String name) {
		return mapEntityToBean(brandsRepo.findBrandsByName(name));
	}

	@Override
	public List<BrandsBean> deleteBrands(int id) {
		brandsRepo.deleteById(id);
		return findAllBrands();
	}

	private BrandsBean mapEntityToBean(Brands brands) {
		BrandsBean savedBrands = modelMapper.map(brands, BrandsBean.class);
		List<Integer> catList = Optional.ofNullable(brands.getCategories()).get().stream().map(cat -> cat.getId())
				.collect(Collectors.toList());
		savedBrands.setCatList(catList);
		return savedBrands;
	}

}
