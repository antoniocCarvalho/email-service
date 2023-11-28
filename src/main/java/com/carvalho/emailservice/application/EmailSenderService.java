package com.carvalho.emailservice.application;

import com.carvalho.emailservice.adapters.EmailSenderGateway;
import com.carvalho.emailservice.core.EmailSenderUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmailSenderService implements EmailSenderUseCase {

    private final EmailSenderGateway emailSenderGateway;


    @Autowired
    public EmailSenderService(EmailSenderGateway emailSenderGateway){
        this.emailSenderGateway = emailSenderGateway;
    }


    @Override
    public void sendEmail(String to, String subject, String body) {
        this.emailSenderGateway.senderEmail(to, subject, body );
    }
}
