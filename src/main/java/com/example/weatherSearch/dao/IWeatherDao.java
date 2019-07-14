package com.example.weatherSearch.dao;

import org.springframework.stereotype.Repository;

import com.example.weatherSearch.entity.domain.WeatherDomain;
import com.example.weatherSearch.entity.model.CityModel;

@Repository
public interface IWeatherDao {
	
	public WeatherDomain getWeatherByCity(String location);
	
	public CityModel getCityList();
}
