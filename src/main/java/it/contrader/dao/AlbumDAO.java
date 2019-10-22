package it.contrader.dao;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.Album;

/**
 * 
 * @author Vittorio
 *
 *Per i dettagli della classe vedi Guida sez 6: DAO
 */
public class AlbumDAO implements DAO<Album> {

	private final String QUERY_ALL = "SELECT * FROM album";
	private final String QUERY_CREATE = "INSERT INTO album (name, author, year) VALUES (?,?,?)";
	private final String QUERY_READ = "SELECT * FROM album WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE album SET name=?, author=?, year=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM album WHERE id=?";

	public AlbumDAO() {

	}

	public List<Album> getAll() {
		List<Album> albumsList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Album album;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String author = resultSet.getString("author");
				String year = resultSet.getString("year");
				album = new Album(name, author, year);
				album.setId(id);
				albumsList.add(album);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return albumsList;
	}

	public boolean insert(Album albumToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, albumToInsert.getName());
			preparedStatement.setString(2, albumToInsert.getAuthor());
			preparedStatement.setString(3, albumToInsert.getYear());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public Album read(int albumId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, albumId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String name, author, year;

			name = resultSet.getString("name");
			author = resultSet.getString("author");
			year = resultSet.getString("year");
			Album album = new Album(name, author, year);
			album.setId(resultSet.getInt("id"));

			return album;
		} catch (SQLException e) {
			return null;
		}

	}

	public boolean update(Album albumToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (albumToUpdate.getId() == 0)
			return false;

		Album albumRead = read(albumToUpdate.getId());
		if (!albumRead.equals(albumToUpdate)) {
			try {
				// Fill the albumToUpdate object
				if (albumToUpdate.getName() == null || albumToUpdate.getName().equals("")) {
					albumToUpdate.setName(albumRead.getName());
				}

				if (albumToUpdate.getAuthor() == null || albumToUpdate.getAuthor().equals("")) {
					albumToUpdate.setAuthor(albumRead.getAuthor());
				}

				if (albumToUpdate.getYear() == null || albumToUpdate.getYear().equals("")) {
					albumToUpdate.setYear(albumRead.getYear());
				}

				// Update the album
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, albumToUpdate.getName());
				preparedStatement.setString(2, albumToUpdate.getAuthor());
				preparedStatement.setString(3, albumToUpdate.getYear());
				preparedStatement.setInt(4, albumToUpdate.getId());
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
