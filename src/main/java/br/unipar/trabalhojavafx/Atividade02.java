package br.unipar.trabalhojavafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Atividade02 extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Atividade 2 - Conversor de Temperatura");

        VBox vbox = new VBox(15);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(25, 25, 25, 25));
        HBox entradaBox = new HBox(10);
        entradaBox.setAlignment(Pos.CENTER);
        Label lblInstrucao = new Label("Digite a Temperatura:");
        TextField tempField = new TextField();
        tempField.setPromptText("Ex: 30");
        tempField.setPrefWidth(100);
        entradaBox.getChildren().addAll(lblInstrucao, tempField);

        HBox botoesBox = new HBox(10);
        botoesBox.setAlignment(Pos.CENTER);
        Button btnParaF = new Button("Converter para °F");
        Button btnParaC = new Button("Converter para °C");
        botoesBox.getChildren().addAll(btnParaF, btnParaC);

        Label lblResultado = new Label("Resultado:");


        btnParaF.setOnAction(event -> {
            try {
                double tempC = Double.parseDouble(tempField.getText());
                double tempF = (tempC * 9.0 / 5.0) + 32;
                lblResultado.setText(String.format("%.1f °C equivalem a %.1f °F", tempC, tempF));
            } catch (NumberFormatException e) {
                lblResultado.setText("Erro: Entrada inválida");
            }
        });

        btnParaC.setOnAction(event -> {
            try {
                double tempF = Double.parseDouble(tempField.getText());
                double tempC = (tempF - 32) * (5.0 / 9.0);
                lblResultado.setText(String.format("%.1f °F equivalem a %.1f °C", tempF, tempC));
            } catch (NumberFormatException e) {
                lblResultado.setText("Erro: Entrada inválida");
            }
        });

        vbox.getChildren().addAll(entradaBox, botoesBox, lblResultado);

        Scene scene = new Scene(vbox, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}