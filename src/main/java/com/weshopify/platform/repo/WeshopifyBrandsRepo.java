package com.weshopify.platform.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.weshopify.platform.entity.Brands;

public interface WeshopifyBrandsRepo
		extends CrudRepository<Brands, Integer>, PagingAndSortingRepository<Brands, Integer> {

	@Query("from Brands b where b.name=:name")
	Brands findBrandsByName(@Param("name") String name);
}
