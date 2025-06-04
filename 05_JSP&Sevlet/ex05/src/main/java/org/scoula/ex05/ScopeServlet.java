package org.scoula.ex05;


import org.scoula.ex05.doman.Member;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/scope")
public class ScopeServlet extends HttpServlet {
    ServletContext sc;

    public void init(ServletConfig config) throws ServletException {
        sc=config.getServletContext();
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        sc.setAttribute("scopeName","applicationScope 값 -태현 submit");
        HttpSession session=req.getSession();
        session.setAttribute("scopeName","sessionScope 값 -태현 submit");

        req.setAttribute("scopeName","requestScope 값 -태현 submit");
        Member member=new  Member("홍길동","hong");
        req.setAttribute("member",member);

        req.getRequestDispatcher("scope.jsp").forward(req,res);

    }
}
