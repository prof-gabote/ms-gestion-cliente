package com.bestsupport.msgestioncliente.dto;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.bestsupport.msgestioncliente.model.Company;

@Component
public class CompanyDTOConverter implements Converter<Company, CompanyDTO> {

    @Override
    public CompanyDTO convert(Company source) {
        if (source == null) {
            return null;
        }
        return CompanyDTO.builder()
                .id(source.getId())
                .companyName(source.getCompanyName())
                .build();
    }

}
