package com.lms.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.lms.model.Purchase;

public interface PurchaseService {

	public ResponseEntity<Map<String,String>> getPurchaseCourse();
	
	public ResponseEntity<Map<String,String>> savePurchaseCourse(Purchase purchase);
}
