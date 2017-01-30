package tableview;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MonthTable extends TableView{
	
	final ObservableList<Person> data = FXCollections.observableArrayList();
	
	public MonthTable(String dept, String year, String div) {

		if(year.equals("1"))year=year+" st year";
		else if(year.equals("2"))year = year+" nd year";
		else if(year.equals("3"))year = year+" rd year";
		else year = year+" th year";
		
		insertData(dept,year,div);
		setEditable(true);
		
		TableColumn date = new TableColumn("Date");
		TableColumn prd1 = new TableColumn("Period1");
		TableColumn prd2 = new TableColumn("Period2");
		TableColumn prd3 = new TableColumn("Period3");
		TableColumn prd4 = new TableColumn("Period4");
		TableColumn prd5 = new TableColumn("Period5");
		TableColumn prd6 = new TableColumn("Period6");
		
		date.setMinWidth(100);
        date.setCellValueFactory(
                new PropertyValueFactory<Person, String>("Date"));
        
        prd1.setMinWidth(100);
        prd1.setCellValueFactory(
        		new PropertyValueFactory<Person, String>("Prd1"));
        
        prd2.setMinWidth(100);
        prd2.setCellValueFactory(
        		new PropertyValueFactory<Person, String>("Prd2"));
        
        prd3.setMinWidth(100);
        prd3.setCellValueFactory(
        		new PropertyValueFactory<Person, String>("Prd3"));
        
        prd4.setMinWidth(100);
        prd4.setCellValueFactory(
        		new PropertyValueFactory<Person, String>("Prd4"));
        
        prd5.setMinWidth(100);
        prd5.setCellValueFactory(
        		new PropertyValueFactory<Person, String>("Prd5"));
        
        prd6.setMinWidth(100);
        prd6.setCellValueFactory(
        		new PropertyValueFactory<Person, String>("Prd6"));
		
        setItems(data);
		getColumns().addAll(date,prd1,prd2,prd3,prd4,prd5,prd6);
	}
	public void insertData(String dept, String year , String div) {
		try {
			data.clear();
			Class.forName("org.sqlite.JDBC");
			Connection connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
			Statement statement = connection.createStatement();
			ResultSet rs;
			for(int i=0;i<30;i++) {
				rs = statement.executeQuery("select * from Month where dept = '"+dept+"' and div = '"+div+"' and year = '"+year+"' and date = '2015/09/"+i+"' ");
				
				while(rs.next()) {
					data.add(new Person( (String)rs.getString("date") , rs.getString("prd1") , rs.getString("prd2") , rs.getString("prd3") , rs.getString("prd4") , rs.getString("prd5") , rs.getString("prd6") ));
				}
			}
		}catch(Exception e) {System.out.println(e);}
	}
}