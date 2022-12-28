package com.inditex.prices.entity;

import java.sql.Timestamp;

import javax.persistence.*;


import lombok.Data;


/**
 * @author acarriog
 * Entidad de la tabla prices la cual obtiene los datos de los precios 
 * id (int), brand_id (Brand), start_date (Timestamp), end_date (Timestamp), price_list (int), product_id (Long), priority (int), price (Double), curr (String)
 * 
 */
@Data
@Entity(name="prices")
public class Prices {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
	
    @ManyToOne
    @JoinColumn(name="brand_id")
    private Brand brand;
    
    @Column(name = "start_date")
	private Timestamp startDate;
	

    @Column(name = "end_date")
	private Timestamp endDate;
	

    @Column(name = "price_list")
	private int priceList;
	

    @Column(name = "product_id")
	private Long productId;
	

    @Column(name = "priority")
	private int priority;
	

    @Column(name = "price")
	private Double price;
	

    @Column(name = "curr")
	private String curr;
	
	public Prices() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Prices(Brand brand ,Timestamp startDate, Timestamp endDate,
			int priceList, Long productId, int priority, Double price, String curr) {
		super();
		this.brand = brand;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priceList = priceList;
		this.productId = productId;
		this.priority = priority;
		this.price = price;
		this.curr = curr;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public int getPriceList() {
		return priceList;
	}

	public void setPriceList(int priceList) {
		this.priceList = priceList;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getCurr() {
		return curr;
	}

	public void setCurr(String curr) {
		this.curr = curr;
	}

	
}
