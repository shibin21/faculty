package load;

import java.awt.Cursor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.layout.HBox;
import javafx.scene.input.KeyCombination;

import org.controlsfx.control.textfield.TextFields;

public class Periods extends HBox{

    ObservableList<String> data = FXCollections.observableArrayList();
	ObservableList<String> entries = FXCollections.observableArrayList();
	
	public void period() {
		try {
			int i=0;
			setSpacing(2);
			Class.forName("org.sqlite.JDBC");
			Connection connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from teacherslist ORDER BY LOWER(name)");
			while(rs.next()) {
//				System.out.println(rs.getString("id")+" "+rs.getString("name"));
				data.add(rs.getString("name"));
				i++;
			}
			i=0;
			while(i<6){
				final int is=i;
				getChildren().add(new TextField());
				((TextField)getChildren().get(i)).setPromptText("period"+(i+1));
				TextFields.bindAutoCompletion(((TextField)getChildren().get(i)),data);
				((TextField)getChildren().get(i)).setOnKeyPressed(e->{
					if(e.getCode()==KeyCode.ENTER) {
						if(is!=5) {
							((TextField)getChildren().get((is+1))).requestFocus();
						}
					}
				});
				i++;
			}
//			((TextField)getChildren().get(0)).setacc
			
		}catch(Exception e) {System.out.println(e);}
    }
	
}