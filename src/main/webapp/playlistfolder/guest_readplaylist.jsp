<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.PlaylistDTO"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Playlist Read">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Read User</title>
</head>
<body>
	<%@ include file="../css/header.jsp"%>
	<br>
<div class="navbar">
		<a href="/userfolder/homeguest.jsp">Home</a> <a class="active"
			href="/playlist/getguestplaylist">Playlist</a> <a href="/user/logout" id="logout">Logout</a>
	</div>
<br>
	<div class="main">
		<%
			PlaylistDTO p = (PlaylistDTO) request.getSession().getAttribute("dto");
		%>


		<table>
			<tr>
				
				<th>Name</th>
				<th>Genre</th>
			</tr>
			<tr>
				
				<td><%=p.getName()%></td>
				<td><%=p.getGenre()%></td>
			</tr>
		</table>

		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>


	</div>

	<%@ include file="../css/footer.jsp"%>
</body>
</html>