<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.AlbumDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Album User Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<%@ include file="../usernavbar.jsp" %>
<div class="main">
	<%
		List<AlbumDTO> list = (List<AlbumDTO>)request.getAttribute("list");
	%>

<br>

	<table>
		<tr>
			<th>Name</th>
			<th>Author</th>
			<th>Year</th>
			<th></th>
			<th></th>
		</tr>
		<%
			for (AlbumDTO a : list) {
		%>
		<tr>
			<td><a href=AlbumServlet?type=user&mode=read&id=<%=a.getId()%>>
					<%=a.getName()%>
			</a></td>
			<td><%=a.getAuthor()%></td>
			<td><%=a.getYear()%></td>
			
		</tr>
		<%
			}
		%>
	</table>


</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>