<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.TrackDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Track Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="navbar">
  <a  href="homeadmin.jsp">Home</a>
  <a href="UserServlet?type=admin&mode=userlist">Users</a>
  <a class="active" href="TrackServlet?type=admin&mode=tracklist">Tracks</a>
  <a href="AlbumServlet?type=admin&mode=albumlist">Albums</a>
  <a href="PlaylistServlet?type=admin&mode=playlistlist">Playlists</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">
	<%
		List<TrackDTO> list = (List<TrackDTO>) request.getAttribute("list");
	%>

<br>

	<table>
		<tr>
			<th>Title</th>
			<th>Author</th>
			
			<th></th>
			<th></th>
		</tr>
		<%
			for (TrackDTO t : list) {
		%>
		<tr>
			<td><a href=TrackServlet?type=admin&mode=read&id=<%=t.getId()%>>
					<%=t.getTitle()%>
			</a></td>
			<td><%=t.getAuthor()%></td>
		
			<td><a href=TrackServlet?type=admin&mode=read&update=true&id=<%=t.getId()%>>Edit</a>
			</td>
			<td><a href=TrackServlet?type=admin&mode=delete&id=<%=t.getId()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="TrackServlet?type=admin&mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="tit">Title</label>
    </div>
    <div class="col-75">
      <input type="text" id="titi" name="title" placeholder="inserisci title">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="Auth">Author</label>
    </div>
    <div class="col-75">
      <input type="text" id="pass" name="author" placeholder="inserisci author"> 
    </div>
  </div>

      <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>