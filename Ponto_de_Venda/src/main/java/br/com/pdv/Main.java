
package br.com.pdv;

import br.com.pdv.database.CriarBanco;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        CriarBanco.criarTabelas();

        Label texto = new Label("Sistema PDV - Mercado");

        StackPane layout = new StackPane();
        layout.getChildren().add(texto);

        Scene cena = new Scene(layout, 800, 500);

        stage.setTitle("Sistema de Ponto de Venda");
        stage.setScene(cena);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
