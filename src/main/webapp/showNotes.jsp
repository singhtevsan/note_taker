<%@page import="com.entities.NoteTaker"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Query"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.helper.FactoryProvider"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Notes</title>

<%@ include file="all_css_js.jsp" %>

</head>
<body>
	<div class="container">
    	<%@ include file="navbar.jsp" %>
    	<br>
    	<h1 class="text-uppercase">Here are All Notes</h1>
    	
    	<div class="row">
    	
    		<div class="col-12">
    		
    			<%
		   		//get session from factory
		   		Session sessionn = FactoryProvider.getFactory().openSession();
		    	
		   		Query q = sessionn.createQuery("from NoteTaker");
		   		List<NoteTaker> notes = q.list();
		   		
		   		for(NoteTaker note:notes){
		   			
		   		%>
		   		
		   			<div class="card mt-3" >
					<img class="card-img-top m-4 mx-auto" style="max-width: 100px" src="img/pencil.png" alt="Card image cap">
					<div class="card-body px-5">
						<h5 class="card-title"><%=note.getTitle() %></h5>
						<p class="card-text"><%=note.getContent() %></p>
						<p><b class="text-primary"><%=note.getAddedDate() %></b></p>
						
						<div class="container text-center mt-2">
							<a href="editNote.jsp?note_id=<%=note.getId() %>" class="btn btn-primary">Update</a>
							<a href="deleteNote?note_id=<%=note.getId() %>" class="btn btn-danger">Delete</a>
						</div>
						
					</div>
				</div>
		   			
		   			
		   			
		   		<%
		   		}
		   	
		   		sessionn.close();
		    	
		    	%>
    		</div>
    	
    	</div>
    	
    	
    	
    </div>
</body>
</html>