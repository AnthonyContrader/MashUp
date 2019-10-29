<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.AlbumDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Album Edit page">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit Album</title>

</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="/homeadmin.jsp">Home</a>
  <a class="active" href="/album/getall">Albums</a>
  <a href="/user/logout" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%AlbumDTO a = (AlbumDTO) request.getSession().getAttribute("dto");%>


<form id="floatleft" action="/album/update" method="post">
  <div class="row">
    <div class="col-25">
      <label for="title">Title</label>
    </div>
    <div class="col-75">
      <input type="text" id="user" name="title" value=<%=a.getTitle()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="author">Author</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="author" name="author" value=<%=a.getAuthor()%>> 
    </div>
  </div>
   <div class="row">
    <div class="col-25">
     <label for="year">Year</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="year" name="year" value=<%=a.getYear()%>> 
    </div>
  </div>
  <input type="hidden" name="id" value =<%=a.getId() %>>
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>