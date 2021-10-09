package com.test.softtek.sgomez.controller;

import com.test.softtek.sgomez.model.Student;
import com.test.softtek.sgomez.service.StudentService;
import com.test.softtek.sgomez.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/student")
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping()
    public Response<List<Student>, String> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping()
    public Response<Student, String> createStudent(@RequestBody Student request){
        return this.studentService.createStudent(request);
    }

}
