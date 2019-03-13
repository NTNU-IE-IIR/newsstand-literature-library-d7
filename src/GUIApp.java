import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.control.Button;

public class GUIApp {
    private BorderPane root;

    private GridPane gridPane;
    private ScrollPane scrollPane;

    private HBox hBox;

    private Button cancelButton;
    private Button returnButton;

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

    public HBox gethBox(){
        return hBox;
    }

    public ScrollPane getScrollPane() {
        return scrollPane;
    }

    public Button getReturnButton() {
        return returnButton;
    }

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


    public GUIApp() {
        root = new BorderPane();

        setupGUI();
    }

    private void setupGUI() {
        question = new Text("What do you want to do?");

        cancelButton = new Button("Cancel");
        returnButton = new Button("Return");

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
        gridPane.setPrefSize(600, 600);
        gridPane.setAlignment(Pos.TOP_CENTER);
        gridPane.setVgap(10);
        gridPane.setHgap(20);
        gridPane.setPadding(new Insets(20));


        gridPane.add(listLiteratureButton, 0, 1);
        gridPane.add(addLiteratureButton, 1, 1);
        gridPane.add(findByTitleButton, 2, 1);
        gridPane.add(findByAuthorButton, 0, 2);
        gridPane.add(removeByTitleButton, 1, 2);
        gridPane.add(convertBookButton, 2, 2);

        GridPane.setHalignment(listLiteratureButton, HPos.CENTER);
        GridPane.setHalignment(addLiteratureButton, HPos.CENTER);
        GridPane.setHalignment(findByTitleButton, HPos.CENTER);
        GridPane.setHalignment(findByAuthorButton, HPos.CENTER);
        GridPane.setHalignment(removeByTitleButton, HPos.CENTER);
        GridPane.setHalignment(convertBookButton, HPos.CENTER);

        question.setFont(Font.font("Arial", FontWeight.BOLD, 15));

        scrollPane = new ScrollPane();
        scrollPane.setContent(gridPane);

        hBox = new HBox(cancelButton, returnButton);


        root.setCenter(scrollPane);
        root.setTop(question);

        root.setBottom(hBox);
        BorderPane.setMargin(question, new Insets(20, 0, 0, 0));
        BorderPane.setAlignment(question, Pos.TOP_CENTER);
        BorderPane.setAlignment(hBox, Pos.BOTTOM_LEFT);
    }
}