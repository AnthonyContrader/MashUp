package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Playlist;
import it.contrader.model.User;

public class PlaylistDAO{


	private final String QUERY_ALL = "SELECT * FROM playlist";
	private final String QUERY_CREATE = "INSERT INTO playlist (id, name, genre) VALUES (?,?,?)";
	private final String QUERY_READ = "SELECT * FROM playlist WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE playlist SET id=?, name=?, genre=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM playlist WHERE id=?";

	public PlaylistDAO(){
	
	}
	
	public List<Playlist> getAll(){
		List<Playlist> playlistList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Playlist playlist;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String genre = resultSet.getString("genre");
				playlist = new Playlist(name, genre);
				playlist.setId(id);
				playlistList.add(playlist);
				}
			}
			catch (SQLException e) {
		e.printStackTrace();
			}
	return playlistList;
	}
	
	public boolean insert(Playlist playlistToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, playlistToInsert.getName());
			preparedStatement.setString(2, playlistToInsert.getGenre());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}
	
	public Playlist read(int playlistId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {

			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, playlistId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String name, genre;

			name = resultSet.getString("name");
			genre = resultSet.getString("genre");
			Playlist playlist = new Playlist(name, genre);
			playlist.setId(resultSet.getInt("id"));

			return playlist;
		} catch (SQLException e) {
			return null;
		}

	}
	
	public boolean update(Playlist playlistToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (playlistToUpdate.getId() == 0)
			return false;

		Playlist playlistRead = read(playlistToUpdate.getId());
		if (!playlistRead.equals(playlistToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (playlistToUpdate.getName() == null || playlistToUpdate.getName().equals("")) {
					playlistToUpdate.setName((playlistRead.getName()));
				}

				if (playlistToUpdate.getGenre() == null || playlistToUpdate.getGenre().equals("")) {
					playlistToUpdate.setGenre((playlistRead.getGenre()));
				}

				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, playlistToUpdate.getName());
				preparedStatement.setString(2, playlistToUpdate.getGenre());
				preparedStatement.setInt(4, playlistToUpdate.getId());
				int a = preparedStatement.executeUpdate();
				if (a > 0)
					return true;
				else
					return false;

			} catch (SQLException e) {
				return false;
			}
		}

		return false;

	}
	public boolean delete(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;

		} catch (SQLException e) {
		}
		return false;
	}

}
	
