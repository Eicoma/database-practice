package eicoma.com.github.jdbc.Demo1.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    //私有空参构造方法
    private JDBCUtils(){}

    //声明配置信息变量
    private static String driverClass;
    private static String url;
    private static String username;
    private static String password;
    private static Connection con;

    //在调用JDBCUtils类的方法的同时，该类的Static代码块会随着类的加载一同执行
    static{
        try {
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("config.properties");
            //创建Properties集合
            //Properties集合是具有键值对的双列集合
            Properties prop = new Properties();
            // 通过Properties集合来加载流对象
            //将配置文件中的内容读取到内存中
            prop.load(is);

            //通过Properties集合的getProperty()方法来获取键对应的值
            driverClass = prop.getProperty("driverClass");
            url = prop.getProperty("url");
            username = prop.getProperty("username");
            password = prop.getProperty("password");

            //通过变量driverClass注册驱动
            Class.forName(driverClass);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //获取数据库连接，返回一个数据库连接对象
    public static Connection getConnection(){
        try {
            con = DriverManager.getConnection(url,username,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return con;
    }

    //释放资源的方法
    //定义了两个close()方法重载
    public static void close(Connection con, Statement stat, ResultSet rs){
        if (con!=null){
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if (stat!=null){
            try {
                stat.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if (rs !=null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void close(Connection con, Statement stat){
        if (con!=null){
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if (stat!=null){
            try {
                stat.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

}
