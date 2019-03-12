import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The type Main.
 */
public class main extends Application {

    @Override
    public void start(Stage primaryStage){
        GUIApp gui = new GUIApp(primaryStage);
        AppController controller = new AppController(primaryStage, gui);

        Scene scene = new Scene(gui.getRoot());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Kiosk");
        primaryStage.show();
    }
}