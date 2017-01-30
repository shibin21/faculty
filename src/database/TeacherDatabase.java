package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TeacherDatabase{
	public void create() throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");
		Connection connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		
		statement.executeUpdate("drop table if exists teacherslist");
		statement.executeUpdate("create table if not exists teacherslist (ID INTEGER PRIMARY KEY   AUTOINCREMENT,name text unique)");
//		statement.executeUpdate("insert or replace into teacherslist (name) values('"+name+"')");
		statement.executeUpdate("insert or replace into teacherslist (name) values('Jafer')");
		statement.executeUpdate("insert or replace into teacherslist (name) values('Prajeesh')");
		statement.executeUpdate("insert or replace into teacherslist (name) values('Neethi')");
		statement.executeUpdate("insert or replace into teacherslist (name) values('Doona')");
		statement.executeUpdate("insert or replace into teacherslist (name) values('Rajan')");
		statement.executeUpdate("insert or replace into teacherslist (name) values('Sharmi')");
		statement.executeUpdate("insert or replace into teacherslist (name) values('Drishya')");
		statement.executeUpdate("insert or replace into teacherslist (name) values('Subisha')");
		statement.executeUpdate("insert or replace into teacherslist (name) values('null')");
		
//		statement.executeQuery("drop table if exists "+name);
//		statement.executeUpdate("create table if not exists "+name+" (id integer,date Date,period string, dept string, div string)");
	}
	public void insertDatabase(String name) throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");
		Connection connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
		Statement statement = connection.createStatement();
		statement.executeUpdate("insert or replace into teacherslist (name) values('"+name+"')");
	}
}