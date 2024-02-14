package com.maikhane.mercentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maikhane.mercentservice.entity.BusinessOwner;

@Repository
public interface BusinessOwnerRepository extends JpaRepository<BusinessOwner, Integer> {

}
