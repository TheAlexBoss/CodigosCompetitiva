package com.competitive;

public class Ordenacion {

    private char orientacion;
    private int ordenEntrada;
    private int numTags;

    public Ordenacion(char orientacion, int ordenEntrada, int numTags) {
        this.orientacion = orientacion;
        this.ordenEntrada = ordenEntrada;
        this.numTags = numTags;
    }

    public void setOrdenEntrada(int ordenEntrada) {
        this.ordenEntrada = ordenEntrada;
    }

    public void setNumTags(int numTags) {
        this.numTags = numTags;
    }

    public void setOrientacion(char orientacion) {
        this.orientacion = orientacion;
    }

    public char getOrientacion() {
        return orientacion;
    }

    public int getOrdenEntrada() {
        return ordenEntrada;
    }

    public int getNumTags() {
        return numTags;
    }
}
