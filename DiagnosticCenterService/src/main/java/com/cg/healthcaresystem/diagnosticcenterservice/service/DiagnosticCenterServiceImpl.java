/****************************************************************************************************************************
 - File Name        : DiagnosticCenterSErviceImpl
 - Author           : Meghna Hens
 - Creation Date    : 13-056-2020
 - Description      : This is service class which contains the business logic of Diagnostic Center Service
 ****************************************************************************************************************************/ 

package com.cg.healthcaresystem.diagnosticcenterservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.healthcaresystem.diagnosticcenterservice.dao.DiagnosticCenterRepository;
import com.cg.healthcaresystem.diagnosticcenterservice.dto.DiagnosticCenterEntity;
import com.cg.healthcaresystem.diagnosticcenterservice.exception.DiagnosticCenterNotFoundException;
import com.cg.healthcaresystem.diagnosticcenterservice.model.DiagnosticCenter;

@Service
public class DiagnosticCenterServiceImpl implements DiagnosticCenterServiceInterface{
	
	@Autowired
	private DiagnosticCenterRepository repository;

	private String errormsg="Sorry for the inconvenience, currently DataBase is down..!";
	private String expmsg="Center not found for the given Id ";
	
	Logger logger = LoggerFactory.getLogger(DiagnosticCenterServiceImpl.class);

	public boolean isRepositoryNotNull() {
		boolean flag = false;

		if (repository != null) {
			flag = true;
			
		}
		return flag;
	}
	
	
	/****************************************************************************************************************************
	 - Method Name      : getAllDiagnosticCenters
	 - Input Parameters : No input parameters required
	 - Return type      : List<DiagnosticCenter>
	 - Author           : Meghna Hens
	 - Creation Date    : 13-06-2020
	 - Description      : Fetching all diagnostic centers present in database.
	  ****************************************************************************************************************************/ 
	@Override
	public List<DiagnosticCenter> getAllDiagnosticCenters() {
		if(!isRepositoryNotNull()) {
			logger.error(errormsg);
		}
		List<DiagnosticCenterEntity> entityList=repository.findAll();
		List<DiagnosticCenter> centerList = new ArrayList<>();
		for (DiagnosticCenterEntity entity : entityList) {
			DiagnosticCenter center = new DiagnosticCenter();
			center.setCenterId(entity.getCenterId());
			center.setCenterName(entity.getCenterName());
			center.setCity(entity.getCity());
			center.setMobile(entity.getMobile());
			centerList.add(center);

		}
		return centerList;
	}
	
	
	/****************************************************************************************************************************
	 - Method Name      : getDiagnosticCenterById
	 - Input Parameters : centerId 
	 - Return type      : DiagnosticCenter object
	 - Author           : Meghna Hens
	 - Creation Date    : 13-06-2020
	 - Description      : Fetching diagnostic centers by Id present in database.
	  ****************************************************************************************************************************/ 
	@Override
	public DiagnosticCenter getDiagnosticCenterById(Integer centerId) throws DiagnosticCenterNotFoundException {
		if(!isRepositoryNotNull()) {
			logger.error(errormsg);
		}
		
		 Optional<DiagnosticCenterEntity> optional= repository.findById(centerId);
		 if(optional.isPresent()) { 
			 DiagnosticCenterEntity entity = optional.get(); 
			 DiagnosticCenter center = new DiagnosticCenter(); 
			 
			 center.setCenterId(entity.getCenterId());
			 center.setCenterName(entity.getCenterName());
			 center.setCity(entity.getCity());
			 center.setMobile(entity.getMobile());
		  
		  return center; 
		  } 
		 else 
		 { 
			 throw new DiagnosticCenterNotFoundException(expmsg); 
		  }
	}
	

