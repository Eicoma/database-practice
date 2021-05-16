package eicoma.com.github.responsedemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 请求重定向
 */

@WebServlet("/responseDemo6")
public class ResponseDemo6 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("servletDemo6执行了");

        //设置请求域共享数据
        req.setAttribute("username","zhangsan");

        //设置重定向
        resp.sendRedirect(req.getContextPath() + "/responseDemo7");
//        //也可以重定向到其他网页
//        resp.sendRedirect("https://www.baidu.com");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
