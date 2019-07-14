package com.example.weatherSearch.utility;

import com.example.weatherSearch.entity.model.ResponseData;
import com.example.weatherSearch.enumData.ResultEnums;

/**
 * The Class ResponseDataUtil.
 */
public class ResponseDataUtil {
    
    /**
     * Builds the success.
     *
     * @param <T> the generic type
     * @param data the data
     * @return the response data
     */
	@SuppressWarnings({"rawtypes" })
    public static <T> ResponseData buildSuccess(T data) {
        return new ResponseData<T>(ResultEnums.SUCCESS, data);
    }
	
    /**
     * Builds the error.
     *
     * @return the response data
     */
	@SuppressWarnings({"rawtypes" })
    public static ResponseData buildError() {
        return new ResponseData(ResultEnums.ERROR);
    }

   
    /**
     * Builds the error.
     *
     * @param code the code
     * @param msg the msg
     * @return the response data
     */
	@SuppressWarnings({"rawtypes" })
    public static ResponseData buildError(String code, String msg) {
        return new ResponseData(code, msg);
    }

    
}
