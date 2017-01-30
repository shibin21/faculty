package animations;

import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

public class animations extends BorderPane{
	public void fadeIn(Node label,int speed,int fopacity,int topacity,int repeat) {
		FadeTransition ft = new FadeTransition(Duration.millis(speed), label);
		ft.setFromValue(fopacity);
		ft.setToValue(topacity);
		ft.setCycleCount(repeat);
		ft.setAutoReverse(false);
		ft.play();
		getChildren().clear();
		setCenter(label);
	}
	public Path path(int i,int j,int k) {
		Path path = new Path();
		path.getElements().add(new MoveTo(i,j));
		path.getElements().add(new HLineTo(k));
//		path.getElements().add(new CubicCurveTo(200, 200, 0, 0, 200, 200));
//		path.getElements().add(new CubicCurveTo(0, 0, 0, 0, 0, 0));
		return path;
	}
	public PathTransition transition(Path path,Node label,int speed,int repeat) {
		PathTransition pathTransition = new PathTransition();
		pathTransition.setDuration(Duration.millis(speed));
		pathTransition.setPath(path);
		pathTransition.setNode(label);
		pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		pathTransition.setCycleCount(repeat);
		pathTransition.setAutoReverse(true);
		pathTransition.play();
		return pathTransition;
	}
}