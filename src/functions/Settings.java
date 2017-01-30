package functions;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class Settings extends BorderPane{
	public Settings() {
		getChildren().clear();
		GridPane centerpane = new GridPane();
		Button dept = new Button("Add Dept"); 
		Button teacher = new Button("Add Teacher");
		
		dept.setId("button");
		teacher.setId("button");
		centerpane.setId("centerpane");
		
		dept.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				Controller controller = new Controller(0);
				getChildren().clear();
				setCenter(controller);
			}
		});
		teacher.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				Controller controller = new Controller(1);
				getChildren().clear();
				setCenter(controller);
			}
		});
		
		centerpane.add(dept, 0, 0);
		centerpane.add(teacher, 1, 0);
		centerpane.setAlignment(Pos.CENTER);
		centerpane.setHgap(10);
		setCenter(centerpane);
		addCloseButton cb = new addCloseButton();
		cb.addxb(0);
		setTop(cb);
		getStylesheets().add("css/settings.css");
	}
}