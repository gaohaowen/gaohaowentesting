package com.example.weatherSearch.service;

import org.springframework.stereotype.Service;

import com.example.weatherSearch.entity.model.CityModel;
import com.example.weatherSearch.entity.model.WeatherModel;

/**
 * The Interface IWeatherService.
 */
@Service
public interface IWeatherService {
	
	/**
	 * Gets the weather by city.
	 *
	 * @param location the location
	 * @return the weather by city
	 */
	public WeatherModel getWeatherByCity(String location); 
	
	/**
	 * Gets the city list.
	 *
	 * @return the city list
	 */
	public CityModel getCityList();
}

