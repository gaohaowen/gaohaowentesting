package com.example.weatherSearch.entity.domain;
import java.util.List;

/**
 * The Class WeatherDomain.
 */
public class WeatherDomain
{
    
    /** The results. */
    private List<Results> results;

    /**
     * Sets the results.
     *
     * @param results the new results
     */
    public void setResults(List<Results> results){
        this.results = results;
    }
    
    /**
     * Gets the results.
     *
     * @return the results
     */
    public List<Results> getResults(){
        return this.results;
    }
}
