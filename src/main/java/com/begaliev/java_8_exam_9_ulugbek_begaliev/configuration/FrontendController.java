package com.begaliev.java_8_exam_9_ulugbek_begaliev.configuration;

import com.begaliev.java_8_exam_9_ulugbek_begaliev.exceptions.ResourceNotFoundException;
import com.begaliev.java_8_exam_9_ulugbek_begaliev.models.CompanyRegisterForm;
import com.begaliev.java_8_exam_9_ulugbek_begaliev.services.CompanyService;
import com.begaliev.java_8_exam_9_ulugbek_begaliev.services.PasswordManagerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping
@AllArgsConstructor
public class FrontendController {

    private final CompanyService companyService;
    private final PasswordManagerService passwordManagerService;

    @GetMapping("/login")
    public String loginPage(@RequestParam(required = false, defaultValue = "false") Boolean error, Model model) {
        model.addAttribute("error", error);
        return "login";
    }

    @GetMapping("/flight")
    public String pageCompanyProfile(Model model, Principal principal)
    {
        var user = companyService.getByEmail(principal.getName());
        model.addAttribute("dto", user);
        return "flight";
    }

    @GetMapping("/register")
    public String pageRegisterCompany(Model model) {
        if (!model.containsAttribute("dto")) {
            model.addAttribute("dto", new CompanyRegisterForm());
        }
        return "register";
    }

    @PostMapping("/register")
    public String registerPage(@Valid CompanyRegisterForm companyRequestDto,
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

    @GetMapping("/forgot-password")
    public String pageForgotPassword(){
        return "forgot";
    }

    @PostMapping("forgot-password")
    public String resetPassword(@RequestParam("email") String email,
                                RedirectAttributes attributes){

        if (!companyService.existsByEmail(email)){
            attributes.addFlashAttribute("errorText", "Entered email does not exist");
            return "redirect:/forgot-password";
        }
        passwordManagerService.createToken(email);

        return "redirect:/forgot-success";
    }

    @GetMapping("/forgot-success")
    public String pageResetPassword(){
        return "forgot-success";
    }

    @PostMapping("/reset-password")
    public String submitResetPasswordPage(@RequestParam("token") String token,
                                          @RequestParam("newPassword") String newPassword,
                                          RedirectAttributes attributes) {
        if (!passwordManagerService.existsByToken(token)) {
            attributes.addFlashAttribute("errorText", "Entered email does not exist!");
            return "redirect:/reset-password";
        }
        companyService.resetPassword(token, newPassword);
        return "redirect:/login";
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    private String handleRNF(ResourceNotFoundException ex, Model model){

        model.addAttribute("resource", ex);
        model.addAttribute("id", ex.getId());

        return "resource-not-found";
    }
}
