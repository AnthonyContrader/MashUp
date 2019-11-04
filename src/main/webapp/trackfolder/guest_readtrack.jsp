<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.TrackDTO"
	import="it.contrader.dto.PlaylistDTO" import="java.util.*"
	import="it.contrader.dto.UserDTO"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Track Read">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Read Track</title>
</head>
<body>
	<%@ include file="../css/header.jsp"%>
	<br>
	<div class="navbar">
		<a href="/userfolder/homeadmin.jsp">Home</a> <a class="active"
			href="/track/getall">Tracks</a> <a href="/user/logout" id="logout">Logout</a>
	</div>
<br>
	<div class="main">
		<%
		
		TrackDTO t = (TrackDTO) request.getSession().getAttribute("dto");
		List<PlaylistDTO> playlistlist = (List<PlaylistDTO>) request.getSession().getAttribute("userplaylists");
			
		%>


		<table>
			<tr>
				
				<th>Title</th>
				<th>Author</th>
			</tr>
			<tr>
				<td><%=t.getTitle()%></td>
				<td><%=t.getAuthor()%></td>
			</tr>
		</table>
		
		<form id="floatright" action="/tp/insert" method="post">
			<div class="col-75">
					<select id="album" name="album">
					<%
					for (PlaylistDTO p : playlistlist){
					%>
						<option value=<%=p.getId()%>><%=p.getName() +"-"+ p.getGenre()%></option>
						
					<%} %>
					</select>
				</div>
					<button type="submit">Insert</button>
		
		</form>

		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>


	</div>

	<%@ include file="../css/footer.jsp"%>
</body>
</html>