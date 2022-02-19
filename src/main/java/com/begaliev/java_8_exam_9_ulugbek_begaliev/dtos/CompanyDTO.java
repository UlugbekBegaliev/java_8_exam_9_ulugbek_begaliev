package com.begaliev.java_8_exam_9_ulugbek_begaliev.dtos;

import com.begaliev.java_8_exam_9_ulugbek_begaliev.models.Company;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CompanyDTO {

    private int id;
    private String email;
    private String companyName;

    public static CompanyDTO from(Company user){
        return builder()
                .id(user.getId())
                .email(user.getEmail())
                .companyName(user.getCompanyName())
                .build();
    }
}
