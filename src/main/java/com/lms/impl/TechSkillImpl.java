//package com.lms.serviceimpl;
//
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//
//
//import com.lms.entity.TechSkill;
//import com.lms.repository.TechSkillRepo;
//import com.lms.service.TechSkillService;
//
//
//
//@Service
//public  class TechSkillImpl implements TechSkillService {
//	
//	@Autowired 
//   TechSkillRepo techskillrepo;
//	
//	
//	
//	@Override
//	public void insertdata(TechSkill techskill) {
//		// TODO Auto-generated method stub
//		techskillrepo.save(techskill);
//	}
//
//
//
//	@Override
//	public List<TechSkill> getdata() {
//		// TODO Auto-generated method stub
//		return techskillrepo.findAll();
//	}
//
//
//
//	@Override
//	public ResponseEntity<TechSkill> update(TechSkill techskill, Long tId) {
//		// TODO Auto-generated method stub
//		   TechSkill tech=techskillrepo.findById(tId).orElseThrow(null);
//		   System.out.println(tech);
//		   tech.setCourseName(techskill.getCourseName());
//		   tech.setEnrollStudent(techskill.getEnrollStudent());
//		   tech.setFacultyName(techskill.getFacultyName());
//		   TechSkill techz=techskillrepo.save(tech);
//		   System.out.println(techz);
//		 return ResponseEntity.ok(techz);
//		
//	}
////	@Override
////	public void update(TechSkill techskill, Long tId) {
////		// TODO Auto-generated method stub
////		TechSkill tech=techskillrepo.findById(tId).orElseThrow(null);
////		System.out.println(tech);
////		   tech.setCourseName(tech.getCourseName());
////		   tech.setEnrollStudent(tech.getEnrollStudent());
////		   tech.setFacultyName(tech.getFacultyName());
////		   TechSkill techz=techskillrepo.save(tech);
////		
////	}
//
//
//
//	
//
//
//
////	@Override
////	public ResponseEntity<TechSkill> updata(TechSkill techskill, Long tId) {
////		// TODO Auto-generated method stub
////		TechSkill tech=techskillrepo.findById(tId).orElseThrow(null);
////		System.out.println(tech);
////		   tech.setCourseName(tech.getCourseName());
////		   tech.setEnrollStudent(tech.getEnrollStudent());
////		   tech.setFacultyName(tech.getFacultyName());
////		   TechSkill techz=techskillrepo.save(tech);
////			return ResponseEntity.ok(techz);
////		
////	}
//}
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
//	
//	
//	
//
//
