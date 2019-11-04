<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import = "it.contrader.dto.UserDTO"%>
<!DOCTYPE html>
<html>

<body>

<div class="navbar">
		<a href="/userfolder/homeguest.jsp">Home</a> 
		<a href="/album/getall">Albums</a>
		<a href="/track/getall?type=guest">Tracks</a>
		<a href="/playlist/getguestplaylist">Playlists</a>
		<a href="/user/logout" id="logout">Logout</a>
	</div>

</body>
</html>