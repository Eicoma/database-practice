package eicoma.com.github.responsedemo;

import javax.jws.WebResult;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 字节流响应消息
 */

@WebServlet("/responseDemo1")
public class ResponseDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置客户端浏览器的字符集
        resp.setContentType("text/html;charset=UTF-8");
        //1.获取字节输出流对象
        ServletOutputStream sos = resp.getOutputStream();
        //2.定义一个消息
        String str = "字节流响应消息";
        //3.通过字节流对象输出
        //字符串数据通过UTF-8的字符集编码为字节数据
        sos.write(str.getBytes("UTF-8"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
