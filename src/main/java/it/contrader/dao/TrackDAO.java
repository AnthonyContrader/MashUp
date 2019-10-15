package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Track;;

public class TrackDAO {

	private final String QUERY_ALL = "SELECT * FROM track";
	private final String QUERY_CREATE = "INSERT INTO track (title, author) VALUES (?,?,?)";
	private final String QUERY_READ = "SELECT * FROM track WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE track SET title=?, author=?, WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM track WHERE id=?";

	public TrackDAO() {

	}

	public List<Track> getAll() {
		List<Track> trackList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Track track;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String title = resultSet.getString("title");
				String author = resultSet.getString("author");
				track = new Track(title, author);
				track.setId(id);
				trackList.add(track);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return trackList;
	}

	public boolean insert(Track trackToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, trackToInsert.getTitle());
			preparedStatement.setString(2, trackToInsert.getAuthor());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public Track read(int trackId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, trackId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String title, author;

			title = resultSet.getString("title");
			author = resultSet.getString("author");
			Track track = new Track(title, author);
			track.setId(resultSet.getInt("id"));

			return track;
		} catch (SQLException e) {
			return null;
		}

	}

	public boolean update(Track trackToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (trackToUpdate.getId() == 0)
			return false;

		Track trackRead = read(trackToUpdate.getId());
		if (!trackRead.equals(trackToUpdate)) {
			try {
				// Fill the trackToUpdate object
				if (trackToUpdate.getTitle() == null || trackToUpdate.getTitle().equals("")) {
					trackToUpdate.setTitle(trackRead.getTitle());				}

				if (trackToUpdate.getAuthor() == null || trackToUpdate.getAuthor().equals("")) {
					trackToUpdate.setTitle(trackRead.getTitle());
				}

				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, trackToUpdate.getTitle());
				preparedStatement.setString(2, trackToUpdate.getAuthor());
				preparedStatement.setInt(4, trackToUpdate.getId());
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