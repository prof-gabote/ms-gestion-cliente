package com.bestsupport.msgestioncliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bestsupport.msgestioncliente.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
