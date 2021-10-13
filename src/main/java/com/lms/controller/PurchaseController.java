package com.lms.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.model.Purchase;
import com.lms.impl.PurchaseServiceImpl;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/purchase")
public class PurchaseController {
	
	@Autowired
	PurchaseServiceImpl purchaseServiceImpl;
	
	Logger logger=LoggerFactory.getLogger(CourseController.class);

	@GetMapping()
		
		public ResponseEntity<Map<String,String>> getPurchaseItems(){
			
			logger.trace(" Purchase Course Successfully");
			
			return purchaseServiceImpl.getPurchaseCourse();
		}
		
	
	@PostMapping()
		
		public ResponseEntity<Map<String,String>> insertPurchaseItems(@RequestBody Purchase purchase){
			
			logger.trace("Course Purchase Successfully");
			
			return purchaseServiceImpl.savePurchaseCourse(purchase);
		}
	}
