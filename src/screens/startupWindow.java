package screens;

import functions.*;
import animations.animations;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class startupWindow extends BorderPane{
	
public startupWindow(){
	
	getChildren().clear();
	getStylesheets().add("css/startupwindow.css");
	setStyle("-fx-background-color:#3498db;");
	
//	animations a= new animations();
	addCloseButton cb = new addCloseButton();
	GridPane startupgrid = new GridPane();
	final Button detailb = new Button("Detail Mode");
	final Button entryb = new Button("Entry Mode");
	final Button settings = new Button("Settings");
	HBox settingsbox = new HBox();
	
//	Image close = new Image(getClass().getResourceAsStream("../img/detailicon.png"));
//    detailb.setGraphic(new ImageView(close));

	detailb.setStyle("-fx-background-image: url('img/detailicon.png');");
	entryb.setStyle("-fx-background-image: url('img/entryicon.png');");

	detailb.setId("detailb");
	entryb.setId("entryb");
	startupgrid.setId("startupgrid");
	settings.setId("settings");
	settingsbox.setId("settings-box");

//CSS OF STARUPWINDOW	
	
	//rootpane.setStyle("-fx-background-color: #1f0068;");
	
    detailb.setAlignment(Pos.BOTTOM_LEFT);
    entryb.setAlignment(Pos.BOTTOM_LEFT);
	
//	Reflection r1 = new Reflection();
//	Reflection r2 = new Reflection();
//    r1.setFraction(5);
//    r2.setFraction(5);
//    entryb.setEffect(r1);
//    detailb.setEffect(r2);
    
//    a.transition(.path(0,15,60),entryb,1500,1);
   
//    a.fadeIn(entryb,1500,0,1,1);
//    try {
//		Thread.sleep(150);
//	} catch (InterruptedException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//    a.transition(a.path(0,15,60),detailb,1500,1);
//    a.fadeIn(detailb,1500,0,1,1);
    
//ACTIONS OF STARTUPWINDOW	
	
	detailb.setOnAction(new EventHandler<ActionEvent>() {
		
		public void handle(ActionEvent ae) {
			getChildren().clear();
			final detailView dview = new detailView();
			setCenter(dview);
		}
	});
	detailb.setOnKeyPressed(e->{
		if(e.getCode()==KeyCode.ENTER) {
			getChildren().clear();
			final detailView dview = new detailView();
			setCenter(dview);
		}
	});
	entryb.setOnKeyPressed(e->{
		if(e.getCode()==KeyCode.ENTER) {
			getChildren().clear();
			final entryViewDept eviewdept = new entryViewDept();
			setCenter(eviewdept);
		}
	});
	
	entryb.setOnAction(new EventHandler<ActionEvent>() {
		
		public void handle(ActionEvent ae) {
			getChildren().clear();
			final entryViewDept eviewdept = new entryViewDept();
			setCenter(eviewdept);
		}
	});
	settings.setOnAction(new EventHandler<ActionEvent>() {
		public void handle(ActionEvent arg0) {
			getChildren().clear();
			Settings set = new Settings();
			setCenter(set);
		}
	});
	
	
	settingsbox.getChildren().add(settings);
	setCenter(startupgrid);
	setRight(settingsbox);
	startupgrid.add(entryb, 0, 0);
	startupgrid.add(detailb, 1, 0);
	
	startupgrid.setHgap(5);
	
	startupgrid .setAlignment(Pos.CENTER);
	cb.addx();
	setTop(cb);
	
}
  }
