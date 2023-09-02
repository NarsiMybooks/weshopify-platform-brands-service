package com.weshopify.platform;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class BrandsBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7164446029363332775L;
	
	private int id;
	private String name;
	private String logoPath;
	private List<Integer> catList;

}
