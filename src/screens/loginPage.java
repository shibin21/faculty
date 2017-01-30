package screens;

import java.awt.Dimension;
import java.awt.Toolkit;

import functions.addCloseButton;
import animations.animations;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class loginPage extends BorderPane{
	public static Stage primaryStage =null;
	
	public loginPage(){
		try {
			getChildren().clear();
			HBox gapbox = new HBox();
			GridPane root = new GridPane();
			HBox loginbox = new HBox();
			GridPane maingrid = new GridPane();
			BorderPane mainpane = new BorderPane();
			BorderPane toplogin = new BorderPane();
			final TextField username = new TextField();
			StackPane rightbutton = new StackPane();
			Region rightbuttongraphic = new Region();
			final PasswordField loginpassword = new PasswordField();
			final Button login = new Button("login");
			final Label wronglabel = new Label("incorrect");
			Label usernamelabel = new Label("username : ");
			Label passwordlabel = new Label("password : ");
			Label mainlabel = new Label("Faculty Manager");
			Label namelabel = new Label("User Login Applications");
			Label copyrightlabel = new Label("Copyright by BlueCipherz");
			wronglabel.setVisible(false);
		    login.getStylesheets().add("css/login.css");
			
		    
		    username.setPromptText("username");
		    loginpassword.setPromptText("password");

		    username.textProperty().addListener(new ChangeListener<Object>() {
				public void changed(ObservableValue<? extends Object> observable, Object oldValue, Object newValue) {
					wronglabel.setVisible(false);
				}
			});
		    loginpassword.textProperty().addListener(new ChangeListener<Object>() {
		    	public void changed(ObservableValue<? extends Object> observable, Object oldValue, Object newValue) {
		    		wronglabel.setVisible(false);
		    	}
		    });
		    
		    login.setOnAction(new EventHandler<ActionEvent>() {
			
				public void handle(ActionEvent arg0) {
					String uname,password,duname="a",dpassword="a";
					uname= username.getText();
					password = loginpassword.getText();
					if(uname.equals(duname)) {
						if(password.equals(dpassword)) {
							Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
							startupWindow start = new startupWindow();
							Scene scene = new Scene(start,screenSize.getWidth(),screenSize.getHeight()-40);
							primaryStage.setScene(scene);
							primaryStage.centerOnScreen();
						}
						else {
							wronglabel.setVisible(true);
						}
					}
					else {
						wronglabel.setVisible(true);
					}
				}
			});
		    
		    setOnKeyPressed(e ->{
		    	if(e.getCode()==KeyCode.ENTER) {
		    		String uname,password,duname="a",dpassword="a";
					uname= username.getText();
					password = loginpassword.getText();
					if(uname.equals(duname)) {
						if(password.equals(dpassword)) {
							Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
							startupWindow start = new startupWindow();
							Scene scene = new Scene(start,screenSize.getWidth(),screenSize.getHeight()-40);
							primaryStage.setScene(scene);
							primaryStage.centerOnScreen();
						}
						else {
							wronglabel.setVisible(true);
						}
					}
					else {
						wronglabel.setVisible(true);
					}
		    	}
		    });
			
			rightbutton.getStyleClass().add("right-button");
			rightbuttongraphic.getStyleClass().add("right-button-graphic");
			wronglabel.setId("wrong-label");
			username.setId("user-name");
			loginpassword.setId("user-name");
			usernamelabel.setId("user-name-label");
			passwordlabel.setId("user-name-label");
			mainlabel.setId("animated");
			namelabel.setId("login-label");
			gapbox.setId("login-details");
			copyrightlabel.setId("right-label");
			loginbox.setId("loginbox");
			login.setId("login-button");
			
			animations a = new animations();
			
			a.fadeIn(mainlabel,1500,0,1,1);
			a.fadeIn(toplogin,1000,0,1,1);
			a.transition(a.path(0,20,210),namelabel,1000,1);
			a.transition(a.path(0,18,100),copyrightlabel,1000,1);
			
			rightbutton.setFocusTraversable(false);
	        rightbuttongraphic.setFocusTraversable(false);
	        
	        rightbuttongraphic.setMaxWidth(Region.USE_PREF_SIZE);
	        rightbuttongraphic.setMaxHeight(Region.USE_PREF_SIZE);
			
	        rightbutton.setVisible(false);
	        
	        rightbutton.getChildren().add(rightbuttongraphic);
			loginbox.getChildren().add(login);
			maingrid.add(mainlabel, 0, 0);
			maingrid.add(namelabel, 0, 1);
			root.add(wronglabel, 1, 0);
//			root.add(usernamelabel, 0, 1);
			root.add(username, 1, 1);
//			root.add(passwordlabel, 0, 2);
			root.add(loginpassword, 1, 2);
			root.add(loginbox, 1, 3);
			root.setAlignment(Pos.CENTER);
			root.setVgap(2);
			gapbox.getChildren().add(root);
			mainpane.setTop(maingrid);
			toplogin.setTop(root);
			mainpane.setCenter(toplogin);
			setCenter(mainpane);
			setBottom(copyrightlabel);
			getStylesheets().add("css/login.css");
			
			addCloseButton closebtn = new addCloseButton();
			closebtn.addx();
			setTop(closebtn);
			
			}catch(Exception e) {System.out.println(e);}
	}
	public void getStage(Stage Stage) {
		primaryStage=Stage;
	}
}