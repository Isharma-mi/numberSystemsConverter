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
		// For the components on the left side GUI
		Label inputLabel = new Label("Number to convert:");
		TextField numberToConvertField = new TextField();
		
		VBox leftBox = new VBox();
		leftBox.getChildren().addAll(inputLabel, numberToConvertField);
		
		// For components on the center of GUI 
		Button convertButton = new Button("Convert!");
		String[] conversionsArray = {"Binary to Decimal", "Decimal to Binary", "Octal to Binary"};
		ChoiceBox<String> conversionsChoiceBox = new ChoiceBox<String>(FXCollections.observableArrayList(conversionsArray));
		
		VBox centerBox = new VBox();
		centerBox.getChildren().addAll(convertButton, conversionsChoiceBox);
		
		// For components on the right side of GUI
		Label resultLabel = new Label("Conversion result:");
		TextField convertedResultField= new TextField();
		convertedResultField.setEditable(false);
		
		VBox rightBox = new VBox();
		rightBox.getChildren().addAll(resultLabel, convertedResultField);
		
		// For combining ALL components
		BorderPane layout = new BorderPane();
		layout.setLeft(leftBox);
		layout.setCenter(centerBox);
		layout.setRight(rightBox);
		
		// When convert button clicked
		convertButton.setOnMouseClicked((event) -> {
			// Gets the selected item from drop down menu by its index
			int conversionSelected = conversionsChoiceBox.getSelectionModel().getSelectedIndex();
			// Gets the number user wants converted
			String numberToConvert = numberToConvertField.getText();
			
			// Uses helper method to perform conversion and update display
			performConversion(numberToConvert, conversionSelected, convertedResultField);
			
		});
			
		return layout;
	}
	
	/**
	 * Converts a given number into a number of a different number system
	 * and updates a TextField with that number.
	 * @param numberToConvert number user wants converted
	 * @param conversionSelected type of conversion user wants to do
	 * @param convertedResultField TextField where converted result is put in
	 */
	private void performConversion(String numberToConvert, int conversionSelected, TextField convertedResultField) {
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
