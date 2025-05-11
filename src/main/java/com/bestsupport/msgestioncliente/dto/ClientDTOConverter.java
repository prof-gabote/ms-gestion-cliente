package com.bestsupport.msgestioncliente.dto;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import com.bestsupport.msgestioncliente.model.Client;
import com.bestsupport.msgestioncliente.service.CompanyService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ClientDTOConverter implements Converter<Client, ClientDTO> {

    private final CompanyService companyService;

    @Override
    public ClientDTO convert(@NonNull Client client) {
        return ClientDTO.builder()
                .id(client.getId())
                .fullName(client.getFullName())
                .email(client.getEmail())
                .phoneNumber(client.getPhoneNumber())
                .companyId(client.getCompany().getId())
                .companyName(client.getCompany().getCompanyName())
                .build();
    }

    public Client convert(@NonNull ClientDTO clientDTO) {
        if (clientDTO.getCompanyId() == null) {
            return null;
        }

        return Client.builder()
                .id(clientDTO.getId())
                .fullName(clientDTO.getFullName())
                .email(clientDTO.getEmail())
                .phoneNumber(clientDTO.getPhoneNumber())
                .company(companyService.getCompanyById(clientDTO.getCompanyId()))
                .build();
    }

}
