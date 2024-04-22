package com.example.NumberSystemsConverter.gui;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.Parent;

public class ConverterGUI {
	
	public Parent getView() {
		// TODO: Add all components
		// TODO: Actually perform conversions, clean up Main as well
		
		// For the components on the left side 
		Label inputLabel = new Label("Number to convert:");
		TextField numberToConvertField = new TextField();
		
		VBox leftBox = new VBox();
		leftBox.getChildren().addAll(inputLabel, numberToConvertField);
		
		// For components on the center
		Button convertButton = new Button("Convert!");
		
		// For components on the right side
		Label resultLabel = new Label("Conversion result:");
		TextField convertedResultField= new TextField();
		convertedResultField.setEditable(false);
		
		VBox rightBox = new VBox();
		rightBox.getChildren().addAll(resultLabel, convertedResultField);
		
		// For combining all components
		BorderPane layout = new BorderPane();
		layout.setLeft(leftBox);
		layout.setCenter(convertButton);
		layout.setRight(rightBox);
		
		// For when button is clicked
		convertButton.setOnMouseClicked((event) -> {
			convertedResultField.setText("Conversion will go here");
		});
		
		return layout;
	}
}
