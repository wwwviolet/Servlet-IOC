package web.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


//@WebFilter("/demo01.action")//与servlet的url一样
@WebFilter("*.action")//与servlet的url一样
public class Filter01 implements Filter {


    //初始化
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    //服务
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("a");
        //放行
        filterChain.doFilter(servletRequest, servletResponse);//拦截前执行上面部分代码
        //
        System.out.println("a1");//当返回的时候在执行这部分内容



    }

    //销毁
    @Override
    public void destroy() {

    }
}
