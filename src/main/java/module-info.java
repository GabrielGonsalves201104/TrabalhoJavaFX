module br.unipar.trabalhojavafx {
    requires javafx.controls;
    requires javafx.fxml;

    // Esta linha substitui o .base e o .animation
    requires javafx.graphics;

    opens br.unipar.trabalhojavafx to javafx.fxml;
    exports br.unipar.trabalhojavafx;
}