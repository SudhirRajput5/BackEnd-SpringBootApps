package com.sudhir.SpringBootConsumeRestAPI.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sudhir.SpringBootConsumeRestAPI.entity.UserEntity;

@RestController

public class ConsumerController {

	@RequestMapping(value = "/getAll", method=RequestMethod.GET)
	public void getAllusers() {
    	HttpHeaders headers = getHeaders();  
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/users/all";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<UserEntity[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, UserEntity[].class);     
    
        UserEntity[] en = responseEntity.getBody();
        for(UserEntity topic : en) {
              System.out.println("Id:"+topic.getFirstName());
        }
	}
     
	   
    private HttpHeaders getHeaders() {
    	HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);     	
    	return headers;
    }
}
