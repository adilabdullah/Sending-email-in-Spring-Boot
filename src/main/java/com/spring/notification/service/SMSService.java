package com.spring.notification.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SMSService{
	 
	 @Autowired
	 private RestTemplate restTemplate;
	
	@Async
	public CompletableFuture<String> callMsgService(String cell,String name,String content) {

  	  HttpHeaders headers = new HttpHeaders();
  	    // set `accept` header
  	    headers.set("x-request-source", "desktop");
  	    headers.set("X-Rapidapi-Key","########################################");
  	    headers.set("X-Rapidapi-Host","#################");
  	    headers.set("Token","################################################################################################);
  	    HttpEntity request = new HttpEntity(headers);
		final String msgServiceUrl = "##################################";
      String req="{\r\n" + 
      		"    \"messages\": [\r\n" + 
      		"        {\r\n" + 
      		"            \"channel\": \"sms\",\r\n" + 
      		"            \"originator\": \""+name+"\",\r\n" + 
      		"            \"recipients\": [\r\n" + 
      		"                \""+cell+"\"\r\n" + 
      		"            ],\r\n" + 
      		"            \"content\": \""+content+"\",\r\n" + 
      		"            \"msg_type\": \"text\"\r\n" + 
      		"        }\r\n" + 
      		"    ]\r\n" + 
      		"}";
	//	return restTemplate.postForObject(msgServiceUrl,new JSONObject(req), String.class);
//   	return restTemplate.exchange(msgServiceUrl, HttpMethod.POST, request,req);
      HttpEntity<String> entity = new HttpEntity<String>(req, headers);

  	ResponseEntity<String> responseJson =restTemplate.exchange(msgServiceUrl, HttpMethod.POST,entity,String.class);
  	return CompletableFuture.completedFuture(responseJson.toString());
		}
}
