/****************************************************************************************************************************
 - File Name        : DiagnosticCenterNotFoundException
 - Author           : Meghna Hens
 - Creation Date    : 13-056-2020
 - Description      : This is the Exception class which is thrown when no such entry of Diagnostic Center if found with entered centerid
 ****************************************************************************************************************************/

package com.cg.healthcaresystem.diagnosticcenterservice.exception;

public class DiagnosticCenterNotFoundException extends Exception{

	public DiagnosticCenterNotFoundException(String msg) {
		super(msg);
	}
}
