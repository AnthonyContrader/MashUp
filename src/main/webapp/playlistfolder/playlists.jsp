<%@ page import="it.contrader.dto.PlaylistDTO" import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Playlist Management">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Playlist Manager</title>

</head>
<body>
	<%@ include file="../css/header.jsp"%>
	<%@ include file="../navbar.jsp" %>

	
	<div class="main">
		<%
			List<PlaylistDTO> list = (List<PlaylistDTO>) request.getSession().getAttribute("list");
		%>

		<br>

		<table>
			<tr>
				<th>Name</th>
				<th>Genre</th>
				<th></th>
				<th></th>
			</tr>
			<%
				for (PlaylistDTO p : list) {
			%>
			<tr>
				<td><a href="/playlist/read?id=<%=p.getId()%>"> <%=p.getName()%>
				</a></td>
				<td><%=(p.getGenre())%></td>
				<td><a href="/playlist/delete?type=admin&id=<%=p.getId()%>">Delete</a></td>

			</tr>
			<%
				}
			%>
		</table>



		<form id="floatright" action="/playlist/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="name">Name</label>
				</div>
				<div class="col-75">
					<input type="text" id="name" name="name"
						placeholder="inserisci nome">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="pass">Genre</label>
				</div>
				<div class="col-75">
					<input type="text" id="genre" name="genre"
						placeholder="inserisci genere">
				</div>
			</div>
				<%UserDTO u = (UserDTO) request.getSession().getAttribute("user");%>
					<input type="hidden" name="iduser" id="iduser" value="<%=u.getId()%>" >	
					<input type="hidden" name="type" id="type" value="admin">
				<button type="submit">Insert</button>
		</form>

	</div>
	<br>
	<%@ include file="../css/footer.jsp"%>
</body>
</html>