package eicoma.com.github.fileter.practice.filter;

import javax.servlet.*;
import java.io.IOException;

public class FilterDemo03 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("FilterDemo03执行了...");

        //处理乱码
        servletResponse.setContentType("text/html;charset=UTF-8");

        //放行
        //放行是必须的，不然客户端的请求被过滤器拦截后，无法发送到服务器端
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
