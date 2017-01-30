package database;

import java.io.Console;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.scene.control.*;
import javafx.scene.control.Alert.*;

public class UpdateData{
	boolean insert = false;
	public UpdateData(String[] datas) {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
			Statement statement = connection.createStatement();
			datas[9] = datas[9].replace('-', '/');
			ResultSet rs = statement.executeQuery("select * from Month");
			
			
			while(rs.next()) {
				if(rs.getString("date").equals(datas[9]) && rs.getString("dept").equals(datas[0]) && rs.getString("div").equals(datas[1]) && rs.getString("year").equals(datas[2])) {
					insert = true;
				}
			}
			
			if(!insert) {
				
				statement.execute("insert into Month (date,dept,div,year,prd1,prd2,prd3,prd4,prd5,prd6) values"
						+ "('"+datas[9]+"', '"+datas[0]+"', '"+datas[1]+"', '"+datas[2]+"' , '"+datas[3]+"' ,"
								+ " '"+datas[4]+"' , '"+datas[5]+"' , '"+datas[6]+"' , '"+datas[7]+"' ,"
										+ " '"+datas[8]+"')");
				
				int i=3;
				while(i<9) {
					if(!datas[i].equals("null")) {
						statement.executeUpdate("create table if not exists "+datas[i]+"(ID INTEGER PRIMARY KEY   AUTOINCREMENT,date Date,period int,dept String,div String,year String)");
						statement.execute("insert into "+datas[i]+" (date,period,dept,div,year) values ('"+datas[9]+"',"+(i-2)+",'"+datas[0]+"','"+datas[1]+"','"+datas[2]+"')");
					}
					i++;
				}
				
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information Dialog");
				alert.setHeaderText(null);
				alert.setContentText(datas[2]+"-"+datas[0]+"-"+datas[1]+" inserted");
				alert.showAndWait();
				
				rs = statement.executeQuery("select * from "+datas[4]);
				while(rs.next()){
					System.out.println(rs.getString("date")+" "+rs.getString("dept")+""
							+ " "+rs.getString("year")+" "+rs.getString("div")+""
									+ " "+rs.getString("period"));
				}
				System.out.println(" ");
				String sam;
				rs = statement.executeQuery("select * from jafer");
				while(rs.next()){
					sam = rs.getString("date");
					System.out.println(rs.getString("date"));
					while(rs.getString("date").equals(sam)) {
						System.out.println(rs.getString("dept")+", "+rs.getString("div")+", "+rs.getString("year")+", "+rs.getString("period"));
						rs.next();
					}
//					System.out.println(rs.getString("date")+" "+rs.getString("dept")+""
//							+ " "+rs.getString("year")+" "+rs.getString("div")+""
//									+ " "+rs.getString("period"));
				}
			}
			else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText(null);
				alert.setContentText(datas[0]+"-"+datas[1]+" is already inserted");
				alert.showAndWait();
			}
			
		}catch(Exception e) {System.out.println(e);}
	}
}