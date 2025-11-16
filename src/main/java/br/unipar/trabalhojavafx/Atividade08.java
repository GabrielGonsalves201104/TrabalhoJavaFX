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
import java.util.Random;

public class Atividade08 extends Application {

    private int numeroSecreto;
    private Random random = new Random();
    private Label lblResultado;
    private TextField tentativaField;
    private Button btnVerificar;
    private Button btnTentarNovamente;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Atividade 8 - Jogo de Adivinhação");

        VBox vbox = new VBox(15);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(25));

        Label lblInstrucao = new Label("Eu sorteei um número de 1 a 10. Tente adivinhar!");

        // Caixa de entrada
        HBox entradaBox = new HBox(10);
        entradaBox.setAlignment(Pos.CENTER);
        Label lblTentativa = new Label("Sua tentativa:");
        tentativaField = new TextField();
        tentativaField.setPrefWidth(60);
        entradaBox.getChildren().addAll(lblTentativa, tentativaField);

        // Botões
        HBox botoesBox = new HBox(10);
        botoesBox.setAlignment(Pos.CENTER);
        btnVerificar = new Button("Verificar");
        btnTentarNovamente = new Button("Tentar Novamente");
        botoesBox.getChildren().addAll(btnVerificar, btnTentarNovamente);

        // Resultado
        lblResultado = new Label("Boa sorte!");

        // --- Lógica de Eventos ---
        btnVerificar.setOnAction(event -> verificarTentativa());

        btnTentarNovamente.setOnAction(event -> iniciarNovoJogo());

        // Inicia o primeiro jogo
        iniciarNovoJogo();

        vbox.getChildren().addAll(lblInstrucao, entradaBox, botoesBox, lblResultado);
        Scene scene = new Scene(vbox, 400, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Inicia um novo jogo
    private void iniciarNovoJogo() {
        numeroSecreto = random.nextInt(10) + 1; // Gera número de 1 a 10
        lblResultado.setText("Novo jogo! Digite um número.");
        tentativaField.clear();
        tentativaField.setDisable(false); // Habilita o campo
        btnVerificar.setDisable(false);   // Habilita o botão
        btnTentarNovamente.setDisable(true); // Desabilita o "Tentar Novamente"
    }

    // Verifica a tentativa do usuário
    private void verificarTentativa() {
        try {
            int tentativa = Integer.parseInt(tentativaField.getText());

            if (tentativa < 1 || tentativa > 10) {
                lblResultado.setText("Digite um número entre 1 e 10.");
                return;
            }

            if (tentativa == numeroSecreto) {
                lblResultado.setText("Acertou! Parabéns!");
                // Fim de jogo
                tentativaField.setDisable(true);
                btnVerificar.setDisable(true);
                btnTentarNovamente.setDisable(false);
            } else {
                lblResultado.setText("Errou! O número era " + numeroSecreto + ".");
                // Fim de jogo
                tentativaField.setDisable(true);
                btnVerificar.setDisable(true);
                btnTentarNovamente.setDisable(false);
            }

        } catch (NumberFormatException e) {
            lblResultado.setText("Erro: Digite um número válido.");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}