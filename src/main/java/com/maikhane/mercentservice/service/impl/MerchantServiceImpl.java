package com.maikhane.mercentservice.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.google.common.base.Optional;
import com.maikhane.mercentservice.dto.MerchantDTO;
import com.maikhane.mercentservice.entity.Merchant;
import com.maikhane.mercentservice.exception.MerchantNotFoundException;
import com.maikhane.mercentservice.repository.MerchantRepository;
import com.maikhane.mercentservice.response.CommonResponse;
import com.maikhane.mercentservice.service.MerchantService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MerchantServiceImpl implements MerchantService {

	@Autowired
	private final MerchantRepository merchantRepository;
	
	@Autowired
	private final ModelMapper modelMapper;

	@Override
	public CommonResponse addMerchant(MerchantDTO merchantDTO) {
		
		if (ObjectUtils.isEmpty(merchantDTO.getEmail())) throw new RuntimeException("Please enter the email ?");
		
		if (ObjectUtils.isEmpty(merchantDTO.getContactNumber())) throw new RuntimeException("Please enter the mobile number ");
		
		Optional<Merchant> email = merchantRepository.findByEmail(merchantDTO.getEmail());
		if (email.isPresent()) throw new RuntimeException("email already registred!");
		
		Optional<Merchant> contactNumber = merchantRepository.findByContactNumber(merchantDTO.getContactNumber());
		if (contactNumber.isPresent()) throw new RuntimeException("mobile number already registred!");
			
		Merchant merchant = modelMapper.map(merchantDTO, Merchant.class);
		merchant = merchantRepository.save(merchant);
		return CommonResponse.builder()
				.data(merchant)
				.message("Merchant added Successfully!")
				.status(HttpStatus.CREATED)
				.build();
	}

	@Override
	public CommonResponse getAllMerchant() {
		List<Merchant> allmerchant = merchantRepository.findAll();
		return CommonResponse.builder()
				.data(allmerchant)
				.message("List of all merchant!")
				.status(HttpStatus.OK)
				.build();
	}

	@Override
	public CommonResponse getMerchantById(Integer id) {
		Merchant merchant = merchantRepository.findById(id).orElseThrow(
				()-> new MerchantNotFoundException("merchant not found with id : "+id)
				);
		return CommonResponse.builder()
				.data(merchant)
				.message("merchant with id : "+id)
				.status(HttpStatus.OK)
				.build() ;
	}

	@Override
	public CommonResponse updateMerchant(MerchantDTO merchantDTO) {
		Merchant merchant = merchantRepository.findById(merchantDTO.getId()).orElseThrow(
				()-> new MerchantNotFoundException("merchant not found with id : "+merchantDTO.getId()));
		
		merchant.setEmail(merchantDTO.getEmail());
		merchant.setPassword(merchantDTO.getPassword());
		merchant.setUsername(merchantDTO.getUsername());
		merchant.setIsActive(merchantDTO.getIsActive());
		merchant.setName(merchantDTO.getName());
		merchant.setContactNumber(merchantDTO.getContactNumber());
		merchant.setAddress(merchantDTO.getAddress());
		merchant.setCity(merchantDTO.getCity());
		merchant.setOwnerEnity(merchantDTO.getOwnerEnity());
		merchant.setOwnerMode(merchantDTO.getOwnerMode());

		merchant = merchantRepository.save(merchant);
		return CommonResponse.builder()
				.data(merchant)
				.message("merchant updated!")
				.status(HttpStatus.OK)
				.build();
	}

	@Override
	public CommonResponse deleteMerchantById(Integer id) {
		Merchant merchant = merchantRepository.findById(id).orElseThrow(
				()-> new MerchantNotFoundException("merchant not found with id : "+id));
		
		merchantRepository.delete(merchant);
		return CommonResponse.builder()
				.message("merchant deleted successfully!")
				.status(HttpStatus.NO_CONTENT)
				.build();
	}
	


}
