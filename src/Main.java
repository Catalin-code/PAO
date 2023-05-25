import Service.*;
import Models.*;

import java.security.Key;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Map;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //Database connection
        Connection connection = null;

        try {
            connection = DatabaseConnection.getConnection();
            System.out.println("Database connection established.");
        } catch (SQLException e) {
            System.err.println("Failed to establish database connection.");
            e.printStackTrace();
            return;
        }

        // Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Main menu
        boolean exit = false;
        while (!exit) {
            System.out.println("Select an option:");
            System.out.println("1. Show all movies");
            System.out.println("2. Show all TV Shows");
            System.out.println("3. Show actors by movie");
            System.out.println("4. Show actors by TV Show");
            System.out.println("5. New media");
            System.out.println("6. New person");
            System.out.println("7. Delete media");
            System.out.println("8. Delete person");
            System.out.println("0. Exit");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    Dictionary<String, Integer> movies = MovieService.getAllMovies();
                    Enumeration<String> moviesKeys = movies.keys();
                    while (moviesKeys.hasMoreElements()){
                        String movieKey = moviesKeys.nextElement();
                        Integer movieValue = movies.get(movieKey);
                        System.out.println("Title: " + movieKey);
                        System.out.println("Duration: " + movieValue);
                        System.out.println("--------------------------");
                    }
                    boolean moviesExit = false;
                    while (!moviesExit) {
                        System.out.println("0. Back");
                        int moviesOption = scanner.nextInt();
                        switch (moviesOption){
                            case 0:
                                moviesExit = true;

                                break;
                            default:
                                System.out.println("Invalid option. Please try again.");
                                break;
                        }
                    }
                    break;
                case 2:
                    boolean tvShowsExit = false;
                    while (!tvShowsExit) {
                        System.out.println("0. Back");
                        int tvShowsOption = scanner.nextInt();
                        switch (tvShowsOption){
                            case 0:
                                tvShowsExit = true;

                                break;
                            default:
                                System.out.println("Invalid option. Please try again.");
                                break;
                        }
                    }
                    break;
                case 3:
                    boolean actorsMovieExit = false;
                    while (!actorsMovieExit) {
                        System.out.println("0. Back");
                        int actorsMovieOption = scanner.nextInt();
                        switch (actorsMovieOption){
                            case 0:
                                actorsMovieExit = true;

                                break;
                            default:
                                System.out.println("Invalid option. Please try again.");
                                break;
                        }
                    }

                    break;
                case 4:
                    boolean actorsTVShowExit = false;
                    while (!actorsTVShowExit) {
                        System.out.println("0. Back");
                        int actorsTVShowOption = scanner.nextInt();
                        switch (actorsTVShowOption){
                            case 0:
                                actorsTVShowExit = true;

                                break;
                            default:
                                System.out.println("Invalid option. Please try again.");
                                break;
                        }
                    }

                    break;
                case 5:
                    String title = "";
                    String country = "";
                    String language = "";
                    String genre = "";
                    String duration = "";

                    boolean newMediaExit = false;
                    while (!newMediaExit) {
                        System.out.println("1. Title");
                        System.out.println("2. Country");
                        System.out.println("3. Language");
                        System.out.println("4. Genre");
                        System.out.println("5. Duration");
                        System.out.println("6. Create");
                        System.out.println("0. Back");
                        int newMediaOption = scanner.nextInt();
                        switch (newMediaOption){
                            case 1:
                                boolean newTitleExit = false;
                                while (!newTitleExit) {
                                    System.out.println("Enter a new title");
                                    System.out.println("0. Back");
                                    scanner.nextLine();
                                    String newTitleOption = scanner.nextLine();
                                    if (newTitleOption.equals("0")) {
                                        newTitleExit = true;
                                    } else {
                                        title = newTitleOption;
                                        System.out.println("The new title is: " + title);
                                        newTitleExit = true;
                                    }
                                }
                                break;
                            case 2:
                                Dictionary<Integer, String> countries = CountryService.getAllCountries();
                                Enumeration<Integer> countriesKeys = countries.keys();
                                boolean newCountryExit = false;
                                while (!newCountryExit) {
                                    while (countriesKeys.hasMoreElements()){
                                        Integer countryKey = countriesKeys.nextElement();
                                        String countryValue = countries.get(countryKey);
                                        System.out.println(countryKey + ": " + countryValue);
                                    }
                                    System.out.println("0. Back");
                                    scanner.nextLine();
                                    String newCountryOption = scanner.nextLine();
                                    if (newCountryOption.equals("0")) {
                                        newCountryExit = true;
                                    } else {
                                        country = newCountryOption;
                                        System.out.println("The new country is: " + country);
                                        newCountryExit = true;
                                    }
                                }
                                break;
                            case 3:
                                Dictionary<Integer, String> languages = LanguageService.getAllLanguages();
                                Enumeration<Integer> languagesKeys = languages.keys();
                                boolean newLanguageExit = false;
                                while (!newLanguageExit) {
                                    while (languagesKeys.hasMoreElements()){
                                        Integer languageKey = languagesKeys.nextElement();
                                        String languageValue = languages.get(languageKey);
                                        System.out.println(languageKey + ": " + languageValue);
                                    }
                                    System.out.println("0. Back");
                                    scanner.nextLine();
                                    String newLanguageOption = scanner.nextLine();
                                    if (newLanguageOption.equals("0")) {
                                        newLanguageExit = true;
                                    } else {
                                        language = newLanguageOption;
                                        System.out.println("The new language is: " + language);
                                        newLanguageExit = true;
                                    }
                                }
                                break;
                            case 4:
                                Dictionary<Integer, String> genres = GenreService.getAllGenres();
                                Enumeration<Integer> genresKeys = genres.keys();
                                boolean newGenreExit = false;
                                while (!newGenreExit) {
                                    while (genresKeys.hasMoreElements()){
                                        Integer genreKey = genresKeys.nextElement();
                                        String genreValue = genres.get(genreKey);
                                        System.out.println(genreKey + ": " + genreValue);
                                    }
                                    System.out.println("0. Back");
                                    scanner.nextLine();
                                    String newGenreOption = scanner.nextLine();
                                    if (newGenreOption.equals("0")) {
                                        newGenreExit = true;
                                    } else {
                                        genre = newGenreOption;
                                        System.out.println("The new genre is: " + genre);
                                        newGenreExit = true;
                                    }
                                }
                                break;
                            case 5:
                                boolean newDurationExit = false;
                                while (!newDurationExit) {
                                    System.out.println("Enter the movie duration");
                                    System.out.println("0. Back");
                                    scanner.nextLine();
                                    String newDurationOption = scanner.nextLine();
                                    if (newDurationOption.equals("0")) {
                                        newDurationExit = true;
                                    } else {
                                        duration = newDurationOption;
                                        System.out.println("The movie duration is: " + title);
                                        newDurationExit = true;
                                    }
                                }
                                break;
                            case 6:
                                Media newMedia = new Media(title, country, language, genre);
                                MediaService.createMedia(newMedia);
                                Movie newMovie = new Movie(MovieService.getMovieId(title), title, country, language, genre, Integer.parseInt(duration));
                                MovieService.createMovie(newMovie);

                                newMediaExit = true;
                                break;
                            case 0:
                                newMediaExit = true;
                                break;
                            default:
                                System.out.println("Invalid option. Please try again.");
                                break;
                        }
                    }

                    break;
                case 6:
                    boolean newPersonExit = false;
                    while (!newPersonExit) {
                        System.out.println("0. Back");
                        int newPersonOption = scanner.nextInt();
                        switch (newPersonOption){
                            case 0:
                                newPersonExit = true;

                                break;
                            default:
                                System.out.println("Invalid option. Please try again.");
                                break;
                        }
                    }

                    break;
                case 7:
                    boolean deleteMediaExit = false;
                    while (!deleteMediaExit) {
                        System.out.println("0. Back");
                        int deleteMediaOption = scanner.nextInt();
                        switch (deleteMediaOption){
                            case 0:
                                deleteMediaExit = true;

                                break;
                            default:
                                System.out.println("Invalid option. Please try again.");
                                break;
                        }
                    }

                    break;
                case 8:
                    boolean deletePersonExit = false;
                    while (!deletePersonExit) {
                        System.out.println("0. Back");
                        int deletePersonOption = scanner.nextInt();
                        switch (deletePersonOption){
                            case 0:
                                deletePersonExit = true;
                                break;
                            default:
                                System.out.println("Invalid option. Please try again.");
                                break;
                        }
                    }
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }

        // Close the database connection
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Database connection closed.");
            }
        } catch (SQLException e) {
            System.err.println("Failed to close database connection.");
            e.printStackTrace();
        }

    }
}