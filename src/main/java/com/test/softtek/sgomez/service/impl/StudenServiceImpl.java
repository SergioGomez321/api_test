package com.test.softtek.sgomez.service.impl;

import com.test.softtek.sgomez.model.Student;
import com.test.softtek.sgomez.repository.impl.StudentRepositoryImpl;
import com.test.softtek.sgomez.service.StudentService;
import com.test.softtek.sgomez.util.Response;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;

@Service
public class StudenServiceImpl implements StudentService {

    private static final Logger logger = LoggerFactory.getLogger(StudenServiceImpl.class);

    @Autowired
    StudentRepositoryImpl studentRepository;


    @Override
    public Response<List<Student>, String> getStudents() {
        Response<List<Student>, String> response = new Response<>();
        try {
            List<Student> students =  this.studentRepository.getAll();
            response.setData(students);
        }catch (Exception e){
            response.setMessages(Arrays.asList("There was an error getting the students", e.getMessage()));
        }
        return response;
    }

    @Override
    public Response<Student, String> createStudent(Student request) {
        Response<Student, String> response = new Response<>();
        try{
            this.validateStudent(request); // Exception if null
            logger.debug("THIS IS DEBUG MESSAGE");
            logger.error("THIS IS ERROR MESSAGE");
            logger.warn("THIS IS WARN MESSAGE");
            logger.info("THIS IS INFO MESSAGE");
            logger.info("This is my student object content: ");
            logger.info("Student Object: " + request.getFirstName() + " " + request.getLastName() + " - " + request.getId());
            Student student = this.studentRepository.save(request);
            response.setData(student);

        }catch (Exception e){
            response.setMessages(Arrays.asList("There was an error saving the student", e.getMessage()));
        }
        return response;
    }

    public void validateStudent(Student student) throws Exception {
        if(student.getFirstName() == null || student.getLastName() == null || student.getId() == null || student.getBirthday() == null)
            throw  new Exception("Some attribute of the student object is null");
    }

}
