<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.TrackDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Track User Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<%@ include file="../usernavbar.jsp" %>

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
			<td><a href=TrackServlet?type=user&mode=read&id=<%=t.getId()%>>
					<%=t.getTitle()%>
			</a></td>
			<td><%=t.getAuthor()%></td>

		</tr>
		<%
			}
		%>
	</table>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>