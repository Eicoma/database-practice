package eicoma.com.github.jdbc.Demo1.controller;

import eicoma.com.github.jdbc.Demo1.domain.Student;
import eicoma.com.github.jdbc.Demo1.service.StudentService;
import eicoma.com.github.jdbc.Demo1.service.StudentServiceImpl;
import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;
import org.junit.Test;

import java.util.ArrayList;

public class StudentController {
    private StudentService service = new StudentServiceImpl();

    @Test
    public void findAll(){
        ArrayList<Student> list = new ArrayList<>();
        list = service.findAll();
        for (Student stu : list){
            System.out.println(stu);
        }
    }
}
