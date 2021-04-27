package eicoma.com.github.jdbc.Demo1.service;

import eicoma.com.github.jdbc.Demo1.dao.StudentDao;
import eicoma.com.github.jdbc.Demo1.dao.StudentDaoImpl;
import eicoma.com.github.jdbc.Demo1.domain.Student;

import java.util.ArrayList;
import java.util.Date;

public class StudentServiceImpl implements StudentService{
    StudentDao dao = new StudentDaoImpl();
    @Override
    public ArrayList<Student> findAll() {
        //在Service层中，返回从Dao层中获取到的ArrayList集合
        return dao.findAll();
    }

    @Override
    public Student findById(Integer id) {
        return dao.findById(id);
    }

    @Override
    public int Insert(Student stu) {
        return 0;
    }

    @Override
    public int Update(Student stu) {
        return 0;
    }

    @Override
    public int Delete(Integer id) {
        return 0;
    }
}
