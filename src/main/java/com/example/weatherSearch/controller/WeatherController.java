package com.example.weatherSearch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.weatherSearch.entity.model.CityPoolModel;
import com.example.weatherSearch.entity.model.ResponseData;
import com.example.weatherSearch.entity.model.WeatherModel;
import com.example.weatherSearch.service.IWeatherService;
import com.example.weatherSearch.utility.ResponseDataUtil;

/**
 * The Class WeatherController.
 */
@RestController
@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600)
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
		final CityPoolModel cityPoolModel = this.weatherService.getCityList();
		return ResponseDataUtil.buildSuccess(cityPoolModel);
	}
	
	/**
	 * Index.
	 *
	 * @return the string
	 */
	@RequestMapping("/")
    public String index()
    {
        return "forward:/index.html";
    }
}
