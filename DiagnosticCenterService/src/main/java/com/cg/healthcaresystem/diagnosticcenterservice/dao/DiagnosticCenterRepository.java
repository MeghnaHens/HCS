/****************************************************************************************************************************
 - File Name        : DiagnosticCenterRepository
 - Author           : Meghna Hens
 - Creation Date    : 13-056-2020
 - Description      : This is repository interface of Diagnostic Center Service  which extends JpaRepository for basic crud operations
 ***************************************************************************************************************************************/ 

package com.cg.healthcaresystem.diagnosticcenterservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.healthcaresystem.diagnosticcenterservice.dto.DiagnosticCenterEntity;

@Repository
public interface DiagnosticCenterRepository extends JpaRepository<DiagnosticCenterEntity, Integer>{
}
