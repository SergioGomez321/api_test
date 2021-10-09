package com.test.softtek.sgomez;

import com.test.softtek.sgomez.model.Student;
import com.test.softtek.sgomez.service.StudentService;
import com.test.softtek.sgomez.util.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class StudentServiceTest {

	@Autowired
	StudentService studentService;

	@Test
	void getStudentsOk() {
		Response<List<Student>, String> response = this.studentService.getStudents();
		Assertions.assertNotNull(response);
		Assertions.assertNotNull(response.getData());
		Assertions.assertFalse(response.getData().isEmpty());
		Assertions.assertEquals("Sergio", response.getData().get(0).getFirstName());
	}

	@Test
	void createStudentOk(){
		Student student = Student.builder().firstName("Renata").lastName("Chavez").birthday(new Date()).id(9).build();
		Response<Student, String> response = this.studentService.createStudent(student);
		Assertions.assertNotNull(response);
		Assertions.assertNotNull(response.getData());
		Assertions.assertEquals("Renata", response.getData().getFirstName());
	}

	@Test
	void createStudentError(){
		Student student = Student.builder().firstName(null).lastName(null).birthday(null).id(null).build();
		Response<Student, String> response = this.studentService.createStudent(student);
		Assertions.assertNull(response.getData());
		Assertions.assertNotNull(response.getMessages());
		Assertions.assertEquals(response.getMessages().size(), 2);
		Assertions.assertFalse(response.getMessages().isEmpty());
	}

}
