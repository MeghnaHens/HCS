/****************************************************************************************************************************
 - File Name        : DiagnosticCenter
 - Author           : Meghna Hens
 - Creation Date    : 13-056-2020
 - Description      : This is the model class for Diagnostic Center Service
  ****************************************************************************************************************************/

package com.cg.healthcaresystem.diagnosticcenterservice.model;

import org.springframework.stereotype.Component;

@Component
public class DiagnosticCenter {

	private Integer centerId;
	
	private String centerName;
	
	private String city;
	
	private String mobile;
	
	public DiagnosticCenter(Integer centerId, String centerName, String city, String mobile) 
	{
		this.centerId = centerId;
		this.centerName = centerName;
		this.city = city;
		this.mobile = mobile;
	}
	
	public DiagnosticCenter() {}
	
	public Integer getCenterId() 
	{
		return centerId;
	}
	public void setCenterId(Integer centerId)
	{
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

}
