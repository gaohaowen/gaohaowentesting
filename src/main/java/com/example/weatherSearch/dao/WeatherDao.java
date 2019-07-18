package com.example.weatherSearch.dao;

import java.net.URLEncoder;
import java.text.MessageFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.example.weatherSearch.entity.domain.WeatherDomain;
import com.example.weatherSearch.entity.model.CityModel;
import com.example.weatherSearch.entity.model.CityPoolModel;
import com.example.weatherSearch.enumData.ResultEnums;
import com.example.weatherSearch.exception.WeatherException;
import com.example.weatherSearch.utility.WeatherUtility;
import com.google.gson.Gson;

/**
 * The Class WeatherDao.
 */
@Repository(value = "weatherDao")
public class WeatherDao implements IWeatherDao{
	
	/** The city model. */
	@Autowired
	private CityPoolModel cityPoolModel;
	
	@Value("${weather.service}")
	private String weatherService;
	
	@Value("${private.key.path}")
	private String privateKeyPath;

	/* (non-Javadoc)
	 * @see com.example.weatherSearch.dao.IWeatherDao#getWeatherByCity(java.lang.String)
	 */
	public WeatherDomain getWeatherByCity(String location) throws Exception{
		WeatherDomain weatherDomain = null;
		try {
			location = URLEncoder.encode(location, "utf-8");
			
			String privateKey = WeatherUtility.getPrivateKey(privateKeyPath);
			String resourcePath = MessageFormat.format(weatherService, privateKey, location);
			String weatherRs = WeatherUtility.getWeatherResource(resourcePath);
			
			Gson gson = new Gson();
			weatherDomain = gson.fromJson(weatherRs, WeatherDomain.class);
		} catch (Exception e) {
			e.printStackTrace();
			throw new WeatherException(ResultEnums.BUSSINESS_ERROR.getCode(), "call get WeatherByCity error");
		}
		
		return weatherDomain;
	}
	
	/* (non-Javadoc)
	 * @see com.example.weatherSearch.dao.IWeatherDao#getCityList()
	 */
	public CityPoolModel getCityList() throws Exception{
		if(cityPoolModel == null)
		{
			throw new WeatherException(ResultEnums.BUSSINESS_ERROR.getCode(), "call get CityList error");
		}
		return cityPoolModel;
	}
}
