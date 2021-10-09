package com.test.softtek.sgomez.service;

import com.test.softtek.sgomez.model.Student;
import com.test.softtek.sgomez.util.Response;

import java.util.List;

public interface StudentService {

    public Response<List<Student>, String> getStudents();

    public Response<Student, String> createStudent(Student student);
}
