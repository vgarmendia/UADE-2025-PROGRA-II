package com.centroemergencias;

import com.centroemergencias.modelo.Paciente;
import com.centroemergencias.modelo.Urgencia;
import com.centroemergencias.servicio.GestorEmergencias;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestorEmergencias gestor = new GestorEmergencias();
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("=== Menú Centro de Emergencias ===");
            System.out.println("1. Registrar paciente");
            System.out.println("2. Atender paciente");
            System.out.println("3. Mostrar pacientes pendientes");
            System.out.println("0. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del paciente: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el nivel de urgencia (ALTA, MEDIA, BAJA): ");
                    String nivel = scanner.nextLine().toUpperCase();
                    Paciente paciente = new Paciente(nombre, Urgencia.valueOf(nivel));
                    gestor.registrarPaciente(paciente);
                    break;
                case 2:
                    gestor.atenderPaciente();
                    break;
                case 3:
                    gestor.mostrarPacientesPendientes();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
        scanner.close();
    }
}
