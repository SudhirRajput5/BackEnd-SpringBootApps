package com.sudhir.SpringBootConsumeRestAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sudhir.SpringBootConsumeRestAPI.entity.Employee;

@RestController

public class ConsumerController {
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@RequestMapping(value = "/getAll", method=RequestMethod.GET)
	public void getAllusers() {
		
		List<ServiceInstance> instances=discoveryClient.getInstances("EMPLOYEE-ZUUL-SERVICE");
		ServiceInstance serviceInstance=instances.get(0);
		
		String baseUrl=serviceInstance.getUri().toString();
		
		
    	HttpHeaders headers = getHeaders();  
        RestTemplate restTemplate = new RestTemplate();
	    String url = baseUrl + "/producer/employee";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Employee> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Employee.class);     
    
        Employee en = responseEntity.getBody();
       
              System.out.println("Name:"+en.getName());
        
	}
     
	   
    private HttpHeaders getHeaders() {
    	HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);     	
    	return headers;
    }
}
