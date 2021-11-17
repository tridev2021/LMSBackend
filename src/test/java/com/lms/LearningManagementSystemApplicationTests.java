package com.lms;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.lms.entity.Admin;
import com.lms.entity.Assessment;
import com.lms.entity.Course;
import com.lms.entity.Faculty;
import com.lms.entity.Student;
import com.lms.entity.TechSkill;
import com.lms.repository.AdminRepo;
import com.lms.repository.AssessmentRepo;
import com.lms.repository.CourseRepo;
import com.lms.repository.FacultyRepo;
import com.lms.repository.StudentRepo;
import com.lms.repository.TechSkillRepo;
import com.lms.serviceimpl.AdminServiceImpl;
import com.lms.serviceimpl.AssessmentServiceImpl;
import com.lms.serviceimpl.CourseServiceImpl;
import com.lms.serviceimpl.FacultyServiceImpl;
import com.lms.serviceimpl.StudentServiceImpl;
import com.lms.serviceimpl.TechSkillImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class LearningManagmentSystemApplicationTests {

	@Autowired
	private FacultyServiceImpl facultyServiceImpl;
	
	@MockBean
	private FacultyRepo facultyRepo;
	
	
//	 Faculty
	
	
	@Test
	public void getTest() {
		when(facultyRepo.findAll()).thenReturn(Stream.of(new Faculty(1L,"noida","m@gmail.com","123","9045913270","mayank"),new Faculty(2L,"delhi","a@gmail.com","1234","1234567890","astha")).collect(Collectors.toList()));
	 assertEquals(2, facultyServiceImpl.getFaculty().size());
	
	}

	@Test
	public void registerTest() {
		Faculty faculty=new Faculty(1L,"noida","m@gmail.com","123","9045913270","mayank");
		when(facultyRepo.save(faculty)).thenReturn(faculty);
		assertEquals(faculty, facultyServiceImpl.insert(faculty));
	}
	
	@Test
	public void getbyidTest() {
		Long id=1L;
		when(facultyRepo.getFacultybyId(id)).thenReturn(Stream.of(new Faculty(1L,"noida","m@gmail.com","123","9045913270","mayank")).collect(Collectors.toList()));
	    assertEquals(1, facultyServiceImpl.getFacultyById(id).size());
	}
	
	@Test
	public void getbyemailTest() {
		String email="m@gmail.com";
		when(facultyRepo.getFacultybyemail(email)).thenReturn(Stream.of(new Faculty(1L,"noida","m@gmail.com","123","9045913270","mayank")).collect(Collectors.toList()));
		assertEquals(1, facultyServiceImpl.getFacultyByemail(email).size());
	}
	
	@Test
	public void getbynameTest() {
		String name="mayank";
		when(facultyRepo.getFacultyByname(name)).thenReturn(Stream.of(new Faculty(1L,"noida","m@gmail.com","123","9045913270","mayank")).collect(Collectors.toList()));
		assertEquals(1, facultyServiceImpl.getFacultyByname(name).size());
	}
	
	@Test
	public void deleteTest() {
		Faculty faculty= new Faculty(1L,"noida","m@gmail.com","123","9045913270","mayank");
		facultyServiceImpl.delete(faculty.getFID());
		verify(facultyRepo,times(1)).deleteById(faculty.getFID());
	}
	
   @Test
   public void updateTest() {
	   Faculty f=new Faculty();
	   f.setFID(1L);
	   f.setUsername("mayank");
	   f.setAddress("noida");
	   f.setEmail("m@gmail.com");
	   f.setMobile("9045913270");
	   f.setPassword("123");
	   facultyRepo.save(f);
	   assertNotNull(facultyRepo.findById(1L));
   }
	
	
//	Course
	
	
	@Autowired
	CourseServiceImpl courseServiceImpl;
	
	@MockBean
	CourseRepo courseRepo;
	
	@Test
	public void getAllCoursesTest() {
		when(courseRepo.findAll()).thenReturn(Stream.of(new Course(1L,"spring boot","6 months","25k"),new Course(2L,"django","4 months","20k")).collect(Collectors.toList()));
	 assertEquals(2, courseServiceImpl.getCourse().size());
	}
	
	@Test
	public void getCourseByIdTest() {
		Long id=1L;
		when(courseRepo.getCourseById(id)).thenReturn(Stream.of(new Course(1L,"spring boot","6 months","25k")).collect(Collectors.toList()));
	    assertEquals(1, courseServiceImpl.getCourseById(id).size());
	}
	
	@Test
	public void getCourseByCourseTest() {
		String course="spring boot";
		when(courseRepo.getCourseBycourseName(course)).thenReturn(Stream.of(new Course(1L,"spring boot","6 months","25k")).collect(Collectors.toList()));
	    assertEquals(1, courseServiceImpl.getCourseByName(course).size());
	}
	
	@Test
	public void insertTest() {
		
		Course course=new Course(1L,"spring boot","6 months","25k");
		when(courseRepo.save(course)).thenReturn(course);
		assertEquals(course, courseServiceImpl.add(course));
	}
	
	@Test
	public void deleteCourseTest() {
		Course course= new Course(1L,"spring boot","6 months","25k");
		courseServiceImpl.deleteCourse(course.getCID());
		verify(courseRepo,times(1)).deleteById(course.getCID());
	}
	
	 @Test
	   public void updateCourseTest() {
		   Course c=new Course();
		   c.setCID(1L);
		   c.setCoursename("spring boot");
		   c.setDuration("6 months");
		   c.setPrice("25k");
		   courseRepo.save(c);
		   assertNotNull(courseRepo.findById(1L));
	   }

//	Admin
	
	@Autowired
	AdminServiceImpl adminServiceImpl;
	
	@MockBean
	AdminRepo adminRepo;
	
	@Test
	public void saveregisterTest() {
		Admin admin=new Admin(1L,"mayank","m@gmail.com","123");
		when(adminRepo.save(admin)).thenReturn(admin);
		assertEquals(admin, adminServiceImpl.insert(admin));
	}
	
	@Test
	public void getsDataTest() {
		when(adminRepo.findAll()).thenReturn(Stream.of(new Admin(1L,"mayank","m@gmail.com","123"),new Admin(2L,"prateek","p@gmail.com","123")).collect(Collectors.toList()));
	 assertEquals(2, adminServiceImpl.getdata().size());
	}
	
	@Test
	public void deleteAdminTest() {
		Admin admin=new Admin(1L,"mayank","m@gmail.com","123");
		adminServiceImpl.delete(admin.getID());
		verify(adminRepo,times(1)).deleteById(admin.getID());
	}

	 @Test
	   public void updateAdminTest() {
		   Admin a=new Admin();
		   a.setID(1L);
		   a.setUsername("mayank");
		   a.setEmail("m@gmail.com");
		   a.setPassword("123");
		   adminRepo.save(a);
		   assertNotNull(adminRepo.findById(1L));
	   }
	 
//Assessmemt
	
	@Autowired
	AssessmentServiceImpl assessmentServiceImpl;
	
	@MockBean
	AssessmentRepo assessmentRepo;
	
	@Test
	public void fetchDataTest() {
		when(assessmentRepo.findAll()).thenReturn(Stream.of(new Assessment(1L,"java","5","mayank"),new Assessment(2L,"python","3","astha")).collect(Collectors.toList()));
	 assertEquals(2, assessmentServiceImpl.getdata().size());
	}
	
	@Test
	public void saveAssessmentTest() {
		Assessment assessment=new Assessment(1L,"java","5","mayank");
		when(assessmentRepo.save(assessment)).thenReturn(assessment);
		assertEquals(assessment, assessmentServiceImpl.insertdata(assessment));
	}
	
	@Test
	public void deleteAssessmentTest() {
		Assessment assessment=new Assessment(1L,"java","5","mayank");
		assessmentServiceImpl.deletedata(assessment.getAId());
		verify(assessmentRepo,times(1)).deleteById(assessment.getAId());
	}
	
	@Test
    public void updateAssessmentTest() {
		Assessment a=new Assessment();
	    a.setAId(1L);
        a.setFacultyName("mayank");
	    a.setTechSkill("java");
        a.setTotalAssessment("10");
	    assertNotNull(assessmentRepo.findById(1L));
	   }
	
//Student
	
	@Autowired
	private StudentServiceImpl studentServiceImpl;
	
	@MockBean
	private StudentRepo studentRepo;
	
	@Test
	public void getstudentTest() {
		when(studentRepo.findAll()).thenReturn(Stream.of(new Student(1L,"mayank","noida","01-02-2021","9045913270","mayank23@gmail.com","12345"),new Student(2L,"astha","delhi","2021-01-01","9045913270","astha12@gmail.com","12345")).collect(Collectors.toList()));
	 assertEquals(2, studentServiceImpl.getStudent().size());
	}

	@Test
	public void deleteStudentTest() {
		Student student=new Student(1L,"mayank","noida","01-02-2021","9045913270","mayank23@gmail.com","12345");
		studentServiceImpl.delete(student.getSid());
		verify(studentRepo,times(1)).deleteById(student.getSid());;
	}
	
	@Test
	public void getstudentbyidTest() {
		Long id=1L;
		when(studentRepo.getStudentbyId(id)).thenReturn(Stream.of(new Student(1L,"astha","delhi","01-02-2021","9045913270","astha12@gmail.com","12345")).collect(Collectors.toList()));
	    assertEquals(1, studentServiceImpl.getStudentById(id).size());
	}

	@Test
	public void getstudentbyemailTest() {
		String email="astha12@gmail.com";
		when(studentRepo.getStudentbyemail(email)).thenReturn(Stream.of(new Student(1L,"astha","delhi","01-02-2021","9045913270","astha12@gmail.com","12345")).collect(Collectors.toList()));
		assertEquals(1, studentServiceImpl.getStudentByemail(email).size());
	}
	
	@Test
	public void getstudentbynameTest() {
		String name="astha";
		when(studentRepo.getStudentByname(name)).thenReturn(Stream.of(new Student(1L,"astha","delhi","01-02-2021","9045913270","astha12@gmail.com","12345")).collect(Collectors.toList()));
		assertEquals(1, studentServiceImpl.getStudentByname(name).size());
	}
	
	@Test
    public void updateStudentTest() {
		Student s=new Student();
	    s.setSid(1L);
	    s.setAddress("noida");
	    s.setDateofbirth("5 july 2021");
	    s.setEmail("m@gmail.com");
	    s.setMobileno("9045913270");
	    s.setPassword("123");
	    s.setUsername("mayank");
	    assertNotNull(studentRepo.findById(1L));
	   }
	

//TechSkill
	
	@Autowired
	TechSkillImpl teckSkillImpl;
	
	@MockBean
	TechSkillRepo techSkillRepo;
	
	@Test
	public void insertTechSkillTest() {
		TechSkill techSkill=new TechSkill(1L,"20","spring boot","mayank");
		when(techSkillRepo.save(techSkill)).thenReturn(techSkill);
		assertEquals(techSkill, teckSkillImpl.insertdata(techSkill));
	}

	@Test
	public void fetchTest() {
		when(techSkillRepo.findAll()).thenReturn(Stream.of(new TechSkill(1L,"20","spring boot","mayank"),new TechSkill(1L,"15","django","astha")).collect(Collectors.toList()));
	 assertEquals(2, teckSkillImpl.getdata().size());
	}
	
	@Test
    public void updateTechSkillTest() {
		TechSkill t=new TechSkill();
		t.settId(1L);
		t.setCourseName("spring boot");
		t.setEnrollStudent("50");
		t.setFacultyName("mayank");
		techSkillRepo.save(t);
	    assertNotNull(techSkillRepo.findById(1L));
	   }
	

	
}