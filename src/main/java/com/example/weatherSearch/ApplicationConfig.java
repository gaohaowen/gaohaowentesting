package com.example.weatherSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.example.weatherSearch.entity.model.CityModel;

/**
 * The Class ApplicationConfig.
 */
@EnableCaching
@Configuration
@ComponentScan
@PropertySource("classpath:resources/cityConfig.properties")
@EnableAutoConfiguration
public class ApplicationConfig {

	/** The city pool. */
	@Value("${weather.city.pool}")
	private String cityPool;
	
	/**
	 * Register city pool.
	 *
	 * @return the city model
	 */
	@Bean
	public CityModel registerCityPool()
	{
		final CityModel cityModel = new CityModel();
		String [] cities = this.cityPool.split(",");
		
		List<String> cityList = new ArrayList<String>(Arrays.asList(cities));
		cityModel.setCities(cityList);
		
		return cityModel;
	}
}
