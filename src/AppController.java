import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class AppController {
    private GUIApp gui;
    private Registry literatureRegistry;
    private Label label;

    public AppController(GUIApp gui) {
        this.gui = gui;
        literatureRegistry = new Registry();

        CancelProcess cancelProcess = new CancelProcess();
        gui.getCancelButton().setOnAction(cancelProcess);

        NewspaperButtonEvent newspaperButtonEvent = new NewspaperButtonEvent();
        gui.getNewspaperButton().setOnAction(newspaperButtonEvent);

        ComicButtonEvent comicButtonEvent = new ComicButtonEvent();
        gui.getComicButton().setOnAction(comicButtonEvent);

        BookButtonEvent bookButtonEvent = new BookButtonEvent();
        gui.getBookButton().setOnAction(bookButtonEvent);

        AddLiteratureEvent addLiteratureEvent = new AddLiteratureEvent();
        gui.getAddLiteratureButton().setOnAction(addLiteratureEvent);

        ListLiteratureEvent listLiteratureEvent = new ListLiteratureEvent();
        gui.getListLiteratureButton().setOnAction(listLiteratureEvent);

        ReturnToStart returnToStart = new ReturnToStart();
        gui.getReturnButton().setOnAction(returnToStart);

        BookSeriesEvent bookSeriesEvent = new BookSeriesEvent();
        gui.getBookSeriesButton().setOnAction(bookSeriesEvent);

        FindByTitleEvent findByTitleEvent = new FindByTitleEvent();
        gui.getFindByTitleButton().setOnAction(findByTitleEvent);

        FindBooksByAuthorEvent findBooksByAuthorEvent = new FindBooksByAuthorEvent();
        gui.getFindByAuthorButton().setOnAction(findBooksByAuthorEvent);

        RemoveLiteratureByTitleEvent removeLiteratureByTitleEvent = new RemoveLiteratureByTitleEvent();
        gui.getRemoveByTitleButton().setOnAction(removeLiteratureByTitleEvent);

        ConvertToSeriesEvent convertToSeriesEvent = new ConvertToSeriesEvent();
        gui.getConvertBookButton().setOnAction(convertToSeriesEvent);
    }

    private String checkLiterature(Literature literature) {
        if (literature != null) {
            if (literature instanceof BookSeries) {
                BookSeries b = (BookSeries) literature;
                return ("\nType: Bookseries"
                        + "\nTitle: " + b.getTitle()
                        + "\nSeriestitle: " + b.getSeriesTitle()
                        + "\nAuthor: " + b.getAuthor()
                        + "\nPublisher: " + b.getPublisher()
                        + "\nEdition: " + b.getEdition()
                        + "\nDate published: " + b.getPublishDate());
            } else if (literature instanceof Book) {
                Book b = (Book) literature;
                return ("\nType: Book"
                        + "\nTitle: " + b.getTitle()
                        + "\nAuthor: " + b.getAuthor()
                        + "\nPublisher: " + b.getPublisher()
                        + "\nEdition: " + b.getEdition()
                        + "\nDate published: " + b.getPublishDate());
            } else if (literature instanceof Newspaper) {
                Newspaper n = (Newspaper) literature;
                return ("\nType: Newspaper"
                        + "\nTitle: " + n.getTitle()
                        + "\nPublisher: " + n.getPublisher()
                        + "\nGenre: " + n.getGenre()
                        + "\nReleases per year: " + n.getReleasesPerYear());
            } else if (literature instanceof ComicBook) {
                ComicBook c = (ComicBook) literature;
                return ("\nType: Comic Book"
                        + "\nTitle: " + c.getTitle()
                        + "\nPublisher: " + c.getPublishDate()
                        + "\nSerialnumber: " + c.getSerialNumber()
                        + "\nDate published: " + c.getPublishDate());
            }
        }
        return "";
    }


    class CancelProcess implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            Platform.exit();
        }
    }

    class ReturnToStart implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            gui.getGridPane().getChildren().clear();
            gui.getGridPane().getRowConstraints().clear();
            gui.getGridPane().add(gui.getListLiteratureButton(), 0, 1);
            gui.getGridPane().add(gui.getAddLiteratureButton(), 1, 1);
            gui.getGridPane().add(gui.getFindByTitleButton(), 2, 1);
            gui.getGridPane().add(gui.getFindByAuthorButton(), 0, 2);
            gui.getGridPane().add(gui.getRemoveByTitleButton(), 1, 2);
            gui.getGridPane().add(gui.getConvertBookButton(), 2, 2);

            gui.getQuestion().setText("What do you want to do?");
        }
    }


    class RemoveLiteratureByTitleEvent implements EventHandler<ActionEvent> {
        Literature literature;

        @Override
        public void handle(ActionEvent event) {
            gui.getGridPane().getChildren().clear();
            gui.getQuestion().setText("Enter the title of the literature you want to remove");

            Text title = new Text("Title");
            TextField titleField = new TextField();

            label = new Label();

            Button remove = new Button("Remove");
            GridPane.setHalignment(remove, HPos.CENTER);

            gui.getGridPane().add(title, 0, 0);
            gui.getGridPane().add(titleField, 0, 1);
            gui.getGridPane().add(remove, 0, 3);
            gui.getGridPane().add(label, 0, 4);

            remove.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    label.setText("");
                    if (!titleField.getText().isEmpty()) {
                        literature = literatureRegistry.removeLiteratureByTitle(titleField.getText());
                        titleField.clear();
                        if (literature != null) {
                            label.setText("You have removed " + literature.getTitle() + " \nfrom the registry");
                        } else {
                            label.setText("That title is not valid");
                        }
                    } else {
                        label.setText("You have to enter \ntext in the field");
                    }
                }
            });
        }
    }


    class ConvertToSeriesEvent implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            gui.getGridPane().getChildren().clear();
            gui.getQuestion().setText("Which book do you want to convert?");

            Text title = new Text("Title");
            TextField titleField = new TextField();
            Text seriesTitle = new Text("Seriestitle");
            TextField seriesTitleField = new TextField();
            Button convert = new Button("Convert");
            label = new Label();


            GridPane.setHalignment(convert, HPos.CENTER);
            GridPane.setHalignment(label, HPos.CENTER);

            gui.getGridPane().add(title, 0, 0);
            gui.getGridPane().add(titleField, 0, 1);
            gui.getGridPane().add(seriesTitle, 0, 2);
            gui.getGridPane().add(seriesTitleField, 0, 3);
            gui.getGridPane().add(convert, 0, 4);
            gui.getGridPane().add(label, 0, 5);

            convert.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    label.setText("");
                    if (!titleField.getText().isEmpty() && !seriesTitleField.getText().isEmpty()) {
                        BookSeries book = literatureRegistry.convertToSeries(titleField.getText(), seriesTitleField.getText());
                        titleField.clear();
                        seriesTitleField.clear();
                        if (book != null) {
                            label.setText("You converted " + book.getTitle() + " to a bookseries \nwith seriestitle " + book.getSeriesTitle());
                        } else {
                            label.setText("There were no books in \nthe registry with that title or \nthe book is already a series, \nplease try again");
                        }
                    } else {
                        label.setText("You have to enter \ntext in all the fields");
                    }
                }
            });
        }
    }


    class FindBooksByAuthorEvent implements EventHandler<ActionEvent> {
        private ArrayList<Book> bookList;
        private Text author;
        private TextField authorField;
        private Button find;
        private VBox bookBox;

        @Override
        public void handle(ActionEvent event) {
            gui.getGridPane().getChildren().clear();
            gui.getQuestion().setText("Enter the author of the book you want to find");

            author = new Text("Author");
            authorField = new TextField();

            gui.getGridPane().add(author, 0, 0);
            gui.getGridPane().add(authorField, 0, 1);

            find = new Button("Find books");
            gui.getGridPane().add(find, 0, 2);
            GridPane.setHalignment(find, HPos.CENTER);

            bookBox = new VBox();
            gui.getGridPane().add(bookBox, 0, 3);

            find.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    bookBox.getChildren().clear();
                    if (!authorField.getText().isEmpty()) {
                        bookList = literatureRegistry.findBookByAuthor(authorField.getText());
                        authorField.clear();
                        if (!bookList.isEmpty()) {
                            for (Book b : bookList) {
                                if (b instanceof BookSeries) {
                                    BookSeries book = (BookSeries) b;
                                    String info = "\nType: Bookseries"
                                            + "\nTitle: " + book.getTitle()
                                            + "\nSeriesitle: " + book.getSeriesTitle()
                                            + "\nAuthor: " + book.getAuthor()
                                            + "\nPublisher: " + book.getPublisher()
                                            + "\nEdition: " + book.getEdition()
                                            + "\nDate published: " + book.getPublishDate();
                                    bookBox.getChildren().add(new Label(info));
                                } else {
                                    String info = "\nType: Book"
                                            + "\nTitle: " + b.getTitle()
                                            + "\nAuthor: " + b.getAuthor()
                                            + "\nPublisher: " + b.getPublisher()
                                            + "\nEdition: " + b.getEdition()
                                            + "\nDate published: " + b.getPublishDate();
                                    bookBox.getChildren().add(new Label(info));
                                }
                            }
                        } else {
                            bookBox.getChildren().add(new Label("There are no books in \nthe registry with that title"));
                        }
                    } else {
                        bookBox.getChildren().add(new Label("You have to enter a \ntitle in the textfield"));
                    }
                }
            });
        }
    }

    class FindByTitleEvent implements EventHandler<ActionEvent> {
        Literature literature = null;

        @Override
        public void handle(ActionEvent event) {
            gui.getGridPane().getChildren().clear();
            gui.getQuestion().setText("Enter the title of the literature you want to find");

            Text title = new Text("Title");
            TextField titleField = new TextField();

            label = new Label();

            gui.getGridPane().add(title, 0, 0);
            gui.getGridPane().add(titleField, 0, 1);

            Button find = new Button("Find literature");
            gui.getGridPane().add(find, 0, 2);
            gui.getGridPane().add(label, 0, 3);
            GridPane.setHalignment(find, HPos.CENTER);

            find.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    label.setText("");
                    if (!titleField.getText().isEmpty()) {
                        literature = literatureRegistry.findLiteratureByTitle(titleField.getText());
                        titleField.clear();
                        if (literature != null) {
                            label.setText(checkLiterature(literature));
                        } else {
                            label.setText("That title is not valid");
                        }
                    } else {
                        label.setText("You have to enter a \ntitle in the textfield");
                    }
                }
            });
        }
    }


    class AddLiteratureEvent implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            gui.getQuestion().setText("What kind of literature do you want to add?");
            gui.getGridPane().getChildren().clear();
            gui.getGridPane().add(gui.getBookButton(), 0, 0);
            gui.getGridPane().add(gui.getBookSeriesButton(), 1, 0);
            gui.getGridPane().add(gui.getNewspaperButton(), 2, 0);
            gui.getGridPane().add(gui.getComicButton(), 3, 0);
        }
    }

    class ListLiteratureEvent implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            gui.getGridPane().getChildren().clear();
            ArrayList<Literature> literatureList = literatureRegistry.getLiteratureList();
            gui.getQuestion().setText("Here is all the literature in the list:");
            int i = 0;
            if (!literatureList.isEmpty()) {
                for (Literature l : literatureList) {
                    String info = checkLiterature(l);
                    gui.getGridPane().add(new Label(info), 0, i);
                    gui.getGridPane().getRowConstraints().add(new RowConstraints(150));
                    i++;
                }
            } else {
                gui.getGridPane().add(new Label("There are no literature in the registry :("), 0, 0);
            }
        }
    }


    abstract class LiteratureButtonEvent implements EventHandler<ActionEvent> {
        protected Button submitButton;
        protected TextField field1;
        protected TextField field2;
        protected TextField field3;
        protected TextField field4;

        @Override
        public abstract void handle(ActionEvent event);

        public void setup(Text text1, Text text2, Text text3, Text text4) {
            gui.getQuestion().setText("Enter info about the literature below");
            field1 = new TextField();
            field2 = new TextField();
            field3 = new TextField();
            field4 = new TextField();

            gui.getGridPane().add(text1, 0, 0);
            gui.getGridPane().add(text2, 0, 2);
            gui.getGridPane().add(text3, 0, 4);
            gui.getGridPane().add(text4, 0, 6);
            gui.getGridPane().add(field1, 0, 1);
            gui.getGridPane().add(field2, 0, 3);
            gui.getGridPane().add(field3, 0, 5);
            gui.getGridPane().add(field4, 0, 7);

            submitButton = new Button("Submit");
            GridPane.setHalignment(submitButton, HPos.CENTER);
            label = new Label();
        }
    }

    class BookSeriesEvent extends BookButtonEvent implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            getInfo();

            Text seriesTitle = new Text("Series title");
            TextField seriesTitleField = new TextField();

            gui.getGridPane().add(seriesTitle, 0, 10);
            gui.getGridPane().add(seriesTitleField, 0, 11);
            gui.getGridPane().add(submitButton, 0, 12);
            gui.getGridPane().add(label, 0, 13);

            submitButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (!field1.getText().isEmpty() && !field2.getText().isEmpty() && !field3.getText().isEmpty()
                            && !field4.getText().isEmpty() && !dateField.getText().isEmpty() && !seriesTitleField.getText().isEmpty()) {
                        label.setText("You added a book titled " + field1.getText()
                                + "\nwith a series title: " + seriesTitleField.getText()
                                + "\nthat is published by " + field2.getText()
                                + "\nand authored by " + field3.getText());
                        literatureRegistry.addLiterature(new BookSeries(field3.getText(), field1.getText(), field2.getText(), field4.getText(), dateField.getText(), seriesTitleField.getText()));
                        field1.clear();
                        field2.clear();
                        field3.clear();
                        field4.clear();
                        dateField.clear();
                        seriesTitleField.clear();
                    } else {
                        label.setText("You have to enter \ntext in all the fields");
                    }
                }
            });
        }
    }

    class BookButtonEvent extends LiteratureButtonEvent implements EventHandler<ActionEvent> {
        protected Text title;
        protected Text author;
        protected Text publisher;
        protected Text edition;
        protected Text publishDate;
        protected TextField dateField;

        @Override
        public void handle(ActionEvent event) {
            getInfo();

            gui.getGridPane().add(submitButton, 0, 10);
            gui.getGridPane().add(label, 0, 11);


            submitButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (!field1.getText().isEmpty() && !field2.getText().isEmpty() && !field3.getText().isEmpty()
                            && !field4.getText().isEmpty() && !dateField.getText().isEmpty()) {
                        label.setText("You added a book titled " + field1.getText()
                                + "\nthat is published by " + field2.getText()
                                + "\nand authored by " + field3.getText());
                        literatureRegistry.addLiterature(new Book(field3.getText(), field1.getText(), field2.getText(), field4.getText(), dateField.getText()));
                        field1.clear();
                        field2.clear();
                        field3.clear();
                        field4.clear();
                        dateField.clear();
                    } else {
                        label.setText("You have to enter \ntext in all the fields");
                    }
                }
            });
        }

        protected void getInfo() {
            gui.getGridPane().getChildren().clear();
            gui.getQuestion().setText("");
            title = new Text("What is the title of the book?");
            publisher = new Text("Who is the publisher?");
            author = new Text("Who is the author?");
            edition = new Text("What edition is it?");
            publishDate = new Text("What date was the book released?");

            dateField = new TextField();

            setup(title, publisher, author, edition);

            gui.getGridPane().add(publishDate, 0, 8);
            gui.getGridPane().add(dateField, 0, 9);
        }
    }

    class ComicButtonEvent extends LiteratureButtonEvent implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            gui.getGridPane().getChildren().clear();
            Text title = new Text("What is the title of the Comic Book?");
            Text publisher = new Text("Who is the publisher?");
            Text serialNumber = new Text("What is the serial number?");
            Text publishDate = new Text("What date was it released?");

            setup(title, publisher, serialNumber, publishDate);

            gui.getGridPane().add(submitButton, 0, 8);
            gui.getGridPane().add(label, 0, 9);

            submitButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (!field1.getText().isEmpty() && !field2.getText().isEmpty()
                            && !field3.getText().isEmpty() && !field4.getText().isEmpty()) {
                        try {
                            int serialNumber = Integer.parseInt(field3.getText());
                            label.setText("You added a comic book titled " + field1.getText()
                                    + "\nthat is published by " + field2.getText());
                            literatureRegistry.addLiterature(new ComicBook(field1.getText(), field2.getText(), serialNumber, field4.getText()));
                            field1.clear();
                            field2.clear();
                            field3.clear();
                            field4.clear();
                        } catch (NumberFormatException nfe) {
                            label.setText("You have to enter a valid number \nfor the serial number");
                        }
                    } else {
                        label.setText("You have to enter \ntext in all the fields");
                    }
                }
            });
        }
    }

    class NewspaperButtonEvent extends LiteratureButtonEvent implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            gui.getGridPane().getChildren().clear();
            Text title = new Text("What is the title of the newspaper?");
            Text publisher = new Text("Who is the publisher?");
            Text genre = new Text("What kind of newspaper is it?");
            Text releases = new Text("How many times a year does it release?");

            setup(title, publisher, genre, releases);

            gui.getGridPane().add(submitButton, 0, 8);
            gui.getGridPane().add(label, 0, 9);

            submitButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (!field1.getText().isEmpty() && !field2.getText().isEmpty()
                            && !field3.getText().isEmpty() && !field4.getText().isEmpty()) {
                        try {
                            int releases = Integer.parseInt(field4.getText());
                            label.setText("You added a newspaper titled " + field1.getText()
                                    + "\nthat is published by " + field2.getText());
                            literatureRegistry.addLiterature(new Newspaper(field1.getText(), field2.getText(), field3.getText(), releases));
                            field1.clear();
                            field2.clear();
                            field3.clear();
                            field4.clear();

                        } catch (NumberFormatException nfe) {
                            label.setText("You have to enter a valid number \nfor releases per year");
                        }
                    } else {
                        label.setText("You have to enter \ntext in all the fields");
                    }
                }
            });
        }
    }
}