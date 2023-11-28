package com.carvalho.emailservice.controllers;

import com.carvalho.emailservice.application.EmailSenderService;
import com.carvalho.emailservice.core.EmailRequest;
import com.carvalho.emailservice.core.exceptions.EmailServiceExcepetion;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")

public class EmailSenderController {
    private final EmailSenderService emailSenderService;


    @Autowired
    public EmailSenderController(EmailSenderService emailService){
        this.emailSenderService = emailService;
    }


    @PostMapping()
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest request){
        try{
            this.emailSenderService.sendEmail(request.to(), request.subject(), request.body());
            return ResponseEntity.ok("Email send sucessfully");
        }catch (EmailServiceExcepetion excepetion){
            return ResponseEntity.status(HttpStatus.SC_INTERNAL_SERVER_ERROR).body("Error while sending email");
        }
    }
}
