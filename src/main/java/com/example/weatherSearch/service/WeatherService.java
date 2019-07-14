package com.example.weatherSearch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.weatherSearch.dao.IWeatherDao;
import com.example.weatherSearch.entity.model.CityModel;
import com.example.weatherSearch.entity.model.WeatherModel;

@Service(value = "weatherService")
public class WeatherService implements IWeatherService{

	@Autowired
	private IWeatherDao weatherDao;
	
	public WeatherModel getWeatherByCity(String location) {		
		WeatherModel weatherModel = new WeatherModel();
		return weatherModel;
	}
	
	public CityModel getCityList() {
		return this.weatherDao.getCityList();
	}
}
