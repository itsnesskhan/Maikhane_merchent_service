package com.maikhane.mercentservice.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.google.common.base.Optional;
import com.maikhane.mercentservice.constants.Constants;
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
		
		if (ObjectUtils.isEmpty(merchantDTO.getEmail())) throw new RuntimeException(Constants.ENTER_EMAIL_MSG);
		
		if (ObjectUtils.isEmpty(merchantDTO.getContactNumber())) throw new RuntimeException(Constants.ENTER_MOBILE_NUMBER_MSG);
		
		if (ObjectUtils.isEmpty(merchantDTO.getUsername())) throw new RuntimeException(Constants.ENTER_USERNAME_MSG);
		
		Optional<Merchant> email = merchantRepository.findByEmail(merchantDTO.getEmail());
		if (email.isPresent()) throw new RuntimeException(Constants.EMAIL_ALREADY_REGISTRED);
		
		Optional<Merchant> contactNumber = merchantRepository.findByContactNumber(merchantDTO.getContactNumber());
		if (contactNumber.isPresent()) throw new RuntimeException(Constants.MOBILE_NUMBER_ALREADY_REGISTRED);
		
		Optional<Merchant> username = merchantRepository.findByUsername(merchantDTO.getUsername());
		if (username.isPresent()) throw new RuntimeException(Constants.USERNAME_ALREADY_REGISTRED);
			
		Merchant merchant = modelMapper.map(merchantDTO, Merchant.class);
		merchant = merchantRepository.save(merchant);
		return CommonResponse.builder()
				.data(merchant)
				.message(Constants.MERCHANT_SAVE_MSG)
				.status(HttpStatus.CREATED)
				.build();
	}

	@Override
	public CommonResponse getAllMerchant() {
		List<Merchant> allmerchant = merchantRepository.findAll();
		return CommonResponse.builder()
				.data(allmerchant)
				.message(Constants.MERCHANT_GET_ALL_MSG)
				.status(HttpStatus.OK)
				.build();
	}

	@Override
	public CommonResponse getMerchantById(Integer id) {
		Merchant merchant = merchantRepository.findById(id).orElseThrow(
				()-> new MerchantNotFoundException(Constants.MERCHANT_NOT_FOUND_MSG+id)
				);
		return CommonResponse.builder()
				.data(merchant)
				.message(Constants.MERCHANT_GET_BY_ID_MSG+id)
				.status(HttpStatus.OK)
				.build() ;
	}

	@Override
	public CommonResponse updateMerchant(MerchantDTO merchantDTO) {
		Merchant merchant = merchantRepository.findById(merchantDTO.getId()).orElseThrow(
				()-> new MerchantNotFoundException(Constants.MERCHANT_NOT_FOUND_MSG+merchantDTO.getId()));
		
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
				.message(Constants.MERCHANT_UPDATE_MSG)
				.status(HttpStatus.OK)
				.build();
	}

	@Override
	public CommonResponse deleteMerchantById(Integer id) {
		Merchant merchant = merchantRepository.findById(id).orElseThrow(
				()-> new MerchantNotFoundException(Constants.MERCHANT_NOT_FOUND_MSG+id));
		
		merchantRepository.delete(merchant);
		return CommonResponse.builder()
				.message(Constants.MERCHANT_DELETE_MSG)
				.status(HttpStatus.NO_CONTENT)
				.build();
	}
	


}
