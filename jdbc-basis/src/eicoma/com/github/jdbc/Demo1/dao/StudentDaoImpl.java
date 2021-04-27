package eicoma.com.github.jdbc.Demo1.dao;

import eicoma.com.github.jdbc.Demo1.domain.Student;
import eicoma.com.github.jdbc.Demo1.utils.JDBCUtils;

import java.sql.*;
import java.text.SimpleDateFormat;
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
            //Class.forName("com.mysql.jdbc.Driver");

            //2.获取数据库连接对象
            //con = DriverManager.getConnection("jdbc:mysql://192.168.23.129:3306/db10", "root", "root1999");

            //优化后：
            // 通过工具类JDBCUtils工具类中的静态代码块和getConnection()方法注册驱动+获取数据库连接对象
            con = JDBCUtils.getConnection();

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
            //选择形参为三个的close()方法重载
           JDBCUtils.close(con,stat,rs);
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
                //Class.forName("com.mysql.jdbc.Driver");

                //2.获取数据库连接对象
                //con = DriverManager.getConnection("jdbc:mysql://192.168.23.129:3306/db10","root","root1999");

                //优化后：
                //通过JDBCUtils工具类中的静态代码块和getConction()方法来注册驱动和获取数据库连接对象
                con = JDBCUtils.getConnection();

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

                //选择形参为三个的close()方法重载
                JDBCUtils.close(con,stat,rs);
            }

            return stu;
        }


        @Override
        public int Insert (Student stu){
            Connection con = null;
            Statement stat = null;
            int result = 0;
            try {

                //1.注册驱动（这一步可省略）
                //Class.forName("com.mysql.jdbc.Driver");

                //2.获取数据库连接对象
                //con = DriverManager.getConnection("jdbc:mysql://192.168.23.129:3306/db10","root","root1999");

                //优化后：
                //通过工具类JDBCUtils中的静态代码块和grtConection()方法来注册驱动和获取数据库连接对象
                con = JDBCUtils.getConnection();

                //3.获取到Sql语句执行对象
                stat = con.createStatement();

                //4.执行Sql语句，并将其赋给ResultSet变量
                Date date = stu.getBirthday();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String birthday = sdf.format(date);
                String sql = "INSERT INTO student VALUES ('"+ stu.getSid()+"','"+stu.getName()+"','"+stu.getAge()+"','"+birthday+"')";
                result = stat.executeUpdate(sql);

            } catch (Exception e) {
                e.printStackTrace();
            }  finally {
                //选择调用形参为两个的close()方法重载
                JDBCUtils.close(con,stat);
            }
            return result;
        }

        @Override
        public int Update (Student stu){
            Connection con = null;
            Statement stat = null;
            int result = 0;
            try {

                //1.注册驱动（这一步可省略）
                //Class.forName("com.mysql.jdbc.Driver");

                //2.获取数据库连接对象
                //con = DriverManager.getConnection("jdbc:mysql://192.168.23.129:3306/db10","root","root1999");

                //优化后：
                //通过工具类JDBCUtils中的静态代码块和grtConection()方法来注册驱动和获取数据库连接对象
                con = JDBCUtils.getConnection();

                //3.获取到Sql语句执行对象
                stat = con.createStatement();

                Date date = stu.getBirthday();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String birthday = sdf.format(date);

                //4.执行Sql语句，并将其赋给ResultSet变量
                String sql ="UPDATE student SET sid='"+stu.getSid()+"',name='"+stu.getName()+"',age='"+stu.getAge()+"',birthday='"+birthday+"' WHERE sid='"+stu.getSid()+"'";
                result = stat.executeUpdate(sql);

            } catch (Exception e) {
                e.printStackTrace();
            }  finally {
                //选择调用形参为两个的close()方法重载
                JDBCUtils.close(con,stat);
            }

            return result;
        }

        @Override
        public int Delete (Integer id){
            Connection con = null;
            Statement stat = null;
            int result = 0;
            try {

                //1.注册驱动（这一步可省略）
                //Class.forName("com.mysql.jdbc.Driver");

                //2.获取数据库连接对象
                //con = DriverManager.getConnection("jdbc:mysql://192.168.23.129:3306/db10","root","root1999");

                //优化后：
                //通过工具类JDBCUtils中的静态代码块和grtConection()方法来注册驱动和获取数据库连接对象
                con = JDBCUtils.getConnection();

                //3.获取到Sql语句执行对象
                stat = con.createStatement();

                //4.执行Sql语句，并将其赋给ResultSet变量
                String sql ="DELETE FROM student WHERE sid=' "+id+" ' ";
                result = stat.executeUpdate(sql);

            } catch (Exception e) {
                e.printStackTrace();
            }  finally {
                //选择调用形参为两个的close()方法重载
                JDBCUtils.close(con,stat);
            }

            return result;
        }
    }
