<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.PlaylistDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Playlist Manager</title>
</head>

<body>
<%@ include file="../css/header.jsp" %>

<div class="navbar">
  <a  href="homeadmin.jsp">Home</a>
  <a href="UserServlet?type=adg&mode=userlist">Users</a>
  <a href="TrackServlet?type=adg&mode=tracklist">Tracks</a>
  <a href="AlbumServlet?type=adg&mode=albumlist">Albums</a>
  <a class="active" href="PlaylistServlet?type=adg&mode=playlistlist">Playlists</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">
	<%
		List<PlaylistDTO> list = (List<PlaylistDTO>) request.getAttribute("list");
	%>
	
<br>

	<table>
		<tr>
			<th>Name</th>
			<th>Genre</th>
			<th></th>
			<th></th>
		</tr>
		<%
			for (PlaylistDTO p : list) {
		%>
		<tr>
			<td><a href=PlaylistServlet?type=admin&mode=read&id=<%=p.getId()%>>
					<%=p.getName()%>
			</a></td>
			<td><%=p.getGenre()%></td>
			<td><a href=PlaylistServlet?type=admin&mode=read&update=true&id=<%=p.getId()%>>Edit</a>
			</td>
			<td><a href=PlaylistServlet?type=admin&mode=delete&id=<%=p.getId()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>
	<form id="floatright" action="PlaylistServlet?type=adg&mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="name">Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="name" name="name" placeholder="inserisci nome playlist">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="genre">Genre</label>
    </div>
    <div class="col-75">
      <input type="text" id="genre" name="genre" placeholder="inserisci genere Playlist"> 
    </div>
  </div>
 
      <button type="submit" >Insert</button>
</form>
	
	


</div>

</body>

</html>
