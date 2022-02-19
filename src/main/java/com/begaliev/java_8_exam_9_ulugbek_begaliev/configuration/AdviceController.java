package com.begaliev.java_8_exam_9_ulugbek_begaliev.configuration;

import com.begaliev.java_8_exam_9_ulugbek_begaliev.models.Constant;
import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class AdviceController {

    public List<String> getTicketModel(HttpSession httpSession){
        var list = httpSession.getAttribute(Constant.TICKET_ID);
        if (list == null){
            httpSession.setAttribute(Constant.TICKET_ID, new ArrayList<>());
        }
        return (List<String>) httpSession.getAttribute(Constant.TICKET_ID);
    }
}
