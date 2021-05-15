package eicoma.com.github.servlet.test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取表单数据
        String username = req.getParameter("username");
        String age = req.getParameter("age");
        String score = req.getParameter("score");

        //通过字符输出流将数据写入到本地文件
        BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\Programming\\IdeaProject\\JDBC\\servlet-test\\student.txt",true));
        bw.write(username + "," + age + "," + score);
        bw.newLine();
        bw.close();

        //对客户端浏览器做出响应
        PrintWriter pw = resp.getWriter();
        pw.print("Submit Success!");
        pw.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
