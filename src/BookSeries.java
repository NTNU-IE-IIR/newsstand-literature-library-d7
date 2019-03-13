import java.util.ArrayList;

public class BookSeries extends Book{
    private String seriesTitle;

    public BookSeries(String author, String title, String publisher, String edition, String publishDate, String seriesTitle){
            super(author, title, publisher, edition, publishDate);
            this.seriesTitle = seriesTitle;
    }

    public String getSeriesTitle(){
        return seriesTitle;
    }
}
