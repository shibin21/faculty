package screens.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class MonthDiv extends ComboBox{
	ObservableList list = FXCollections.observableArrayList();
	public MonthDiv(String dept, String year) {
		getChildren().clear();
		list.clear();
		try {
			int i =0,j=1,items=0,mchecker=0;
			Class.forName("org.sqlite.JDBC");
			Connection connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from class where dept = '"+dept+"' and year = '"+year+"'");
			while(rs.next()) {
				list.add(rs.getString("div"));
			}
			setItems(list);
		}catch(Exception e) {System.out.println(e);}
	}
}