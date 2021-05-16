package eicoma.com.github.responsedemo;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 字符流响应消息
 */

@WebServlet("/responseDemo2")
public class ResponseDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String str = "字符流响应消息";
        //设置 浏览器解码字符集，解决中文乱码
        //注意字符集的设置要在获取输出流对象之前
        resp.setContentType("text/html;charset=UTF-8");
        //获取字符输出流对象
        PrintWriter pw = resp.getWriter();

        pw.write(str);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
