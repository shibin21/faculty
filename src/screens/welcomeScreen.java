package screens;

import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import animations.animations;
import functions.addCloseButton;

public class welcomeScreen extends BorderPane{
	
	public welcomeScreen(){
		final Label loadinglabel = new Label();
		try {
			HBox box1 = new HBox();
			GridPane boxpane = new GridPane();
			Label mainlabel = new Label("Faculty Manager");
			Label namelabel = new Label("BCz Collection's");
			Label copyrightlabel = new Label("Copyright by BlueCipherz");
			Image image = new Image(getClass().getResourceAsStream("../img/loading.GIF"));
//			
		    loadinglabel.setGraphic(new ImageView(image));
		    
		    mainlabel.setId("animated");
			namelabel.setId("name-label");
			loadinglabel.setId("img-label");
			copyrightlabel.setId("right-label");
			
			loadinglabel.setVisible(false);
			
			animations a = new animations();
			
			a.fadeIn(mainlabel,1500,0,1,1);
			a.transition(a.path(0,10,210),namelabel,1000,1);
			a.transition(a.path(0,18,100),copyrightlabel,1000,1);
			
			boxpane.add(mainlabel, 0, 0);
			boxpane.add(namelabel, 0, 1);
			boxpane.add(loadinglabel, 0, 2);
			boxpane.setAlignment(Pos.TOP_CENTER);
			box1.getChildren().add(boxpane);
			setCenter(box1);
			setBottom(copyrightlabel);
			getStylesheets().add("css/style.css");
			
			addCloseButton closebtn = new addCloseButton();
			closebtn.addx();
			setTop(closebtn);
			
			///////////////////loading true/////////////////////
						
				Task<Void> sleeper1 = new Task<Void>() {
			      @Override
			      protected Void call() throws Exception {
			          try {
			              Thread.sleep(2000);
			          } catch (InterruptedException e) {
			          }
			          return null;
			      }
			  };
			  sleeper1.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
			      public void handle(WorkerStateEvent event) {
			    	  loadinglabel.setVisible(true);
			      }
			  });
			  new Thread(sleeper1).start();
				
			
			}catch(Exception e) {System.out.println(e);}
	}
}