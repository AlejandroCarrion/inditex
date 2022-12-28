package com.inditex.prices.controller;

import java.sql.Timestamp;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.prices.DTO.PricesDTO;
import com.inditex.prices.exceptions.RequestException;
import com.inditex.prices.service.PricesService;


/**
 * @author acarriog
 * Controlador PricesController encargado de gestionar los end points /prices
 */
@RestController
@RequestMapping(value = "/prices")
public class PricesController {

	@Autowired
	private PricesService pricesService;

		
	/** 
	 * End point encargado de consultar el precio final aplicable para el producto y fechas especificadas
	 * @param Timestamp dateParameter fecha de aplicación
	 * @param Long productId identificador del producto
	 * @param int brandId identificador de la cadena
	 * @return PricesDTO
	 */
	@GetMapping
	public PricesDTO findPricesAplicable(@QueryParam("dateParameter") Timestamp dateParameter, @QueryParam("productId") Long productId,@QueryParam("brandId") int brandId) {
		if(dateParameter.toString().equals("") || dateParameter == null) {
			// Excepción campo fecha de aplicación vacío
			throw new RequestException("401","fecha de aplicación requerida");			
		}
		if(productId == null) {
			// Excepción campo identificador producto vacío
			throw new RequestException("402","identificador de producto requerido");
		}
		if(Integer.toString(brandId).equals("") || brandId < 0) {
			// Excepción campo identificador cadena vacío
			throw new RequestException("403","identificador de cadena requerido");
		}
		
		PricesDTO pricesDTO = pricesService.findPricesAplicable(productId,brandId, dateParameter); 
				
		return pricesDTO;
	}



}
