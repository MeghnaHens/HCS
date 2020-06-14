/****************************************************************************************************************************
 - File Name        : DiagnosticCenterEntity
 - Author           : Meghna Hens
 - Creation Date    : 13-056-2020
 - Description      : This is the entity class for Diagnostic Center Service which gets mapped with database table.
  ****************************************************************************************************************************/ 

package com.cg.healthcaresystem.diagnosticcenterservice.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity(name="centers")
@Table(name="centertable")
public class DiagnosticCenterEntity {
	
		@Id
		@Column(name="centerid",nullable=false)    
	    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_generator") 
		@SequenceGenerator(name="seq_generator",initialValue=1006,allocationSize=1,sequenceName="id_seq")    
		private Integer centerId;
		
		@Column(name="centername")
		@Pattern(regexp ="(^[a-zA-Z]+$)", message = "Center name can only be in alphabets.")
		@NotBlank(message="Diagnostic Center Name is mandatory")
		@NotNull(message="Diagnostic Center Name is mandatory")
		private String centerName;

		@Column(name="city")
		@Pattern(regexp ="(^[a-zA-Z]+$)", message = "City name can only be in alphabets.")
		@NotBlank(message="city is mandatory")
		@NotNull(message="city is mandatory")
		private String city;
		
		@Column(name="mobile")
		@NotNull(message="Contact number cannot be blank")
		@Pattern(regexp ="^({1}0){1}[1-9]{1}[0-9]{9}$", message = "Not a valid phone number,must start with 0")
		private String mobile;
	
		public DiagnosticCenterEntity(Integer centerId, String centerName, String city, String mobile) 
		{
		super();
		this.centerId = centerId;
		this.centerName = centerName;
		this.city = city;
		this.mobile = mobile;
		}

		public Integer getCenterId() 
		{
			return centerId;
		}
		public void setCenterId(Integer centerId) {
			this.centerId = centerId;
		}
		public String getCenterName() 
		{
			return centerName;
		}
		public void setCenterName(String centerName) 
		{
			this.centerName = centerName;
		}
		public String getCity()
		{
			return city;
		}
		public void setCity(String city)
		{
			this.city = city;
		}
		public String getMobile() 
		{
			return mobile;
		}
		public void setMobile(String mobile) 
		{
			this.mobile = mobile;
		}
		public DiagnosticCenterEntity() {}
}
