package com.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.model.Purchase;

public interface PurchaseRepo extends JpaRepository<Purchase, Long>{

}
