package main;



import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;

public class GUIController {

	/*
	 * Buttons 1-0
	 */
	@FXML
	Button oneButton;
	@FXML
	Button twoButton;
	@FXML
	Button threeButton;
	@FXML
	Button fourButton;
	@FXML
	Button fiveButton;
	@FXML
	Button sixButton;
	@FXML
	Button sevenButton;
	@FXML
	Button eightButton;
	@FXML
	Button nineButton;
	@FXML
	Button zeroButton;

	/*
	 * Function-Buttons
	 */
	@FXML
	Button kommaButton;
	@FXML
	Button plusButton;
	@FXML
	Button minusButton;
	@FXML
	Button multiButton;
	@FXML
	Button divideButton;
	@FXML
	Button deleteAllButton;
	@FXML
	Button plusMinusButton;
	@FXML
	Button moduloButton;
	@FXML
	Button equalButton;

	/*
	 * Textfield
	 */
	@FXML
	TextField textfieldOne;
	@FXML
	TextField textfieldTwo;
	
	/*
	 * Labels
	 */
	@FXML
	Label resultLabel;
	@FXML
	Label errorLabel;
	
	@FXML
	Rectangle resultBox;

	private boolean commaSet = false;
	private boolean textfieldOneMinusSet = false;
	private boolean textfieldTwoMinusSet = false;
	
	private boolean plusPressed = false;
	private boolean minusPressed = false;
	private boolean multiplyPressed = false;
	private boolean dividePressed = false;
	private boolean moduloPressed = false;

	/*
	 * Initialize the alignment of both textfields
	 * Set Keylisteners to both textfields, so only numerical values and ',' is allowed
	 */
	public void initialize() {
		textfieldOne.setAlignment(Pos.CENTER_RIGHT);
		textfieldTwo.setAlignment(Pos.CENTER_RIGHT);
		
		textfieldOne.textProperty().addListener(new ChangeListener<String>() {
	        @Override
	        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
	            if (!newValue.matches("-?\\d{0,10}([\\,]\\d{0,7})?")) {
	            	textfieldOne.setText(oldValue);
	            }
	        }
	    });
		
