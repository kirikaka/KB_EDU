package org.scoula.ex02;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

//@WebServlet(name = "helloServlet", value = "/hello-servlet")
//@WebServlet(name = "helloServlet",urlPatterns = {"/xxx","/yyy"})
public class HelloServlet extends HttpServlet {
    private String message;

    @Override
    public void init(){
        message = "Hello Servlet";
        System.out.println("init 호출");
    }



    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    @Override
    public void destroy() {
        System.out.println("destroy 호출");
    }
}