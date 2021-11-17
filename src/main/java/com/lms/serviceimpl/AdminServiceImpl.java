package com.lms.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.lms.entity.Admin;
import com.lms.repository.AdminRepo;
import com.lms.service.AdminService;
@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	AdminRepo adminrepo;

  
	   private static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
public String hash(String password) {
		
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
@Override

public String Login(String username, String password) {

   Admin admin=adminrepo.findByUsername(username);

  
   if(admin!=null) {
		
		if(verifyHash(password, admin.getPassword())) {
			
			return "Login Successfully";
		}
   }
	
		return "Not Login";

}

	 public boolean verifyHash(String password, String hash) {
	        return BCrypt.checkpw(password, hash);
	    }
	@Override
	public ResponseEntity<Map<String,String>> delete( Long ID) {
		// TODO Auto-generated method stub
		Map<String,String> response=new HashMap<>();
		response.put("Data", "Delete data Successfully");
	    adminrepo.deleteById(ID);
		return ResponseEntity.ok(response);
	}
	@Override
	public List<Admin> getdata() {
		// TODO Auto-generated method stub
		return adminrepo.findAll();
	}
	@Override
	public ResponseEntity<Admin> update(Admin admin, Long tId) {
		// TODO Auto-generated method stub
		Admin adm=adminrepo.findById(tId).orElseThrow(null);
		   System.out.println(adm);
		   adm.setEmail(admin.getEmail());
		  adm.setUsername(admin.getUsername());
		   Admin adms=adminrepo.save(adm);
		   System.out.println(adms);
		 return ResponseEntity.ok(adms);
	}
	@Override
	public Optional<Admin> findById(Long ID) {
		// TODO Auto-generated method stub
		return adminrepo.findById(ID);
	}
	
	@Override
	public Admin insert(Admin admin) {
		
        String pass=hash(admin.getPassword());
		
		admin.setPassword(pass);
		
		
		return adminrepo.save(admin);
	}
	
	


	
	
}
