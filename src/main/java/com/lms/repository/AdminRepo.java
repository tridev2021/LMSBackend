package com.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.lms.entity.Admin;

public interface AdminRepo extends JpaRepository<Admin, Long>{
     public Admin findByEmail(String email);
      Admin findByUsername(String username);
      //public Admin findByID(Long ID);
      @Query("SELECT u FROM Admin u WHERE u.verificationcode = ?1")
      public Admin findByVerificationCode(String code);
      @Query("UPDATE Admin c SET c.enabled = true WHERE c.ID = ?1")
      @Modifying
      @Transactional
	public void enabled(Long ID);
      
      @Query(value="Select * from admin where username=?1",nativeQuery = true)
  	public List<Admin> getAdminByname(String admin_name);
    
}





