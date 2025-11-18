package br.unipar.trabalhojavafx;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Atividade05 extends Application {

    private TableView<Aluno> tabelaAlunos = new TableView<>();
    private ObservableList<Aluno> listaAlunos = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Atividade 5 - Cadastro de Alunos");

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20));
        vbox.setAlignment(Pos.CENTER);

        HBox formBox = new HBox(10);
        formBox.setAlignment(Pos.CENTER);

        TextField nomeField = new TextField();
        nomeField.setPromptText("Nome");

        TextField idadeField = new TextField();
        idadeField.setPromptText("Idade");
        idadeField.setPrefWidth(60);

        ComboBox<String> cursoBox = new ComboBox<>();
        cursoBox.setPromptText("Curso");
        cursoBox.getItems().addAll("Eng. de Software", "Ciência da Computação", "Sistemas de Informação", "Análise de Sistemas");

        formBox.getChildren().addAll(new Label("Nome:"), nomeField, new Label("Idade:"), idadeField, new Label("Curso:"), cursoBox);

        HBox botoesBox = new HBox(10);
        botoesBox.setAlignment(Pos.CENTER);
        Button btnAdicionar = new Button("Adicionar");
        Button btnExcluir = new Button("Excluir");
        botoesBox.getChildren().addAll(btnAdicionar, btnExcluir);

        TableColumn<Aluno, String> colNome = new TableColumn<>("Nome");
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colNome.setMinWidth(150);

        TableColumn<Aluno, Integer> colIdade = new TableColumn<>("Idade");
        colIdade.setCellValueFactory(new PropertyValueFactory<>("idade"));
        colIdade.setMinWidth(80);

        TableColumn<Aluno, String> colCurso = new TableColumn<>("Curso");
        colCurso.setCellValueFactory(new PropertyValueFactory<>("curso"));
        colCurso.setMinWidth(200);

        tabelaAlunos.getColumns().addAll(colNome, colIdade, colCurso);
        tabelaAlunos.setItems(listaAlunos);

        btnAdicionar.setOnAction(event -> {
            try {
                String nome = nomeField.getText();
                int idade = Integer.parseInt(idadeField.getText());
                String curso = cursoBox.getValue();

                if (nome != null && !nome.isEmpty() && curso != null) {
                    listaAlunos.add(new Aluno(nome, idade, curso));

                    nomeField.clear();
                    idadeField.clear();
                    cursoBox.setValue(null);
                }
            } catch (NumberFormatException e) {

                System.out.println("Erro: Idade inválida.");
            }
        });

        btnExcluir.setOnAction(event -> {
            Aluno alunoSelecionado = tabelaAlunos.getSelectionModel().getSelectedItem();
            if (alunoSelecionado != null) {
                listaAlunos.remove(alunoSelecionado);
            }
        });

        vbox.getChildren().addAll(formBox, botoesBox, tabelaAlunos);

        Scene scene = new Scene(vbox, 550, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static class Aluno {
        private String nome;
        private int idade;
        private String curso;

        public Aluno(String nome, int idade, String curso) {
            this.nome = nome;
            this.idade = idade;
            this.curso = curso;
        }

        public String getNome() {
            return nome;
        }

        public int getIdade() {
            return idade;
        }

        public String getCurso() {
            return curso;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
