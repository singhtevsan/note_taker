<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Notes</title>

<%@ include file="all_css_js.jsp" %>

</head>
<body>

	<div class="container">
    	<%@ include file="navbar.jsp" %>
    	<br>
    	<h1>Add Note Details</h1>
    	<br>
    	
    	<!-- this is add form -->
		<form action="saveNote" method="post">
			<div class="form-group">
				<label for="title">Note Title</label> 
				<input type="text" class="form-control" id="title" required
				name="title" aria-describedby="emailHelp" placeholder="Enter Note Title"> 
			</div>
			
			<div class="form-group">
				<label for="content">Note Details</label>
				<textarea name="details" required  id="content" placeholder="Enter Note Details" class="form-control" style="height:300px"></textarea>
			</div>
			
			<div class="contianer text-center">
				<button type="submit" class="btn btn-primary">Submit</button>
			</div>
		</form>
	</div>
    
    
</body>
</html>