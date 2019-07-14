package com.example.weatherSearch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.weatherSearch.dao.IWeatherDao;
import com.example.weatherSearch.entity.model.CityModel;
import com.example.weatherSearch.entity.model.WeatherModel;

/**
 * The Class WeatherService.
 */
@Service(value = "weatherService")
public class WeatherService implements IWeatherService{

	/** The weather dao. */
	@Autowired
	private IWeatherDao weatherDao;
	
	/* (non-Javadoc)
	 * @see com.example.weatherSearch.service.IWeatherService#getWeatherByCity(java.lang.String)
	 */
	public WeatherModel getWeatherByCity(String location) {		
		WeatherModel weatherModel = new WeatherModel();
		return weatherModel;
	}
	
	/* (non-Javadoc)
	 * @see com.example.weatherSearch.service.IWeatherService#getCityList()
	 */
	public CityModel getCityList() {
		return this.weatherDao.getCityList();
	}
}
