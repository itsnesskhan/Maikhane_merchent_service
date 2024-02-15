package com.maikhane.mercentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maikhane.mercentservice.dto.MerchantDTO;
import com.maikhane.mercentservice.response.CommonResponse;
import com.maikhane.mercentservice.service.MerchantService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/api/v1/merchant")
@RestController
@RequiredArgsConstructor
public class MerchantController {

	@Autowired
	private final MerchantService MerchantService;
	
	@PostMapping("/save")
	ResponseEntity<CommonResponse> addMerchant(@RequestBody MerchantDTO MerchantDTO){
		CommonResponse response = MerchantService.addMerchant(MerchantDTO);
		return ResponseEntity.created(null).body(response);
	}
	
	@GetMapping("/get-all")
	ResponseEntity<CommonResponse> getAllMerchant(){
		CommonResponse response = MerchantService.getAllMerchant();
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/get/{id}")
	ResponseEntity<CommonResponse> getMerchantById(@PathVariable Integer id){
		CommonResponse response = MerchantService.getMerchantById(id);
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("/update")
	ResponseEntity<CommonResponse> updateMerchantOwner(@RequestBody MerchantDTO MerchantDTO){
		CommonResponse response = MerchantService.updateMerchant(MerchantDTO);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	
	@DeleteMapping("/delete/{id}")
	ResponseEntity<CommonResponse> deleteMerchantById(@PathVariable Integer id){
		CommonResponse response = MerchantService.deleteMerchantById(id);
		return ResponseEntity.ok(response);
	}
	
	
}
