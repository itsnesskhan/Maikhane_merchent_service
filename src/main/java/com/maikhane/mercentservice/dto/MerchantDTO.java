package com.maikhane.mercentservice.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.maikhane.mercentservice.entity.OwnershipEntity;
import com.maikhane.mercentservice.entity.OwnershipMode;
import com.maikhane.mercentservice.entity.Role;
import com.maikhane.mercentservice.entity.VerfificationStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MerchantDTO {


	private Integer id;
	
	private String name;
	
	private String username;
	
	private String email;
	
	private String password;
	
	private String contactNumber;
	
	private Role role;
		
	private OwnershipMode ownerMode;
	
	private OwnershipEntity ownerEnity;
	
	private VerfificationStatus status;
	
	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "address")
	private String address;
	
	@Column(name = "postal_address")
	private String postalAddress;
	
	@Column(name = "city")
	private String city;
	
	@CreationTimestamp
	@JsonProperty("created_date")	
	private Date createdDate;

	@UpdateTimestamp
	@JsonProperty("updated_date")
	private Date updatedDate;
}
