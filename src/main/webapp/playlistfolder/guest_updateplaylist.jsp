<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.PlaylistDTO"
    import="it.contrader.dto.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Playlist Edit page">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit Playlist</title>

</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="/userfolder/homeguest.jsp">Home</a>
  <a class="active" href="/playlist/getguestplaylist">Playlists</a>
  <a href="/user/logout" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%PlaylistDTO p = (PlaylistDTO) request.getSession().getAttribute("dto");
  UserDTO u = (UserDTO) request.getSession().getAttribute("user");
%>


	<form id="floatleft" action="/playlist/update" method="post">
	  <div class="row">
	    <div class="col-25">
	      <label for="playlist">Name</label>
	    </div>
	    <div class="col-75">
	      <input type="text" id="user" name="name" value=<%=p.getName()%>>
	    </div>
	  </div>
	  <div class="row">
	    <div class="col-25">
	     <label for="author">Genre</label>
	    </div>
	    <div class="col-75">
	      <input type="text" id="genre" name="genre" value=<%=p.getGenre()%>> 
	    </div>
	  </div>
	   <input type="hidden" name="id" value =<%=p.getId() %>>
	    <input type="hidden" name="iduser" value =<%=u.getId()%>> 
	     <input type="hidden" name="type" value ="guest">
	      <button type="submit" >Edit</button>
	</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>