package eicoma.com.github.servlet.practice;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletDemo3 extends HttpServlet {
    //对象出生
    public void init(){
        System.out.println("对象创建并初始化成功！");
    }

    //对象服务的过程
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("接收到客户端请求！");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    //对象销毁

    @Override
    public void destroy() {
        System.out.println("对象已销毁！");
    }
}
