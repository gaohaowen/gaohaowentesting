package com.example.weatherSearch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.weatherSearch.entity.model.CityModel;
import com.example.weatherSearch.entity.model.WeatherModel;
import com.example.weatherSearch.service.IWeatherService;

@RestController
@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RequestMapping("/api")
public class WeatherController {

	@Autowired
	private IWeatherService weatherService;
	
	@GetMapping("/weather/{location}")
	@ResponseBody
	public WeatherModel getWeatherByCity(@PathVariable("location") String location) {
		return this.weatherService.getWeatherByCity(location);
	}

	
	@GetMapping("/cities")	
	public CityModel getCities() {
		return this.weatherService.getCityList();
	}
	
	@GetMapping("/")	
	public String defaultPage() {
		return "Hello World";
	}
}
