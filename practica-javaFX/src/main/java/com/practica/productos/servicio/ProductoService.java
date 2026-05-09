package com.practica.productos.servicio;

import com.practica.productos.modelo.Producto;
import java.util.ArrayList;
import java.util.List;

public class ProductoService {

    private final List<Producto> productos = new ArrayList<>();

    public void agregar(Producto p) {
        productos.add(p);
    }

    public List<Producto> listar() {
        return new ArrayList<>(productos);
    }
}