	/****************************************************************************************************************************
	 - Method Name      : addDiagnosticCenter
	 - Input Parameters : DiagnosticCenter Object
	 - Return type      : String
	 - Author           : Meghna Hens
	 - Creation Date    : 13-06-2020
	 - Description      : Inserting new Diagnostic Center in database.
	  ****************************************************************************************************************************/ 
	@Override
	public String addDiagnosticCenter(DiagnosticCenter center) {

		if(!isRepositoryNotNull()) 
		{
			logger.error(errormsg);
		}
		DiagnosticCenterEntity entity = new DiagnosticCenterEntity();
		entity.setCenterName(center.getCenterName());
		entity.setCity(center.getCity());
		entity.setMobile(center.getMobile());
		repository.saveAndFlush(entity);		
		return "Diagnostic Center added successfully";
	}
	
	
	/****************************************************************************************************************************
	 - Method Name      : deleteDiagnosticCenterById
	 - Input Parameters : centerId
	 - Return type      : String
	 - Author           : Meghna Hens
	 - Creation Date    : 13-06-2020
	 - Description      : Removing existing Diagnostic Center from database.
	  ****************************************************************************************************************************/ 
	@Override
	public String deleteDiagnosticCenterById(Integer centerId) throws DiagnosticCenterNotFoundException{
		if(!isRepositoryNotNull()) 
		{
			logger.error(errormsg);
		}
		Optional<DiagnosticCenterEntity> optional= repository.findById(centerId);
		 if(optional.isPresent()) {
			repository.deleteById(centerId);
			return "Diagnostic Center record deleted successfully!";
		 }
		 else
			 throw new DiagnosticCenterNotFoundException(expmsg); 
	}

	
	/****************************************************************************************************************************
	 - Method Name      : updateCenterContactById
	 - Input Parameters : centerId, mobile
	 - Return type      : String
	 - Author           : Meghna Hens
	 - Creation Date    : 13-06-2020
	 - Description      : To update existing Diagnostic Center contact details in database.
	  ****************************************************************************************************************************/
	@Override
	public String updateDiagnosticCenterContactById(Integer centerId, String mobile) throws DiagnosticCenterNotFoundException {
		if(!isRepositoryNotNull()) 
		{
			logger.error(errormsg);
		}
		Optional<DiagnosticCenterEntity> optional= repository.findById(centerId);
		 if(optional.isPresent()) {
			 DiagnosticCenterEntity entity = optional.get(); 
					
					entity.setMobile(mobile);
					repository.saveAndFlush(entity);
			
			return "Diagnostic Center Contact number updated successfully!";
		 }
		 else
			 throw new DiagnosticCenterNotFoundException(expmsg); 
	}
	
	
	/****************************************************************************************************************************
	 - Method Name      : updateCenterCityById
	 - Input Parameters : centerId,city
	 - Return type      : String
	 - Author           : Meghna Hens
	 - Creation Date    : 13-06-2020
	 - Description      : To update existing Diagnostic Center contact details in database.
	  ****************************************************************************************************************************/
	@Override
	public String updateDiagnosticCenterCityById(Integer centerId, String city) throws DiagnosticCenterNotFoundException {
		if(!isRepositoryNotNull()) 
		{
			logger.error(errormsg);
		}
		Optional<DiagnosticCenterEntity> optional= repository.findById(centerId);
		 if(optional.isPresent()) {
			 DiagnosticCenterEntity entity = optional.get(); 
					
					entity.setCity(city);
					repository.saveAndFlush(entity);
			
			return "Diagnostic Center city updated successfully!";
		 }
		 else
			 throw new DiagnosticCenterNotFoundException(expmsg); 
	}
	
	
	/****************************************************************************************************************************
	 - Method Name      : updateCenterNameById
	 - Input Parameters : centerId,city
	 - Return type      : String
	 - Author           : Meghna Hens
	 - Creation Date    : 13-06-2020
	 - Description      : To Update existing Diagnostic Center name details in database.
	  ****************************************************************************************************************************/
	@Override
	public String updateDiagnosticCenterNameById(Integer centerId, String centerName) throws DiagnosticCenterNotFoundException {
		if(!isRepositoryNotNull()) 
		{
			logger.error(errormsg);
		}
		Optional<DiagnosticCenterEntity> optional= repository.findById(centerId);
		 if(optional.isPresent()) {
			 DiagnosticCenterEntity entity = optional.get(); 
					
					entity.setCenterName(centerName);
					repository.saveAndFlush(entity);
			
			return "Diagnostic Center name updated successfully!";
		 }
		 else
			 throw new DiagnosticCenterNotFoundException(expmsg); 
	}
}
