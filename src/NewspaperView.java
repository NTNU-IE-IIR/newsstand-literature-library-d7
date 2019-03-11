public class NewspaperView {
    private Newspaper newspaper;

    public NewspaperView(Newspaper newspaper){
        this.newspaper = newspaper;
        viewNewspaper();
    }

    private void viewNewspaper(){
        String title = newspaper.getTitle();
        String publisher = newspaper.getPublisher();
        String genre = newspaper.getGenre();
        int releases = newspaper.getReleasesPerYear();

        printInfo(title, publisher, genre, releases);
    }

    private void printInfo(String title, String publisher, String genre, int releases){
        System.out.println("-------------------------------------");
        System.out.println("Title: " + title
                        + "\nPublisher: " + publisher
                        + "\nGenre: " + genre
                        + "\nReleases: " + releases);
        System.out.println("-------------------------------------");
    }
}
