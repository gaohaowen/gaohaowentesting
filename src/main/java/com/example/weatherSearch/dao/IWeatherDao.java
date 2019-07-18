package com.example.weatherSearch.dao;

import org.springframework.stereotype.Repository;

import com.example.weatherSearch.entity.domain.WeatherDomain;
import com.example.weatherSearch.entity.model.CityPoolModel;

/**
 * The Interface IWeatherDao.
 */
@Repository
public interface IWeatherDao {
	
	/**
	 * Gets the weather by city.
	 *
	 * @param location the location
	 * @return the weather by city
	 */
	public WeatherDomain getWeatherByCity (String location) throws Exception;
	
	/**
	 * Gets the city list.
	 *
	 * @return the city list
	 */
	public CityPoolModel getCityList() throws Exception;
}
