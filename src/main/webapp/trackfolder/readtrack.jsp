<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.TrackDTO"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Track Read">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Read Track</title>
</head>
<body>
	<%@ include file="../css/header.jsp"%>
	<br>
	<div class="navbar">
		<a href="/userfolder/homeadmin.jsp">Home</a> <a class="active"
			href="/track/getall?type=admin">Tracks</a> <a href="/user/logout" id="logout">Logout</a>
	</div>
<br>
	<div class="main">
		<%
			TrackDTO t = (TrackDTO) request.getSession().getAttribute("dto");
		%>


		<table>
			<tr>
				
				<th>Title</th>
				<th>Author</th>
			</tr>
			<tr>
				<td><%=t.getTitle()%></td>
				<td><%=t.getAuthor()%></td>
			</tr>
		</table>

		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>


	</div>

	<%@ include file="../css/footer.jsp"%>
</body>
</html>