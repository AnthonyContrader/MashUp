<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.TrackDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Track Edit page">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit Track</title>

</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="/userfolder/homeadmin.jsp">Home</a>
  <a class="active" href="/track/getall">Tracks</a>
  <a href="/user/logout" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%TrackDTO t = (TrackDTO) request.getSession().getAttribute("dto");%>


<form id="floatleft" action="/track/update" method="post">
  <div class="row">
    <div class="col-25">
      <label for="track">Title</label>
    </div>
    <div class="col-75">
      <input type="text" id="user" name="title" value=<%=t.getTitle()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="author">Author</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="author" name="author" value=<%=t.getAuthor()%>> 
    </div>
  </div>
   <input type="hidden" name="id" value =<%=t.getId() %>>
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>