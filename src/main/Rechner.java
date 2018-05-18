package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Rechner extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage stage) throws Exception {
		AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("GUI.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(this.getClass().getResource("main.css").toExternalForm());
		stage.setTitle("Calculator");
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
	}

	/**
	 * @param value, the String input from a textfield
	 * @return true, if the String contains a ',' and is therefore a floating point number
	 */
	protected static boolean checkIfFloatingNumber(String value) {
		if (value.contains(",")) {
			return true;
		}

		return false;
	}

	/**
	 * @param value, the String input from a textfield
	 * @return Double value, wich is represented in the given String
	 */
	protected static double convertToDouble(String value) {
		String text = value.replace(",", ".");
		Double result = Double.valueOf(text);
		return result;
	}

	/**
	 * @param text, the String input from a textfield
	 * @return The converted String made into a negative Double value if the first char is '-', 
	 * 			else just replace the ',' with a '.' and parse to Double
	 */
	protected static double checkIfNegativeDouble(String text) {
		char minus = '-';
		if (text.charAt(0) == minus) {
			String value = text.substring(1, text.length());
			value = value.replace(",", ".");
			double result = Double.parseDouble(value);
			result = -result;
			return result;
		} else {
			String value = text;
			value.replace(",", ".");
			double result = Double.parseDouble(value);
			return result;
		}
	}

	/**
	 * @param text, the String input from a textfield
	 * @return The converted String made into a negative Integer value
	 */
	protected static int checkIfNegativeInteger(String text) {
		char minus = '-';
		if (text.charAt(0) == minus) {
			String value = text.substring(1, text.length());
			int result = -Integer.parseInt(value);
			return result;
		} else {
			String value = text.substring(0, text.length());
			int result = Integer.parseInt(value);
			return result;
		}
	}

	protected static double multiplyDouble(double valueOne, double valueTwo) {
		return valueOne * valueTwo;
	}

	protected static int multiplyInteger(int valueOne, int valueTwo) {
		return valueOne * valueTwo;
	}

	protected static double divideDouble(double valueOne, double valueTwo) {
		if (valueOne > 0 && valueTwo > 0) {
			return valueOne / valueTwo;
		} else {
			throw new ArithmeticException("Durch Null teilen ist nicht moeglich!");
		}
	}

	protected static int divideInteger(int valueOne, int valueTwo) {
		if (valueOne != 0 && valueTwo != 0) {
			return valueOne / valueTwo;
		} else {
			throw new ArithmeticException("Durch Null teilen ist nicht moeglich!");
		}
	}

	protected static double additionDouble(double valueOne, double valueTwo) {
		return valueOne + valueTwo;
	}

	protected static int additionInteger(int valueOne, int valueTwo) {
		return valueOne + valueTwo;
	}

	protected static double subtractionDouble(double valueOne, double valueTwo) {
		return valueOne - valueTwo;
	}

	protected static int subtractionInteger(int valueOne, int valueTwo) {
		return valueOne - valueTwo;
	}

	protected static double moduloDouble(double valueOne, double valueTwo) {
		return valueOne % valueTwo;
	}

	protected static int moduloInteger(int valueOne, int valueTwo) {
		return valueOne % valueTwo;
	}
}
