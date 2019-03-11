public class ComicBookView {
    private ComicBook comicBook;

    public ComicBookView(ComicBook comicBook){
        this.comicBook = comicBook;
        viewComicBook();
    }

    private void viewComicBook(){
        String title = comicBook.getTitle();
        String publisher = comicBook.getPublisher();
        int serialNumber = comicBook.getSerialNumber();
        String publishDate = comicBook.getPublishDate();

        printInfo(title, publisher, serialNumber, publishDate);
    }

    private void printInfo(String title, String publisher, int serialNumber, String publishDate){
        System.out.println("-------------------------------------");
        System.out.println("Title: " + title
                        + "\nPublisher: " + publisher
                        + "\nSerial number: " + serialNumber
                        + "\nPublish Date: " + publishDate);
        System.out.println("-------------------------------------");
    }
}
