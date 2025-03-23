package com.nt.clint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BillingServiceRestController {
	
	@Autowired
	private DiscoveryClient client;
	
	
	public String getBillingInfo() {
		
		//find the service instance of producer by service Id
		List<ServiceInstance>listSI=client.getInstances("Billing-Service");
		
		//use first service instance from the list of instance
		ServiceInstance SI=listSI.get(0);
		
		//get Producer MS URI and make it as URL
		String url=SI.getUri()+"/billing/info";
		
		//create rest templet obj
		RestTemplate templet= new RestTemplate();
		
		//invoke producer MS service method or operation by getting http call
		String resp= templet.getForObject(url,String.class);
		
		return resp;
		
	}
	
}
