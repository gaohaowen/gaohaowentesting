package com.example.weatherSearch.converter;

import java.time.OffsetDateTime;

import com.example.weatherSearch.entity.domain.Results;
import com.example.weatherSearch.entity.domain.WeatherDomain;
import com.example.weatherSearch.entity.model.WeatherModel;

/**
 * The Class ConvertWeatherData.
 */
public class ConvertWeatherData {

	/**
	 * Convert.
	 *
	 * @param weatherDomain the weather domain
	 * @return the weather model
	 */
	public static WeatherModel convert(final WeatherDomain weatherDomain)
	{
		WeatherModel weatherModel = null;
		if(weatherDomain != null && (weatherDomain.getResults() != null) && (weatherDomain.getResults().size() >0))
		{
			Results weatherResults = weatherDomain.getResults().get(0);
			
			weatherModel = new WeatherModel();
			if(weatherResults.getLocation() != null)
			{
				weatherModel.setCity(weatherResults.getLocation().getName());
			}
			
			if(weatherResults.getNow() != null)
			{
				weatherModel.setWeather(weatherResults.getNow().getText());
				weatherModel.setWind(weatherResults.getNow().getWind_direction());
				weatherModel.setTemperature(weatherResults.getNow().getTemperature());
			}
			
			OffsetDateTime lastUpdate = OffsetDateTime.parse(weatherResults.getLast_update());
			weatherModel.setUpdateTime(lastUpdate.toLocalDateTime().toString());
		}
		return weatherModel;
	}
}
