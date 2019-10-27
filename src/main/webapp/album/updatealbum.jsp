<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.AlbumDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Album</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a class="active" href="AlbumServlet?type=admin&mode=albumlist">Albums</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%AlbumDTO a = (AlbumDTO) request.getAttribute("dto");%>


<form id="floatleft" action="AlbumServlet?mode=update&id=<%=a.getId()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="user">Nome</label>
    </div>
    <div class="col-75">
      <input type="text" id="user" name="name" value=<%=a.getName()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="pass">Autore</label>
    </div>
    <div class="col-75">
      <input type="text" id="pass" name="author" value=<%=a.getAuthor()%>> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="pass">Anno</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="pass" name="year" value=<%=a.getYear()%>> 
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