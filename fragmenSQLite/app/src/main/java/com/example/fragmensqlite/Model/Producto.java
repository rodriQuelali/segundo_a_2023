package com.example.fragmensqlite.Model;

public class Producto {
    private int codigo;
    private int descripcion;
    private double precio;

    //los metodos de producto


    public int getCod() {
        return codigo;
    }

    public void setCod(int cod) {
        this.codigo = codigo;
    }

    public int getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(int descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
