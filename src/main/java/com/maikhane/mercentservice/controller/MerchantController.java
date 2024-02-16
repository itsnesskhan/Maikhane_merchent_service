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

import com.maikhane.mercentservice.constants.ApiRouts;
import com.maikhane.mercentservice.dto.MerchantDTO;
import com.maikhane.mercentservice.response.CommonResponse;
import com.maikhane.mercentservice.service.MerchantService;

import lombok.RequiredArgsConstructor;

@RequestMapping(path = ApiRouts.BASE_URL+""+ApiRouts.MERCHANT_REQUEST_MAPPING)
@RestController
@RequiredArgsConstructor
public class MerchantController {

	@Autowired
	private final MerchantService MerchantService;
	
	@PostMapping(path = ApiRouts.SAVE_API)
	ResponseEntity<CommonResponse> addMerchant(@RequestBody MerchantDTO MerchantDTO){
		CommonResponse response = MerchantService.addMerchant(MerchantDTO);
		return ResponseEntity.created(null).body(response);
	}
	
	@GetMapping(path = ApiRouts.GET_ALL_API)
	ResponseEntity<CommonResponse> getAllMerchant(){
		CommonResponse response = MerchantService.getAllMerchant();
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(path = ApiRouts.GET_BY_ID_API)
	ResponseEntity<CommonResponse> getMerchantById(@PathVariable Integer id){
		CommonResponse response = MerchantService.getMerchantById(id);
		return ResponseEntity.ok(response);
	}
	
	@PutMapping(path = ApiRouts.UPDATE_API)
	ResponseEntity<CommonResponse> updateMerchantOwner(@RequestBody MerchantDTO MerchantDTO){
		CommonResponse response = MerchantService.updateMerchant(MerchantDTO);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	
	@DeleteMapping(path = ApiRouts.DELETE_API)
	ResponseEntity<CommonResponse> deleteMerchantById(@PathVariable Integer id){
		CommonResponse response = MerchantService.deleteMerchantById(id);
		return ResponseEntity.ok(response);
	}
	
	
}
