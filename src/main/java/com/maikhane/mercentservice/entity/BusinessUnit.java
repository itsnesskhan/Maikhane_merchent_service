package com.maikhane.mercentservice.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BusinessUnit {

	@Column(name = "id")
	private Integer id;

	@Column(name = "bu_name")
	private String name;

	@Column(name = "buGuid")
	private String buGuid;

	@Column(name = "official_email")
	private String officialEmail;

	@Column(name = "contact_no")
	private Long contactNo;

	@Column(name = "vicinity")
	private String vicinity;

	@Column(name = "primar_category")
	private String primarCategory;

	@Column(name = "secondry_category")
	private String secondryCategory;

	@Column(name = "additional_category")
	private String additionalCategory;

	@Column(name = "area")
	private String area;

	@Column(name = "area_type")
	private String areaType;

	@Column(name = "address")
	private String address;

	@Column(name = "landmark")
	private String landmark;
	
	@Column(name = "shop_category")
	private String shopcategory;

	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;

	@Column(name = "country")
	private String country;
		
	@Column(name = "opentime")
	private String opentime;

	@Column(name = "closetime")
	private String closetime;

	@Column(name = "business_key")
	private String businessKey;
	
	@Column(name = "status")
	private String status;


	@Column(name = "is_active")
	private boolean isActive;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "created_date")
	private Date createdDate;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "updated_date")
	private Date updatedDate;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "updated_by")
	private String updatedBy;

	@Column(name = "latitude")
	private Float latitude;

	@Column(name = "longitude")
	private Float longitude;

	@Column(name = "cost_for_two")
	private Float costForTwo;

	@Column(name = "otp_no")
	private Integer otp;

	@NotNull
	@Column(name = "mood")
	private String mood;

	@Column(name = "food_ordering")
	private boolean foodOrdering;

	@Column(name = "food_delivery")
	private boolean foodDelivery;

	@Column(name = "cod")
	private boolean cod;

	@Column(name = "liquor_delivery")
	private boolean liquorDelivery;
	
	@Column(name = "business_likes")
	private Integer businessLikes;

	@Column(name = "base_currency")
	private String baseCurrency;
	
}
