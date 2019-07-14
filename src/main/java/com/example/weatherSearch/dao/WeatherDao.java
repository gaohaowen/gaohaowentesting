package com.example.weatherSearch.dao;

import org.springframework.stereotype.Repository;

import com.example.weatherSearch.entity.domain.WeatherDomain;
import com.example.weatherSearch.entity.model.CityModel;

/**
 * The Class WeatherDao.
 */
@Repository(value = "weatherDao")
public class WeatherDao implements IWeatherDao{
	
	/** The url now. */
	private String url_now = "https://api.seniverse.com/v3/weather/now.json?key=SpuAxDsc1_gNdlv27&location=LOCATION";

	/* (non-Javadoc)
	 * @see com.example.weatherSearch.dao.IWeatherDao#getWeatherByCity(java.lang.String)
	 */
	public WeatherDomain getWeatherByCity(String location) {
		WeatherDomain weatherDomain = null;
		return weatherDomain;
	}
	
	/* (non-Javadoc)
	 * @see com.example.weatherSearch.dao.IWeatherDao#getCityList()
	 */
	public CityModel getCityList() {

		CityModel cityModel = new CityModel();
		return cityModel;
	}
}
