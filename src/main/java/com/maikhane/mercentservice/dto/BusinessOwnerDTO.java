package com.maikhane.mercentservice.dto;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.maikhane.mercentservice.entity.OwnershipMode;
import com.maikhane.mercentservice.entity.VerfificationStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessOwnerDTO {


	private Integer id;
	
	private String name;
	
	private String designation;
	
	private String username;
	
	private String panNumber;
	
	private String email;
	
	@JsonProperty("gst_number" )
	private String gstn;
	
	@JsonProperty("license_number")
	private String lrid;
	
	private String password;
	
	private String contactNumber;
	
	@JsonProperty("date_of_birth")
	private Date dob;
	
	private VerfificationStatus status;
	
	@JsonProperty("is_active")
	private Boolean isActive;

	@JsonProperty("address")
	private String address;

	@JsonProperty("roll_name")
	private String roleName;
	
	private OwnershipMode owerMode;
	
	@CreationTimestamp
	@JsonProperty("created_date")	
	private Date createdDate;

	@UpdateTimestamp
	@JsonProperty("updated_date")
	private Date updatedDate;
}
