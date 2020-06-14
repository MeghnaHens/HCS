/****************************************************************************************************************************
 - File Name        : DiagnosticCenterController
 - Author           : Meghna Hens
 - Creation Date    : 13-056-2020
 - Description      : This is end point controller to consume Diagnostic Center Service
 ****************************************************************************************************************************/ 

package com.cg.healthcaresystem.diagnosticcenterservice.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.healthcaresystem.diagnosticcenterservice.exception.DiagnosticCenterNotFoundException;
import com.cg.healthcaresystem.diagnosticcenterservice.model.DiagnosticCenter;
import com.cg.healthcaresystem.diagnosticcenterservice.service.DiagnosticCenterServiceInterface;

@RestController
@Validated
@RequestMapping("/centers")
public class DiagnosticCenterController {
	
	@Autowired
	private DiagnosticCenterServiceInterface service;
	
	
	/****************************************************************************************************************************
	 - Method Name      : getAllDiagnosticCenters
	 - Input Parameters : No input parameters required
	 - Return type      : ResponseEntity<List<DiagnosticCenter>>
	 - Author           : Meghna Hens
	 - Creation Date    : 13-06-2020
	 - Description      : Fetching all diagnostic centers present in database.
	 - End Point URL    : http://localhost:4445/centers/getAllCenters
	  ****************************************************************************************************************************/ 
	@GetMapping("/getAllCenters")
	public ResponseEntity<List<DiagnosticCenter>> getAllDiagnosticCenters() {
		List<DiagnosticCenter> cList=service.getAllDiagnosticCenters();
		return new ResponseEntity<>(cList,HttpStatus.OK);
	}
	
	
	/****************************************************************************************************************************
	 - Method Name      : getDiagnosticCenterById
	 - Input Parameters : centerId 
	 - Return type      : ResponseEntity<DiagnosticCenter>
	 - Author           : Meghna Hens
	 - Creation Date    : 13-06-2020
	 - Description      : Fetching diagnostic centers by Id present in database.
	 - End Point URL    : http://localhost:4445/centers/getCenterById/2
	  ****************************************************************************************************************************/ 
	@GetMapping("/getCenterById/{centerId}")
	public ResponseEntity<DiagnosticCenter> getDiagnosticCenterById(@PathVariable("centerId") Integer centerId) throws DiagnosticCenterNotFoundException {
		DiagnosticCenter center=service.getDiagnosticCenterById(centerId);
		return ResponseEntity.ok(center);
	}
	
	
	
	/****************************************************************************************************************************
	 - Method Name      : addDiagnosticCenter
	 - Input Parameters : DiagnosticCenter Object
	 - Return type      : ResponseEntity<String>
	 - Author           : Meghna Hens
	 - Creation Date    : 13-06-2020
	 - Description      : Inserting new Diagnostic Center in database.
	 - End Point URL    : http://localhost:4445/centers/addCenters
	  ****************************************************************************************************************************/ 
	@PostMapping("/addCenters")
	public ResponseEntity<String> addDiagnosticCenter(@RequestBody DiagnosticCenter center) {
		String msg= service.addDiagnosticCenter(center);
		return new ResponseEntity<String>(msg,HttpStatus.ACCEPTED);
	}
	
	
	
	/****************************************************************************************************************************
	 - Method Name      : updateDiagnosticCenterContactById
	 - Input Parameters : centerId, mobile
	 - Return type      : ResponseEntity<String>
	 - Author           : Meghna Hens
	 - Creation Date    : 13-06-2020
	 - Description      : Updating contact number of existing Diagnostic Center in database.
	 - End Point URL    : http://localhost:4445/centers/updateContact/1002/08967332146
	 ****************************************************************************************************************************/ 
		@PutMapping("/updateContact/{centerId}/{mobile}")
		public ResponseEntity<String> updateDiagnosticCenterContactById
		(@PathVariable("centerId") Integer centerId, @PathVariable("mobile") String mobile) throws DiagnosticCenterNotFoundException {
			return ResponseEntity.ok(service.updateDiagnosticCenterContactById(centerId, mobile));
		}
		
		
	
	/****************************************************************************************************************************
	 - Method Name      : updateDiagnosticCenterCityById
	 - Input Parameters : centerId, city
	 - Return type      : ResponseEntity<String>
	 - Author           : Meghna Hens
	 - Creation Date    : 13-06-2020
	 - Description      : Updating city of existing Diagnostic Center in database.
	 - End Point URL    : http://localhost:4445/centers/updateCity/1001/Kolkata
	 ****************************************************************************************************************************/ 	
		@PutMapping("/updateCity/{centerId}/{city}")
		public ResponseEntity<String> updateDiagnosticCenterCityById
		(@PathVariable("centerId") Integer centerId, @PathVariable("city") String city) throws DiagnosticCenterNotFoundException {
			return ResponseEntity.ok(service.updateDiagnosticCenterCityById(centerId, city));
		}
	
	/****************************************************************************************************************************
	 - Method Name      : updateDiagnosticCenterNameById
	 - Input Parameters : centerId,centerName
	 - Return type      : ResponseEntity<String>
	 - Author           : Meghna Hens
	 - Creation Date    : 13-06-2020
	 - Description      : Updating city of existing Diagnostic Center in database.
	 - End Point URL    : http://localhost:4445/centers/updateCenterName/1002/CenterABC
	****************************************************************************************************************************/ 	
		@PutMapping("/updateCenterName/{centerId}/{centerName}")
		public ResponseEntity<String> updateDiagnosticCenterNameById
		(@PathVariable("centerId") Integer centerId, @PathVariable("centerName") String centerName) throws DiagnosticCenterNotFoundException {
			return ResponseEntity.ok(service.updateDiagnosticCenterNameById(centerId, centerName));
		}
	
		
	/****************************************************************************************************************************
	 - Method Name      : deleteDiagnosticCenterById
	 - Input Parameters : centerId
	 - Return type      : ResponseEntity<String>
	 - Author           : Meghna Hens
	 - Creation Date    : 13-06-2020
	 - Description      : Removing existing Diagnostic Center from database.
	 - End Point URL    : http://localhost:4445/centers/deleteCenter/2
	  ****************************************************************************************************************************/ 
	@DeleteMapping("/deleteCenter/{centerId}")
	public ResponseEntity<String> deleteDiagnosticCenter(@PathVariable Integer centerId) throws DiagnosticCenterNotFoundException {
		return ResponseEntity.ok( service.deleteDiagnosticCenterById(centerId));
	}
	
}
