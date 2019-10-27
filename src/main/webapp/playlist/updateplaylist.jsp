<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.PlaylistDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Playlist</title>
</head>
<body>
<%@include file="../css/header.jsp" %>
<div class="navbar">
	<a href="homeadmin.jsp">Home</a>
	<a class="active" href="PlaylistServlet?type=gfg&mode=playlistlist">Playlists</a>
	<a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%PlaylistDTO p = (PlaylistDTO) request.getAttribute("dto");%>

<form id="floatleft" action="PlaylistServlet?type=grdgf&mode=update&id=<%=p.getId()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="name">Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="name" name="name" value=<%=p.getName()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="genre">Genre</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="genre" name="genre" value=<%=p.getGenre()%>> 
    </div>
  </div>
      <button type="submit" >Edit</button>
      <button onclick="goBack()">Back</button>
</form>


</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>