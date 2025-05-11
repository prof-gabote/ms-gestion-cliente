package com.bestsupport.msgestioncliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bestsupport.msgestioncliente.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
