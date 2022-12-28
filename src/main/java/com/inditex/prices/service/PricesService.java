package com.inditex.prices.service;

import java.sql.Timestamp;

import com.inditex.prices.DTO.PricesDTO;

/**
 * @author acarriog
 * Interfaz servicio Prices
 */
public interface PricesService {

	
	/**
	 * Método de servicio encargado de consultar el precio final aplicable para el producto y fechas especificadas
	 * @param productId (Long) identificador del producto
	 * @param brandId (int) identificador de la cadena
	 * @param dateParameter (Timestamp) fecha de aplicación
	 * @return PricesDTO ()
	 */
	PricesDTO findPricesAplicable(Long productId, int brandId, Timestamp dateParameter);
}
