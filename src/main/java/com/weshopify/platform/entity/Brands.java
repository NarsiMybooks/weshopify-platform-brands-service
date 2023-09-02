package com.weshopify.platform.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "brand")
@Data
public class Brands extends IdBasedEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 864765418740153649L;
	
	@Column(unique = true)
	private String name;
	private String logo;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Category> categories;

}
