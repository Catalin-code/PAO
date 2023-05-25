package Models;



public class Media {
    private int id = 0;
    private String title;
    private String country;
    private String language;
    private String genre;

    public Media(int id, String title, String country, String language, String genre) {
        this.id = id;
        this.title = title;
        this.country = country;
        this.language = language;
        this.genre = genre;
    }

    public Media(String title, String country, String language, String genre) {
        this.title = title;
        this.country = country;
        this.language = language;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
