package com.example.fragmensqlite.Model;

public class Producto {
    private int codigo;
    private String descripcion;
    private double precio;

    public Producto(int codigo, String descripcion, double precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public Producto(int codigo) {
        this.codigo = codigo;
    }
//los metodos de producto

    public Double calIVA(){
        return this.precio * 0.16;
    }

    public Double calTotal(Producto c){
        return c.calIVA() + this.precio +(this.precio*0.05);
    }
    public int getCod() {
        return codigo;
    }

    public void setCod(int cod) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
