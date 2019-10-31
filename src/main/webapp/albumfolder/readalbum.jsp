<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.TrackDTO"
	import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Album Read">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Read Album</title>
</head>
<body>
	<%@ include file="../css/header.jsp"%>
	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> <a class="active"
			href="/album/getall">Albums</a> <a href="/user/logout" id="logout">Logout</a>
	</div>
	<br>

	<div class="main">
		<%
		List<TrackDTO> tracks = (List<TrackDTO>) request.getSession().getAttribute("tracklist");
		
		%>


<%			for(TrackDTO t: tracks){ %>
		<table>
			<tr>
				<th>Title</th>
				<th>Author</th>
				<th>Year</th>
			</tr>
			<tr>
				<td><%=t.getTitle()%></td>
				<td><%=t.getAuthor()%></td>
				
			</tr>
		</table>
<%} %>
		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>


	</div>

	<%@ include file="../css/footer.jsp"%>
</body>
</html>