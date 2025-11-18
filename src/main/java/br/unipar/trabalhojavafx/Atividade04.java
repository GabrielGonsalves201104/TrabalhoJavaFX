package br.unipar.trabalhojavafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Atividade04 extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Atividade 4 - Média Escolar");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        grid.add(new Label("Nome do Aluno:"), 0, 0);
        TextField nomeField = new TextField();
        grid.add(nomeField, 1, 0);

        grid.add(new Label("Nota 1:"), 0, 1);
        TextField nota1Field = new TextField();
        grid.add(nota1Field, 1, 1);

        grid.add(new Label("Nota 2:"), 0, 2);
        TextField nota2Field = new TextField();
        grid.add(nota2Field, 1, 2);

        grid.add(new Label("Nota 3:"), 0, 3);
        TextField nota3Field = new TextField();
        grid.add(nota3Field, 1, 3);

        Button btnCalcular = new Button("Calcular Média");
        grid.add(btnCalcular, 0, 4, 2, 1);

        Label lblResultado = new Label("Resultado:");
        grid.add(lblResultado, 0, 5, 2, 1);


        btnCalcular.setOnAction(event -> {
            try {
                String nome = nomeField.getText();
                double n1 = Double.parseDouble(nota1Field.getText());
                double n2 = Double.parseDouble(nota2Field.getText());
                double n3 = Double.parseDouble(nota3Field.getText());

                double media = (n1 + n2 + n3) / 3.0;
                String situacao;

                if (media >= 7.0) {
                    situacao = "Aprovado";
                } else if (media >= 4.0) {
                    situacao = "Recuperação";
                } else {
                    situacao = "Reprovado";
                }

                String resultadoStr = String.format("Aluno %s — média: %.1f — %s.",
                        nome, media, situacao);

                lblResultado.setText(resultadoStr);

            } catch (NumberFormatException e) {
                lblResultado.setText("Erro: Verifique as notas digitadas.");
            }
        });

        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}