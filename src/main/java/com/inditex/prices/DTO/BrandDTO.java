package com.inditex.prices.DTO;

/**
 * @author acarriog
 * DTO de la entidad Brand
 */
public class BrandDTO {

	private int brandId;
	private String brandName;

	public BrandDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BrandDTO(int brandId, String brandName) {
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
