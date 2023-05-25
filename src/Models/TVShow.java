package Models;


public class TVShow extends Media{

    private int seasons;
    private int episodes;

    public TVShow(int id, String title, String country, String language, String genre, int seasonCount, int episodeCount) {
        super(id, title, country, language, genre);
        this.seasons = seasonCount;
        this.episodes = episodeCount;
    }

    public int getSeasonCount() {
        return seasons;
    }

    public void setSeasonCount(int seasonCount) {
        this.seasons = seasonCount;
    }

    public int getEpisodes() {
        return episodes;
    }

    public void setEpisodes(int episodes) {
        this.episodes = episodes;
    }
}
