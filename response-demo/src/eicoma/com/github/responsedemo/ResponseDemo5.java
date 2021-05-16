package eicoma.com.github.responsedemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 定时刷新
 */

@WebServlet("/responseDemo5")
public class ResponseDemo5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String str  = "您的用户名或密码有误，3秒后自动跳转到登录页面...";

        //设置编码
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write(str);

        //定时刷新
        //setHeader("Refresh","跳转时间（秒），跳转路径")
        resp.setHeader("Refresh","3;URL=/response/login.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
