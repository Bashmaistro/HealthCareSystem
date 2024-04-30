package com.healthcaresystem.service;

public interface EmailSenderService {
    void sendMail(String email, String emailVerification, String valueOf);
}
