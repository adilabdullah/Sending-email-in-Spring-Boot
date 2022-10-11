package com.spring.notification.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.spring.notification.model.Email;
import com.spring.notification.service.EmailServiceImpl;
import com.spring.notification.service.SMSService;

@RestController
public class HomeController {
	   @Autowired 
	   private JavaMailSender javaMailSender;
	   
		 @Autowired
		 private RestTemplate restTemplate;
	   
		 @Autowired
		 private EmailServiceImpl emailServiceImpl;
		 
		 
	   @Autowired 
	   private SMSService smsService;
	  
	    @Value("${spring.mail.username}") private String sender;
	    
	    @PostMapping("/SendMail")
	    public String sendMail(@RequestBody Email email)
	    {
	 
	        // Try block to check for exceptions
	    	return emailServiceImpl.sendSimpleMail(email);
 
	    }
	    
	 
	    
	    @PostMapping("/SendAttachMail")
	    public String sendMailWithAttachment(@RequestBody Email email)
	    {
	    	return emailServiceImpl.sendMailWithAttachment(email); 
	    }
	    
	    
/*	    @GetMapping("/SendSMS")
	    public String sendSMS()
	    {
	    	try {
			List<CompletableFuture<String>> allFutures = new ArrayList<>();

			allFutures.add(smsService.callMsgService());
		//	CompletableFuture.allOf(allFutures.toArray());
		//	CompletableFuture.completedFuture(allFutures);
		//	CompletableFuture.allOf(allFutures.toArray(new CompletableFuture[0])).join();
			CompletableFuture.allOf(allFutures.toArray(new CompletableFuture[0])).join();

			for (int i = 0; i < 10; i++) {
				System.out.println("response: " + allFutures.get(i).get().toString());
			
			}
			return "Success";
	      }
	    	catch(Exception ex)
	    	{
	    		return "Error: "+ex.getMessage();
	    	}

	    }  */
	    
	    @GetMapping("/sendSMS")
	    public String sendSMS(@RequestParam("name") String name,@RequestParam("cell") String cell,@RequestParam("content") String content)
	    {
	    	List<String> smsList;
	        CompletableFuture<String> smsSendingList = smsService.callMsgService(cell, name, content);
	        return smsSendingList.join();
	    }
}
