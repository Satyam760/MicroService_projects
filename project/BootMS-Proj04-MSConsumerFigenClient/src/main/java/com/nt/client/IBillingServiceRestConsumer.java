package com.nt.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("Billing-Service")  //target MS service Id
public interface IBillingServiceRestConsumer {

	
	@GetMapping("/billing/api/info") //complet request path of target ms service method
	public String fetchBillDetails();
	
	
}
