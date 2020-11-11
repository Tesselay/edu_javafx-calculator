package calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

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
    @FXML public Button btnFloorDivision;
    @FXML public Button btnReset;

    private double value1;
    private double value2;

    private List<Button> buttons = new ArrayList<>();

    private void addButtons() {
        buttons.add(btnAddition);
        buttons.add(btnSubtraction);
        buttons.add(btnMultiplication);
        buttons.add(btnDivision);
        buttons.add(btnPower);
        buttons.add(btnModulo);
        buttons.add(btnFloorDivision);
    }

    private void updateValues() {
        // For more efficiency, the values are only updated once one of the operand buttons is pressed.
        value1 = Double.parseDouble(fieldValue1.getText());
        value2 = Double.parseDouble(fieldValue2.getText());
    }

    private void deactivateButtons(String id) {
        if (buttons.size() == 0) {
            addButtons();
        }

        for (Button button : buttons) {
            button.setDisable(true);
            if (button.getId().equals(id)) {
                button.setDisable(false);
            }
        }
    }

    private void activateButtons() {
        for (Button button : buttons) {
            button.setDisable(false);
        }
    }

    private void resetFields() {
        fieldValue1.setText("");
        fieldValue2.setText("");
        fieldResult.setText("");
    }

    public void btnAdditionOnAction(ActionEvent actionEvent) {
        deactivateButtons(((Node) actionEvent.getSource()).getId());
        updateValues();
        double result = value1 + value2;
        fieldResult.setText(String.valueOf(result));
    }


    public void btnSubtractionOnAction(ActionEvent actionEvent) {
        deactivateButtons(((Node) actionEvent.getSource()).getId());
        updateValues();
        double result = value1 - value2;
        fieldResult.setText(String.valueOf(result));
    }

    public void btnMultiplicationOnAction(ActionEvent actionEvent) {
        deactivateButtons(((Node) actionEvent.getSource()).getId());
        updateValues();
        double result = value1 * value2;
        fieldResult.setText(String.valueOf(result));
    }

    public void btnDivisionOnAction(ActionEvent actionEvent) {
        deactivateButtons(((Node) actionEvent.getSource()).getId());
        updateValues();
        double result = value1 / value2;
        fieldResult.setText(String.valueOf(result));
    }

    public void btnPowerOnAction(ActionEvent actionEvent) {
        deactivateButtons(((Node) actionEvent.getSource()).getId());
        updateValues();

        double result = value1;
        for (int i = 0; i < value2 - 1; i++) {
            result *= value1;
        }
        fieldResult.setText(String.valueOf(result));
    }

    public void btnModuloOnAction(ActionEvent actionEvent) {
        deactivateButtons(((Node) actionEvent.getSource()).getId());
        updateValues();
        double result = value1 % value2;
        fieldResult.setText(String.valueOf(result));
    }

    public void btnFloorDivisionOnAction(ActionEvent actionEvent) {
        deactivateButtons(((Node) actionEvent.getSource()).getId());
        updateValues();
        // A simple typecast suffices for flooring, since the fractional digits will just be cut off.
        int result = (int) (value1 / value2);
        fieldResult.setText(String.valueOf(result));
    }

    public void btnResetOnAction(ActionEvent actionEvent) {
        resetFields();
        activateButtons();
    }
}
