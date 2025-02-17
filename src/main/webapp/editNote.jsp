<%@page import="com.entities.NoteTaker"%>
<%@page import="com.helper.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Note</title>

<%@ include file="all_css_js.jsp" %>

</head>
<body>
	
	<div class="container">
    	<%@ include file="navbar.jsp" %>
    	<br>
    	<h1 class="text-uppercase">Edit Your Note</h1>
    	<br>
    	<%
    	//get the parameters from request object
    	int node_Id = Integer.parseInt(request.getParameter("note_id").trim());
    	
    	//get the object using hibernate
    	//get session
    	Session sessionn = FactoryProvider.getFactory().openSession();
    	
    	//get note taker object
    	NoteTaker note = sessionn.get(NoteTaker.class,node_Id);
    	
    	%>
    	
    	<!-- this is update form -->
    	<form action="editNote" method="post">
    	
    		<input name="note_id" value="<%=note.getId() %>" type="hidden" />
    		
			<div class="form-group">
				<label for="title">Note Title</label> 
				<input type="text" class="form-control" id="title" required value="<%=note.getTitle() %>"
				name="title" aria-describedby="emailHelp" placeholder="Enter Note Title"> 
			</div>
			
			<div class="form-group">
				<label for="content">Note Details</label>
				<textarea name="details" required  id="content" placeholder="Enter Note Details" class="form-control" style="height:300px"><%=note.getContent() %></textarea>
			</div>
			
			<div class="contianer text-center">
				<button type="submit" class="btn btn-success">Save Note</button>
			</div>
		</form>
    	
    </div>
</body>
</html>