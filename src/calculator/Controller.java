package calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {

    @FXML public TextField fieldValue1;
    @FXML public TextField fieldValue2;
    @FXML public TextField fieldResult;
    @FXML public Button btnAddition;
    @FXML public Button btnSubtraction;
    @FXML public Button btnMultiplication;
    @FXML public Button btnDivision;
    @FXML public Button btnPower;
    @FXML public Button btnModulo;
    @FXML public Button btnModuloInverse;

    private int value1;
    private int value2;

    private void updateValues() {
        // For more efficiency, the values are only updated once one of the operand buttons is pressed.
        value1 = Integer.parseInt(fieldValue1.getText());
        value2 = Integer.parseInt(fieldValue2.getText());
    }

    public void btnAdditionOnAction(ActionEvent actionEvent) {
        updateValues();
        int result = value1 + value2;
        fieldResult.setText(String.valueOf(result));
    }


    public void btnSubtractionOnAction(ActionEvent actionEvent) {
        updateValues();
        int result = value1 - value2;
        fieldResult.setText(String.valueOf(result));
    }

    public void btnMultiplicationOnAction(ActionEvent actionEvent) {
        updateValues();
        int result = value1 * value2;
        fieldResult.setText(String.valueOf(result));
    }

    public void btnDivisionOnAction(ActionEvent actionEvent) {
        updateValues();
        int result = value1 / value2;
        fieldResult.setText(String.valueOf(result));
    }

    public void btnPowerOnAction(ActionEvent actionEvent) {
        updateValues();

        int result = value1;
        for (int i = 0; i <= value2; i++) {
            result *= value1;
        }
        fieldResult.setText(String.valueOf(result));
    }

    public void btnModuloOnAction(ActionEvent actionEvent) {
        updateValues();
        int result = value1 % value2;
        fieldResult.setText(String.valueOf(result));
    }

    public void btnModuloInverseOnAction(ActionEvent actionEvent) {
        updateValues();
        int result = value1 + value2;
        fieldResult.setText(String.valueOf(result));
    }

    public void btnResetOnAction(ActionEvent actionEvent) {
        fieldValue1.setText("");
        fieldValue2.setText("");
        fieldResult.setText("");
    }
}
