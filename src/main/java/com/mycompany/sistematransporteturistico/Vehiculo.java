package com.mycompany.sistematransporteturistico;

    
public abstract class Vehiculo {

    protected String tipo; 
    protected String patente; 
    protected String marca; 
    protected int capacidadPasajeros;
    protected int anioFabricacion;

    public Vehiculo() {
    }

    public Vehiculo(String tipo, String patente, String marca, int capacidadPasajeros, int anioFabricacion) {
        this.tipo = tipo;
        this.patente = patente;
        this.marca = marca;
        this.capacidadPasajeros = capacidadPasajeros;
        this.anioFabricacion = anioFabricacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getCapacidadPasajeros() {
        return capacidadPasajeros;
    }

    public void setCapacidadPasajeros(int capacidadPasajeros) {
        this.capacidadPasajeros = capacidadPasajeros;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(int anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }

    
    public void mostrarDatos() {
    System.out.println("Tipo de vehiculo: " + tipo);
    System.out.println("Patente: " + patente);
    System.out.println("Marca: " + marca);
    System.out.println("Capacidad de pasajeros: " + capacidadPasajeros);
    System.out.println("Anio de fabricacion: " + anioFabricacion);
}
}

    
