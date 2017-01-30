package screens;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import tableview.IndTable;

public class Individual extends BorderPane{
	ObservableList<String> data = FXCollections.observableArrayList();
	public Individual() {
		try {
			getChildren().clear();
			data.clear();
			
			Class.forName("org.sqlite.JDBC");
			Connection connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from teacherslist ORDER BY LOWER(name)");
			while(rs.next()) {
				data.add(rs.getString("name"));
			}
			
			BorderPane toppane = new BorderPane();
			ComboBox tbox = new ComboBox();
			
			tbox.setItems(data);
			tbox.setPromptText("Select Teacher");
			
			tbox.setOnAction(e->{
				IndTable it = new IndTable((String)tbox.getSelectionModel().getSelectedItem());
				setCenter(it);
			});
			
			toppane.setRight(tbox);
			setTop(toppane);
		}catch(Exception e) {System.out.println(e);}
	}
}