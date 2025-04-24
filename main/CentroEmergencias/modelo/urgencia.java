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

// Paciente.java
package com.centroemergencias.modelo;

public class Paciente {
    private String nombre;
    private Urgencia urgencia;
    private Medico medicoAsignado;

    public Paciente(String nombre, Urgencia urgencia) {
        this.nombre = nombre;
        this.urgencia = urgencia;
        this.medicoAsignado = null;
    }

    public String getNombre() {
        return nombre;
    }

    public Urgencia getUrgencia() {
        return urgencia;
    }

    public Medico getMedicoAsignado() {
        return medicoAsignado;
    }

    public void asignarMedico(Medico medico) {
        this.medicoAsignado = medico;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "nombre='" + nombre + '\'' +
                ", urgencia=" + urgencia +
                ", medicoAsignado=" + (medicoAsignado != null ? medicoAsignado.getNombre() : "sin asignar") +
                '}';
    }
}

// Medico.java
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