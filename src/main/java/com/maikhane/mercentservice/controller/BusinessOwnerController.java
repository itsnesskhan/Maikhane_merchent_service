package com.maikhane.mercentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maikhane.mercentservice.dto.BusinessOwnerDTO;
import com.maikhane.mercentservice.response.CommonResponse;
import com.maikhane.mercentservice.service.BusinessOwnerService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/api/v1/bussinessOwner")
@RestController
@RequiredArgsConstructor
public class BusinessOwnerController {

	@Autowired
	private final BusinessOwnerService businessOwnerService;
	
	@PostMapping("/save")
	ResponseEntity<CommonResponse> addBusinessOwner(@RequestBody BusinessOwnerDTO businessOwnerDTO){
		CommonResponse response = businessOwnerService.addBusinessOwner(businessOwnerDTO);
		return ResponseEntity.created(null).body(response);
	}
	
	@GetMapping("/get-all")
	ResponseEntity<CommonResponse> getAllBusinessOwner(){
		CommonResponse response = businessOwnerService.getAllBusinessOwner();
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/get/{id}")
	ResponseEntity<CommonResponse> getBusinessOwnerById(@PathVariable Integer id){
		CommonResponse response = businessOwnerService.getBusinessOwnerById(id);
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/update")
	ResponseEntity<CommonResponse> updateBusinessOwner(@RequestBody BusinessOwnerDTO businessOwnerDTO){
		CommonResponse response = businessOwnerService.updateBusinessOwner(businessOwnerDTO);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	
	
}
