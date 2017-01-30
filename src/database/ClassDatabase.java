package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClassDatabase{
	public void createDatabase() {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);
			statement.executeUpdate("drop table if exists class");
			  statement.executeUpdate("create table if not exists class (id integer auto increment, dept string, div string, year int)");
			  statement.executeUpdate("insert into class values(1,'BCA','A',1)");
			  statement.executeUpdate("insert into class values(2,'BCA','B',1)");
			  statement.executeUpdate("insert into class values(3,'BCA','A',2)");
			  statement.executeUpdate("insert into class values(4,'BCom','A',2)");
			  
			  
			  statement.executeUpdate("create table if not exists Month (ID INTEGER PRIMARY KEY   AUTOINCREMENT,date DATE,"
						+ "dept String,div String,year String, prd1 String, prd2 String, prd3 String, prd4 String, prd5 String, prd6 String)");
			  
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	public void insertDatabase(String dept) {
		try {
			int i=1;
			Class.forName("org.sqlite.JDBC");
			Connection connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);
			ResultSet rs = statement.executeQuery("select * from class");
			while(rs.next()) {
				i++;
			}
			statement.executeUpdate("insert into class values("+i+",'"+dept+"','A')");
			  
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	public void update(String str,int year) throws SQLException, ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");
		Connection connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery("select * from class where dept = '"+str+"' AND year = "+year);
		String lastdiv = "A";
		char[] newdiv;
		int i=1;
		while(rs.next()) {
			lastdiv = rs.getString("div");
			i++;
		}
		newdiv = lastdiv.toCharArray();
		for(char alphabet = newdiv[0]; alphabet <= 'Z';alphabet++) {
			alphabet++;
			if(alphabet=='[')break;
			statement.executeUpdate("insert into class values("+i+",'"+str+"','"+alphabet+"',"+year+")");
			break;
		}
	}
}