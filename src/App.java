import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        VBox root = new VBox();
        root.setSpacing(5);

        Label title = new Label("Todo App");
        TextField usserEingabe = new TextField();
        Button addTask = new Button("Add");
        addTask.setId("addTask");
        usserEingabe.setPromptText("Add a task...");

        ListView<TodoItem> taskListe = new ListView<>();
        taskListe.setId("taskListe");
        taskListe.setItems(javafx.collections.FXCollections.observableArrayList());
        root.getChildren().addAll(title, usserEingabe, addTask, taskListe);

        addTask.setOnAction(e -> {
            String text = usserEingabe.getText();

            if (!text.isEmpty()) {
                taskListe.getItems().add(new TodoItem(text, taskListe.getItems()));
                usserEingabe.clear();
            }
        });

        Scene scene = new Scene(root, 500, 600);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setTitle("TODO App");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }
}