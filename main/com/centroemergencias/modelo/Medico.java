//GestorEmergencias.java

package servicio;

import modelo.*;
import implementation.dynamic.*;
import definition.*;

public class GestorEmergencias {

    private PriorityQueueADT pacientes;
    private SetADT medicosDisponibles;
    private MultipleDictionaryADT pacientesAtendidos;

    public GestorEmergencias() {
        pacientes = new DynamicPriorityQueueADT();
        medicosDisponibles = new DynamicSetADT();
        pacientesAtendidos = new DynamicMultipleDictionaryADT();
    }

    public void registrarPaciente(String nombre, Urgencia urgencia) {
        Paciente paciente = new Paciente(nombre, urgencia);
        pacientes.add(nombre.hashCode(), urgencia.getPrioridad());
    }

    public void altaMedico(int idMedico) {
        medicosDisponibles.add(idMedico);
    }

    public void asignarMedico() {
        if (pacientes.isEmpty()) {
            System.out.println("No hay pacientes en espera.");
            return;
        }
        if (medicosDisponibles.isEmpty()) {
            System.out.println("No hay médicos disponibles.");
            return;
        }

        int pacienteId = pacientes.getElement();
        int medico = ((DynamicSetADT) medicosDisponibles).choose();

        pacientes.remove();
        medicosDisponibles.remove(medico);
        pacientesAtendidos.add(medico, pacienteId);

        System.out.println("Médico " + medico + " atiende al paciente ID: " + pacienteId);
    }

    public void liberarMedico(int medicoId) {
        medicosDisponibles.add(medicoId);
    }

    public void reportePendientes() {
        System.out.println("Pacientes pendientes: (no se cuenta size, mostrar hasta que esté vacío)");

        DynamicPriorityQueueADT copia = new DynamicPriorityQueueADT();
        while (!pacientes.isEmpty()) {
            int id = pacientes.getElement();
            int prioridad = pacientes.getPriority();
            System.out.println("Paciente ID: " + id + ", Prioridad: " + prioridad);
            copia.add(id, prioridad);
            pacientes.remove();
        }
        while (!copia.isEmpty()) {
            int id = copia.getElement();
            int prioridad = copia.getPriority();
            pacientes.add(id, prioridad);
            copia.remove();
        }
    }
}
