<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.AlbumDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Album Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="navbar">
  <a  href="homeadmin.jsp">Home</a>
  <a href="UserServlet?type=sa&mode=userlist">Users</a>
  <a href="TrackServlet?type=sa&mode=tracklist">Tracks</a>
  <a href="AlbumServlet?type=sa&mode=albumlist">Albums</a>
  <a href="PlaylistServlet?type=sa&mode=playlistlist">Playlists</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
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
			<td><a href=AlbumServlet?type=sa&mode=read&id=<%=a.getId()%>>
					<%=a.getName()%>
			</a></td>
			<td><%=a.getAuthor()%></td>
			<td><%=a.getYear()%></td>
			<td><a href=AlbumServlet?type=sa&mode=read&update=true&id=<%=a.getId()%>>Edit</a>
			</td>
			<td><a href=AlbumServlet?type=sa&mode=delete&id=<%=a.getId()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="AlbumServlet?type=sa&mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="album">Nome</label>
    </div>
    <div class="col-75">
      <input type="text" id="user" name="name" placeholder="inserisci nome">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="pass">Autore</label>
    </div>
    <div class="col-75">
      <input type="text" id="auth" name="author" placeholder="inserisci autore"> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="type">Anno</label>
    </div>
   		 <div class="col-75">
 		<input type="text" id="year" name="year" placeholder="inserisci l'anno"> 
    	</div>
  </div>
      <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>