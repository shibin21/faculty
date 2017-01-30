package functions;

import java.sql.SQLException;

import database.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class Controller extends BorderPane{
	addCloseButton cb = new addCloseButton();
	TeacherDatabase tdatabase = new TeacherDatabase();
	public Controller(int type) {
		if(type==0) {
			dept();
		}
		if(type==1) {
			teacher();
		}
	}
	public void dept() {
		getChildren().clear();
		GridPane centerpane = new GridPane();
		TextField dept = new TextField();
		Button add = new Button("Add");
		
		centerpane.setId("centerpane");
		add.setId("add");
		
		dept.setPromptText("Enter New Department");
		add.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				if(!dept.getText().equals("")) {
					ClassDatabase cdatabase = new ClassDatabase();
					cdatabase.insertDatabase(dept.getText());
					dept.setText("");
				}
			}
		});
		
		centerpane.add(dept, 0, 0);
		centerpane.add(add, 1, 0);
		centerpane.setAlignment(Pos.CENTER);
		centerpane.setHgap(3);
		setCenter(centerpane);
		cb.addxb(2);
		setTop(cb);
		getStylesheets().add("css/settings.css");
	}
	public void teacher() {
		getChildren().clear();
		GridPane centerpane = new GridPane();
		TextField teacher = new TextField();
		Button add = new Button("Add");
		
		centerpane.setId("centerpane");
		add.setId("add");
		
		teacher.setPromptText("Enter New Teacher");
		add.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				if(!teacher.getText().equals("")) {
					TeacherDatabase tdatabase = new TeacherDatabase();
					try {
						tdatabase.insertDatabase(teacher.getText());
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					teacher.setText("");
				}
			}
		});
		
		centerpane.add(teacher, 0, 0);
		centerpane.add(add, 1, 0);
		centerpane.setAlignment(Pos.CENTER);
		centerpane.setHgap(3);
		setCenter(centerpane);
		cb.addxb(2);
		setTop(cb);
		getStylesheets().add("css/settings.css");
	}
}