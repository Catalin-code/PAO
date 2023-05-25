package Service;
import Models.Media;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Dictionary;
import java.util.Hashtable;

public class MediaService {
    public static void  createMedia(Media media) {

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DatabaseConnection.getConnection();
            String query = "INSERT INTO \"PAO\".media(title, \"countryId\", \"languageId\", \"genreId\")\n" +
                           "VALUES (?, ?, ?, ?);";
            statement = connection.prepareStatement(query);

            statement.setString(1, media.getTitle());
            statement.setInt(2, Integer.parseInt(media.getCountry()));
            statement.setInt(3, Integer.parseInt(media.getLanguage()));
            statement.setInt(4, Integer.parseInt(media.getGenre()));

            statement.executeUpdate();

            System.out.println("New media created successfully.");
        } catch (SQLException e) {
            System.err.println("Failed to add new media.");
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
