package com.practica.productos.modelo;

public class Producto {
    private String nombre;

    public Producto(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("Nombre inválido");
        }
        this.nombre = nombre.trim();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("Nombre inválido");
        }
        this.nombre = nombre.trim();
    }

    @Override
    public String toString() {
        return nombre;
    }
}