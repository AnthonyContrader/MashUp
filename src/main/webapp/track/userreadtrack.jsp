<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.TrackDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read User Track</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homeuser.jsp">Home</a>
  <a href="TrackServlet?type=user&mode=userlist">Tracks</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>

<div class="main">
<%TrackDTO u = (TrackDTO) request.getAttribute("dto");%>


<table>
	<tr> 
		<th>Title</th>
		<th>Author</th>
	
	</tr>
	<tr>
		<td><%=u.getTitle()%></td>
		<td> <%=u.getAuthor()%></td>
		
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