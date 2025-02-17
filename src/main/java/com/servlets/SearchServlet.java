package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			//fetching the query from search box
			String query = req.getParameter("input");
			
			//sending it to google
			resp.sendRedirect("https://www.google.com/search?q="+query);
			
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	
}
