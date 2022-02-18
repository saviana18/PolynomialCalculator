package org.example;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import static org.example.Operations.additionOperation;
import static org.example.Operations.subtractionOperation;
import static org.example.Operations.multiplicationOperation;
import static org.example.Operations.derivativeOperation;
import static org.example.Operations.sortPolynomial;

public class PrimaryController {

    @FXML private TextField resField;
    @FXML private TextField firstField;
    @FXML private TextField secondField;
    private boolean firstFocus = false;
    private boolean secondFocus = false;

    @FXML
    public void addOperation(ActionEvent actionEvent) {
        resField.clear();

        Polynomial polynomial = new Polynomial();
        polynomial.monomials = polynomial.parsePolynomial(firstField.getText());
        Polynomial polynomial1 = new Polynomial();
        polynomial1.monomials = polynomial.parsePolynomial(secondField.getText());

        System.out.println(firstField.getText());
        System.out.println(secondField.getText());
        Polynomial result = new Polynomial();
        result = additionOperation(polynomial, polynomial1);
        sortPolynomial(result);

        StringBuilder res = new StringBuilder();
        for (Monomial monomial : result.getPolynomial()) {
            res.append(monomial);
        }
        resField.setText(res.toString());
        if(resField.getText() == null || resField.getText().trim().isEmpty()) {
            firstField.clear();
            secondField.clear();
            resField.setText("Wrong input");
        }
    }

    @FXML
    public void subOperation(ActionEvent actionEvent) {
        resField.clear();

        Polynomial polynomial = new Polynomial();
        polynomial.monomials = polynomial.parsePolynomial(firstField.getText());
        Polynomial polynomial1 = new Polynomial();
        polynomial1.monomials = polynomial.parsePolynomial(secondField.getText());

        System.out.println(firstField.getText());
        System.out.println(secondField.getText());
        Polynomial result = new Polynomial();
        result = subtractionOperation(polynomial, polynomial1);
        sortPolynomial(result);

        StringBuilder res = new StringBuilder();
        for (Monomial monomial : result.getPolynomial()) {
            res.append(monomial);
        }
        resField.setText(res.toString());

        if(resField.getText() == null || resField.getText().trim().isEmpty()) {
            firstField.clear();
            secondField.clear();
            resField.setText("Wrong input");
        }
    }

    @FXML
    public void mulOperation(ActionEvent actionEvent) {
        resField.clear();

        Polynomial polynomial = new Polynomial();
        polynomial.monomials = polynomial.parsePolynomial(firstField.getText());
        Polynomial polynomial1 = new Polynomial();
        polynomial1.monomials = polynomial.parsePolynomial(secondField.getText());

        System.out.println(firstField.getText());
        System.out.println(secondField.getText());
        Polynomial result = new Polynomial();
        result = multiplicationOperation(polynomial, polynomial1);
        sortPolynomial(result);

        StringBuilder res = new StringBuilder();
        for (Monomial monomial : result.getPolynomial()) {
            res.append(monomial);
        }
        resField.setText(res.toString());

        if(resField.getText() == null || resField.getText().trim().isEmpty()) {
            firstField.clear();
            secondField.clear();
            resField.setText("Wrong input");
        }
    }

    @FXML
    public void divOperation(ActionEvent actionEvent) {
        resField.setText("Not implemented yet");
        //System.out.println("Not implemented yet");
    }

    @FXML
    public void derOperation(ActionEvent actionEvent) {
        resField.clear();

        Polynomial polynomial = new Polynomial();
        polynomial.monomials = polynomial.parsePolynomial(firstField.getText());

        System.out.println(firstField.getText());
        Polynomial result = new Polynomial();
        result = derivativeOperation(polynomial);
        sortPolynomial(result);

        StringBuilder res = new StringBuilder();
        for (Monomial monomial : result.getPolynomial()) {
            res.append(monomial);
        }
        resField.setText(res.toString());

        if(resField.getText() == null || resField.getText().trim().isEmpty()) {
            firstField.clear();
            resField.setText("Wrong input");
        }
    }

    @FXML
    public void intOperation(ActionEvent actionEvent) {
        resField.setText("Not implemented yet");
        //System.out.println("Not implemented yet");
    }

    @FXML
    public void processButtons(ActionEvent actionEvent) {
        String value = ((Button)actionEvent.getSource()).getText();

        firstField.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                firstFocus = true;
                secondFocus = false;
            }
        });
        secondField.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                firstFocus = false;
                secondFocus = true;
            }
        });

        if(firstFocus)
            firstField.setText(firstField.getText()+value);
        else if(secondFocus)
            secondField.setText(secondField.getText()+value);
    }

    @FXML
    public void clearAll(ActionEvent actionEvent) {
        resField.clear();
        firstField.clear();
        secondField.clear();
    }
}
