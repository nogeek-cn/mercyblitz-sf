package com.darian.springbootweb.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "myServlet",
        urlPatterns = "/myServlet",
        initParams = {
                @WebInitParam(name = "myname", value = "myvalue")
        }
)
public class MyServlet extends HttpServlet {

    private String value;

    @Override
    public void init(ServletConfig config) throws ServletException {
        value = config.getInitParameter("myname");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = req.getServletContext();
        servletContext.log("myservlet doGet.....");

        PrintWriter writer = resp.getWriter();
        writer.write("<html><body>hello,darian, myvalue = " + value + "</body></html>");
    }
}
