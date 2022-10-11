package com.spring.notification.service;

import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.util.Iterator;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import org.springframework.util.ResourceUtils;

public class Utility {

	public static void main(String[] args)
	{
		try {
			File file = ResourceUtils.getFile("D:\\Config\\SpringBoot.properties");
			byte[] fileData = Files.readAllBytes(file.toPath());
			String fileContent = new String(fileData);  
	        JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(fileContent);
           
            Set<String> keys = jsonObject.keySet();

      /*      Iterator<String> iterate = jsonObject.keySet().iterator();
            while(iterate.hasNext()) {
                JSONObject obj=(JSONObject) jsonObject.get(iterate.next());
            	System.out.println(obj);
              }  */
            for(String key:keys)
            {
            	JSONObject obj=(JSONObject) jsonObject.get(key);
            	Set<String> kobj=obj.keySet();
            	 for(String ob:kobj)
                 {
            		 System.out.println(key+"-"+ob+"=="+obj.get(ob));	 
                 }
            }  
            /*    JSONObject jsonObject1 = (JSONObject) jsonObject.get("SendSMSEmail");

			System.out.println(jsonObject1.get("x-request-source"));  */
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
}
