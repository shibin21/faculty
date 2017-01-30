package screens.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.collections.*;
import javafx.scene.control.*;

public class LoadYear extends ComboBox{
	LoadDiv div;
	public LoadYear(Object object) {
		div = (LoadDiv) object;
	}
	String[] str = null;
	int i =0,j=1,count=0,items=0,mchecker=0;
	ObservableList<String> year = FXCollections.observableArrayList();
	public void loadYear() {
		try {
			
			Class.forName("org.sqlite.JDBC");
			Connection connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from class where dept = '"+str[1]+"'");

			while(rs.next()) {
				items++;
			}
			rs = statement.executeQuery("select * from class where dept = '"+str[1]+"'");
			String[] istring = new String[items];
			istring[0]="a";
			items=0;
			while(rs.next()) {
				for(int ch=0;ch<items;ch++) {
					if(istring[ch].equals(rs.getString("year"))) {
						mchecker=1;
					}
				}
				if(mchecker==0) {
					istring[items]=rs.getString("year");
					items++;
					String years;
					if(rs.getString("year").equals("1"))years=rs.getString("year")+" st year";
					else if(rs.getString("year").equals("2"))years=rs.getString("year")+" nd year";
					else if(rs.getString("year").equals("3"))years=rs.getString("year")+" rd year";
					else years=rs.getString("year")+" rd year";
					year.add(years);
				}
				mchecker=0;
			}
			
			setItems(year);
			getSelectionModel().select(0);
//			div.getYear((String)getSelectionModel().getSelectedItem());
//			setOnAction(e->{
//				div.getYear((String)getSelectionModel().getSelectedItem());
//			});
		}catch(Exception e) {System.out.println(e);}
	}
	public void getNode(Object object) {
		str = object.toString().split("'");
	}
}