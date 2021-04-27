package eicoma.com.github.jdbc.Demo1.dao;

import eicoma.com.github.jdbc.Demo1.domain.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class StudentDaoImpl implements StudentDao {
    @Override
    public ArrayList<Student> findAll() {
        ArrayList<Student> list = new ArrayList<>();
        Connection con = null;
        Statement stat = null;
        ResultSet rs = null;
        try {

            //1.注册驱动（这一步可省略）
            Class.forName("com.mysql.jdbc.Driver");

            //2.获取数据库连接对象
            con = DriverManager.getConnection("jdbc:mysql://192.168.23.129:3306/db10", "root", "root1999");

            //3.获取到Sql语句执行对象
            stat = con.createStatement();

            //4.执行Sql语句，并将其赋给ResultSet变量
            String sql = "SELECT * FROM student";
            rs = stat.executeQuery(sql);

            while (rs.next()) {
                Integer sid = rs.getInt("sid");
                String name = rs.getString("name");
                Integer age = rs.getInt("age");
                Date birthday = rs.getDate("birthday");

                Student stu = new Student(sid, name, age, birthday);

                list.add(stu);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (con != null) {
                try {
                    con.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

            return list;
        }

        @Override
        public Student findById (Integer id){
            //在全局变量位置创建一个Student类对象
            Student stu = new Student();
            Connection con = null;
            Statement stat = null;
            ResultSet rs = null;
            try {

                //1.注册驱动（这一步可省略）
                Class.forName("com.mysql.jdbc.Driver");

                //2.获取数据库连接对象
                con = DriverManager.getConnection("jdbc:mysql://192.168.23.129:3306/db10","root","root1999");

                //3.获取到Sql语句执行对象
                stat = con.createStatement();

                //4.执行Sql语句，并将其赋给ResultSet变量
                String sql = "SELECT * FROM student WHERE sid='"+id+"'";
                rs = stat.executeQuery(sql);

                while (rs.next()) {
                    Integer sid = rs.getInt("sid");
                    String name = rs.getString("name");
                    Integer age = rs.getInt("age");
                    Date birthday = rs.getDate("birthday");

                    stu.setSid(sid);
                    stu.setName(name);
                    stu.setAge(age);
                    stu.setBirthday(birthday);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }  finally {

                if (con!=null) {
                    try {
                        con.close();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }

                if (stat!=null) {
                    try {
                        stat.close();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }

                if (rs!=null) {
                    try {
                        rs.close();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
            }

            return stu;
        }


        @Override
        public int Insert (Student stu){

            return 0;
        }

        @Override
        public int Update (Student stu){
            return 0;
        }

        @Override
        public int Delete (Integer id){
            return 0;
        }
    }
