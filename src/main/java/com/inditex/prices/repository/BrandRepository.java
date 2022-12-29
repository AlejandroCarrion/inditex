package com.inditex.prices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inditex.prices.entity.Brand;

/**
 * @author acarriog
 * interfaz BrandRepository la cual extiende de la clase JpaRepository y accederá a la base de datos mediante métodos definidos en la interfaz JpaRepository
 *
 */
public interface BrandRepository extends JpaRepository<Brand, Long> {
	
	

}
