package com.weshopify.platform.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.weshopify.platform.BrandsBean;
import com.weshopify.platform.service.WeshopifyBrandsService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BrandsResource {

	@Autowired
	private WeshopifyBrandsService brandsService;
	
	@PostMapping(value = {"/brands"})
	public ResponseEntity<BrandsBean> createBrands(@RequestBody BrandsBean brandsBean){
		return ResponseEntity.ok(brandsService.createOrUpdateBrands(brandsBean));
	}
	
	@GetMapping(value = {"/brands"})
	public ResponseEntity<List<BrandsBean>> findAllBrands(){
		return ResponseEntity.ok(brandsService.findAllBrands());
	}
	
	
}
