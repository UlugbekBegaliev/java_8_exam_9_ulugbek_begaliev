package com.begaliev.java_8_exam_9_ulugbek_begaliev.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Email
    @NotBlank
    @Size(min = 1, max = 128)
    @Column(length = 128)
    private String email;

    @NotBlank
    @Size(min = 8, max = 128)
    @Column(length = 128)
    private String password;

    @NotBlank
    @Size(min = 1, max = 128)
    @Column(length = 128)
    private String companyName;

    @Column
    @Builder.Default
    private boolean enabled = true;

    @NotBlank
    @Builder.Default
    @Size(min = 1, max = 128)
    @Column(length = 128)
    private String role = "USER";

    @NotBlank
    private String captcha;
}
