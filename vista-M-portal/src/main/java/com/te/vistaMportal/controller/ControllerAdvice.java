package com.te.vistaMportal.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.vistaMportal.exception.CustomException;
import com.te.vistaMportal.transaction_bean.BaseResponse;


@RestControllerAdvice
public class ControllerAdvice {
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<BaseResponse>  ifDataIsNull(CustomException exception){
		BaseResponse response = new BaseResponse(true, exception.getMessage());
		return new ResponseEntity<BaseResponse>(response, HttpStatus.NOT_FOUND);
	}
}
