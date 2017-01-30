import database.*;
import functions.getStage;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import screens.*;


public class Main extends Application{

	public void start(Stage primaryStage) throws Exception {
		primaryStage.initStyle(StageStyle.UNDECORATED);
		
		final welcomeScreen ws = new welcomeScreen();
		final BorderPane mainpane = new BorderPane();
		
		mainpane.getStylesheets().add("css/style.css");
		mainpane.setCenter(ws);
		Scene scene = new Scene(mainpane,577,382);
		primaryStage.setScene(scene);
		primaryStage.show();
		//////
		getStage g = new getStage();
		g.returnStage(primaryStage);
		////////////////////////////////////////////////////
		ClassDatabase data = new ClassDatabase();
		data.createDatabase();
		try {
			TeacherDatabase teacher = new TeacherDatabase();
			teacher.create();
		}catch(Exception e) {System.out.println(e);}
		
		////////////////////next page///////////////////////
		
		Task<Void> sleeper1 = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                }
                return null;
            }
        };
        sleeper1.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            public void handle(WorkerStateEvent event) {
            	ws.getChildren().clear();
            	loginPage lp = new loginPage();
            	mainpane.getChildren().clear();
            	mainpane.setCenter(lp);
//            	System.out.println("completed");
            }
        });
        new Thread(sleeper1).start();
	}
	public static void main(String[] args) {
		launch(args);
	}
}