package com.maikhane.mercentservice.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maikhane.mercentservice.dto.BusinessOwnerDTO;
import com.maikhane.mercentservice.entity.BusinessOwner;
import com.maikhane.mercentservice.exception.BusinessOwnerNotFoundException;
import com.maikhane.mercentservice.repository.BusinessOwnerRepository;
import com.maikhane.mercentservice.response.CommonResponse;
import com.maikhane.mercentservice.service.BusinessOwnerService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BusinessOwnerServiceImpl implements BusinessOwnerService {

	@Autowired
	private final BusinessOwnerRepository businessOwnerRepository;
	
	@Autowired
	private final ModelMapper modelMapper;

	@Override
	public CommonResponse addBusinessOwner(BusinessOwnerDTO businessOwnerDTO) {
		BusinessOwner businessOwner = modelMapper.map(businessOwnerDTO, BusinessOwner.class);
		businessOwner = businessOwnerRepository.save(businessOwner);
		return CommonResponse.builder()
				.data(businessOwner)
				.message("BusinessOwner added Successfully!")
				.build();
	}

	@Override
	public CommonResponse getAllBusinessOwner() {
		List<BusinessOwner> allBusinessOwner = businessOwnerRepository.findAll();
		return CommonResponse.builder()
				.data(allBusinessOwner)
				.message("List of all BusinessOwner!")
				.build();
	}

	@Override
	public CommonResponse getBusinessOwnerById(Integer id) {
		BusinessOwner businessOwner = businessOwnerRepository.findById(id).orElseThrow(
				()-> new BusinessOwnerNotFoundException("BusinessOwner not found with id : "+id)
				);
		return CommonResponse.builder()
				.data(businessOwner)
				.message("BusinessOwner with id : "+id)
				.build() ;
	}

	@Override
	public CommonResponse updateBusinessOwner(BusinessOwnerDTO businessOwnerDTO) {
		BusinessOwner businessOwner = businessOwnerRepository.findById(businessOwnerDTO.getId()).orElseThrow(
				()-> new BusinessOwnerNotFoundException("BusinessOwner not found with id : "+businessOwnerDTO.getId()));
		
		businessOwner.setDob(businessOwnerDTO.getDob());
		businessOwner.setEmail(businessOwnerDTO.getEmail());
		businessOwner.setPanNumber(businessOwnerDTO.getPanNumber());
		businessOwner.setGstn(businessOwnerDTO.getGstn());
		businessOwner.setPassword(businessOwnerDTO.getPassword());
		businessOwner.setUsername(businessOwnerDTO.getUsername());
		businessOwner.setIsActive(businessOwnerDTO.getIsActive());
		businessOwner.setLrid(businessOwnerDTO.getLrid());
		businessOwner.setName(businessOwnerDTO.getName());
		businessOwner.setContactNumber(businessOwnerDTO.getContactNumber());

		businessOwner = businessOwnerRepository.save(businessOwner);
		return CommonResponse.builder()
				.data(businessOwner)
				.message("BusinessOwner updated!")
				.build();
	}
	


}
