package com.spring.notification.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;

import org.springframework.util.ResourceUtils;

public class RedisService {

	public void putCache()
	{
		try {
			File file = ResourceUtils.getFile("classpath:‪D:\\Config\\SpringBoot.properties");
			byte[] fileData = Files.readAllBytes(file.toPath());
			String fileContent = new String(fileData);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
