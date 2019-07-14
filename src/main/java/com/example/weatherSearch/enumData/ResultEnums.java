package com.example.weatherSearch.enumData;

/**
 * The Enum ResultEnums.
 */
public enum ResultEnums {

    /** The success. */
    SUCCESS("888", "success"),
    
    /** The error. */
    ERROR("000", "error"),
    
    /** The system error. */
    SYSTEM_ERROR("111", "system error"),
    
    /** The bussiness error. */
    BUSSINESS_ERROR("222", "logic error"),
    
    /** The param error. */
    PARAM_ERROR("333", "param error");

    /** The code. */
    private String code;
    
    /** The msg. */
    private String msg;

    /**
     * Instantiates a new result enums.
     *
     * @param code the code
     * @param msg the msg
     */
    ResultEnums(String code, String msg) {
        this.code = code;
        this.msg = msg;
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

    /**
     * Gets the msg.
     *
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * Sets the msg.
     *
     * @param msg the new msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }
}