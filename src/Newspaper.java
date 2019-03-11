public class Newspaper extends Literature {
    private String genre;
    private int releasesPerYear;

    public Newspaper(String title, String author, String genre, int releasesPerYear){
        super(title, author);
        this.genre = genre;
        this.releasesPerYear = releasesPerYear;
    }

    public String getGenre(){
        return genre;
    }

    public int getReleasesPerYear(){
        return releasesPerYear;
    }
}
