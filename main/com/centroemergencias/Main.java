// Main.java (Entry point)
package com.centroemergencias;

import com.centroemergencias.modelo.Medico;
import com.centroemergencias.modelo.Paciente;
import com.centroemergencias.modelo.Urgencia;
import com.centroemergencias.servicio.GestorEmergencias;

import java.util.Scanner;

public class Main {
    private static GestorEmergencias gestor = new GestorEmergencias();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        inicializarDatosIniciales();
        mostrarMenu();
    }

    private static void inicializarDatosIniciales() {
        // Inicialización con 10 médicos
        for (int i = 1; i <= 10; i++) {
            gestor.darDeAltaMedico(new Medico("Médico " + i, i));
        }

        // Pacientes iniciales
        gestor.registrarPaciente(new Paciente("Paciente 1", Urgencia.ALTA));
        gestor.registrarPaciente(new Paciente("Paciente 2", Urgencia.MEDIA));
        gestor.registrarPaciente(new Paciente("Paciente 3", Urgencia.BAJA));

        System.out.println("Sistema inicializado con 10 médicos y 3 pacientes");
    }

    private static void mostrarMenu() {
        boolean salir = false;

        while (!salir) {
            System.out.println("\n----- CENTRO DE EMERGENCIAS -----");
            System.out.println("1. Registrar nuevo paciente");
            System.out.println("2. Dar de alta nuevo médico");
            System.out.println("3. Asignar médico a paciente prioritario");
            System.out.println("4. Atender paciente y liberar médico");
            System.out.println("5. Mostrar pacientes pendientes");
            System.out.println("6. Mostrar médicos disponibles");
            System.out.println("7. Mostrar pacientes atendidos");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (opcion) {
                case 1:
                    registrarPaciente();
                    break;
                case 2:
                    darDeAltaMedico();
                    break;
                case 3:
                    asignarMedico();
                    break;
                case 4:
                    atenderPaciente();
                    break;
                case 5:
                    mostrarPacientesPendientes();
                    break;
                case 6:
                    mostrarMedicosDisponibles();
                    break;
                case 7:
                    mostrarPacientesAtendidos();
                    break;
                case 8:
                    salir = true;
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }

    private static void registrarPaciente() {
        System.out.print("Nombre del paciente: ");
        String nombre = scanner.nextLine();

        System.out.println("Nivel de urgencia (1: ALTA, 2: MEDIA, 3: BAJA): ");
        int nivelUrgencia = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Urgencia urgencia;
        switch (nivelUrgencia) {
            case 1:
                urgencia = Urgencia.ALTA;
                break;
            case 2:
                urgencia = Urgencia.MEDIA;
                break;
            case 3:
                urgencia = Urgencia.BAJA;
                break;
            default:
                System.out.println("Nivel de urgencia no válido. Se asignará BAJA por defecto.");
                urgencia = Urgencia.BAJA;
        }

        Paciente paciente = new Paciente(nombre, urgencia);
        gestor.registrarPaciente(paciente);
        System.out.println("Paciente registrado correctamente con urgencia " + urgencia);
    }

    private static void darDeAltaMedico() {
        System.out.print("Nombre del médico: ");
        String nombre = scanner.nextLine();

        System.out.print("ID del médico: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Medico medico = new Medico(nombre, id);
        gestor.darDeAltaMedico(medico);
        System.out.println("Médico registrado correctamente");
    }

    private static void asignarMedico() {
        boolean asignado = gestor.asignarMedicoAPacientePrioritario();
        if (asignado) {
            System.out.println("Médico asignado correctamente al paciente prioritario");
        } else {
            System.out.println("No hay médicos disponibles o no hay pacientes pendientes");
        }
    }

    private static void atenderPaciente() {
        Paciente paciente = gestor.atenderPaciente();
        if (paciente != null) {
            System.out.println("Paciente " + paciente.getNombre() + " atendido correctamente");
            System.out.println("Médico liberado");
        } else {
            System.out.println("No hay pacientes en atención");
        }
    }

    private static void mostrarPacientesPendientes() {
        int pendientes = gestor.obtenerNumeroPacientesPendientes();
        System.out.println("Número de pacientes pendientes de atención: " + pendientes);

        System.out.println("\nDetalle de pacientes pendientes:");
        gestor.mostrarPacientesPendientes();
    }

    private static void mostrarMedicosDisponibles() {
        int disponibles = gestor.obtenerNumeroMedicosDisponibles();
        System.out.println("Número de médicos disponibles: " + disponibles);

        System.out.println("\nDetalle de médicos disponibles:");
        gestor.mostrarMedicosDisponibles();
    }

    private static void mostrarPacientesAtendidos() {
        int atendidos = gestor.obtenerNumeroPacientesAtendidos();
        System.out.println("Número de pacientes atendidos: " + atendidos);

        System.out.println("\nDetalle de pacientes atendidos:");
        gestor.mostrarPacientesAtendidos();
    }
}
