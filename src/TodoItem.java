import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;

public class TodoItem extends HBox {

    private ObservableList<TodoItem> items;

    public TodoItem(String taskText, ObservableList<TodoItem> items) {
        this.items = items;
        this.setSpacing(50);
        CheckBox checkBox = new CheckBox(taskText);
        Button delete = new Button("Delete");
        delete.setId("delete");
        getChildren().addAll(checkBox, delete);

        delete.setOnAction(e -> {
            items.remove(this);
        });
    }
}