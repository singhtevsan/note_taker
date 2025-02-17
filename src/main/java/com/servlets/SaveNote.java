package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.NoteTaker;
import com.helper.FactoryProvider;

public class SaveNote extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			//fetching the data from request object
			String title = req.getParameter("title");
			String content = req.getParameter("details");
			
			//creating new NoteTaker object
			NoteTaker note = new NoteTaker(title,content,new Date());
			
			//System.out.println(note.getId()+" : "+note.getTitle()+" : "+note.getContent());
			
			//save the note object using hibernate
			//get session
			Session session = FactoryProvider.getFactory().openSession();
			
			//begin transaction
			Transaction tx = session.beginTransaction();
			
			//save the object
			session.save(note);
			
			tx.commit();
			
			session.close();
			
			
			//set the content type of response
			resp.setContentType("text/html");
			PrintWriter writer = resp.getWriter();
			writer.println("<h1 style='text-align:center'>Note Added Succesfully</h1>");
			writer.println("<h1 style='text-align:center'>"
					+ "<a href='showNotes.jsp'><button>Show Notes</button></a>"
					+ "&nbsp;&nbsp;"
					+ "<a href='addNotes.jsp'><button>Add Note</button></a>"
					+ "&nbsp;&nbsp;"
					+ "<a href='index.jsp'><button>Home Page</button></a>"
					+ "</h1>");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
	}

	
}
