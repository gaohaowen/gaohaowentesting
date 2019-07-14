package com.example.weatherSearch.utility;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import com.example.weatherSearch.enumData.ResultEnums;
import com.example.weatherSearch.exception.WeatherException;

/**
 * The Class WeatherUtility.
 */
public class WeatherUtility {

	/**
	 * Gets the weather resource.
	 *
	 * @param urlStr the url str
	 * @return the weather resource
	 */
	public static String getWeatherResource(String urlStr) {	
		StringBuffer resultBuffer = new StringBuffer();
		try {
	        URL url = new URL(urlStr);
	        InputStream in =url.openStream();
	        InputStreamReader isr = new InputStreamReader(in);
	        BufferedReader bufr = new BufferedReader(isr);
	        String tempLine;
	        while ((tempLine = bufr.readLine()) != null) {
	        	resultBuffer.append(tempLine);
	        }
	        bufr.close();
	        isr.close();
	        in.close();
	    } catch (Exception e) {    	
	        e.printStackTrace();
	        throw new WeatherException(ResultEnums.BUSSINESS_ERROR.getCode(), "call weather resource error");
	    }
		return resultBuffer.toString();
	}
}
