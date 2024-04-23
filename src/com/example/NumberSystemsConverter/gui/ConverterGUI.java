package com.example.NumberSystemsConverter.gui;

import com.example.NumberSystemsConverter.logic.Converter;

import javafx.collections.FXCollections;
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
		// TODO: Create helper method with putting error message in convertedResultField
		
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
			// Gets the number user wants converted
			String numberToConvert = numberToConvertField.getText();
			
			// Uses helper method to perform conversion and update display
			performConversion(conversionSelected, convertedResultField, numberToConvert);
			
		});
			
		return layout;
	}
	
	/*
	 * Method that contains code in performing actual conversion
	 * 
	 * String return type to make it easier for outputting
	 */
	private void performConversion(int conversionSelected, TextField convertedResultField, String numberToConvert) {
		// Creates Converter object to perform conversions after validating input
		Converter converter = new Converter();
		
		// To perform conversion specified by user
		switch (conversionSelected) {
			case 0:
				if (numberToConvert.matches("^[-01][01]*")) {
					// Converts binary num to decimal and updates text field to show it
					
					convertedResultField.setText(converter.binaryConversion(numberToConvert));
				} else {
					// Lets user know incorrect number was given 
					
					convertedResultField.setText("ERROR: Binary number was not given");
				}
				break;
			case 1:
				if (numberToConvert.matches("^[-0123456789][0123456789]*")) {
					// Converts decimal num to binary and updates text field to show it

					convertedResultField.setText(converter.decimalConversion(numberToConvert));					
				} else {
					// Lets user know an incorrect number was given
					
					convertedResultField.setText("ERROR: Decimal number was not given.");
				}
				break;
			case 2:
				// TODO: Implement octal to binary conversion here, cleanup 0s in front and end
				
				if (numberToConvert.matches("^[-01234567][01234567]*")) {
					// Performs octal to binary conversion and will print output
					
					convertedResultField.setText(converter.octalConversion(numberToConvert));	
				} else {
					convertedResultField.setText("ERROR: Octal number was not given");
				}
				break;
			default:
				// If user tries to convert with no option selected
				convertedResultField.setText("ERROR: Please select a conversion");
		}
	}
	
	
}