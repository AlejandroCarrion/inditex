package com.inditex.prices.DTO;

import java.sql.Timestamp;

/**
 * @author acarriog
 * DTO de la entidad Prices
 * 
 */
public class PricesDTO {

	private Long productId;
	private BrandDTO brand;
	private int priceList;
	private Timestamp startDate;
	private Timestamp endDate;
	private Double price;
	private String curr;

	public PricesDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PricesDTO(Long productId, BrandDTO brand, int priceList, Timestamp startDate, Timestamp endDate,
			Double price, String curr) {
		super();
		this.productId = productId;
		this.brand = brand;
		this.priceList = priceList;
		this.startDate = startDate;
		this.endDate = endDate;
		this.price = price;
		this.curr = curr;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public int getPriceList() {
		return priceList;
	}

	public void setPriceList(int priceList) {
		this.priceList = priceList;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Timestamp getEndDate() {
		return endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public BrandDTO getBrand() {
		return brand;
	}

	public void setBrand(BrandDTO brand) {
		this.brand = brand;
	}

	public String getCurr() {
		return curr;
	}

	public void setCurr(String curr) {
		this.curr = curr;
	}
	
	

}
