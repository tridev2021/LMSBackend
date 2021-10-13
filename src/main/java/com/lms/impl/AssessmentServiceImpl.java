//package com.lms.serviceimpl;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//import com.lms.entity.Assessment;
//import com.lms.entity.TechSkill;
//import com.lms.repository.AssessmentRepo;
//import com.lms.service.AssessmentService;
//@Service
//public class AssessmentServiceImpl implements AssessmentService {
//    @Autowired
//	AssessmentRepo assessmentrepo;
//	
//    @Override
//	public List<Assessment> getdata() {
//		// TODO Auto-generated method stub
//		return assessmentrepo.findAll();
//		
//	}
//    
//    @Override
//	public ResponseEntity<Assessment> insertdata(Assessment assessment) {
//		// TODO Auto-generated method stub
//    	Assessment ass=assessmentrepo.save(assessment);
//    	System.out.println(ass);
//		return ResponseEntity.ok(ass);
//	}
//	
//    @Override
//	public ResponseEntity<Assessment> updatedata(Assessment assessment, Long AId) {
//		// TODO Auto-generated method stub
//    	Assessment ass=assessmentrepo.findById(AId).orElseThrow(null);
//    	ass.setFacultyName(assessment.getFacultyName());
//    	ass.setTechSkill(assessment.getTechSkill());
//    	ass.setTotalAssessment(assessment.getTotalAssessment());
//    	Assessment ass1=assessmentrepo.save(ass);
//		return ResponseEntity.ok(ass1);
//	}
//
//	@Override
//	public  ResponseEntity<Map<String,String>> deletedata(Assessment assessment, Long AId) {
//		Map<String,String> response=new HashMap<>();
//		 assessmentrepo.deleteById(AId);
//		response.put("Data","Delete data from the table");
//			return ResponseEntity.ok(response);
//		
//		
//		
//				}
//	
//	
//
//	
//
//
//
//	
//
//	
//    
//}
