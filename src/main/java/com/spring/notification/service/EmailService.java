package com.spring.notification.service;

import com.spring.notification.model.Email;

public interface EmailService {
	   // Method
    // To send a simple email
    String sendSimpleMail(Email details);
 
    // Method
    // To send an email with attachment
    String sendMailWithAttachment(Email details);
}
