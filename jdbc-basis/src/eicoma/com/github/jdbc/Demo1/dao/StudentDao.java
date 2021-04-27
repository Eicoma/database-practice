package eicoma.com.github.jdbc.Demo1.dao;

import eicoma.com.github.jdbc.Demo1.domain.Student;

import java.util.ArrayList;

public interface StudentDao {
    //查询所有学生信息的抽象方法
    public abstract ArrayList<Student> findAll();

    //条件查询，通过id查询单个学生信息
    public abstract Student findById(Integer id);

    //添加学生信息
    public abstract int Insert(Student stu);

    //修改学生信息
    public abstract int Update(Student stu);

    //删除学生信息
    public abstract int Delete(Integer id);
}
