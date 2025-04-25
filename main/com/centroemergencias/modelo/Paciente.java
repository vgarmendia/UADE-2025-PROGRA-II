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
