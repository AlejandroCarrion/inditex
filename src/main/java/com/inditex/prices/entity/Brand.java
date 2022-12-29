package com.inditex.prices.entity;



import javax.persistence.*;

import lombok.Data;

/**
 * @author acarriog
 * Entidad de la tabla brand la cual obtiene los datos de la categoria 
 * (brand_id (Brand), brand_name (String)
 * 
 */
@Data
@Entity(name="brand")
public class Brand {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "brand_id")
    private int brandId;
	
	@Column(name = "brand_name")
	private String brandName;
	
	public Brand() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Brand(int brandId, String brandName) {
		super();
		this.brandId = brandId;
		this.brandName = brandName;
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	
}
