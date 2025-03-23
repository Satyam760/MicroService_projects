package com.nt.client;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BillingServiceConsumerClient {
	
	@Autowired
	private LoadBalancerClient client;
	
	public String getBillingInfo() {
		//get Billing-service instance from eureka server based on LoadFactor
		ServiceInstance instance = client.choose("Billing-Service");
		//get details from Service instance
		URI uri= instance.getUri();
		//prepare provide MS related to url to consume method
		String url=uri.toString()+"/billing/api/info";
		
		//create rest template clas obj to consume the provide service
		 RestTemplate template=new RestTemplate();
		 //consume the provide service 
		 ResponseEntity<String>response=template.getForEntity(url,String.class);
		 //get response content from responseEntity obj
		 String responseContent = response.getBody();
		 
		 return responseContent;
				
	
	}
	
	
	

}
