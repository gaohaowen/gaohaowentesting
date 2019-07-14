package com.example.weatherSearch.dao;

import org.springframework.stereotype.Repository;

import com.example.weatherSearch.entity.domain.WeatherDomain;
import com.example.weatherSearch.entity.model.CityModel;

@Repository(value = "weatherDao")
public class WeatherDao implements IWeatherDao{
	
	private String url_now = "https://api.seniverse.com/v3/weather/now.json?key=SpuAxDsc1_gNdlv27&location=LOCATION";

	public WeatherDomain getWeatherByCity(String location) {
		WeatherDomain weatherDomain = null;
		return weatherDomain;
	}
	
	public CityModel getCityList() {

		CityModel cityModel = new CityModel();
		return cityModel;
	}
}
