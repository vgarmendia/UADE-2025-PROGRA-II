// Urgencia.java
package com.centroemergencias.modelo;

public enum Urgencia {
    ALTA(3),
    MEDIA(2),
    BAJA(1);

    private final int prioridad;

    Urgencia(int prioridad) {
        this.prioridad = prioridad;
    }

    public int getPrioridad() {
        return prioridad;
    }
}
