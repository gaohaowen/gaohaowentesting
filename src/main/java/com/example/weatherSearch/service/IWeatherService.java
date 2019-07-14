package com.example.weatherSearch.service;

import org.springframework.stereotype.Service;

import com.example.weatherSearch.entity.model.CityModel;
import com.example.weatherSearch.entity.model.WeatherModel;

@Service
public interface IWeatherService {
	
	public WeatherModel getWeatherByCity(String location); 
	
	public CityModel getCityList();
}

