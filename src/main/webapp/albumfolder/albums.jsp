<%@ page import="it.contrader.dto.AlbumDTO" import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Album Management">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Album Manager</title>

</head>
<body>
	<%@ include file="../css/header.jsp"%>

	<div class="navbar">
		<a href="../homeadmin.jsp">Home</a> <a class="active"
			href="/album/getall">Albums</a> <a href="/user/logout" id="logout">Logout</a>
	</div>
	<div class="main">
		<%
			List<AlbumDTO> list = (List<AlbumDTO>) request.getSession().getAttribute("list");
		%>

		<br>

		<table>
			<tr>
				<th>Title</th>
				<th>Author</th>
				<th>Years</th>
				<th></th>
				<th></th>
			</tr>
			<%
				for (AlbumDTO a : list) {
			%>
			<tr>
				<td><a href="/album/read?id=<%=a.getId()%>"> <%=a.getTitle()%>
				</a></td>
				<td><%=a.getAuthor()%></td>
				<td><%=a.getYear()%></td>
				<td><a href="/album/preupdate?id=<%=a.getId()%>">Edit</a></td>


				<td><a href="/album/delete?id=<%=a.getId()%>">Delete</a></td>

			</tr>
			<%
				}
			%>
		</table>



		<form id="floatright" action="/album/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="title">Title</label>
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
			<div class="row">
				<div class="col-25">
					<label for="year">Year</label>
				</div>
				<div class="col-75">
					<input type="text" id="year" name="year"
						placeholder="inserisci anno">
				</div>
			</div>
			<button type="submit">Insert</button>
		</form>

	</div>
	<br>
	<%@ include file="../css/footer.jsp"%>
</body>
</html>