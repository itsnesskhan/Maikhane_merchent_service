package com.maikhane.mercentservice.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.maikhane.mercentservice.exception.MerchantNotFoundException;
import com.maikhane.mercentservice.response.CommonResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler({RuntimeException.class})
	public ResponseEntity<CommonResponse> validationExceptionHander(final RuntimeException e){
		log.info("Exception occured : "+e.getMessage());
		CommonResponse response = CommonResponse.builder().message(e.getMessage()).status(HttpStatus.BAD_REQUEST).build();
		return ResponseEntity.badRequest().body(response);
	}
	
	@ExceptionHandler({MerchantNotFoundException.class})
	public ResponseEntity<CommonResponse> merchantNotFoundExceptionHander(final RuntimeException e){
		log.info("Exception occured : "+e.getMessage());
		CommonResponse response = CommonResponse.builder().message(e.getMessage()).status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.badRequest().body(response);
	}
}
