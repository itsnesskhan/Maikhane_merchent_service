package com.maikhane.mercentservice.response;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResponse {

	private Object data;
	
	private String message;
	
	private HttpStatus status;
}
