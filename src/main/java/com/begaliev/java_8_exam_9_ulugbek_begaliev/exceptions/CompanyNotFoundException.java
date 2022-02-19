package com.begaliev.java_8_exam_9_ulugbek_begaliev.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class CompanyNotFoundException extends RuntimeException {
}
