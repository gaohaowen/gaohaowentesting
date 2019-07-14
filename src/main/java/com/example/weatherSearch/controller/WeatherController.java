package com.example.weatherSearch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.weatherSearch.entity.model.CityModel;
import com.example.weatherSearch.entity.model.ResponseData;
import com.example.weatherSearch.entity.model.WeatherModel;
import com.example.weatherSearch.service.IWeatherService;
import com.example.weatherSearch.utility.ResponseDataUtil;

/**
 * The Class WeatherController.
 */
@RestController
@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RequestMapping("/api")
public class WeatherController {

	/** The weather service. */
	@Autowired
	private IWeatherService weatherService;
	
	/**
	 * Gets the weather by city.
	 *
	 * @param location the location
	 * @return the weather by city
	 */
	@GetMapping("/weather/{location}")
	@ResponseBody
	@SuppressWarnings({"rawtypes" })
	public ResponseData getWeatherByCity(@PathVariable("location") String location) throws Exception{
		final WeatherModel weatherModel = this.weatherService.getWeatherByCity(location);
		return ResponseDataUtil.buildSuccess(weatherModel);
	}

	
	/**
	 * Gets the cities.
	 *
	 * @return the cities
	 */
	@GetMapping("/cities")
	@SuppressWarnings({"rawtypes" })
	public ResponseData getCities() throws Exception{
		final CityModel cityModel = this.weatherService.getCityList();
		return ResponseDataUtil.buildSuccess(cityModel);
	}
	
	/**
	 * Default page.
	 *
	 * @return the string
	 */
	@GetMapping("/")	
	public String defaultPage() throws Exception{
		return "Hello World";
	}
}
