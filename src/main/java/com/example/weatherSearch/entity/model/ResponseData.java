package com.example.weatherSearch.entity.model;

import java.io.Serializable;

import com.example.weatherSearch.enumData.ResultEnums;

/**
 * The Class ResponseData.
 *
 * @param <T> the generic type
 */
public class ResponseData<T> implements Serializable {

	/** The code. */
    private String code;

    /** The msg. */
    private String msg;

    /** The data. */
    private T data;


    /**
     * Instantiates a new response data.
     *
     * @param code the code
     * @param msg the msg
     * @param data the data
     */
    public ResponseData(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * Instantiates a new response data.
     *
     * @param code the code
     * @param msg the msg
     */
    public ResponseData(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * Instantiates a new response data.
     *
     * @param resultEnums the result enums
     */
    public ResponseData(ResultEnums resultEnums) {
        this.code = resultEnums.getCode();
        this.msg = resultEnums.getMsg();
    }

    /**
     * Instantiates a new response data.
     *
     * @param resultEnums the result enums
     * @param data the data
     */
    public ResponseData(ResultEnums resultEnums, T data) {
        this.code = resultEnums.getCode();
        this.msg = resultEnums.getMsg();
        this.data = data;
    }

    /**
     * Instantiates a new response data.
     */
    public ResponseData() {
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

    /**
     * Gets the data.
     *
     * @return the data
     */
    public T getData() {
        return data;
    }

    /**
     * Sets the data.
     *
     * @param data the new data
     */
    public void setData(T data) {
        this.data = data;
    }
}
