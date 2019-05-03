import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.control.Button;

/**
 * The type Gui app.
 */
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
    private Button findByPublisherButton;

    private Button bookButton;
    private Button newspaperButton;
    private Button comicButton;
    private Button bookSeriesButton;

    private Button addDummiesButton;

    private Label question;

    /**
     * Get hbox.
     *
     * @return the hBox
     */
    public HBox gethBox(){
        return hBox;
    }

    /**
     * Get add dummies button button.
     *
     * @return the button
     */
    public Button getAddDummiesButton(){
        return addDummiesButton;
    }

    /**
     * Get find by publisher button button.
     *
     * @return the button
     */
    public Button getFindByPublisherButton(){
        return findByPublisherButton;
    }

    /**
     * Gets scroll pane.
     *
     * @return the scroll pane
     */
    public ScrollPane getScrollPane() {
        return scrollPane;
    }

    /**
     * Gets return button.
     *
     * @return the return button
     */
    public Button getReturnButton() {
        return returnButton;
    }

    /**
     * Gets book button.
     *
     * @return the book button
     */
    public Button getBookButton() {
        return bookButton;
    }

    /**
     * Gets newspaper button.
     *
     * @return the newspaper button
     */
    public Button getNewspaperButton() {
        return newspaperButton;
    }

    /**
     * Gets comic button.
     *
     * @return the comic button
     */
    public Button getComicButton() {
        return comicButton;
    }

    /**
     * Gets book series button.
     *
     * @return the book series button
     */
    public Button getBookSeriesButton() {
        return bookSeriesButton;
    }

    /**
     * Gets remove by title button.
     *
     * @return the remove by title button
     */
    public Button getRemoveByTitleButton() {
        return removeByTitleButton;
    }

    /**
     * Gets convert book button.
     *
     * @return the convert book button
     */
    public Button getConvertBookButton() {
        return convertBookButton;
    }

    /**
     * Gets find by author button.
     *
     * @return the find by author button
     */
    public Button getFindByAuthorButton() {
        return findByAuthorButton;
    }

    /**
     * Gets question.
     *
     * @return the question
     */
    public Label getQuestion() {
        return question;
    }

    /**
     * Gets list literature button.
     *
     * @return the list literature button
     */
    public Button getListLiteratureButton() {
        return listLiteratureButton;
    }

    /**
     * Gets add literature button.
     *
     * @return the add literature button
     */
    public Button getAddLiteratureButton() {
        return addLiteratureButton;
    }

    /**
     * Gets find by title button.
     *
     * @return the find by title button
     */
    public Button getFindByTitleButton() {
        return findByTitleButton;
    }

    /**
     * Gets cancel button.
     *
     * @return the cancel button
     */
    public Button getCancelButton() {
        return cancelButton;
    }

    /**
     * Gets root.
     *
     * @return the root
     */
    public BorderPane getRoot() {
        return root;
    }

    /**
     * Gets grid pane.
     *
     * @return the grid pane
     */
    public GridPane getGridPane() {
        return gridPane;
    }


    /**
     * Instantiates a new Gui app.
     */
    public GUIApp() {
        root = new BorderPane();

        setupGUI();
    }

    /**
     * Sets up the initial look of the GUI
     */
    private void setupGUI() {
        question = new Label("What do you want to do?");
        question.setId("TopText");

        cancelButton = new Button("Cancel");
        returnButton = new Button("Return");

        listLiteratureButton = new Button("List all literature");
        addLiteratureButton = new Button("Add more literature");
        findByTitleButton = new Button("Find literature by title");
        findByAuthorButton = new Button("Find book by author");
        removeByTitleButton = new Button("Remove literature by title");
        convertBookButton = new Button("Convert book to bookseries");
        findByPublisherButton = new Button("Find literature by publisher");
        addDummiesButton = new Button("Add dummies");

        newspaperButton = new Button("Newspaper");
        comicButton = new Button("Comic Book");
        bookButton = new Button("Book");
        bookSeriesButton = new Button("Bookseries");

        gridPane = new GridPane();
        gridPane.setPrefSize(970, 450);
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
        gridPane.add(findByPublisherButton, 1, 3);
        gridPane.add(addDummiesButton, 1, 4);

        GridPane.setHalignment(listLiteratureButton, HPos.CENTER);
        GridPane.setHalignment(addLiteratureButton, HPos.CENTER);
        GridPane.setHalignment(findByTitleButton, HPos.CENTER);
        GridPane.setHalignment(findByAuthorButton, HPos.CENTER);
        GridPane.setHalignment(removeByTitleButton, HPos.CENTER);
        GridPane.setHalignment(convertBookButton, HPos.CENTER);
        GridPane.setHalignment(findByPublisherButton, HPos.CENTER);
        GridPane.setHalignment(addDummiesButton, HPos.CENTER);

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