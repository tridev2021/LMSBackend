//package com.lms.serviceimpl;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.lms.entity.Admin;
//import com.lms.entity.CustomUserDetails;
//
//import com.lms.repository.AdminRepo;
//
//
//import java.util.ArrayList;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//   
//    @Autowired
//    private AdminRepo adminRepo;
//
//    @Override
//    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//
//        //final User user = this.userRepository.findByUsername(userName);
//        final Admin admin = this.adminRepo.findByUsername(userName);
//
//        if (admin == null) {
//            throw new UsernameNotFoundException("Admin not found !!");
//        } else {
//            return new CustomUserDetails(admin);
//        }
//
//
//        //user database `
//
////        if (userName.equals("Durgesh")) {
////            return new User("Durgesh", "Durgesh123", new ArrayList<>());
////        } else {
////            throw new UsernameNotFoundException("User not found !!");
////        }
//
//    }
//}
