public class Newspaper extends Literature {
    private String genre;
    private int releasesPerYear;
    final private String type;

    public Newspaper(String title, String publisher, String genre, int releasesPerYear){
        super(title, publisher);
        this.genre = genre;
        this.releasesPerYear = releasesPerYear;
        type = "Newspaper";
    }
    /**
     * Returns the genre of the newspaper.
     *
     * @return The genre of the newspaper.
     */
    public String getGenre(){
        return genre;
    }

    /**
     * Returns the releases per year of the newspaper.
     *
     * @return The releases per year of the newspaper.
     */
    public int getReleasesPerYear(){
        return releasesPerYear;
    }

    /**
     * Returns the type of the newspaper.
     *
     * @return The type of the newspaper.
     */
    public String getType(){
        return type;
    }
}