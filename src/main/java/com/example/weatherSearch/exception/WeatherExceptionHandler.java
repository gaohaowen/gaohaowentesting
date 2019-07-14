package com.example.weatherSearch.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.weatherSearch.entity.model.ResponseData;
import com.example.weatherSearch.utility.ResponseDataUtil;

@ControllerAdvice
@ResponseBody
public class WeatherExceptionHandler {
	
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    @SuppressWarnings({"rawtypes" })
    public ResponseData ExceptionHandler(Exception ex){
        return ResponseDataUtil.buildError();
    }
    
    @ResponseBody
    @ExceptionHandler(value = WeatherException.class)
    @SuppressWarnings({"rawtypes" })
    public ResponseData myExceptionHandler(WeatherException ex){
    	return ResponseDataUtil.buildError(ex.getCode(), ex.getMessage());
    }
}