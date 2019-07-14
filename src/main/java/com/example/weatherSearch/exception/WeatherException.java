package com.example.weatherSearch.exception;

/**
 * The Class WeatherException.
 */
public class WeatherException extends RuntimeException{

    /** The code. */
    private String code;

    /** The message. */
    private String message;

    /**
     * Instantiates a new weather exception.
     *
     * @param code the code
     * @param message the message
     */
    public WeatherException(String code, String message) {
        this.code=code;
        this.message=message;
    }

    /**
     * Gets the code.
     *
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the code.
     *
     * @param code the new code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /* (non-Javadoc)
     * @see java.lang.Throwable#getMessage()
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message.
     *
     * @param message the new message
     */
    public void setMessage(String message) {
        this.message = message;
    }
}

