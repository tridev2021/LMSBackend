package com.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.lms.entity.Admin;

public interface AdminRepo extends JpaRepository<Admin, Long>{
     public Admin findByEmail(String email);
      Admin findByUsername(String username);
      //public Admin findByID(Long ID);

}
