package functions;

import screens.loginPage;
import javafx.stage.Stage;

public class getStage{
	public void returnStage(Stage primaryStage) {
		loginPage log = new loginPage();
		log.getStage(primaryStage);
		addCloseButton btn = new addCloseButton();
		btn.getStage(primaryStage);
	}
}