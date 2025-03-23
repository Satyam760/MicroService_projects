package com.nt.ms;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.clint.BillingServiceRestController;

@RestController
@RequestMapping("/shopping")
public class ShopingServiceOperationController {
	
	@Autowired
	private BillingServiceRestController client;
	
	@GetMapping("/details")
	public ResponseEntity<String>showBillingDetails(){
		//use client component support to invoke Provider MS service
		String resultBody=client.getBillingInfo();
		//return responseEntity obj from consumer ms
		String billInfo="Bill amount "+new Random().nextInt(100000);//consumer ms result
		return new ResponseEntity<String>(billInfo+"...."+resultBody,HttpStatus.OK);//contains provider and consumer MS
		
		
		
	}
	
	
}
