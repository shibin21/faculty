package screens.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.ClassDatabase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.*;

public class LoadDiv{
	String[] str = null,splityear = null;
	ObservableList<String> divisions = FXCollections.observableArrayList();
	ListView<String> list = new ListView<String>();
	ClassDatabase cdatabase = new ClassDatabase();
	public GridPane loadDiv() {
		GridPane maingrid = new GridPane();
		maingrid.getChildren().clear();
		maingrid.setVgap(2);
		divisions.clear();
		Button add = new Button("add");
		try {
			Class.forName("org.sqlite.JDBC");
			Connection connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from class where dept = '"+str[1]+"' AND year = "+Integer.parseInt(splityear[0]));
			int i=0;
			while(rs.next()) {
				divisions.add(rs.getString("div"));
			}
			list.setItems(divisions);
			maingrid.add(list, 0, 0);
			maingrid.add(add, 0, 1);
			add.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent arg0) {
					try {
						try {
							cdatabase.update(str[1],Integer.parseInt(splityear[0]));
						} catch (Exception e) {
							System.out.println(e);
						}
						maingrid.getChildren().clear();
						ResultSet rs = statement.executeQuery("select * from class where dept = '"+str[1]+"' AND year = "+Integer.parseInt(splityear[0]));                   
						int i=0;
						divisions.clear();
						while(rs.next()) {
							divisions.add(rs.getString("div"));
						}
						list.setItems(divisions);
						maingrid.add(list, 0, 0);
						maingrid.add(add, 0, 1);
					} catch (SQLException e) {
						System.out.println(e);
					}
				}
			});
			
		
		maingrid.setAlignment(Pos.TOP_CENTER);
		}catch(Exception e) {System.out.println(e);}
		return(maingrid);
	}
	
	public void getNode(Object object) {
		str = object.toString().split("'");
	}
	public void getYear(String year) {
		splityear = year.split(" ");
	}
	public ListView takelist() {
		// TODO Auto-generated method stub
		return list;
	}
}