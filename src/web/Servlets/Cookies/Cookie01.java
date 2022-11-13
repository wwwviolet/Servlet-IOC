package web.Servlets.Cookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/cookie01")
public class Cookie01 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.创建一个cookie对象
        Cookie cookie = new Cookie("uname", "jim2");
        //2.将Cookie对象添加到浏览器端中
        response.addCookie(cookie);
//        cookie.setDomain("pattern");
//        cookie.setPath("url");
        //3.返回响应//服务器内部转发
        request.getRequestDispatcher("hello01").forward(request, response);
    }
}
