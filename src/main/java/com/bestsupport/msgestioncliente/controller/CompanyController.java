package com.bestsupport.msgestioncliente.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bestsupport.msgestioncliente.dto.CompanyDTO;
import com.bestsupport.msgestioncliente.dto.CompanyDTOConverter;
import com.bestsupport.msgestioncliente.model.Company;
import com.bestsupport.msgestioncliente.service.CompanyService;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/v1/companies")
@AllArgsConstructor
public class CompanyController {
    private final CompanyService companyService;
    private final CompanyDTOConverter companyDTOConverter;

    @GetMapping()
    public ResponseEntity<List<CompanyDTO>> getAllCompanies () {
        List<Company> companies = companyService.getAllCompanies();
        List<CompanyDTO> companyDTOs = new ArrayList<>();
        for (Company company : companies) {
            CompanyDTO companyDTO = companyDTOConverter.convert(company);
            companyDTOs.add(companyDTO);
        }
        if (companyDTOs.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(companyDTOs);
    }
    
}
