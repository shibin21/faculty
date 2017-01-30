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

public class IndTable extends TableView{
	
	final ObservableList<IndContents> data = FXCollections.observableArrayList();
	
	public IndTable(String name) {

		insertData(name);
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
                new PropertyValueFactory<IndContents, String>("Date"));
        
        prd1.setMinWidth(100);
        prd1.setCellValueFactory(
        		new PropertyValueFactory<IndContents, String>("Prd1"));
        
        prd2.setMinWidth(100);
        prd2.setCellValueFactory(
        		new PropertyValueFactory<IndContents, String>("Prd2"));
        
        prd3.setMinWidth(100);
        prd3.setCellValueFactory(
        		new PropertyValueFactory<IndContents, String>("Prd3"));
        
        prd4.setMinWidth(100);
        prd4.setCellValueFactory(
        		new PropertyValueFactory<IndContents, String>("Prd4"));
        
        prd5.setMinWidth(100);
        prd5.setCellValueFactory(
        		new PropertyValueFactory<IndContents, String>("Prd5"));
        
        prd6.setMinWidth(100);
        prd6.setCellValueFactory(
        		new PropertyValueFactory<IndContents, String>("Prd6"));
		
        setItems(data);
		getColumns().addAll(date,prd1,prd2,prd3,prd4,prd5,prd6);
	}
	public void insertData(String name) {
		try {
			data.clear();
			Class.forName("org.sqlite.JDBC");
			Connection connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
			Statement statement = connection.createStatement();
			ResultSet rs;
//			for(int i=0;i<30;i++) {
//				rs = statement.executeQuery("select * from Month where dept = '"+dept+"' and div = '"+div+"' and year = '"+year+"' and date = '2015/09/"+i+"' ");
				
				int j=0;
				rs = statement.executeQuery("select * from "+name);
				while(rs.next()){
					System.out.println(rs.getString("date")+" "+rs.getString("dept")+""
							+ " "+rs.getString("year")+" "+rs.getString("div")+""
									+ " "+rs.getString("period"));
					j++;
				}
				System.out.println(" ");
				String sam;
				int i=0,k=0;
				String[] dept = new String[6];
				String[] div = new String[6];
				String[] year = new String[6];
				int[] period = new int[6];
				rs = statement.executeQuery("select * from "+name );
				while(rs.next()){
					i=0;
					sam = rs.getString("date");
//					System.out.println(rs.getString("date"));
					while(rs.getString("date").equals(sam)) {
						dept[i] = ((String)rs.getString("dept"));
						
						System.out.println(i);
						
						div[i] = ((String)rs.getString("div")); 
						year[i] = ((String)rs.getString("year")); 
						period[i] = Integer.parseInt(rs.getString("period"));

						i++;

						k++;
						if(k<j) {
//							System.out.println(" j "+j+""+k);
							rs.next();
						}
						else break;
					}
					k++;
//					System.out.println(period[1]);
//					for(int temp=0;temp<i;temp++) {
						data.add(new IndContents(sam, period[0]+"_"+dept[0]+"_"+div[0]+"_"+year[0] , period[1]+"_"+period[0]+"_"+dept[1]+"_"+div[1]+"_"+year[1] , 
								period[2]+"_"+dept[2]+"_"+div[2]+"_"+year[2] , period[3]+"_"+dept[3]+"_"+div[3]+"_"+year[3] , period[4]+"_"+dept[4]+"_"+div[4]+"_"+year[4]
										, period[4]+"_"+dept[5]+"_"+div[5]+"_"+year[5]));
//					}
					i=0;
				}
				
				
//				while(rs.next()) {
//					data.add(new Person( (String)rs.getString("date") , rs.getString("prd1") , rs.getString("prd2") , rs.getString("prd3") , rs.getString("prd4") , rs.getString("prd5") , rs.getString("prd6") ));
//				}
//			}
		}catch(Exception e) {System.out.println(e);}
	}
	
}