import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class AppController {
    private GUIApp gui;
    private Registry literatureRegistry;

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
            gui.getGridPane().add(gui.getListLiteratureButton(), 0, 1);
            gui.getGridPane().add(gui.getAddLiteratureButton(), 1, 1);
            gui.getGridPane().add(gui.getFindByTitleButton(), 2, 1);
            gui.getGridPane().add(gui.getFindByAuthorButton(), 0, 2);
            gui.getGridPane().add(gui.getRemoveByTitleButton(), 1, 2);
            gui.getGridPane().add(gui.getConvertBookButton(), 2, 2);

            gui.getQuestion().setText("What do you want to do?");
        }
    }


    class FindByTitleEvent implements EventHandler<ActionEvent> {
        Literature literature = null;

        @Override
        public void handle(ActionEvent event) {
            gui.getGridPane().getChildren().clear();
            Text title = new Text("Title");
            TextField titleField = new TextField();

            gui.getGridPane().add(title, 0, 0);
            gui.getGridPane().add(titleField, 0, 1);


            Button find = new Button("Find");
            gui.getGridPane().add(find, 0, 2);

            find.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (!titleField.getText().isEmpty()) {
                        literature = literatureRegistry.findLiteratureByTitle(titleField.getText());
                    }
                    titleField.clear();
                    if (literature != null) {
                        if (literature instanceof BookSeries) {
                            BookSeries b = (BookSeries) literature;
                            BookSeriesView.viewBookSeries(b);
                        } else if (literature instanceof Book) {
                            Book b = (Book) literature;
                            gui.getGridPane().add(new Text(b.getTitle()), 0, 3);
                        } else if (literature instanceof Newspaper) {
                            Newspaper n = (Newspaper) literature;
                            NewspaperView.viewNewspaper(n);
                        } else if (literature instanceof ComicBook) {
                            ComicBook c = (ComicBook) literature;
                            ComicBookView.viewComicBook(c);
                        }
                    }
                }
            });

        }
    }


    class AddLiteratureEvent implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
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
            for (Literature l : literatureList) {
                String title = l.getTitle();
                gui.getGridPane().add(new Text(title), 0, i);
                i++;
            }
        }
    }


    abstract class LiteratureButtonEvent implements EventHandler<ActionEvent> {
        protected Button submitButton;
        protected Button returnButton;
        protected HBox buttonBox;
        protected Label label;
        protected TextField field1;
        protected TextField field2;
        protected TextField field3;
        protected TextField field4;

        @Override
        public abstract void handle(ActionEvent event);

        public void setup(Text text1, Text text2, Text text3, Text text4) {
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
            buttonBox = new HBox(submitButton);
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
            gui.getGridPane().add(buttonBox, 0, 12);
            gui.getGridPane().add(label, 0, 13);

            submitButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (!field1.getText().isEmpty() && !field2.getText().isEmpty() && !field3.getText().isEmpty()
                            && !field4.getText().isEmpty() && !dateField.getText().isEmpty() && !seriesTitleField.getText().isEmpty()) {
                        label.setText("You added a book titled " + field1.getText()
                                + "\nwith a series title: "
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
                        label.setText("You have to enter text in all the fields");
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

            gui.getGridPane().add(buttonBox, 0, 10);
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
                        label.setText("You have to enter text in all the fields");
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

            gui.getGridPane().add(buttonBox, 0, 8);
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

                        } catch (NumberFormatException nfe) {
                            label.setText("You have to enter a valid number for the serial number");
                        }
                    } else {
                        label.setText("You have to enter text in all the fields");
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

            gui.getGridPane().add(buttonBox, 0, 8);
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

                        } catch (NumberFormatException nfe) {
                            label.setText("You have to enter a valid number for releases per year");
                        }
                    } else {
                        label.setText("You have to enter text in all the fields");
                    }
                }
            });
        }
    }
}