package eicoma.com.github.jdbc.practice;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcDemo1 {
    public static void main(String[] args) throws Exception{
        //1.导入jar包

        //2.注册驱动
        //mysql5之后可以不用手动注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //3.获取数据库连接对象
        //static Connection getConnection(String url, String user, String password);
        //该方法返回一个Connection数据库连接对象
        Connection con = DriverManager.getConnection("jdbc:mysql://192.168.23.129:3306/db_stu_cour","root","root1999");

        //4.获取执行者对象
        //此处Statement createStatement();为获取普通的执行者对象
        Statement stat = con.createStatement();

        //5.通过执行者对象执行sql语句
        //sql语句
        String sql = "SELECT * FROM student";
        //通过执行者调用查询方法，即DML语句，executeUpdate(String sql)
        // 或增删改方法，即DQL语句，executeQuery(String sql)
        ResultSet rs = stat.executeQuery(sql);

        //6.从ResultSet对象中提取结果
        //XXX getXxx("列名");
        //String getString("name");
        // int getInt("age");
        while(rs.next()){
            //String s = rs.getString();
            System.out.println(rs.getInt("Sno") + "\t" + rs.getString("Sname") + "\t"
            + rs.getString("Ssex") + "\t" + rs.getInt("Sage") + "\t"
                            + rs.getString("Sdept")
            );
        }

        //7.调用close()释放资源
        con.close();
        stat.close();
        rs.close();
    }
}
