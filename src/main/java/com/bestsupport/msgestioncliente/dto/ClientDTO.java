package com.bestsupport.msgestioncliente.dto;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

import com.bestsupport.msgestioncliente.model.Client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {

    private Long id;
    private String fullName;
    private String email;
    private String phoneNumber;
    private Long companyId;
    private String companyName;

}
