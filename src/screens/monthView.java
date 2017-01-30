package screens;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import animations.animations;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import screens.database.*;
import tableview.MonthTable;

public class monthView extends BorderPane {
	
	int checker = 0;
	
	@SuppressWarnings("unchecked")
	public monthView(){
		getChildren().clear();
		GridPane mainpane = new GridPane();
		BorderPane deptpane = new BorderPane();
		MonthDept dept = new MonthDept();
		dept.setPromptText("Department");
		
		dept.setOnAction(e->{
			MonthYear year = new MonthYear( (String)dept.getSelectionModel().getSelectedItem() );
			year.setPromptText("Year");
			deptpane.setCenter(year);
			
			year.setOnAction(e1->{
				MonthDiv div = new MonthDiv( (String)dept.getSelectionModel().getSelectedItem() 
						, (String)year.getSelectionModel().getSelectedItem() );
				div.setPromptText("Division");
				deptpane.setLeft(div);
				
				div.setOnAction(e2->{
					MonthTable table = new MonthTable( (String)dept.getSelectionModel().getSelectedItem() 
							, (String)year.getSelectionModel().getSelectedItem()
							, (String)div.getSelectionModel().getSelectedItem());
					mainpane.add(table, 0, 0);
				});
			});
			
		});
		
		
		mainpane.setAlignment(Pos.CENTER);
		deptpane.setRight(dept);
		setTop(deptpane);
		setCenter(mainpane);
		setStyle("-fx-background-color:#ecf0f1;"
				+ "-fx-padding:20;");
	}

}
