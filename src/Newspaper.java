public class Newspaper extends Literature {
    private String genre;
    private int releasesPerYear;

    public Newspaper(String title, String publisher, String genre, int releasesPerYear) {
        super(title, publisher);
        this.genre = genre;
        this.releasesPerYear = releasesPerYear;
    }

    public String getGenre() {
        return genre;
    }

    public int getReleasesPerYear() {
        return releasesPerYear;
    }
}