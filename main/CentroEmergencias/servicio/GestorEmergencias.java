package com.centroemergencias.servicio;

import com.centroemergencias.modelo.Medico;
import com.centroemergencias.modelo.Paciente;
import com.centroemergencias.tda.ColaPrioridad;
import java.util.ArrayList;
import java.util.List;

public class GestorEmergencias {
    private List<Medico> medicos;
    private ColaPrioridad colaPacientes;
    private List<Paciente> pacientesAtendidos;

    public GestorEmergencias() {
        medicos = new ArrayList<>();
        colaPacientes = new ColaPrioridad();
        pacientesAtendidos = new ArrayList<>();
        // Cargar 10 médicos iniciales
        for (int i = 1; i <= 10; i++) {
            medicos.add(new Medico("Medico " + i));
        }
    }

    // Registro de paciente
    public void registrarPaciente(Paciente paciente) {
        colaPacientes.acolar(paciente);
    }

    // Asignar y atender paciente
    public void atenderPaciente() {
        Paciente paciente = colaPacientes.desacolar();
        if (paciente == null) {
            System.out.println("No hay pacientes en espera.");
            return;
        }
        // Buscar médico disponible
        Medico medicoAsignado = null;
        for (Medico medico : medicos) {
            if (medico.isDisponible()) {
                medicoAsignado = medico;
                break;
            }
        }
        if (medicoAsignado == null) {
            System.out.println("No hay médicos disponibles en este momento.");
            // Opcional: Reacolar el paciente o gestionarlo de otra forma.
            return;
        }
        // Asignar el médico y simular la atención
        medicoAsignado.setDisponible(false);
        System.out.println("Atendiendo a " + paciente.getNombre() + " con " + medicoAsignado.getNombre());
        // Simular que finaliza la atención
        medicoAsignado.setDisponible(true);
        pacientesAtendidos.add(paciente);
    }

    // Reporte de pacientes pendientes
    public void mostrarPacientesPendientes() {
        System.out.println("Cantidad de pacientes en espera: " + (colaPacientes.isEmpty() ? 0 : "más de 0"));
        // Aquí podrías implementar un método para contar y mostrar el número exacto
    }
}
