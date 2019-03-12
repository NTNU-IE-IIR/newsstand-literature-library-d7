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

    private Button listLiteratureButton;
    private Button addLiteratureButton;
    private Button findByTitleButton;
    private Button findByAuthorButton;
    private Button removeByTitleButton;
    private Button convertBookButton;

    private Button bookButton;
    private Button newspaperButton;
    private Button comicButton;
    private Button bookSeriesButton;

    private Text question;

    public Button getBookButton() {
        return bookButton;
    }

    public Button getNewspaperButton() {
        return newspaperButton;
    }

    public Button getComicButton() {
        return comicButton;
    }

    public Button getBookSeriesButton() {
        return bookSeriesButton;
    }

    public Button getRemoveByTitleButton() {
        return removeByTitleButton;
    }

    public Button getConvertBookButton() {
        return convertBookButton;
    }

    public Button getFindByAuthorButton() {
        return findByAuthorButton;
    }

    public Text getQuestion() {
        return question;
    }

    public Button getListLiteratureButton() {
        return listLiteratureButton;
    }

    public Button getAddLiteratureButton() {
        return addLiteratureButton;
    }

    public Button getFindByTitleButton() {
        return findByTitleButton;
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

        question = new Text("What do you want to do?");

        cancelButton = new Button("Cancel");
        listLiteratureButton = new Button("List all literature");
        addLiteratureButton = new Button("Add more literature");
        findByTitleButton = new Button("Find literature by title");
        findByAuthorButton = new Button("Find book by author");
        removeByTitleButton = new Button("Remove literature by title");
        convertBookButton = new Button("Convert book to bookseries");
        newspaperButton = new Button("Newspaper");
        comicButton = new Button("Comic Book");
        bookButton = new Button("Book");
        bookSeriesButton = new Button("Bookseries");


        gridPane = new GridPane();
        gridPane.setPrefSize(500, 500);
        gridPane.setAlignment(Pos.TOP_CENTER);
        gridPane.setVgap(5);
        gridPane.setHgap(5);

        gridPane.add(listLiteratureButton, 0, 1);
        gridPane.add(addLiteratureButton, 1, 1);
        gridPane.add(findByTitleButton, 2, 1);
        gridPane.add(findByAuthorButton, 0, 2);
        gridPane.add(removeByTitleButton, 1, 2);
        gridPane.add(convertBookButton, 2, 2);
        gridPane.add(bookButton, 3, 0);
        root.setCenter(gridPane);
        root.setTop(question);
        root.setAlignment(question, Pos.TOP_CENTER);
        root.setBottom(new HBox(cancelButton));
    }
}
