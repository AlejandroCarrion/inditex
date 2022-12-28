package com.inditex.prices.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.sql.Timestamp;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.inditex.prices.DTO.BrandDTO;
import com.inditex.prices.DTO.PricesDTO;
import com.inditex.prices.entity.Prices;
import com.inditex.prices.exceptions.RequestException;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class PricesControllerTest {
	@Autowired
	PricesController pricessController;

	@Mock
	Prices prices;

	@Rule
	public ExpectedException exceptionRule  = ExpectedException.none();
	
	/**
	 * Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)
	 */
	@Test
	public void test_endpoint_1()  {		
		assertThrows(RequestException.class,() -> {
                pricessController.findPricesAplicable(Timestamp.valueOf("2020-06-14 00:00:00.000"), 35455L, 1);
        });
	}
	/**
	 * Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)
	 */
	@Test
	public void test_endpoint_2() {
		PricesDTO prices = new PricesDTO(35455L, new BrandDTO(1,""),2,Timestamp.valueOf("2020-06-14 15:00:00"),
				Timestamp.valueOf("2020-06-14 18:30:00"), 25.45, "EUR");
		PricesDTO result = pricessController.findPricesAplicable(Timestamp.valueOf("2020-06-14 16:00:00.000"), 35455L, 1);
		Assertions.assertThat(result.getPrice()).isEqualTo(prices.getPrice());
	}
	
	/**
	 * Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)
	 */
	@Test
	public void test_endpoint_3() {
		assertThrows(RequestException.class,() -> {
			pricessController.findPricesAplicable(Timestamp.valueOf("2020-06-14 21:00:00.000"), 35455L, 1);
		});
	}
	
	
	/**
	 * Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)
	 */
	@Test
	public void test_endpoint_4() {
		PricesDTO prices = new PricesDTO(35455L, new BrandDTO(1,""),3, Timestamp.valueOf("2020-06-15 00:00:00"),
				Timestamp.valueOf("2020-06-15 11:00:00"), 30.50, "EUR");
		PricesDTO result = pricessController.findPricesAplicable(Timestamp.valueOf("2020-06-15 10:00:00.000"), 35455L, 1);
		Assertions.assertThat(result.getPrice()).isEqualTo(prices.getPrice());
	}
	
	/**
	 * Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)
	 */
	@Test
	public void test_endpoint_5() {
		PricesDTO prices = new PricesDTO(35455L, new BrandDTO(1,""), 4,Timestamp.valueOf("2020-06-15 16:00:00"),
				Timestamp.valueOf("2020-12-31 23:59:59"), 38.95, "EUR");
		PricesDTO result = pricessController.findPricesAplicable(Timestamp.valueOf("2020-06-16 21:00:00.000"), 35455L, 1);
		Assertions.assertThat(result.getPrice()).isEqualTo(prices.getPrice());
	}
}