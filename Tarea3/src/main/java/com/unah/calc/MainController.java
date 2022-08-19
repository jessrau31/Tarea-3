package com.unah.calc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;

import java.util.Objects;
import java.util.Optional;

public class MainController {
    private String num1;
    private float res;
    private String cad="";
    private String tmp="";
    private String op="";
    @FXML
    private Label label;

    @FXML
    protected void calcButtonClick(ActionEvent event) {
        Button button = (Button) event.getSource();
        cad+=button.getText();
        tmp+=button.getText();
        printop();
    }

    @FXML
    protected void opButtonClick(ActionEvent event) {
        Button button = (Button) event.getSource();
        num1=cad;
        tmp="";
        if (!Objects.equals(op, "")){
            num1 = String.valueOf(res);
            cad = num1;
        }
        cad += button.getText();
        op = button.getText();
        printop();

    }

    @FXML
    protected void delButtonClick() {
        if (cad.length() > 0) {
            if (tmp.length()==0) {
                op="";
                cad = cad.substring(0, cad.length() - 1);
                num1="";
                printop();
            }else {
                cad = cad.substring(0, cad.length() - 1);
                tmp = tmp.substring(0, tmp.length() - 1);
                printop();
            }
        }
    }

    @FXML
    protected  void infoButtonClick(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Información");
        alert.setContentText("Realizado por: Ana Gabriela Cantarero Flores");
        Optional<ButtonType> action = alert.showAndWait();
    }

    @FXML
    protected void resButtonClick(){
        if (op.length()>0){
            if (tmp.length()>0){
                switch (op) {
                    case "+" -> res = Float.parseFloat(num1) + Float.parseFloat(tmp);
                    case "-" -> res = Float.parseFloat(num1) - Float.parseFloat(tmp);
                    case "x" -> res = Float.parseFloat(num1) * Float.parseFloat(tmp);
                    case "/" -> res = Float.parseFloat(num1) / Float.parseFloat(tmp);
                    default -> res = 0;
                }
                label.setText(String.format("%.2f", res));
            }
        }
    }

    protected  void printop(){
        if (!Objects.equals(num1, "") && !tmp.equals("") && !op.equals("")){
            switch (op) {
                case "+" -> res = Float.parseFloat(num1) + Float.parseFloat(tmp);
                case "-" -> res = Float.parseFloat(num1) - Float.parseFloat(tmp);
                case "x" -> res = Float.parseFloat(num1) * Float.parseFloat(tmp);
                case "/" -> res = Float.parseFloat(num1) / Float.parseFloat(tmp);
                default -> res = 0;
            }

            label.setText(String.format(cad));
        }else{
            label.setText(String.format(cad, res));
        }
    }
}