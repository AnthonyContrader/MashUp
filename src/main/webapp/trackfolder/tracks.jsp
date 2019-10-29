<%@ page import="it.contrader.dto.TrackDTO" import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Track Management">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Track Manager</title>

</head>
<body>
	<%@ include file="../css/header.jsp"%>
	<%@ include file="../navbar.jsp" %>

	
	<div class="main">
		<%
			List<TrackDTO> list = (List<TrackDTO>) request.getSession().getAttribute("list");
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
				<td><a href="/track/read?id=<%=t.getId()%>"> <%=t.getTitle()%>
				</a></td>
				<td><%=t.getAuthor()%></td>
				<td><a href="/track/preupdate?id=<%=t.getId()%>">Edit</a></td>


				<td><a href="/track/delete?id=<%=t.getId()%>">Delete</a></td>

			</tr>
			<%
				}
			%>
		</table>



		<form id="floatright" action="/track/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="track">Title</label>
				</div>
				<div class="col-75">
					<input type="text" id="title" name="title"
						placeholder="inserisci titolo">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="author">Author</label>
				</div>
				<div class="col-75">
					<input type="text" id="author" name="author"
						placeholder="inserisci autore">
				</div>
			</div>
				<button type="submit">Insert</button>
		</form>

	</div>
	<br>
	<%@ include file="../css/footer.jsp"%>
</body>
</html>