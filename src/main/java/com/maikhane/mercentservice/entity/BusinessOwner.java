package com.maikhane.mercentservice.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BusinessOwner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	private String username;
	
	private String panNumber;
	
	private String email;
	
	@Column(name = "gst_number" )
	private String gstn;
	
	@Column(name = "license_number")
	private String lrid;
	
	private String password;
	
	private String contactNumber;
	
	@Column(name = "date_of_birth")
	private Date dob;
	
	private OwnershipMode owerMode;
	
	private VerfificationStatus status;
	
	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "address")
	private String address;
	
	@Column(name = "postal_address")
	private String postalAddress;

	@Column(name = "roll_name")
	private String roleName;
	
	@CreationTimestamp
	@Column(name = "created_date")	
	private Date createdDate;

	@UpdateTimestamp
	@Column(name = "updated_date")
	private Date updatedDate;
}
