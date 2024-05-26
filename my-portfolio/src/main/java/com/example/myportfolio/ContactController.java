package com.example.myportfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ContactController {

    @Autowired
    private JavaMailSender mailSender;

    @PostMapping("/contact")
    @ResponseBody
    public String handleContactForm(
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String email,
            @RequestParam String subject,
            @RequestParam String message) {

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo("davidprograms7@gmail.com");
        mailMessage.setSubject("New Contact Form Submission: " + subject);
        mailMessage.setText("Name: " + firstName + " " + lastName + "\nEmail: " + email + "\nMessage: " + message);

        mailSender.send(mailMessage);

        return "Message sent successfully";
    }
}