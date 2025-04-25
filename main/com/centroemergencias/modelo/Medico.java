package com.centroemergencias.modelo;

public class Medico {
    private String nombre;
    private boolean disponible;

    public Medico(String nombre) {
        this.nombre = nombre;
        this.disponible = true; // Inicialmente, el médico está disponible
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return nombre + " (Disponible: " + disponible + ")";
    }
}
