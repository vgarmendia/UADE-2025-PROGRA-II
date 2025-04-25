// GestorEmergencias.java
package com.centroemergencias.servicio;

import com.centroemergencias.modelo.Medico;
import com.centroemergencias.modelo.Paciente;
import com.centroemergencias.tda.ColaPrioridad;
import com.centroemergencias.tda.IPila;
import com.centroemergencias.tda.IVisitante;
import com.centroemergencias.tda.Pila;

public class GestorEmergencias {
    private ColaPrioridad<Paciente> pacientesPendientes;
    private Pila<Medico> medicosDisponibles;
    private Pila<Paciente> pacientesEnAtencion;
    private Pila<Paciente> pacientesAtendidos;

    public GestorEmergencias() {
        pacientesPendientes = new ColaPrioridad<>();
        medicosDisponibles = new Pila<>();
        pacientesEnAtencion = new Pila<>();
        pacientesAtendidos = new Pila<>();
    }

    public void registrarPaciente(Paciente paciente) {
        pacientesPendientes.encolar(paciente, paciente.getUrgencia().getPrioridad());
    }

    public void darDeAltaMedico(Medico medico) {
        medicosDisponibles.apilar(medico);
    }

    public boolean asignarMedicoAPacientePrioritario() {
        if (pacientesPendientes.esVacia() || medicosDisponibles.esVacia()) {
            return false;
        }

        Paciente paciente = pacientesPendientes.desencolar();
        Medico medico = medicosDisponibles.desapilar();

        // Asignar el médico al paciente
        paciente.asignarMedico(medico);
        medico.setDisponible(false);

        // Mover el paciente a la lista de en atención
        pacientesEnAtencion.apilar(paciente);

        return true;
    }

    public Paciente atenderPaciente() {
        if (pacientesEnAtencion.esVacia()) {
            return null;
        }

        Paciente paciente = pacientesEnAtencion.desapilar();
        Medico medico = paciente.getMedicoAsignado();

        // Liberar al médico
        medico.setDisponible(true);
        medicosDisponibles.apilar(medico);

        // Registrar el paciente como atendido
        pacientesAtendidos.apilar(paciente);

        return paciente;
    }

    public int obtenerNumeroPacientesPendientes() {
        return pacientesPendientes.longitud();
    }

    public int obtenerNumeroMedicosDisponibles() {
        return medicosDisponibles.longitud();
    }

    public int obtenerNumeroPacientesAtendidos() {
        return pacientesAtendidos.longitud();
    }

    public void mostrarPacientesPendientes() {
        pacientesPendientes.mostrarElementos(new IVisitante<Paciente>() {
            @Override
            public void visitar(Paciente paciente) {
                System.out.println(paciente);
            }
        });
    }

    public void mostrarMedicosDisponibles() {
        medicosDisponibles.mostrarElementos(new IVisitante<Medico>() {
            @Override
            public void visitar(Medico medico) {
                System.out.println(medico);
            }
        });
    }

    public void mostrarPacientesAtendidos() {
        pacientesAtendidos.mostrarElementos(new IVisitante<Paciente>() {
            @Override
            public void visitar(Paciente paciente) {
                System.out.println(paciente);
            }
        });
    }
}