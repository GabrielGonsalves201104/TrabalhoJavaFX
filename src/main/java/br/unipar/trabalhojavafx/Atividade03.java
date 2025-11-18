package br.unipar.trabalhojavafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Atividade03 extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Atividade 3 - Cadastro e Análise");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        grid.add(new Label("Nome:"), 0, 0);
        TextField nomeField = new TextField();
        grid.add(nomeField, 1, 0);

        grid.add(new Label("Idade:"), 0, 1);
        TextField idadeField = new TextField();
        grid.add(idadeField, 1, 1);

        grid.add(new Label("Sexo:"), 0, 2);
        ComboBox<String> sexoBox = new ComboBox<>();
        sexoBox.getItems().addAll("Masculino", "Feminino", "Outro");
        sexoBox.setValue("Masculino");
        grid.add(sexoBox, 1, 2);

        grid.add(new Label("Interesses:"), 0, 3);
        CheckBox esportesCheck = new CheckBox("Gosta de praticar esportes");
        grid.add(esportesCheck, 1, 3);


        Button btnAnalisar = new Button("Analisar");
        grid.add(btnAnalisar, 0, 4, 2, 1);

        Label lblResumo = new Label("Resumo:");
        Label lblObservacao = new Label("Observação:");

        VBox resultadosVBox = new VBox(5, lblResumo, lblObservacao);
        grid.add(resultadosVBox, 0, 5, 2, 1);

        btnAnalisar.setOnAction(event -> {
            try {

                String nome = nomeField.getText();
                int idade = Integer.parseInt(idadeField.getText());
                String sexo = sexoBox.getValue();
                boolean gostaDeEsportes = esportesCheck.isSelected();


                String gostaEsportesStr = gostaDeEsportes ? "gosta de esportes" : "não gosta de esportes";
                String resumo = String.format("%s, %d anos, do sexo %s, %s.",
                        nome, idade, sexo.toLowerCase(), gostaEsportesStr);

                lblResumo.setText(resumo);

                if (idade < 18) {
                    lblObservacao.setText("Observação: Menor de idade.");
                } else {
                    lblObservacao.setText("Observação: Maior de idade.");
                }

            } catch (NumberFormatException e) {
                lblResumo.setText("Erro: Idade inválida.");
                lblObservacao.setText("");
            } catch (Exception e) {
                lblResumo.setText("Erro: Verifique os dados.");
                lblObservacao.setText("");
            }
        });

        Scene scene = new Scene(grid, 450, 350);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}