package com.darian.springbootweb.spring.boot;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyServlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = req.getServletContext();
        servletContext.log("MyServlet2 doGet.....");

        PrintWriter writer = resp.getWriter();
        writer.write("<html><body>hello,darian, myvalue = servlet2 </body></html>");
    }
}
