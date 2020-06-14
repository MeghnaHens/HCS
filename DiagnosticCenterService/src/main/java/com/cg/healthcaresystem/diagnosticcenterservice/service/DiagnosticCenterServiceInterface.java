/****************************************************************************************************************************
 - File Name        : DiagnosticCenterSErviceInterface
 - Author           : Meghna Hens
 - Creation Date    : 13-056-2020
 - Description      : This is service Interface which contains all the unimplemented methods of Diagnostic Center Service
 ****************************************************************************************************************************/ 

package com.cg.healthcaresystem.diagnosticcenterservice.service;

import java.util.List;

import com.cg.healthcaresystem.diagnosticcenterservice.exception.DiagnosticCenterNotFoundException;
import com.cg.healthcaresystem.diagnosticcenterservice.model.DiagnosticCenter;
public interface DiagnosticCenterServiceInterface {

	public List<DiagnosticCenter> getAllDiagnosticCenters();
	public DiagnosticCenter getDiagnosticCenterById(Integer centerid) throws DiagnosticCenterNotFoundException;
	public String addDiagnosticCenter(DiagnosticCenter center);
	public String deleteDiagnosticCenterById(Integer centerId) throws DiagnosticCenterNotFoundException;
	public String updateDiagnosticCenterContactById(Integer centerId, String mobile) throws DiagnosticCenterNotFoundException;
	public String updateDiagnosticCenterCityById(Integer centerId, String city) throws DiagnosticCenterNotFoundException ;
	public String updateDiagnosticCenterNameById(Integer centerId, String centerName) throws DiagnosticCenterNotFoundException ;
}
