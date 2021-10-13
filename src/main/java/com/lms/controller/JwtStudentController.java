//package com.lms.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import com.lms.entity.JwtRequest;
//import com.lms.entity.JwtResponse;
//import com.lms.helper.JwtUtil;
//import com.lms.serviceimpl.CustomStudentDetailsService;
//import com.lms.serviceimpl.CustomUserDetailsService;
//
//public class JwtStudentController {
//
//	 @Autowired
//	    private AuthenticationManager authenticationManager;
//
//
//	    @Autowired
//	    private CustomStudentDetailsService customStudentDetailsService;
//
//	    @Autowired
//	    private JwtUtil jwtUtil;
//
//	    @RequestMapping(value = "/token", method = RequestMethod.POST)
//	    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
//
//	        System.out.println("Inside Controller");
//	        System.out.println(jwtRequest);
//	        try {
//
//	            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
//
//
//	        } catch (UsernameNotFoundException e) {
//	            e.printStackTrace();
//	            throw new Exception("Bad Credentials");
//	        }catch (BadCredentialsException e)
//	        {
//	            e.printStackTrace();
//	            throw new Exception("Bad Credentials");
//	        }
//
//
//	        //fine area..
//	        UserDetails userDetails = this.customStudentDetailsService.loadUserByUsername(jwtRequest.getUsername());
//
//	        String token = this.jwtUtil.generateToken(userDetails);
//	        System.out.println("JWT " + token);
//
//	        //{"token":"value"}
//
//	        return ResponseEntity.ok(new JwtResponse(token));
//
//	    }
//}
