package com.bestsupport.msgestioncliente.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Client {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "client_id")
    private Long id;
    
    @Column (name = "full_name", nullable = false)
    private String fullName;

    @Column (name = "email", nullable = false)
    private String email;

    @Column (name = "phone", nullable = false)
    private String phoneNumber;

    @ManyToOne
    @JoinColumn (name = "company_id", nullable = false)
    private Company company;

}
