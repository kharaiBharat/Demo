<%@page import="java.util.*"%>
<%@page import="com.spring.entity.Book"%>
<table class="table table-striped">
	<thead>
		<tr>
			<th scope="col">#</th>
			<th scope="col">Name</th>
			<th scope="col">Author</th>
			<th scope="col">Date</th>
			<th scope="col">Action</th>
		</tr>
	</thead>
	<tbody>
		<%
		List<Book> ll = (List<Book>) session.getAttribute("tableDetails");
		for (Book item : ll) {
		%>
		<tr>
			<th scope="row"><%=item.getBookCode()%></th>
			<td><%=item.getName()%></td>
			<td><%=item.getAuthor()%></td>
			<td><%=item.getDate()%></td>

			<td><form method="get" action="edit">
					<input name="edit-<%=item.getBookCode()%>" value="edit"
						type="submit" />
				</form>&emsp;&emsp;
				<form method="get" action="delete">
					<input name="delete-<%=item.getBookCode()%>" value="delete"
						type="submit" />
				</form></td>

		</tr>
		<%
		}
		%>
	</tbody>
</table>