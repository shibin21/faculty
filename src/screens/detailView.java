package screens;

import animations.animations;
import functions.addCloseButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class detailView extends BorderPane {
	
	addCloseButton cb = new addCloseButton();
	
	
	
	public detailView(){
		
		getChildren().clear();
		getStylesheets().add("css/detail.css");
		
		animations danimations= new animations();
		GridPane optiongrid = new GridPane(); 
		final BorderPane centerpane = new BorderPane();
		final Button Weekview = new Button("Week View");
		final Button Monthview= new Button("Month View");
		final Button YearView= new Button("Year View");
		final Button IndividualView = new Button("Individual View");
		Label labelbutton = new Label();
		
		labelbutton.setId("labelbutton");
		Weekview.setId("Weekview");
		Monthview.setId("Monthview");
		YearView.setId("YearView");
		IndividualView.setId("IndividualView");
		optiongrid.setId("optiongrid");
		
		//danimations.transition(danimations.path(20,10,90),optiongrid,1000,1);
		danimations.fadeIn(optiongrid,1500,1,1,1);
		
		Weekview.setAlignment(Pos.BASELINE_LEFT);
		Monthview.setAlignment(Pos.BASELINE_LEFT);
		YearView.setAlignment(Pos.BASELINE_LEFT);
		IndividualView.setAlignment(Pos.BASELINE_LEFT);
		
		
		optiongrid.add(labelbutton,0,1);
//		optiongrid.add(Weekview,0,2);
		optiongrid.add(Monthview,0,3);
//		optiongrid.add(YearView,0,4);
		optiongrid.add(IndividualView,0,5);
		
		//optiongrid .setMinSize(20, 20);
		optiongrid .setAlignment(Pos.TOP_LEFT);
		
		
		
		
//		BUTTON ACTIONS
		
		Monthview.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent ae) {
				
				final monthView mview = new monthView();
				centerpane.setCenter(mview);
	
///////////////////////////////////////////////////////////////////////////////////////			
				Weekview.setStyle("-fx-background-color: #2c589b; -fx-text-fill: #ecf0f1; -fx-border-color:transparent;");
				Monthview.setStyle("-fx-background-color: #ecf0f1; -fx-text-fill: #2c589b; -fx-border-color:transparent;-fx-background-radius:0;");
				YearView.setStyle("-fx-background-color: #2c589b; -fx-text-fill: #ecf0f1; -fx-border-color:transparent;");
				IndividualView.setStyle("-fx-background-color: #2c589b; -fx-text-fill: #ecf0f1; -fx-border-color:transparent;");
///////////////////////////////////////////////////////////////////////////////////////
			}
		});
		IndividualView.setOnAction(new EventHandler<ActionEvent>() {
	
			public void handle(ActionEvent ae) {
				
				centerpane.getChildren().clear();
				final Individual iview = new Individual();
				centerpane.setCenter(iview);
///////////////////////////////////////////////////////////////////////////////////////				
				Weekview.setStyle("-fx-background-color: #2c589b; -fx-text-fill: #ecf0f1; -fx-border-color:transparent;");
				Monthview.setStyle("-fx-background-color: #2c589b; -fx-text-fill: #ecf0f1; -fx-border-color:transparent;");
				YearView.setStyle("-fx-background-color: #2c589b; -fx-text-fill: #ecf0f1; -fx-border-color:transparent;");
				IndividualView.setStyle("-fx-background-color: #ecf0f1; -fx-text-fill: #2c589b; -fx-border-color:transparent;-fx-background-radius:0; ");
///////////////////////////////////////////////////////////////////////////////////////			
			}
		});
		
		setLeft(optiongrid);
		
		setCenter(centerpane);
		cb.addxb(0);
		setTop(cb);
		
	}
}


