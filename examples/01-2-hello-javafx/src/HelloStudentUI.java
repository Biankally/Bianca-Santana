import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloStudentUI extends Application {

    @Override
    public void start(Stage stage) {
        System.out.println("Starting JavaFX application...");
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        Label l = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        Scene scene = new Scene(new StackPane(l), 640, 480);
        stage.setScene(scene);
        stage.show();
        System.out.println("JavaFX application started.");
    }

    public static void main(String[] args) {
        System.out.println("Launching JavaFX application...");
        launch();
        System.out.println("JavaFX application terminated.");
    }

}