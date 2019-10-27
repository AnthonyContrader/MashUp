<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.UserDTO"
	 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>User: ${user.getUsername()}</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
	<%
		UserDTO u = (UserDTO) session.getAttribute("user");
	%>
<div class="navbar">
  <a  href="homeuser.jsp">Home</a>
    <a href="TrackServlet?type=user&mode=tracklist">Tracks</a>
 	<a href="AlbumServlet?type=user&mode=albumlist">Albums</a>
 	<a href="PlaylistServlet?type=user&mode=playlistlist">Playlists</a>
	<a href=UserServlet?type=user&mode=read&update=true&id=<%=u.getId()%>>Profile</a>
  	<a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">
	

<br>

	<table>
		<tr>
			<th>Username</th>
			<th>Password</th>
			<th>Usertype</th>
			<th></th>
			<th></th>
		</tr>
	
		<tr>
			<td><a href=UserServlet?type=user&mode=read&id=<%=u.getId()%>>
					<%=u.getUsername()%>
			</a></td>
			<td><%=u.getPassword()%></td>
			<td><%=u.getUsertype()%></td>
			<td><a href=UserServlet?type=user&mode=read&update=true&id=<%=u.getId()%>>Edit</a>
			<td><a href=UserServlet?type=user&mode=delete&id=<%=u.getId() %>>Delete</a>
			</td>

		</tr>
	</table>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>