package com.weshopify.platform.service;

import java.util.List;

import com.weshopify.platform.BrandsBean;

public interface WeshopifyBrandsService {

	BrandsBean createOrUpdateBrands(BrandsBean bransBean);
	List<BrandsBean> findAllBrands();
	BrandsBean findBrandsById(int id);
	BrandsBean findBrandsByName(String name);
	List<BrandsBean> deleteBrands(int id);
	
	
}
