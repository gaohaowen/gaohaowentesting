package com.example.weatherSearch.entity.domain;

/**
 * The Class Location.
 */
public class Location
{
    
    /** The id. */
    private String id;

    /** The name. */
    private String name;

    /** The country. */
    private String country;

    /** The path. */
    private String path;

    /** The timezone. */
    private String timezone;

    /** The timezone offset. */
    private String timezone_offset;

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(String id){
        this.id = id;
    }
    
    /**
     * Gets the id.
     *
     * @return the id
     */
    public String getId(){
        return this.id;
    }
    
    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name){
        this.name = name;
    }
    
    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * Sets the country.
     *
     * @param country the new country
     */
    public void setCountry(String country){
        this.country = country;
    }
    
    /**
     * Gets the country.
     *
     * @return the country
     */
    public String getCountry(){
        return this.country;
    }
    
    /**
     * Sets the path.
     *
     * @param path the new path
     */
    public void setPath(String path){
        this.path = path;
    }
    
    /**
     * Gets the path.
     *
     * @return the path
     */
    public String getPath(){
        return this.path;
    }
    
    /**
     * Sets the timezone.
     *
     * @param timezone the new timezone
     */
    public void setTimezone(String timezone){
        this.timezone = timezone;
    }
    
    /**
     * Gets the timezone.
     *
     * @return the timezone
     */
    public String getTimezone(){
        return this.timezone;
    }
    
    /**
     * Sets the timezone offset.
     *
     * @param timezone_offset the new timezone offset
     */
    public void setTimezone_offset(String timezone_offset){
        this.timezone_offset = timezone_offset;
    }
    
    /**
     * Gets the timezone offset.
     *
     * @return the timezone offset
     */
    public String getTimezone_offset(){
        return this.timezone_offset;
    }
}