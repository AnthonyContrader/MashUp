<%@ page language="java" contentType="text/html; charset=ISO8859-1"
	pageEncoding="ISO8859-1" import="it.contrader.dto.PlaylistDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Playlist</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
	<a href="homeadmin.jsp">Home</a>
	<a class="active" href="PlaylistServlet?mode=playlistlist">Playlists</a>
	<a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>

<div class="main">
<%PlaylistDTO p = (PlaylistDTO) request.getAttribute("dto"); %>

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

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>


</div>

<%@ include file="../css/footer.jsp" %>
</body>
</html>