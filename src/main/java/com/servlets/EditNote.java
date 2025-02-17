package com.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.NoteTaker;
import com.helper.FactoryProvider;

public class EditNote extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			//get the parameters from request object
			int id = Integer.parseInt(req.getParameter("note_id").trim());
			String title = req.getParameter("title");
			String content = req.getParameter("details");
			
			//save the object using hibernate
			//get session
			Session session = FactoryProvider.getFactory().openSession();
			
			//begin transaction
			Transaction tx = session.beginTransaction();
			
			//get the note object
			NoteTaker note = session.get(NoteTaker.class, id);
			note.setTitle(title);
			note.setContent(content);
			note.setAddedDate(new Date());
			
			//save the object
			session.save(note);
			
			tx.commit();
			session.close();
			
			//send redirect to show notes
			resp.sendRedirect("showNotes.jsp");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	
}
