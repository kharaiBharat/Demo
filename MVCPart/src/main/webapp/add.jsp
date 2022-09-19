<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@page import="java.text.*"%>
<%@page import="com.spring.entity.Author"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="component/bootstrapCSS.jsp"%>
<title>Insert title here</title>
</head>
<body>

	<%@include file="component/navBar.jsp"%>
	<%
	List<Author> list = (List<Author>) session.getAttribute("authors");
	Date date=new Date();
	SimpleDateFormat dateForm=new SimpleDateFormat("dd/MMMM/YY");
	%>

	<div>
		<h1>Add Book Details</h1>
		<br>
		<form action="addBook">
			
			<lable>Book code</lable>
			<input type="number" name="bookCode"><br>
			<lable>Book Name</lable>
			<input type="text" name="bookName"><br>
			<lable>Author</lable>
			<select name="author"
				value="Authors" style="margin-left: 2rem">
				<option selected>Choose Author</option>
				<%
				for (int i = 0; i < list.size(); i++) {
				%>
				<option><%=list.get(i).getName()%></option>
				<%
				}
				%>
			</select><br>

					<lable>Added On</lable><input name="date" type="text" value="<%=dateForm.format(date)%>" readonly>
					<button type="submit" class="btn btn-danger"
						style="height: 30px; font-size: 14px; margin-left: 10rem;; width: 100px">Submit</button>
					<button type="button" class="btn btn-danger"
						style="height: 30px; font-size: 14px; margin-left: 1rem;"
						back" onclick="history.back()">Cancel</button>

		</form>


	</div>


	<%@include file="component/bootstrapJS.jsp"%>
</body>
</html>