package com.lms;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.lms.model.Student;
import com.lms.repository.StudentRepo;
import com.lms.impl.StudentServiceImpl;
@RunWith(SpringRunner.class)
@SpringBootTest
class LearningManagmentSystemApplicationTests {

	@Autowired
	private StudentServiceImpl studentServiceImpl;
	
	@MockBean
	private StudentRepo studentRepo;
	
	@Test
	public void getTest() {
		when(studentRepo.findAll()).thenReturn(Stream.of(new Student(1L,"mayank","noida",(java.util.Date) new Date(01-02-2021),"9045913270","mayank23@gmail.com","12345"),new Student(2L,"astha","delhi",(java.util.Date) new Date(2021-01-01),"9045913270","astha12@gmail.com","12345")).collect(Collectors.toList()));
	 assertEquals(2, studentServiceImpl.getStudent().size());
	}

//	@Test
//	public  Student registerTest() {
//		Student student=new Student(1L,"mayank","noida",(java.util.Date) new Date(2021-01-01),"9045913270","mayank23@gmail.com","12345");
//		when(studentRepo.save(student)).thenReturn(student);
//		assertEquals(student, studentServiceImpl.register(student));
//	}
	
	@Test
	public void getbyidTest() {
		Long id=1L;
		when(studentRepo.getStudentbyId(id)).thenReturn(Stream.of(new Student(1L,"astha","delhi",(java.util.Date) new Date(2021-01-01),"9045913270","astha12@gmail.com","12345")).collect(Collectors.toList()));
	    assertEquals(1, studentServiceImpl.getStudentById(id).size());
	}

	@Test
	public void getbyemailTest() {
		String email="astha12@gmail.com";
		when(studentRepo.getStudentbyemail(email)).thenReturn(Stream.of(new Student(1L,"astha","delhi",(java.util.Date) new Date(2021-01-01),"9045913270","astha12@gmail.com","12345")).collect(Collectors.toList()));
		assertEquals(1, studentServiceImpl.getStudentByemail(email).size());
	}
	
	@Test
	public void getbynameTest() {
		String name="astha";
		when(studentRepo.getStudentByname(name)).thenReturn(Stream.of(new Student(1L,"astha","delhi",(java.util.Date) new Date(2021-01-01),"9045913270","astha12@gmail.com","12345")).collect(Collectors.toList()));
		assertEquals(1, studentServiceImpl.getStudentByname(name).size());
	}
	
	
//	@Test
//	public void deleteTest() {
//		Long sid=1L;
//		Student student=new Student(1L,"astha","delhi",(java.util.Date) new Date(2021-01-01),"9045913270","astha12@gmail.com","12345");
//		 studentServiceImpl.deleteById(sid);
//		 verify(studentRepo,times(1)).delete(student);
//		
//	}
	
//	@Test
//	public void deleteTest() {
//		Long id=1L;
//		Faculty faculty=new Faculty(1L,"noida","m@gmail.com","123","9045913270","mayank");
//		facultyServiceImpl.delete(id);
//		verify(facultyRepo,times(1)).delete(faculty);
//	}	
		
}