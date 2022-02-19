package com.begaliev.java_8_exam_9_ulugbek_begaliev.models;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CompanyRegisterForm {

    @Email
    @NotBlank
    private String email = "";

    @Size(min=4, max=24, message = "Length must be >= 4 and <= 24")
    @Pattern(regexp = "^[^\\d\\s]+$", message = "Should contain only letters")
    private String name = "";

    @NotBlank
    private String password = "";
}
