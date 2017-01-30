package screens;

import animations.animations;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.TextAlignment;
	
public class weekView extends BorderPane {
	
		
	
	public weekView() {
		
		getChildren().clear();
		getStylesheets().add("css/week.css");
		
		final animations wanimations= new animations();
		BorderPane mainpane = new BorderPane();
		BorderPane combopane = new BorderPane();
		BorderPane weekscrollpane = new BorderPane();
		final GridPane weekgrid = new GridPane();
		final GridPane prdgrid = new GridPane();
		ComboBox<String> deptcombo = new ComboBox<String>();
		
		
		HBox combohbox = new HBox();
		Label prolabel = new Label();
		
//		int p=0;
//		if(p==0) {
//		Image image = new Image(getClass().getResourceAsStream("../img/progress.GIF"));
//	    prolabel.setGraphic(new ImageView(image));
//	    p=1;
//		}
		
		Button prevweek = new Button("<");
		Button nextweek = new Button(">");
		
		
		prolabel.setId("prolabel");
		weekscrollpane.setId("grid-hbox");
		combohbox.setId("combo-hbox");
		deptcombo.setId("combo-box");
		combopane.setId("wvcombopane");
		weekgrid.setId("weekgrid");
		prdgrid.setId("prdgrid");
		prevweek.setId("prevweek");
		nextweek.setId("nextweek");
		mainpane.setId("mainpane");
		
		combohbox.getChildren().clear();
		combohbox.getChildren().add(deptcombo);
		
		weekgrid.getChildren().clear();
		
		
		weekscrollpane.setLeft(prevweek);
		weekscrollpane.setRight(nextweek);
		//weekscrollpane.setRight(prolabel);
		
		weekgrid.add(weekscrollpane,0,0);
		weekgrid.add(prdgrid,0,1);
		
		
		
		for(int i=0;i<=6;i++) {
			for(int j=0;j<=6;j++) {
				
				prdgrid.add(new Label(), j, i);
				//((Labeled) prdgrid.getChildren()).setTextAlignment(TextAlignment.CENTER);
			}
		}
		

		prdgrid.setAlignment(Pos.CENTER);
		weekgrid.setAlignment(Pos.TOP_CENTER);
		
		wanimations.fadeIn(weekgrid,1000,0,2,0);
//		wanimations.vtransition(wanimations.vpath(-10,0,20),weekgrid,1500,1);
		 
		weekgrid.setVgap(3);
		prdgrid.setHgap(5);
		prdgrid.setVgap(5);
		
		prdgrid .setMinSize(10, 10);
		weekscrollpane .setMinSize(700, 40);
		weekgrid .setMinSize(700, 40);
		
		
		
		deptcombo.getItems().add("BCA");
		deptcombo.getItems().add("BCOM");
		deptcombo.getItems().add("BBA");
		
		combopane.setRight(combohbox);
		combopane.setBottom(prolabel);
		
		//mainpane.setTop(prolabel);
		mainpane.setTop(combopane);
		mainpane.setCenter(weekgrid);
		setCenter(mainpane);
		
///////////////////////		ANIMATIONS	
		
		
		
	}
}

