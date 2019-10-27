<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import = "it.contrader.dto.UserDTO"%>
<!DOCTYPE html>
<html>

<body>

<div class="navbar">
  <a href="homeuser.jsp">Home</a>
  <a href="TrackServlet?type=user&mode=tracklist">Tracks</a>
  <a href="AlbumServlet?type=user&mode=albumlist">Albums</a>
  <a href="PlaylistServlet?type=user&mode=playlistlist">Playlists</a>
  <a href="UserServlet?type=user&mode=userlist">Profile</a>
  <a href="LogoutServlet" id="logout">Logout</a>
  

</div>
</body>
</html>