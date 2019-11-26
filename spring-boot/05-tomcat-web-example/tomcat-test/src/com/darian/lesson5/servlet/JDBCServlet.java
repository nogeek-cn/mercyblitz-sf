package com.darian.lesson5.servlet;



import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.activation.MimeType;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class JDBCServlet extends HttpServlet {
	
	/**
	 * 为什么 Servlet 要实现序列化
	 */
	private static final long serialVersionUID = 1L;
	private DataSource dataSource;

	@Override
	public void init(ServletConfig servletConfig) throws ServletException{
		try {
			Context context = new InitialContext();
			Context envContext = (Context) context.lookup("java:comp/env");
			dataSource = (DataSource) envContext.lookup("jdbc/TestDB");
			String bean = (String) envContext.lookup("Bean");
			System.out.println(bean);
		}catch(Exception e) {
			throw new ServletException(e);
		}
	}
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
		Writer writer = response.getWriter();
		response.setContentType("text/html;charset=UTF-8");
		try {
			Connection connection = dataSource.getConnection();
			Statement statement =   connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SHOW DATABASES");
			while(resultSet.next()) {
				String dataname = resultSet.getString(1);
				writer.write(dataname);
				writer.write("<br />");
				writer.flush();
			}
		}catch(SQLException e) {
			throw new ServletException(e);
		}
	}
}
