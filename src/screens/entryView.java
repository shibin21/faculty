package screens;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.controlsfx.control.action.Action;
import org.controlsfx.dialog.Dialogs;

import database.UpdateData;
import functions.addCloseButton;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.util.StringConverter;
import load.Periods;
import screens.database.*;

public class entryView extends BorderPane{
	int a=0,i=0;
	LoadDiv div = new LoadDiv();
	LoadYear lyear = new LoadYear(div);
	ListView list ;
	String[] datas = new String[10];
	@SuppressWarnings("unchecked")
	public entryView(Object object) {
		getChildren().clear();
		getStylesheets().add("css/entryView.css");
        giveNode(object);
		
		BorderPane mainpane = new BorderPane();
		BorderPane centerpane = new BorderPane();
		BorderPane bottompane = new BorderPane();
		GridPane divgrid = new GridPane();
		GridPane maingrid = new GridPane();
		Label emptylab = new Label();
		Label divlab = new Label();
		Label title = new Label();
		VBox options = new VBox();
		VBox tlist = new VBox();
		Button ok = new Button("ok");
		Periods periods = new Periods();
		DatePicker date = new DatePicker();
		BorderPane datepane = new BorderPane();
		BorderPane nextpane = new BorderPane();
		Button next = new Button("next");
		ComboBox year = new ComboBox();
		addCloseButton cb = new addCloseButton();
		
		String[] str = null;
		str = object.toString().split("'");
		title.setText(str[1]);
		
		
		options.setId("options");
		tlist.setId("tlist");
		divgrid.setId("divgrid");
		bottompane.setId("bottompane");
		periods.setId("period");
		divlab.setId("divlabel");
		datepane.setId("datepane");
		nextpane.setId("nextpane");
		title.setId("title");
		
		
		emptylab.setPrefHeight(100);
		bottompane.setStyle("-fx-background-color:#ecf0f1;");
		

		year.setPrefWidth(200);
		year.setPrefHeight(10);
		year.setEditable(true);
		StringConverter converter = new StringConverter<LocalDate>() {
	        DateTimeFormatter dateFormatter = 
	            DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        
	        @Override
	        public String toString(LocalDate date) {
	            if (date != null) {
	                return dateFormatter.format(date);
	            } else {
	                return "";
	            }
	        }
	        @Override
	        public LocalDate fromString(String string) {
	            if (string != null && !string.isEmpty()) {
	                return LocalDate.parse(string, dateFormatter);
	            } else {
	                return null;
	            }
	        }
	    };           
	    
	    lyear.setOnAction(e->{
			div.getYear((String)lyear.getSelectionModel().getSelectedItem());
			options.getChildren().clear();
			options.getChildren().add(div.loadDiv());
			
		});
	    
	    date.setConverter(converter);
	    date.setPromptText("yyyy-MM-dd".toLowerCase());
		
		date.setValue(LocalDate.now());


		maingrid=div.loadDiv();
		list = (ListView)div.takelist();
		periods.period();
		list.getSelectionModel().select(0);
		divlab.setText((String) list.getItems().get(0));
		list.setOnMouseClicked(e ->{
			divlab.setText((String) list.getSelectionModel().getSelectedItem());
			periods.getChildren().clear();
			periods.period();
		});
		final Node node = maingrid.getChildren().get(0);
		Platform.runLater(new Runnable() {
		     @Override
		     public void run() {
		         node.requestFocus();
		     }
		});
//		try {
			next.setOnAction(e ->{
				if(!((TextField)periods.getChildren().get(0)).getText().equals("") && !((TextField)periods.getChildren().get(1)).getText().equals("") && !((TextField)periods.getChildren().get(2)).getText().equals("") && !((TextField)periods.getChildren().get(3)).getText().equals("") && !((TextField)periods.getChildren().get(4)).getText().equals("") && !((TextField)periods.getChildren().get(5)).getText().equals("") && list.getSelectionModel().isEmpty()!=true) {
					datas[0] = title.getText();
					datas[1] = list.getSelectionModel().getSelectedItem().toString();
					datas[2] = lyear.getSelectionModel().getSelectedItem().toString();
					datas[3] = ((TextField)periods.getChildren().get(0)).getText();
					datas[4] = ((TextField)periods.getChildren().get(1)).getText();
					datas[5] = ((TextField)periods.getChildren().get(2)).getText();
					datas[6] = ((TextField)periods.getChildren().get(3)).getText();
					datas[7] = ((TextField)periods.getChildren().get(4)).getText();
					datas[8] = ((TextField)periods.getChildren().get(5)).getText();
					datas[9] = date.getEditor().getText(); 
					
					UpdateData udata = new UpdateData(datas);
					
					list.getSelectionModel().select(list.getSelectionModel().getSelectedIndex()+1);
					divlab.setText((String) list.getSelectionModel().getSelectedItem());
	
					((TextField)periods.getChildren().get(0)).setText("");
					((TextField)periods.getChildren().get(1)).setText("");
					((TextField)periods.getChildren().get(2)).setText("");
					((TextField)periods.getChildren().get(3)).setText("");
					((TextField)periods.getChildren().get(4)).setText("");
					((TextField)periods.getChildren().get(5)).setText("");
					
					Platform.runLater(new Runnable() {
					     @Override
					     public void run() {
					    	 ((TextField)periods.getChildren().get(0)).requestFocus();
					     }
					});
				}
				if(list.getSelectionModel().isEmpty()==true) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Division Error");
					alert.setHeaderText(null);
					alert.setContentText("Select any Division");
					alert.showAndWait();
				}
			});
			next.setOnKeyPressed(e->{
				if(!((TextField)periods.getChildren().get(0)).getText().equals("") && !((TextField)periods.getChildren().get(1)).getText().equals("") && !((TextField)periods.getChildren().get(2)).getText().equals("") && !((TextField)periods.getChildren().get(3)).getText().equals("") && !((TextField)periods.getChildren().get(4)).getText().equals("") && !((TextField)periods.getChildren().get(5)).getText().equals("") && list.getSelectionModel().isEmpty()!=true) {
					datas[0] = title.getText();
					datas[1] = list.getSelectionModel().getSelectedItem().toString();
					datas[2] = lyear.getSelectionModel().getSelectedItem().toString();
					datas[3] = ((TextField)periods.getChildren().get(0)).getText();
					datas[4] = ((TextField)periods.getChildren().get(1)).getText();
					datas[5] = ((TextField)periods.getChildren().get(2)).getText();
					datas[6] = ((TextField)periods.getChildren().get(3)).getText();
					datas[7] = ((TextField)periods.getChildren().get(4)).getText();
					datas[8] = ((TextField)periods.getChildren().get(5)).getText();
					datas[9] = date.getEditor().getText(); 
					
					UpdateData udata = new UpdateData(datas);
					
					list.getSelectionModel().select(list.getSelectionModel().getSelectedIndex()+1);
					divlab.setText((String) list.getSelectionModel().getSelectedItem());
					
					((TextField)periods.getChildren().get(0)).setText("");
					((TextField)periods.getChildren().get(1)).setText("");
					((TextField)periods.getChildren().get(2)).setText("");
					((TextField)periods.getChildren().get(3)).setText("");
					((TextField)periods.getChildren().get(4)).setText("");
					((TextField)periods.getChildren().get(5)).setText("");
					
					Platform.runLater(new Runnable() {
					     @Override
					     public void run() {
					    	 ((TextField)periods.getChildren().get(0)).requestFocus();
					     }
					});
				}
				if(list.getSelectionModel().isEmpty()==true) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Division Error");
					alert.setHeaderText(null);
					alert.setContentText("Select any Division");
					alert.showAndWait();
				}
			});
//		}catch(Exception e) {System.out.println(e);}
		
		cb.addxb(1);
		nextpane.setRight(next);
		datepane.setLeft(lyear);
		datepane.setRight(date);
        options.getChildren().clear();
        options.getChildren().add(maingrid);
        divgrid.setHgap(5);
//		divgrid.add(emptylab, 0, 1);
//		divgrid.add(datepane, 0, 0);
//		divgrid.add(date, 2, 0);
		divgrid.add(divlab, 0, 2);
		divgrid.add(periods, 1, 2);
		divgrid.add(nextpane, 1, 3);
		divgrid.setAlignment(Pos.TOP_CENTER);
		mainpane.setCenter(centerpane);
		mainpane.setLeft(options);
		centerpane.setTop(datepane);
		centerpane.setCenter(divgrid);
		centerpane.setBottom(bottompane);
		bottompane.setRight(ok);
		cb.setCenter(title);
		
		setTop(cb);
		setCenter(mainpane);
	}
	public void giveNode(Object object) {
		lyear.getNode(object);
		lyear.loadYear();
		div.getYear((String)lyear.getSelectionModel().getSelectedItem());
		div.getNode(object);
	}
	
	
}