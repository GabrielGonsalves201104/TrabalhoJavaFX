package br.unipar.trabalhojavafx;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Atividade07 extends Application {

    private Circle circuloVermelho;
    private Circle circuloAmarelo;
    private Circle circuloVerde;
    private Timeline timeline;
    private int estadoAtual = 0;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Atividade 7 - Semáforo");

        VBox vboxPrincipal = new VBox(20);
        vboxPrincipal.setAlignment(Pos.CENTER);
        vboxPrincipal.setPadding(new Insets(20));

        VBox semaforoBox = new VBox(10);
        semaforoBox.setAlignment(Pos.CENTER);
        semaforoBox.setStyle("-fx-background-color: #333; -fx-padding: 10px; -fx-border-radius: 10; -fx-background-radius: 10;");

        circuloVermelho = new Circle(40, Color.GRAY);
        circuloAmarelo = new Circle(40, Color.GRAY);
        circuloVerde = new Circle(40, Color.GRAY);

        semaforoBox.getChildren().addAll(circuloVermelho, circuloAmarelo, circuloVerde);

        HBox botoesBox = new HBox(10);
        botoesBox.setAlignment(Pos.CENTER);
        Button btnIniciar = new Button("Iniciar");
        Button btnParar = new Button("Parar");
        botoesBox.getChildren().addAll(btnIniciar, btnParar);

        timeline = new Timeline(new KeyFrame(Duration.seconds(2), event -> trocarEstado()));
        timeline.setCycleCount(Timeline.INDEFINITE);

        btnIniciar.setOnAction(event -> {
            if (timeline.getStatus() != Timeline.Status.RUNNING) {

                estadoAtual = 0;
                atualizarLuzes();
                timeline.play();
            }
        });

        btnParar.setOnAction(event -> {
            timeline.stop();

            estadoAtual = -1;
            atualizarLuzes();
        });

        btnParar.fire();

        vboxPrincipal.getChildren().addAll(semaforoBox, botoesBox);
        Scene scene = new Scene(vboxPrincipal, 250, 350);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void trocarEstado() {

        estadoAtual = (estadoAtual + 1) % 3;
        atualizarLuzes();
    }

    private void atualizarLuzes() {
        switch (estadoAtual) {
            case 0:
                circuloVermelho.setFill(Color.RED);
                circuloAmarelo.setFill(Color.GRAY);
                circuloVerde.setFill(Color.GRAY);
                break;
            case 1:
                circuloVermelho.setFill(Color.GRAY);
                circuloAmarelo.setFill(Color.YELLOW);
                circuloVerde.setFill(Color.GRAY);
                break;
            case 2:
                circuloVermelho.setFill(Color.GRAY);
                circuloAmarelo.setFill(Color.GRAY);
                circuloVerde.setFill(Color.GREEN);
                break;
            default:
                circuloVermelho.setFill(Color.GRAY);
                circuloAmarelo.setFill(Color.GRAY);
                circuloVerde.setFill(Color.GRAY);
                break;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}   