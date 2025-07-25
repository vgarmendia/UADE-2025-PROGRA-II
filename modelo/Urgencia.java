//Urgencia.java

package modelo;

public enum Urgencia {
    ALTA(1), MEDIA(2), BAJA(3);

    private final int prioridad;

    Urgencia(int prioridad) {
        this.prioridad = prioridad;
    }

    public int getPrioridad() {
        return prioridad;
    }
}
