package com.maikhane.mercentservice.service;

import com.maikhane.mercentservice.dto.MerchantDTO;
import com.maikhane.mercentservice.response.CommonResponse;

public interface MerchantService {

	CommonResponse addMerchant(MerchantDTO businessOwerDTO);
	
	CommonResponse getAllMerchant();
	
	CommonResponse getMerchantById(Integer id);
	
	CommonResponse updateMerchant(MerchantDTO businessOwerDTO);
	
	CommonResponse deleteMerchantById(Integer id);
}
