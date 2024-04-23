package com.example.NumberSystemsConverter.gui;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ChoiceBox;
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
		String[] conversionsArray = {"Binary to Decimal", "Decimal to Binary", "Octal to Binary"};
		ChoiceBox<String> conversionsChoiceBox = new ChoiceBox<String>(FXCollections.observableArrayList(conversionsArray));
		
		VBox centerBox = new VBox();
		centerBox.getChildren().addAll(convertButton, conversionsChoiceBox);
		
		// For components on the right side
		Label resultLabel = new Label("Conversion result:");
		TextField convertedResultField= new TextField();
		convertedResultField.setEditable(false);
		
		VBox rightBox = new VBox();
		rightBox.getChildren().addAll(resultLabel, convertedResultField);
		
		// For combining all components
		BorderPane layout = new BorderPane();
		layout.setLeft(leftBox);
		layout.setCenter(centerBox);
		layout.setRight(rightBox);
		
		// For when button is clicked
		convertButton.setOnMouseClicked((event) -> {
			// Gets the selected item from dropdown menu by its index
			int conversionSelected = conversionsChoiceBox.getSelectionModel().getSelectedIndex();
			
			// To perform conversion specified by user
			switch (conversionSelected) {
				case 0:
					// TODO: Implement binary to decimal conversion here
					break;
				case 1:
					// TODO: Implement decimal to binary conversion here
					break;
				case 2:
					// TODO: Implement octal to binary conversion here
					break;
				default:
					// If user tries to convert with no option selected
					convertedResultField.setText("ERROR: Please select a conversion");
			}
		});
			
		return layout;
	}
}
