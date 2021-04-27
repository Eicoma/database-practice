package eicoma.com.github.jdbc.Demo1.controller;

import eicoma.com.github.jdbc.Demo1.domain.Student;
import eicoma.com.github.jdbc.Demo1.service.StudentService;
import eicoma.com.github.jdbc.Demo1.service.StudentServiceImpl;
import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

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

    @Test
    public void findById(){
        Student stu = service.findById(2);
        System.out.println(stu);
    }

    @Test
    public void Insert(){
        Date date = new Date();
        Student stu = new Student(5,"魏七",27,date);
        int result = service.Insert(stu);
        if (result!=0){
            System.out.println("信息添加成功");
        }else{
            System.out.println("信息添加失败");
        }
    }
}
