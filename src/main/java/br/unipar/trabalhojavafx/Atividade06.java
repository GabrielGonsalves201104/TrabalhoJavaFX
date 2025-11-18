package br.unipar.trabalhojavafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Atividade06 extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Atividade 6 - Montagem de Lanche");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER_LEFT);
        grid.setHgap(10);
        grid.setVgap(15);
        grid.setPadding(new Insets(25, 25, 25, 25));

        grid.add(new Label("Nome do Cliente:"), 0, 0);
        TextField nomeClienteField = new TextField();
        grid.add(nomeClienteField, 1, 0);

        grid.add(new Label("Tipo de Pão:"), 0, 1);
        ComboBox<String> paoBox = new ComboBox<>();
        paoBox.getItems().addAll("Francês", "Integral", "Australiano");
        paoBox.setValue("Integral");
        grid.add(paoBox, 1, 1);

        grid.add(new Label("Tipo de Carne:"), 0, 2);
        ToggleGroup carneGroup = new ToggleGroup();
        RadioButton rbBovina = new RadioButton("Bovina");
        rbBovina.setToggleGroup(carneGroup);
        rbBovina.setSelected(true);

        RadioButton rbFrango = new RadioButton("Frango");
        rbFrango.setToggleGroup(carneGroup);

        RadioButton rbSoja = new RadioButton("Soja");
        rbSoja.setToggleGroup(carneGroup);

        HBox carneBox = new HBox(10, rbBovina, rbFrango, rbSoja);
        grid.add(carneBox, 1, 2);

        grid.add(new Label("Adicionais:"), 0, 3);
        CheckBox cbQueijo = new CheckBox("Queijo");
        CheckBox cbBacon = new CheckBox("Bacon");
        CheckBox cbSalada = new CheckBox("Salada");
        CheckBox cbMolho = new CheckBox("Molho");
        VBox adicionaisBox = new VBox(5, cbQueijo, cbBacon, cbSalada, cbMolho);
        grid.add(adicionaisBox, 1, 3);

        Button btnGerarPedido = new Button("Gerar Pedido");
        grid.add(btnGerarPedido, 0, 4, 2, 1);

        Label lblResumo = new Label("Resumo do Pedido:");
        grid.add(lblResumo, 0, 5, 2, 1);

        btnGerarPedido.setOnAction(event -> {
            StringBuilder resumo = new StringBuilder();

            String nome = nomeClienteField.getText();
            if (nome.isEmpty()) {
                lblResumo.setText("Erro: Digite o nome do cliente.");
                return;
            }
            resumo.append("Pedido de ").append(nome).append(": ");

            String pao = paoBox.getValue();
            resumo.append("pão ").append(pao.toLowerCase());

            RadioButton carneSelecionada = (RadioButton) carneGroup.getSelectedToggle();
            String carne = carneSelecionada.getText();
            resumo.append(" com carne ").append(carne.toLowerCase());

            List<String> adicionais = new ArrayList<>();
            if (cbQueijo.isSelected()) adicionais.add("queijo");
            if (cbBacon.isSelected()) adicionais.add("bacon");
            if (cbSalada.isSelected()) adicionais.add("salada");
            if (cbMolho.isSelected()) adicionais.add("molho");

            if (!adicionais.isEmpty()) {
                resumo.append(", com ");
                for (int i = 0; i < adicionais.size(); i++) {
                    resumo.append(adicionais.get(i));
                    if (i < adicionais.size() - 2) {
                        resumo.append(", ");
                    } else if (i == adicionais.size() - 2) {
                        resumo.append(" e ");
                    }
                }
            }
            resumo.append(".");

            lblResumo.setText(resumo.toString());
        });

        Scene scene = new Scene(grid, 500, 450);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}