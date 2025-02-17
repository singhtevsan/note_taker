package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.NoteTaker;
import com.helper.FactoryProvider;

public class DeleteNote extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			//get the parameters from request object
			int note_Id = Integer.parseInt(req.getParameter("note_id").trim());
			
			//delete the note using hibernate
			//get session
			Session session = FactoryProvider.getFactory().openSession();
			
			//begin transaction
			Transaction tx = session.beginTransaction();
			
			//bring/get the note taker object using id
			NoteTaker note = session.get(NoteTaker.class, note_Id);
			
			//delete the object
			session.delete(note);
			
			
			tx.commit();
			session.close();
			
			//send redirect to show notes
			resp.sendRedirect("showNotes.jsp");
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	
}
