package com.inditex.prices.service.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.inditex.prices.DTO.PricesDTO;
import com.inditex.prices.entity.Prices;
import com.inditex.prices.exceptions.RequestException;
import com.inditex.prices.repository.PricesRepository;
import com.inditex.prices.service.PricesService;

/**
 * @author acarriog
 * Implementación del servicio PricesService
 */
@Service
public class PricesServiceImpl implements PricesService{
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
    private PricesRepository pricesRespository;

	
	/**
	 * Implementación método findPricesAplicable del servicio findPricesAplicable()
	 */
	@Override
	public PricesDTO findPricesAplicable(Long productId, int brandId, Timestamp dateParameter) {
		PricesDTO pricesResponse = null;
		
		try {
			Prices prices = pricesRespository.findPricesAplicable(productId, brandId, dateParameter);
			if(prices==null) {
				// Excepción precio aplicable no encontrado 
				throw new RequestException("404","precio aplicable no encontrado");
			}else {
				pricesResponse = modelMapper.map(prices, PricesDTO.class);
			}
		}catch (DataAccessException ex) {
			// Excepción acceso base de datos fallido
			throw new RequestException("P-402",ex.getLocalizedMessage());
		}
		return pricesResponse;
	}


}
