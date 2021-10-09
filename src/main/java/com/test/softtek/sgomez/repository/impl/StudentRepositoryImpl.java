package com.test.softtek.sgomez.repository.impl;

import com.test.softtek.sgomez.model.Student;
import com.test.softtek.sgomez.repository.GenericRepository;
import com.test.softtek.sgomez.util.FakeData;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepositoryImpl implements GenericRepository<Student, Integer> {

    // get data from database
    @Override
    public List<Student> getAll(){
      return FakeData.students;
    }

    // Save data in database
    @Override
    public Student save(Student entity){
        return entity;
    }

}
