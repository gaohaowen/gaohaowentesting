package com.example.weatherSearch.dao;

import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.weatherSearch.entity.domain.WeatherDomain;
import com.example.weatherSearch.entity.model.CityModel;
import com.example.weatherSearch.utility.WeatherUtility;
import com.google.gson.Gson;

/**
 * The Class WeatherDao.
 */
@Repository(value = "weatherDao")
public class WeatherDao implements IWeatherDao{
	
	/** The city model. */
	@Autowired
	private CityModel cityModel;
	
	/** The url now. */
	private String url_now = "https://api.seniverse.com/v3/weather/now.json?key=SpuAxDsc1_gNdlv27&location=LOCATION";

	/* (non-Javadoc)
	 * @see com.example.weatherSearch.dao.IWeatherDao#getWeatherByCity(java.lang.String)
	 */
	public WeatherDomain getWeatherByCity(String location) {
		WeatherDomain weatherDomain = null;
		try {
			location = URLEncoder.encode(location, "utf-8");
			String weatherRs = WeatherUtility.getWeatherResource(url_now.replace("LOCATION", location));
			
			Gson gson = new Gson();
			weatherDomain = gson.fromJson(weatherRs, WeatherDomain.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return weatherDomain;
	}
	
	/* (non-Javadoc)
	 * @see com.example.weatherSearch.dao.IWeatherDao#getCityList()
	 */
	public CityModel getCityList() {

		return cityModel;
	}
}
