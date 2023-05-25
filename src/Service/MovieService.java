package Service;
import Models.Media;
import Models.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Dictionary;
import java.util.Hashtable;

public class MovieService {
    public static Dictionary<String, Integer> getAllMovies() {
        Dictionary<String, Integer> movies = new Hashtable<>();

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseConnection.getConnection();
            String query = "SELECT media.title, movie.duration FROM \"PAO\".media AS media\n" +
                    "RIGHT JOIN \"PAO\".movie AS movie ON movie.\"mediaId\" = media.id";
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String title = resultSet.getString("title");
                int duration = resultSet.getInt("duration");

                movies.put(title, duration);
            }
        } catch (SQLException e) {
            System.err.println("Failed to retrieve movies from the database.");
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Failed to close database resources.");
                e.printStackTrace();
            }
        }
        return movies;
    }

    public static int getMovieId(String title) {
        int id = 0;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseConnection.getConnection();
            String query = "SELECT id FROM \"PAO\".media\n" +
                    "WHERE title = ?;";
            statement = connection.prepareStatement(query);
            statement.setString(1, title);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                id = resultSet.getInt("id");
            }
        } catch (SQLException e) {
            System.err.println("Failed to retrieve movie from the database.");
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Failed to close database resources.");
                e.printStackTrace();
            }
        }
        return id;
    }

    public static void  createMovie(Movie movie) {

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DatabaseConnection.getConnection();
            String query = "INSERT INTO \"PAO\".movie(\"mediaId\", duration)\n" +
                           "VALUES (?, ?);";
            statement = connection.prepareStatement(query);

            statement.setInt(1, movie.getId());
            statement.setInt(2, movie.getDuration());

            statement.executeUpdate();

            System.out.println("New movie created successfully.");
        } catch (SQLException e) {
            System.err.println("Failed to add new movie.");
            e.printStackTrace();
        } finally {
            try {

                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Failed to close database resources.");
                e.printStackTrace();
            }
        }
    }
}
