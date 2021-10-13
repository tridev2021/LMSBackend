package com.lms.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lms.model.Purchase;
import com.lms.repository.PurchaseRepo;
import com.lms.service.PurchaseService;

@Service
public class PurchaseServiceImpl implements PurchaseService {

	@Autowired
	PurchaseRepo purchaseRepo;
	
	@Override
	public ResponseEntity<Map<String, String>> getPurchaseCourse() {
		
		Map<String,String> response=new HashMap<>();
		purchaseRepo.findAll();
		response.put("Purchase Course", "successfully");
		return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<Map<String, String>> savePurchaseCourse(Purchase purchase) {
		 
		Map<String,String> response=new HashMap<>();
		purchaseRepo.save(purchase);
		response.put("Purchase Course", "successfully");
		return ResponseEntity.ok(response);
	}

	

}
