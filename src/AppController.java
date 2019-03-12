import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AppController {
    private GUIApp gui;
    private Stage stage;

    public AppController(Stage stage, GUIApp gui) {
        this.gui = gui;
        this.stage = stage;

        CancelProcess cancelProcess = new CancelProcess();
        gui.getCancelButton().setOnAction(cancelProcess);

        NewspaperButtonEvent NewspaperButtonEvent = new NewspaperButtonEvent();
        gui.getBookButton().setOnAction(NewspaperButtonEvent);
    }


    class CancelProcess implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            Platform.exit();
        }
    }

    class NewspaperButtonEvent implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            gui.getNewspaperButton().setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    gui.getGridPane().getChildren().clear();
                    Text title = new Text("What is the title of the newspaper?");
                    Text publisher = new Text("Who is the publisher?");
                    Text genre = new Text("What kind of newspaper is it?");
                    Text releases = new Text("How many times a year does it release?");

                    TextField titleField = new TextField();
                    TextField publisherField = new TextField();
                    TextField genreField = new TextField();
                    TextField releasesField = new TextField();
                    gui.getGridPane().add(title, 0, 0);
                    gui.getGridPane().add(titleField,0, 1);
                    gui.getGridPane().add(publisher,0, 2);
                    gui.getGridPane().add(publisherField,0, 3);
                    gui.getGridPane().add(genre, 0, 4);
                    gui.getGridPane().add(genreField,0, 5);
                    gui.getGridPane().add(releases, 0, 6);
                    gui.getGridPane().add(releasesField,0, 7);

                    Button submitButton = new Button("Submit");
                    gui.getGridPane().add(submitButton, 0, 8);

                    submitButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            Label label = new Label();
                            if((title.getText() != null) && !title.getText().isEmpty()){
                                label.setText("You added a newspaper titled " + titleField.getText()
                                        + " that is published by " + publisherField.getText());
                                gui.getGridPane().add(label, 0, 9);
                            }
                        }
                    });
                }
            });
        }
    }
}