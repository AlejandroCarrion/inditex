package com.inditex.prices;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.inditex.prices.entity.Brand;
import com.inditex.prices.entity.Prices;
import com.inditex.prices.repository.BrandRepository;
import com.inditex.prices.repository.PricesRepository;

/**
 * @author acarriog
 * Clase principal de la aplicación Spring Boot encargada de arrancar la aplicación
 */
@SpringBootApplication
public class PricesApplication {

	private static final Logger log = LoggerFactory.getLogger(PricesApplication.class);

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	/**
	 * Método main() encargado de arrancar la aplicación Spring 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(PricesApplication.class, args);
	}
	

	/**
	 * Método createH2DB() encargado de crear la base datos H2 (db en memoria)
	 * @param pricesRepository (PricesRepository)
	 * @param brandRepository (BrandRepository)
	 * @return CommandLineRunner
	 */
	@Bean
	public CommandLineRunner createH2DB(PricesRepository pricesRepository, BrandRepository brandRepository) {
		return (args) -> {
			brandRepository.save(new Brand(1,"ZARA"));
			List<Prices> pricesList = new ArrayList<Prices>();
			pricesList.add(new Prices(new Brand(1,""), Timestamp.valueOf("2020-06-14 00:00:00"),
					Timestamp.valueOf("2020-12-31 23:59:59"), 1, 35455L, 0, 35.50, "EUR"));
			pricesList.add(new Prices(new Brand(1,""), Timestamp.valueOf("2020-06-14 15:00:00"),
					Timestamp.valueOf("2020-06-14 18:30:00"), 2, 35455L, 1, 25.45, "EUR"));
			pricesList.add(new Prices(new Brand(1,""), Timestamp.valueOf("2020-06-15 00:00:00"),
					Timestamp.valueOf("2020-06-15 11:00:00"), 3, 35455L, 1, 30.50, "EUR"));
			pricesList.add(new Prices(new Brand(1,""), Timestamp.valueOf("2020-06-15 16:00:00"),
					Timestamp.valueOf("2020-12-31 23:59:59"), 4, 35455L, 1, 38.95, "EUR"));
			pricesRepository.saveAll(pricesList);
		};
	}

}
