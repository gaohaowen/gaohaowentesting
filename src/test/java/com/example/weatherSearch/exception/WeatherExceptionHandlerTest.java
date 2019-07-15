package com.example.weatherSearch.exception;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.net.URI;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.weatherSearch.controller.WeatherController;
import com.example.weatherSearch.enumData.ResultEnums;

/**
 * The Class WeatherExceptionHandlerTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class WeatherExceptionHandlerTest {
	 
 	/** The mock mvc. */
 	private MockMvc mockMvc;

	    /** The weather controller. */
    	@Mock
	    private WeatherController weatherController;

	    /**
    	 * Setup.
    	 */
    	@Before
	    public void setup() {
	        this.mockMvc = MockMvcBuilders.standaloneSetup(weatherController)
	        		 .setControllerAdvice(new WeatherExceptionHandler()).build();
	    }

	    /**
    	 * Check unexpected exceptions.
    	 *
    	 * @throws Exception the exception
    	 */
    	@Test
	    public void check_unexpected_exceptions() throws Exception {

	        when(weatherController.getCities()).thenThrow(new RuntimeException("Unexpected Exception"));

	        final URI uri = URI.create("/api/cities");
	        mockMvc.perform(MockMvcRequestBuilders.get(uri))
	                .andExpect(status().isOk())
	                .andExpect(content().json("{\"code\":\"000\",\"msg\":\"error\",\"data\":null}"));
	    }
	    
	    /**
    	 * Check custom exceptions.
    	 *
    	 * @throws Exception the exception
    	 */
    	@Test
	    public void check_custom_exceptions() throws Exception {

	        when(weatherController.getCities()).thenThrow(new WeatherException(ResultEnums.BUSSINESS_ERROR.getCode(), "call get CityList error"));

	        final URI uri = URI.create("/api/cities");
	        mockMvc.perform(MockMvcRequestBuilders.get(uri))
	                .andExpect(status().isOk())
	                .andExpect(content().json("{\"code\":\"222\",\"msg\":\"call get CityList error\",\"data\":null}"));   
	    }
}