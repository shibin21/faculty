package screens;

import functions.*;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

import animations.animations;

public class entryViewDept extends BorderPane{
	public entryViewDept(){
		getChildren().clear();
		getStylesheets().add("css/dept.css");
		addCloseButton cb = new addCloseButton();
		Label title = new Label("Departments");
		GridPane deptgrid = new GridPane();
		VBox lbox = new VBox();
		VBox rbox = new VBox();
		final ScrollPane hscrollpane = new ScrollPane();
		final Label emptylabel = new Label();
		animations animation = new animations();

		hscrollpane.setHbarPolicy(ScrollBarPolicy.ALWAYS);
		
		String str="";
		int i =0,j=1,count=0,items=0,mchecker=0;
		
		title.setId("title");
		deptgrid.setId("grid");
		hscrollpane.setId("scroll");
		lbox.setId("lbox");
		rbox.setId("rbox");
		emptylabel.setId("empty-button");
		
		emptylabel.setMaxWidth(40);
		emptylabel.setMinWidth(40);
		
		try {
			Class.forName("org.sqlite.JDBC");
			Connection connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from class");
			deptgrid.add(emptylabel, 0, 0);
			
			///////////////////////////////////////////////////////////////////////
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
					if(i==4) {
						i=0;j++;
					}
					deptgrid.add(new Button(rs.getString("dept")),j,i);
//					str=rs.getString("dept");
					i++;
					count++;
				}
				mchecker=0;
			}
		
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		animation.fadeIn(deptgrid, 1500, 0, 1, 0);
		
		for(i=1;i<=count;i++) {
			setBtnColor(deptgrid.getChildren().get(i));
		}
		
		for(i=1;i<=count;i++) {
			deptgrid.getChildren().get(i).setOnMouseClicked(new EventHandler<Event>() {
				public void handle(Event e) {
					getChildren().clear();
					entryView eview = new entryView(e.getSource());
					setCenter(eview);
				}

			});
		}
		
		rbox.setOnMouseMoved(new EventHandler<Event>() {
			public void handle(Event arg0) {
				hscrollpane.setHvalue(hscrollpane.getHvalue()+0.03);
			}
		});
		lbox.setOnMouseMoved(new EventHandler<Event>() {
			public void handle(Event arg0) {
				hscrollpane.setHvalue(hscrollpane.getHvalue()-0.03);
			}
		});
		
		hscrollpane.prefWidthProperty().bind(deptgrid.widthProperty());
		hscrollpane.prefHeightProperty().bind(deptgrid.heightProperty());
		hscrollpane.setContent(deptgrid);
		hscrollpane.setCenterShape(true);
		deptgrid.setAlignment(Pos.CENTER);
		deptgrid.setVgap(8);
		deptgrid.setHgap(8);
		cb.addxb(0);
		cb.setCenter(title);
		setTop(cb);
		setCenter(hscrollpane);
		setLeft(lbox);
		setRight(rbox);
	}
	
	public void setBtnColor(Node btn) {
		Random rand = new Random(System.currentTimeMillis());
		String[] colors = new String[] {
				"#cc3333",
				"#336699",
				"#3399ff",
				"#009999",
				"#663366",
				"#cc6633",
				"#336699",
				"#009900",
				"#6633cc",
		};
		for (int i = 0; i < 10000; i++) {
		 int index = rand.nextInt(9);
		 btn.setStyle("-fx-background-color:"+colors[index]);
//		 System.out.println("red "+red+" green "+green+" blue "+blue);
		}
	}
	
	
}