package br.unipar.trabalhojavafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Atividade01 extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Atividade 1 - Calculadora");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        grid.add(new Label("Número 1:"), 0, 0);
        TextField num1Field = new TextField();
        grid.add(num1Field, 1, 0);

        grid.add(new Label("Número 2:"), 0, 1);
        TextField num2Field = new TextField();
        grid.add(num2Field, 1, 1);

        HBox hboxBotoes = new HBox(10);
        hboxBotoes.setAlignment(Pos.CENTER);
        Button btnSoma = new Button("+");
        Button btnSub = new Button("-");
        Button btnMult = new Button("×");
        Button btnDiv = new Button("÷");
        hboxBotoes.getChildren().addAll(btnSoma, btnSub, btnMult, btnDiv);
        grid.add(hboxBotoes, 0, 2, 2, 1);


        Label lblResultado = new Label("Resultado:");
        grid.add(lblResultado, 0, 3, 2, 1);
        lblResultado.setAlignment(Pos.CENTER);

        btnSoma.setOnAction(event -> {
            try {
                double num1 = Double.parseDouble(num1Field.getText());
                double num2 = Double.parseDouble(num2Field.getText());
                double resultado = num1 + num2;
                lblResultado.setText("Resultado: " + resultado);
            } catch (NumberFormatException e) {
                lblResultado.setText("Erro: Entrada inválida");
            }
        });

        btnSub.setOnAction(event -> {
            try {
                double num1 = Double.parseDouble(num1Field.getText());
                double num2 = Double.parseDouble(num2Field.getText());
                double resultado = num1 - num2;
                lblResultado.setText("Resultado: " + resultado);
            } catch (NumberFormatException e) {
                lblResultado.setText("Erro: Entrada inválida");
            }
        });

        btnMult.setOnAction(event -> {
            try {
                double num1 = Double.parseDouble(num1Field.getText());
                double num2 = Double.parseDouble(num2Field.getText());
                double resultado = num1 * num2;
                lblResultado.setText("Resultado: " + resultado);
            } catch (NumberFormatException e) {
                lblResultado.setText("Erro: Entrada inválida");
            }
        });

        btnDiv.setOnAction(event -> {
            try {
                double num1 = Double.parseDouble(num1Field.getText());
                double num2 = Double.parseDouble(num2Field.getText());
                if (num2 == 0) {
                    lblResultado.setText("Erro: Divisão por zero");
                } else {
                    double resultado = num1 / num2;
                    lblResultado.setText("Resultado: " + resultado);
                }
            } catch (NumberFormatException e) {
                lblResultado.setText("Erro: Entrada inválida");
            }
        });

        Scene scene = new Scene(grid, 350, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}