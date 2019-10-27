<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.TrackDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Track</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a class="active" href="TrackServlet?type=admin&mode=Tracklist">Tracks</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%TrackDTO t = (TrackDTO) request.getAttribute("dto");%>


<form id="floatleft" action="TrackServlet?mode=update&id=<%=t.getId()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="Track">Title</label>
    </div>
    <div class="col-75">
      <input type="text" id="track" name="title" value=<%=t.getTitle()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="pass">author</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="pass" name="author" value=<%=t.getAuthor()%>> 
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