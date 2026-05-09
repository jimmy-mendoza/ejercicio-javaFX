package com.practica.productos.app;

import com.practica.productos.modelo.Producto;
import com.practica.productos.servicio.ProductoService;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    ProductoService servicio = new ProductoService();

    @Override
    public void start(Stage stage) {
        TextField campo = new TextField();
        Button boton = new Button("Agregar");

        // ✅ TextArea en lugar de Label
        TextArea area = new TextArea();
        area.setEditable(false);

        boton.setOnAction(e -> {
            try {
                servicio.agregar(new Producto(campo.getText()));
                String texto = "";
                for (Producto p : servicio.listar()) {
                    texto += p.getNombre() + "\n";
                }
                area.setText(texto);
                campo.clear();
            } catch (Exception ex) {
                area.setText(ex.getMessage());
            }
        });

        VBox layout = new VBox(10, campo, boton, area);
        Scene scene = new Scene(layout, 300, 300);
        stage.setScene(scene);
        stage.setTitle("Productos");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}