		textfieldTwo.textProperty().addListener(new ChangeListener<String>() {
	        @Override
	        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
	            if (!newValue.matches("-?\\d{0,10}([\\,]\\d{0,7})?")) {
	            	textfieldTwo.setText(oldValue);
	            }
	        }
	    });
	}

	/*
	 * Number-Functions
	 * Writes the number according to the buttons pressed into the currently active textfield
	 */
	public void oneClicked() {
		if (textfieldOne.isFocused()) {
			textfieldOne.appendText("1");
		} else if (textfieldTwo.isFocused()) {
			textfieldTwo.appendText("1");
		}
	}

	public void twoClicked() {
		if (textfieldOne.isFocused()) {
			textfieldOne.appendText("2");
		} else {
			textfieldTwo.appendText("2");
		}
	}

	public void threeClicked() {
		if (textfieldOne.isFocused()) {
			textfieldOne.appendText("3");
		} else {
			textfieldTwo.appendText("3");
		}
	}

	public void fourClicked() {
		if (textfieldOne.isFocused()) {
			textfieldOne.appendText("4");
		} else {
			textfieldTwo.appendText("4");
		}
	}

	public void fiveClicked() {
		if (textfieldOne.isFocused()) {
			textfieldOne.appendText("5");
		} else {
			textfieldTwo.appendText("5");
		}
	}

	public void sixClicked() {
		if (textfieldOne.isFocused()) {
			textfieldOne.appendText("6");
		} else {
			textfieldTwo.appendText("6");
		}
	}

	public void sevenClicked() {
		if (textfieldOne.isFocused()) {
			textfieldOne.appendText("7");
		} else {
			textfieldTwo.appendText("7");
		}
	}

	public void eightClicked() {
		if (textfieldOne.isFocused()) {
			textfieldOne.appendText("8");
		} else {
			textfieldTwo.appendText("8");
		}
	}

	public void nineClicked() {
		if (textfieldOne.isFocused()) {
			textfieldOne.appendText("9");
		} else {
			textfieldTwo.appendText("9");
		}
	}

	public void zeroClicked() {
		if (textfieldOne.isFocused()) {
			textfieldOne.appendText("0");
		} else {
			textfieldTwo.appendText("0");
		}
	}

	/*
	 * Calc-Functions
	 */
	public void plusClicked() {
		if (Rechner.checkIfFloatingNumber(textfieldOne.getText())  //Check if one or both entered numbers are Double
				|| Rechner.checkIfFloatingNumber(textfieldTwo.getText())) {
			double valueOne = Rechner.checkIfNegativeDouble(textfieldOne.getText());
			double valueTwo = Rechner.checkIfNegativeDouble(textfieldTwo.getText());

			double result = Rechner.additionDouble(valueOne, valueTwo);
			String size = String.valueOf(result);
			String endValue = String.valueOf(result).substring(0, Math.min(size.length(), 12));
			resultLabel.setText(String.valueOf(endValue));
			resultBox.setVisible(true);
		} else {
			try {
				int valueOne = Rechner.checkIfNegativeInteger(textfieldOne.getText());
				int valueTwo = Rechner.checkIfNegativeInteger(textfieldTwo.getText());

				int result = Rechner.additionInteger(valueOne, valueTwo);
				String size = String.valueOf(result);
				String endValue = String.valueOf(result).substring(0, Math.min(size.length(), 12));
				resultLabel.setText(String.valueOf(endValue));
				resultBox.setVisible(true);
			} catch (NumberFormatException e) {
				errorLabel.setText("Das Ergebnis ist zu gross, um dargstellt zu werden.");;
			}
		}
	}

	public void minusClicked() {
		if (Rechner.checkIfFloatingNumber(textfieldOne.getText())	//Check if one or both entered numbers are Double
				|| Rechner.checkIfFloatingNumber(textfieldTwo.getText())) {
			double valueOne = Rechner.checkIfNegativeDouble(textfieldOne.getText());
			double valueTwo = Rechner.checkIfNegativeDouble(textfieldTwo.getText());

			double result = Rechner.subtractionDouble(valueOne, valueOne);
			String size = String.valueOf(result);
			String endValue = String.valueOf(result).substring(0, Math.min(size.length(), 12));
			resultLabel.setText(String.valueOf(endValue));
			resultBox.setVisible(true);
		} else {
			try {
				int valueOne = Rechner.checkIfNegativeInteger(textfieldOne.getText());
				int valueTwo = Rechner.checkIfNegativeInteger(textfieldTwo.getText());

				int result = Rechner.subtractionInteger(valueOne, valueTwo);
				String size = String.valueOf(result);
				String endValue = String.valueOf(result).substring(0, Math.min(size.length(), 12));
				resultLabel.setText(String.valueOf(endValue));
				resultBox.setVisible(true);
			} catch (NumberFormatException e) {
				errorLabel.setText("Das Ergebnis ist zu gross, um dargstellt zu werden.");;
			}
		}
	}

	public void multiClicked() {
		if (Rechner.checkIfFloatingNumber(textfieldOne.getText())	//Check if one or both entered numbers are Double
				|| Rechner.checkIfFloatingNumber(textfieldTwo.getText())) {
			double valueOne = Rechner.checkIfNegativeDouble(textfieldOne.getText());
			double valueTwo = Rechner.checkIfNegativeDouble(textfieldTwo.getText());

			double result = Rechner.multiplyDouble(valueOne, valueTwo);
			String size = String.valueOf(result);
			String endValue = String.valueOf(result).substring(0, Math.min(size.length(), 12));
			resultLabel.setText(String.valueOf(endValue));
			resultBox.setVisible(true);
		} else {
			try {
				int valueOne = Rechner.checkIfNegativeInteger(textfieldOne.getText());
				int valueTwo = Rechner.checkIfNegativeInteger(textfieldTwo.getText());

				int result = Rechner.multiplyInteger(valueOne, valueTwo);
				String size = String.valueOf(result);
				String endValue = String.valueOf(result).substring(0, Math.min(size.length(), 12));
				resultLabel.setText(String.valueOf(endValue));
				resultBox.setVisible(true);
			} catch (NumberFormatException e) {
				errorLabel.setText("Das Ergebnis ist zu gross, um dargstellt zu werden.");
			}
		}
	}

	public void divideClicked() {
		if (Rechner.checkIfFloatingNumber(textfieldOne.getText())	//Check if one or both entered numbers are Double
				|| Rechner.checkIfFloatingNumber(textfieldTwo.getText())) {
			double valueOne = Rechner.checkIfNegativeDouble(textfieldOne.getText());
			double valueTwo = Rechner.checkIfNegativeDouble(textfieldTwo.getText());
			double resultDouble;

			try {
				resultDouble = Rechner.divideDouble(valueOne, valueTwo);
				String size = String.valueOf(resultDouble);
				String endValue = String.valueOf(resultDouble).substring(0, Math.min(size.length(), 12));
				resultLabel.setText(String.valueOf(endValue));
				resultBox.setVisible(true);
			} catch (ArithmeticException e) {
				errorLabel.setText(e.getMessage());
			}
		} else {
			int valueOne = Rechner.checkIfNegativeInteger(textfieldOne.getText());
			int valueTwo = Rechner.checkIfNegativeInteger(textfieldTwo.getText());
			int resultInt;

			try {
				resultInt = Rechner.divideInteger(valueOne, valueTwo);
				String size = String.valueOf(resultInt);
				String endValue = String.valueOf(resultInt).substring(0, Math.min(size.length(), 12));
				resultLabel.setText(String.valueOf(endValue));
				resultBox.setVisible(true);
			} catch (ArithmeticException e) {
				errorLabel.setText(e.getMessage());
			} catch (NumberFormatException ne) {
				errorLabel.setText("Das Ergebnis ist zu gross, um dargstellt zu werden.");
			}
		}
	}

	public void moduloClicked() {
		if (Rechner.checkIfFloatingNumber(textfieldOne.getText())	//Check if one or both entered numbers are Double
				|| Rechner.checkIfFloatingNumber(textfieldTwo.getText())) {

			double valueOne = Double.parseDouble(textfieldOne.getText());
			double valueTwo = Double.parseDouble(textfieldTwo.getText());
			double result = Rechner.moduloDouble(valueOne, valueTwo);

			String size = String.valueOf(result);
			String endValue = String.valueOf(result).substring(0, Math.min(size.length(), 12));
			resultLabel.setText(String.valueOf(endValue));
			resultBox.setVisible(true);
		} else {
			int valueOne = Integer.parseInt(textfieldOne.getText());
			int valueTwo = Integer.parseInt(textfieldTwo.getText());
			int result = Rechner.moduloInteger(valueOne, valueTwo);

			String size = String.valueOf(result);
			String endValue = String.valueOf(result).substring(0, Math.min(size.length(), 12));
			resultLabel.setText(String.valueOf(endValue));
			resultBox.setVisible(true);
		}
	}

	public void deleteAllClicked() {
		textfieldOne.clear();
		textfieldTwo.clear();
		resultLabel.setText("");
		textfieldOne.requestFocus();;
	}

	/*
	 * Toggle the preceding '-' for the currently focused textfield
	 */
	public void plusMinusClicked() {
		if (textfieldOne.isFocused() && textfieldOneMinusSet == false) {
			String string = "-";
			string += textfieldOne.getText();
			textfieldOne.setText(string);
			textfieldOneMinusSet = true;
		} else if (textfieldTwo.isFocused() && textfieldTwoMinusSet == false) {
			String string = "-";
			string += textfieldTwo.getText();
			textfieldTwo.setText(string);
			textfieldTwoMinusSet = true;
		} else if (textfieldOne.isFocused() && textfieldOneMinusSet == true) {
			String string = textfieldOne.getText();
			string = string.substring(1, textfieldOne.getText().length());
			textfieldOne.setText(string);
			textfieldOneMinusSet = false;
		} else if (textfieldTwo.isFocused() && textfieldTwoMinusSet == true) {
			String string = textfieldTwo.getText();
			string = string.substring(1, textfieldTwo.getText().length());
			textfieldTwo.setText(string);
			textfieldTwoMinusSet = false;
		}
	}

	public void kommaClicked() {
		if (commaSet == false) {
			if (textfieldOne.isFocused()) {
				textfieldOne.appendText(",");
			} else {
				textfieldTwo.appendText(",");
			}
			commaSet = true;
		}
	}

}
