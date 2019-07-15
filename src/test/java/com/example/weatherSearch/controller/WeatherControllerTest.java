package com.example.weatherSearch.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.weatherSearch.ApplicationConfig;
import com.example.weatherSearch.entity.model.CityModel;
import com.example.weatherSearch.entity.model.WeatherModel;
import com.example.weatherSearch.service.WeatherService;

/**
 * The Class WeatherControllerTest.
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
public class WeatherControllerTest {
	
	/** The mock mvc. */
	private MockMvc mockMvc;

    /** The weather service. */
    @Mock
    private WeatherService weatherService;

    /** The weather controller. */
    @InjectMocks
    private WeatherController weatherController;
    
    /**
     * Inits the.
     */
    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(weatherController)
                .build();
    }
    
    /**
     * Test get city success.
     *
     * @throws Exception the exception
     */
    @Test
    public void test_get_city_success() throws Exception {
    	CityModel cityModel = new CityModel();
    	List<String> cities =new ArrayList<String>();
    	cities.add("Sydney");
    	cities.add("Melbourne");
    	cities.add("Wollongong");
    	cityModel.setCities(cities);

        when(this.weatherService.getCityList()).thenReturn(cityModel);

        final URI uri = URI.create("/api/cities");
        mockMvc.perform(MockMvcRequestBuilders.get(uri))
                .andExpect(status().isOk())
        		.andExpect(content().json("{\"code\":\"888\",\"msg\":\"success\",\"data\":{\"cities\":[\"Sydney\",\"Melbourne\",\"Wollongong\"]}}"));
        verify(weatherService, times(1)).getCityList();
        verifyNoMoreInteractions(weatherService);
    }
    
    @Test
    public void test_get_weather_success() throws Exception {
    	WeatherModel weatherModel = new WeatherModel();
    	weatherModel.setCity("Sydney");
    	weatherModel.setTemperature("29");
    	weatherModel.setUpdateTime("2019-07-13 20:00:00");
    	weatherModel.setWeather("cloudy");
    	weatherModel.setWind("east wind");

        when(this.weatherService.getWeatherByCity("Sydney")).thenReturn(weatherModel);

        final URI uri = URI.create("/api/weather/Sydney");
        mockMvc.perform(MockMvcRequestBuilders.get(uri))
                .andExpect(status().isOk())
        		.andExpect(content().json("{\"code\":\"888\",\"msg\":\"success\",\"data\":{\"city\":\"Sydney\",\"updateTime\":\"2019-07-13 20:00:00\",\"weather\":\"cloudy\",\"temperature\":\"29\",\"wind\":\"east wind\"}}"));
        verify(weatherService, times(1)).getWeatherByCity("Sydney");
        verifyNoMoreInteractions(weatherService);
    }
}
