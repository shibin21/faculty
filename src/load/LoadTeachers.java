package load;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.function.Consumer;

import database.TeacherDatabase;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

public class LoadTeachers extends GridPane{

	ObservableList<String> entries = FXCollections.observableArrayList();
	ListView<String> list = new ListView<String>();
	
	public LoadTeachers(){
		TeacherDatabase t = new TeacherDatabase();
		TextField search = new TextField();
		
		search.setId("search");

		list.setPrefWidth(200);
		list.setPrefHeight(580);
		try {
			t.create();
		
		
			Class.forName("org.sqlite.JDBC");
			Connection connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from teacherslist");
			int i=0;
			
			while(rs.next()) {
				entries.add(rs.getString("name"));
				i++;
			}
			list.setItems(entries);
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		try {
//			for(String part : entries) {
				
			list.setOnDragDetected(e -> {
				ClipboardContent content = new ClipboardContent();
				Dragboard db = list.startDragAndDrop(TransferMode.COPY);
//    			db.setDragView(new Text(((Label)node).getText()).snapshot(null, null), e.getX(), e.getY());
    			content.putString(list.getSelectionModel().getSelectedItem());
    			db.setContent(content);
			});
			
//			}
		}catch(Exception e) {System.out.println(e);}

		search.setPromptText("search");
		search.textProperty().addListener(new ChangeListener<Object>() {
			public void changed(ObservableValue<? extends Object> observable, Object oldValue, Object newValue) {
				search( (String)oldValue, (String)newValue );
			}
		});
		add(search, 0, 0);
		add(list, 0, 1);
		setId("grid");
	}
	public void search(String oldVal, String newVal) {
		if ( oldVal != null && (newVal.length() < oldVal.length()) ) {
			list.setItems(entries);
		}
		String[] parts = newVal.toUpperCase().split(" ");
		ObservableList<String> subentries = FXCollections.observableArrayList();
		for(Object entry : list.getItems()) {
			boolean match = true;
			String entryset = (String)entry;
			for(String part : parts) {
				if (! entryset.toUpperCase().contains(part)) {
					match=false;
					break;
					
				}
			}
			if (match) {
				subentries.add(entryset);
			}
		}
		list.setItems(subentries);
	}
}