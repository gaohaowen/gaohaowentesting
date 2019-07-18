package com.example.weatherSearch.entity.model;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class CityPoolModel.
 */
public class CityPoolModel {
	
	/** The city model. */
	private List<CityModel> cityModel;

	/**
	 * Gets the city model.
	 *
	 * @return the city model
	 */
	public List<CityModel> getCityModel() {
		if(this.cityModel == null)
		{
			this.cityModel = new ArrayList<CityModel>();
		}
		return cityModel;
	}

	/**
	 * Sets the city model.
	 *
	 * @param cityModel the new city model
	 */
	public void setCityModel(List<CityModel> cityModel) {
		this.cityModel = cityModel;
	}
}
