import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.GridPane;

public class GUIApp {
    private Stage stage;
    private BorderPane root;

    private Button cancelButton;
    private GridPane gridPane;

    private Button bookButton;
    private Button newspaperButton;
    private Button comicButton;

    public Button getBookButton() {
        return bookButton;
    }

    public Button getNewspaperButton() {
        return newspaperButton;
    }

    public Button getComicButton() {
        return comicButton;
    }

    public Button getCancelButton() {
        return cancelButton;
    }

    public BorderPane getRoot() {
        return root;
    }

    public GridPane getGridPane() {
        return gridPane;
    }



    public GUIApp(Stage stage) {
        this.stage = stage;
        root = new BorderPane();

        setupGUI();
    }

    private void setupGUI() {

        Text question = new Text("What type of literature do you want to add?");

        cancelButton = new Button("Cancel");
        bookButton = new Button("Book");
        newspaperButton = new Button("Newspaper");
        comicButton = new Button("Comic Book");


        gridPane = new GridPane();
        gridPane.setPrefSize(500, 500);
        gridPane.setAlignment(Pos.TOP_CENTER);
        gridPane.setVgap(5);
        gridPane.setHgap(5);

        gridPane.add(bookButton, 0, 1);
        gridPane.add(newspaperButton, 1, 1);
        gridPane.add(comicButton, 2, 1);
        root.setCenter(gridPane);
        root.setTop(question);
        root.setBottom(new HBox(cancelButton));
    }
}
