package web.myssm.filter;

import web.myssm.uitl.StringUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@WebFilter(urlPatterns = {"*.do"} , initParams = {@WebInitParam(name = "encoding",value = "GBK")})
//如果写了初始化参数,那么初始化时就会读到该值,进行编码格式判断,如果没有,默认就是utf-8
public class CharacterEncodingFilter implements Filter {

    private String encoding = "UTF-8";



    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //获取初始化参数
        String encodingStr = filterConfig.getInitParameter("encoding");
        if (StringUtil.isNotEmpty(encoding)){
            encoding = encodingStr;
        }

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //设置编码
        ((HttpServletRequest)servletRequest).setCharacterEncoding("UTF-8");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
