package com.example.rest_http.model;

public class Carrera {
    private int id;
    private String nombre;
    private String estado;
    private int rango;
    private String tipo;

    public Carrera(int id, String nombre, String estado, int rango, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
        this.rango = rango;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getRango() {
        return rango;
    }

    public void setRango(int rango) {
        this.rango = rango;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
