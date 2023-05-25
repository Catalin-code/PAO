package Models;


public class Movie extends Media{

    private int duration;

    public Movie(int id, String title, String country, String language, String genre, int duration) {
        super(id, title, country, language, genre);
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
