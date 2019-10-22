<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.AlbumDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read User</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a class="active"  href="AlbumServlet?mode=albumlist">Albums</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>

<div class="main">
<%AlbumDTO a = (AlbumDTO) request.getAttribute("dto");%>


<table>
	<tr> 
		<th>Name</th>
		<th>Author/th>
		<th>Year</th>
	</tr>
	<tr>
		<td><%=a.getName()%></td>
		<td> <%=a.getAuthor()%></td>
		<td> <%=a.getYear()%></td>
	</tr>	
</table>

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>


</div>

<%@ include file="../css/footer.jsp" %>
</body>
</html>