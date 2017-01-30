package functions;

import java.awt.Dimension;
import java.awt.Toolkit;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import screens.*;

public class addCloseButton extends BorderPane{
	public static Stage primaryStage =null;
	public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	Scene scene = null;
	public static int stageno;
	public void addx() {
		getChildren().clear();
		setStyle("-fx-background-color:#3498db;"
				+ "-fx-padding: 0 3 0 0;");
		Button closebutton = new Button();
		closebutton.getStylesheets().add("css/menubar.css");
//		try {
		Image close = new Image(getClass().getResourceAsStream("../img/close.png"));
	    closebutton.setGraphic(new ImageView(close));
//		}catch(Exception e) {System.out.println(e);}
	    closebutton.setId("close-button");
		closebutton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				System.exit(0);
			}
		});
		setRight(closebutton);
	}
	public void addxb(int no) {
		try {
		getChildren().clear();
		setStyle("-fx-background-color:#3498db;"
				+ "-fx-padding: 0 3 0 0;");
		Button closebutton = new Button();
		stageno = no;
		final Button backbutton = new Button();
		HBox backbox = new HBox();
		HBox rightbox = new HBox();
		GridPane rightpane = new GridPane();
		getStylesheets().add("css/menubar.css");
		
		final Image back = new Image(getClass().getResourceAsStream("../img/back-35.png"));
		final Image backdb = new Image(getClass().getResourceAsStream("../img/back-35-ash.png"));
		Image close = new Image(getClass().getResourceAsStream("../img/close.png"));
		closebutton.setGraphic(new ImageView(close));
		backbutton.setGraphic(new ImageView(back));
		
		closebutton.setId("close-button");
		backbutton.setId("back-button");
		backbox.setId("back-box");
		rightbox.setId("right-box");
		rightpane.setId("right-pane");
		
		backbutton.setOnMousePressed(new EventHandler<Event>() {
			public void handle(Event arg0) {
				backbutton.setGraphic(new ImageView(backdb));
				setScreen(no);
			}
		});
		backbutton.requestFocus();
		backbutton.setOnKeyPressed(e->{
			System.out.println(e.getCode());
			if(e.getCode()==KeyCode.ESCAPE) {
				setScreen(no);
			}
		});
		backbutton.setOnMouseReleased(new EventHandler<Event>() {
			public void handle(Event arg0) {
				backbutton.setGraphic(new ImageView(back));
			}
		});
		closebutton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				System.exit(0);
			}
		});
		rightpane.setAlignment(Pos.CENTER);
		
		rightbox.getChildren().clear();
		backbox.getChildren().clear();
		rightpane.add(closebutton, 0, 0);
		rightbox.getChildren().add(rightpane);
		backbox.getChildren().add(backbutton);
		setRight(rightbox);
		setLeft(backbox);
		}catch(Exception e) {System.out.println(e);}
	}
	public void getStage(Stage stage) {
		primaryStage=stage;
	}
	public void setScreen(int stage) {
		switch(stage) {
		case 0:
			startupWindow start = new startupWindow();
			scene = new Scene(start,screenSize.getWidth(),screenSize.getHeight()-40);
			break;
		case 1:
			entryViewDept dept = new entryViewDept();
			scene = new Scene(dept,screenSize.getWidth(),screenSize.getHeight()-40);
			break;
		case 2:
			Settings set = new Settings();
			scene = new Scene(set,screenSize.getWidth(),screenSize.getHeight()-40);
			break;
		}
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}