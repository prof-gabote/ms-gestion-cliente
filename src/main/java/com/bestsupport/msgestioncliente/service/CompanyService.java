package com.bestsupport.msgestioncliente.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bestsupport.msgestioncliente.model.Company;
import com.bestsupport.msgestioncliente.repository.CompanyRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public Company getCompanyById(Long id) {
        return companyRepository.findById(id)
                .orElse(null);
    }

}
