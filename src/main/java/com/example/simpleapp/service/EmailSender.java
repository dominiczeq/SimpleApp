package com.example.simpleapp.service;

public interface EmailSender {
    void sendEmail (String to, String subject, String content);
}
