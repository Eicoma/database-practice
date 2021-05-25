package eicoma.com.github.fileter.practice.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//通过注解对过滤器进行配置
//  “/*”代表对该项目下所有的Servlet都起作用，也可单独指定某一个Servlet
@WebFilter("/*")
public class FilterDemo01 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("FilterDemo01执行了...");

        //处理乱码
        servletResponse.setContentType("text/html;charset=UTF-8");

        //放行
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
