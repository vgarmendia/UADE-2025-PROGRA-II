package com.centroemergencias.modelo;

public class Medico {
    private String nombre;
    private int id;
    private boolean disponible;

    public Medico(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
        this.disponible = true;  // Al crear un médico, está disponible por defecto
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "Medico{" +
                "nombre='" + nombre + '\'' +
                ", id=" + id +
                ", disponible=" + disponible +
                '}';
    }
}
