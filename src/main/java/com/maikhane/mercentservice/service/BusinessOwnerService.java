package com.maikhane.mercentservice.service;

import com.maikhane.mercentservice.dto.BusinessOwnerDTO;
import com.maikhane.mercentservice.response.CommonResponse;

public interface BusinessOwnerService {

	CommonResponse addBusinessOwner(BusinessOwnerDTO businessOwerDTO);
	
	CommonResponse getAllBusinessOwner();
	
	CommonResponse getBusinessOwnerById(Integer id);
	
	CommonResponse updateBusinessOwner(BusinessOwnerDTO businessOwerDTO);
}
