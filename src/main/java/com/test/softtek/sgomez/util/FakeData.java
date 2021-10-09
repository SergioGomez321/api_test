package com.test.softtek.sgomez.util;

import com.test.softtek.sgomez.model.Student;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class FakeData {

    public static List<Student> students =
            Arrays.asList(
                    Student.builder().id(1).firstName("Sergio").lastName("Gomez").birthday(new Date()).build(),
                    Student.builder().id(2).firstName("Enrique").lastName("Espinoza").birthday(new Date()).build(),
                    Student.builder().id(3).firstName("Jeanette").lastName("Duran").birthday(new Date()).build(),
                    Student.builder().id(4).firstName("Lorna").lastName("Vela").birthday(new Date()).build(),
                    Student.builder().id(5).firstName("Guadalupe").lastName("Gutierrez").birthday(new Date()).build()
            );



}
