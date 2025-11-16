package br.unipar.trabalhojavafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Atividade09 extends Application {

    // Tarifas
    private static final double TARIFA_RESIDENCIAL = 0.60;
    private static final double TARIFA_COMERCIAL = 0.48;
    private static final double TARIFA_INDUSTRIAL = 0.75;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Atividade 9 - Conta de Luz");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // Entradas
        grid.add(new Label("Nome do Cliente:"), 0, 0);
        TextField nomeField = new TextField();
        grid.add(nomeField, 1, 0);

        grid.add(new Label("Consumo (kWh):"), 0, 1);
        TextField consumoField = new TextField();
        grid.add(consumoField, 1, 1);

        grid.add(new Label("Tipo de Residência:"), 0, 2);
        ComboBox<String> tipoBox = new ComboBox<>();
        tipoBox.getItems().addAll("Residencial", "Comercial", "Industrial");
        tipoBox.setValue("Residencial"); // Valor padrão
        grid.add(tipoBox, 1, 2);

        // Botão
        Button btnCalcular = new Button("Calcular Conta");
        grid.add(btnCalcular, 0, 3, 2, 1);

        // Resultado
        Label lblResultado = new Label("Resultado:");
        grid.add(lblResultado, 0, 4, 2, 1);

        // --- Lógica de Eventos ---
        btnCalcular.setOnAction(event -> {
            try {
                String nome = nomeField.getText();
                double consumo = Double.parseDouble(consumoField.getText());
                String tipo = tipoBox.getValue();

                double tarifa;

                switch (tipo) {
                    case "Residencial":
                        tarifa = TARIFA_RESIDENCIAL;
                        break;
                    case "Comercial":
                        tarifa = TARIFA_COMERCIAL;
                        break;
                    case "Industrial":
                        tarifa = TARIFA_INDUSTRIAL;
                        break;
                    default:
                        lblResultado.setText("Erro: Tipo de residência inválido.");
                        return;
                }

                if(nome.isEmpty()) {
                    lblResultado.setText("Erro: Nome não pode estar vazio.");
                    return;
                }

                double valorTotal = consumo * tarifa;

                String resultadoStr = String.format("Cliente: %s — Tipo: %s — Consumo: %.0f kWh — Valor: R$ %.2f",
                        nome, tipo, consumo, valorTotal);

                lblResultado.setText(resultadoStr);

            } catch (NumberFormatException e) {
                lblResultado.setText("Erro: Verifique o valor do consumo.");
            }
        });

        Scene scene = new Scene(grid, 450, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}