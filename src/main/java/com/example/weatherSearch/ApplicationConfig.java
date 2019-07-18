package com.example.weatherSearch;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.example.weatherSearch.entity.model.CityPoolModel;
import com.example.weatherSearch.utility.WeatherUtility;
import com.google.gson.Gson;

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
	public CityPoolModel registerCityPool()
	{
		String cityList = WeatherUtility.getCityList();
		
		Gson gson = new Gson();
		CityPoolModel cityPoolModel = gson.fromJson(cityList, CityPoolModel.class);
		Collections.sort(cityPoolModel.getCityModel(), (s1, s2) -> s1.getId().substring(0).compareTo(s2.getId().substring(0)));
		return cityPoolModel;
	}
}
