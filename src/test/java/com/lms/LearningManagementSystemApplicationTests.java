
package com.lms;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.io.UnsupportedEncodingException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.mail.MessagingException;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.lms.entity.Admin;
import com.lms.repository.AdminRepo;
import com.lms.serviceimpl.AdminServiceImpl;

//import com.lms.entity.Faculty;
//import com.lms.repository.FacultyRepo;
//import com.lms.serviceimpl.FacultyServiceImpl;
@RunWith(SpringRunner.class)
@SpringBootTest
class LearningManagmentSystemApplicationTests {

	@Autowired
	private  AdminServiceImpl adminserviceimpl;
	
	@MockBean
	private AdminRepo adminrepo;
	
	@Test
	public void getTest() {
		when(adminrepo.findAll()).thenReturn(Stream.of(new Admin(1L,"lalit","lalitraghavji1996@gmail.com","1234","asdfghnjmhgfdsxdf",true),new Admin(2L,"astha","astha@gmail.com","1234","sdfvgbhnxcvb",true)).collect(Collectors.toList()));
	 assertEquals(2, adminserviceimpl.getdata().size());
	}

	@Test
	public void registerTest() throws UnsupportedEncodingException, MessagingException {
		Admin admin=new Admin(1L,"lalit","lalitraghavji1996@gmail.com","1234","asdfghnjmhgfdsxdf",true);
		when(adminrepo.save(admin)).thenReturn(admin);
		String siteURL = null;
		assertEquals(admin, adminserviceimpl.register(admin,siteURL));
	}
	
//	@Test
//	public void getbyidTest() {
//		Long id=1L;
//		when(adminrepo.findById(id)).thenReturn(Stream.of(new Admin(1L,"lalit","lalitraghavji1996@gmail.com","1234","asdfghnjmhgfdsxdf",true)).collect(Collectors.toList()));
//	    assertEquals(1, adminserviceimpl.findById(id).size());
//	}
	
//	@Test
//	public void getbyemailTest() {
//		String email="lalit@gmail.com";
//		when(adminrepo.get).thenReturn(Stream.of(new Admin(1L,"noida","m@gmail.com","123","9045913270","mayank")).collect(Collectors.toList()));
//		assertEquals(1, adminserviceimpl.getFacultyByemail(email).size());
//	}
	
	@Test
	public void getbynameTest() {
		String name="lalit";
		when(adminrepo.getAdminByname(name)).thenReturn(Stream.of(new Admin(1L,"lalit","lalitraghavji1996@gmail.com","1234","asdfghnjmhgfdsxdf",true)).collect(Collectors.toList()));
		assertEquals(1, adminserviceimpl.getAdminByname(name).size());
	}
	
//	@Test
//	public void deleteTest() {
//		Long id=1L;
//		Faculty faculty=new Faculty(1L,"noida","m@gmail.com","123","9045913270","mayank");
//		facultyServiceImpl.delete(id);
//		verify(facultyRepo,times(1)).delete(faculty);
//	}
		
}