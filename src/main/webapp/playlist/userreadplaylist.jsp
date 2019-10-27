<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.PlaylistDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Playlist User Read</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
	<a href="homeuser.jsp">Home</a>
	<a class="active" href="PlaylistServlet?type=user&mode=playlistlist">Playlists</a>
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
	<form id="floatleft" action="PlaylistServlet?type=user&mode=playlistlist" method="post">
<button onclick="goBack()">Back</button>
</form>

</div>

<%@ include file="../css/footer.jsp" %>
</body>
</html>