package com.example.weatherSearch.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.core.io.ClassPathResource;

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
		InputStream in = null;
		InputStreamReader isr = null;
		BufferedReader bufr = null;
		try {
	        URL url = new URL(urlStr);
	        in =url.openStream();
	        isr = new InputStreamReader(in);
	        bufr = new BufferedReader(isr);
	        String tempLine;
	        while ((tempLine = bufr.readLine()) != null) {
	        	resultBuffer.append(tempLine);
	        }
	        bufr.close();
	        isr.close();
	        in.close();
	    } catch (IOException e) {    	
	        e.printStackTrace();
	        throw new WeatherException(ResultEnums.BUSSINESS_ERROR.getCode(), "call weather resource error");
	    } finally {
	    	try {
	    		if(bufr != null)
	    		{
	    			bufr.close();
	    		}
	    		if(isr != null)
	    		{
	    			isr.close();
	    		}
		        if(in != null)
		        {
		        	in.close();
		        }	        
	    	}catch (IOException e) {    	
		        e.printStackTrace();
		        throw new WeatherException(ResultEnums.BUSSINESS_ERROR.getCode(), "call weather resource error");
		    }
	    	 
	    }
		return resultBuffer.toString();
	}
	
	public static String getPrivateKey(String fileName) {
		StringBuffer sb = new StringBuffer();
		try {
			Files.readAllLines(Paths.get(fileName)).forEach(sb::append);
        } catch (IOException e) {
        	e.printStackTrace();
	        throw new WeatherException(ResultEnums.BUSSINESS_ERROR.getCode(), "call weather resource error");
        }
		
		return sb.toString();
    }
	
	public static String getCityList() {
		StringBuffer sb = new StringBuffer();
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader bufr = null;
		try {
			ClassPathResource classPathResource =  new ClassPathResource("resources/cityList.json");
			is = classPathResource.getInputStream();
			isr = new InputStreamReader(is);
		    bufr = new BufferedReader(isr);
            String lineTxt = null;
            while ((lineTxt = bufr.readLine()) != null) {
           	 sb.append(lineTxt);
            }
            bufr.close();
        } catch (IOException e) {
        	e.printStackTrace();
	        throw new WeatherException(ResultEnums.BUSSINESS_ERROR.getCode(), "call city list error");
        } finally {
	    	try {
	    		if(bufr != null)
	    		{
	    			bufr.close();
	    		}
	    		if(is != null)
	    		{
	    			is.close();
	    		}
		        if(isr != null)
		        {
		        	isr.close();
		        }	        
	    	}catch (final IOException e) {    	
		        e.printStackTrace();
		        throw new WeatherException(ResultEnums.BUSSINESS_ERROR.getCode(), "call city list error");
		    }
        }
		return sb.toString();
	}
	

}
