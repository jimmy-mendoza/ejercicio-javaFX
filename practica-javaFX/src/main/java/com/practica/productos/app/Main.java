package com.practica.productos.app;

import com.practica.productos.modelo.Producto;
import com.practica.productos.servicio.ProductoService;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    ProductoService servicio = new ProductoService();

    @Override
    public void start(Stage stage) {
        TextField campo = new TextField();
        campo.setPromptText("Nombre del producto...");

        // ✅ Botones
        Button agregar  = new Button("Agregar");
        Button eliminar = new Button("Eliminar");
        Button buscar   = new Button("Buscar");

        TextArea area = new TextArea();
        area.setEditable(false);

        // ✅ Agregar
        agregar.setOnAction(e -> {
            try {
                servicio.agregar(new Producto(campo.getText()));
                actualizarLista(area);
                campo.clear();
            } catch (Exception ex) {
                area.setText(ex.getMessage());
            }
        });

        // ✅ Eliminar
        eliminar.setOnAction(e -> {
            servicio.eliminar(campo.getText());
            actualizarLista(area);
            campo.clear();
        });

        // ✅ Buscar
        buscar.setOnAction(e -> {
            Producto p = servicio.buscar(campo.getText());
            if (p != null) {
                area.setText("✅ Encontrado: " + p.getNombre());
            } else {
                area.setText("❌ No encontrado");
            }
        });

        HBox botones = new HBox(10, agregar, eliminar, buscar);
        VBox layout  = new VBox(10, campo, botones, area);
        Scene scene  = new Scene(layout, 350, 300);
        stage.setScene(scene);
        stage.setTitle("CRUD Productos");
        stage.show();
    }

    // ✅ Método para refrescar la lista
    private void actualizarLista(TextArea area) {
        String texto = "";
        for (Producto p : servicio.listar()) {
            texto += "• " + p.getNombre() + "\n";
        }
        area.setText(texto);
    }

    public static void main(String[] args) {
        launch(args);
    }
}