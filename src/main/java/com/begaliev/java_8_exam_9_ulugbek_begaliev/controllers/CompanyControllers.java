package com.begaliev.java_8_exam_9_ulugbek_begaliev.controllers;

import com.begaliev.java_8_exam_9_ulugbek_begaliev.dtos.CompanyDTO;
import com.begaliev.java_8_exam_9_ulugbek_begaliev.models.Company;
import com.begaliev.java_8_exam_9_ulugbek_begaliev.models.CompanyRegisterForm;
import com.begaliev.java_8_exam_9_ulugbek_begaliev.services.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/api/companies")
public class CompanyControllers {

    private final CompanyService companyService;

    @GetMapping
    public Page<CompanyDTO> getAll(Pageable pageable) {
        return companyService.getAll(pageable);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public String registerPage(@Valid @RequestBody CompanyRegisterForm companyRequestDto,
                               BindingResult validationResult,
                               RedirectAttributes attributes) {
        attributes.addFlashAttribute("dto", companyRequestDto);

        if (validationResult.hasFieldErrors()) {
            attributes.addFlashAttribute("errors", validationResult.getFieldErrors());
            return "redirect:/register";
        }
        companyService.register(companyRequestDto);
        return "redirect:/login";
    }

    public String save(@ModelAttribute("company") Company company, HttpServletRequest request) {
        if (company.getCaptcha().equals(request.getSession().getAttribute("captcha"))) {
            companyService.add(company);
            return "redirect:/list";
        } else {
            return "redirect:/";
        }
    }
}
