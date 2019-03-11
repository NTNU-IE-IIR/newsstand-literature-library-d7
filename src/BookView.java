public class BookView {
    private Book book;

    public BookView(Book book){
        this.book = book;
        viewBook();
    }

    private void viewBook(){
        String title = book.getTitle();
        String author = book.getAuthor();
        String date = book.getPublishDate();
        String publisher = book.getPublisher();
        String edition = book.getEdition();

        printInfo(title, author, date, publisher, edition);
    }

    private void printInfo(String title, String author, String date, String publisher, String edition){
        System.out.println("-------------------------------------");
        System.out.println("Title: " + title
                        + "\nAuthor: " + author
                        + "\nDate: " + date
                        + "\nPublisher: " + publisher
                        + "\nEdition: " + edition);
        System.out.println("-------------------------------------");
    }
}
