package com.maikhane.mercentservice.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Merchant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	private String username;
	
	private String email;
	
	private String password;
	
	private String contactNumber;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "roll_id", nullable = false)
	private Role role;
		
	@Enumerated(EnumType.STRING)
	private OwnershipMode ownerMode;
	
	@Enumerated(EnumType.STRING)
	private OwnershipEntity ownerEnity;
	
	@Enumerated(EnumType.STRING)
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
	@Column(name = "created_date")	
	private Date createdDate;

	@UpdateTimestamp
	@Column(name = "updated_date")
	private Date updatedDate;
}
