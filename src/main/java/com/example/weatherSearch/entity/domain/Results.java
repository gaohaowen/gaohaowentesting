package com.example.weatherSearch.entity.domain;

/**
 * The Class Results.
 */
public class Results
{
    
    /** The location. */
    private Location location;

    /** The now. */
    private Now now;

    /** The last update. */
    private String last_update;

    /**
     * Sets the location.
     *
     * @param location the new location
     */
    public void setLocation(Location location){
        this.location = location;
    }
    
    /**
     * Gets the location.
     *
     * @return the location
     */
    public Location getLocation(){
        return this.location;
    }
    
    /**
     * Sets the now.
     *
     * @param now the new now
     */
    public void setNow(Now now){
        this.now = now;
    }
    
    /**
     * Gets the now.
     *
     * @return the now
     */
    public Now getNow(){
        return this.now;
    }
    
    /**
     * Sets the last update.
     *
     * @param last_update the new last update
     */
    public void setLast_update(String last_update){
        this.last_update = last_update;
    }
    
    /**
     * Gets the last update.
     *
     * @return the last update
     */
    public String getLast_update(){
        return this.last_update;
    }
}