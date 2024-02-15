package com.maikhane.mercentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.google.common.base.Optional;
import com.maikhane.mercentservice.entity.Merchant;

@Repository
public interface MerchantRepository extends JpaRepository<Merchant, Integer> {

	Optional<Merchant> findByEmail(String email);
	
	Optional<Merchant> findByContactNumber(String contactNumber);
	
	Optional<Merchant> findByUsername(String username);
}
