package com.bestsupport.msgestioncliente.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {

    private Long clientId;
    private String fullName;
    private String email;
    private String phoneNumber;
    private Long companyId;
    private String companyName;

}
