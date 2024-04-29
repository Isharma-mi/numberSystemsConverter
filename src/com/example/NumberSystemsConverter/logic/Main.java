package com.example.NumberSystemsConverter.logic;

import com.example.NumberSystemsConverter.gui.ConverterGUI;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
	
public class Main extends Application {
	
	@Override
	public void start(Stage stage) {
		// Gets the gui for conversion
		ConverterGUI guiApp = new ConverterGUI();

		// Sets the layout
		Scene scene = new Scene(guiApp.getView());
		
		// For showing everything to user
		stage.setScene(scene);
		stage.setTitle("Number Converter");
		stage.show();
	}
	
	public static void main(String[] args) {
		// Launches GUI app
		launch(Main.class);
	}
}