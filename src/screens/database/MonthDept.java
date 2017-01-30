package screens.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class MonthDept extends ComboBox{
	ObservableList list = FXCollections.observableArrayList();
	public MonthDept() {
		try {
			int i =0,j=1,items=0,mchecker=0;
			Class.forName("org.sqlite.JDBC");
			Connection connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from class");
			
			while(rs.next()) {
				items++;
			}
			
			
			rs = statement.executeQuery("select * from class");
			String[] istring = new String[items];
			istring[0]="a";
			items=0;
			while(rs.next()) {
				for(int ch=0;ch<items;ch++) {
					if(istring[ch].equals(rs.getString("dept"))) {
						mchecker=1;
					}
				}
				if(mchecker==0) {
					istring[items]=rs.getString("dept");
					items++;
					list.add(rs.getString("dept"));
				}
				mchecker=0;
			}
			
			setItems(list);
			
		}catch(Exception e) {System.out.println(e);}
	}
}