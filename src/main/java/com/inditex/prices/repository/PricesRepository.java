package com.inditex.prices.repository;

import java.sql.Timestamp;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inditex.prices.entity.Prices;



public interface PricesRepository extends JpaRepository<Prices, Long> {
	
	@Transactional
	@Query("SELECT p FROM prices p "
			+ "WHERE p.priority = "
			+ "(SELECT MAX(pr.priority) FROM prices pr) AND "
			+ "p.productId = :productId AND "
			+ "p.brand.brandId = :brandId AND "
			+ ":dateParameter BETWEEN p.startDate AND p.endDate")
	public Prices findPricesAplicable(@Param("productId") Long productId,@Param("brandId") int brandId, @Param("dateParameter") Timestamp dateParameter);


}
