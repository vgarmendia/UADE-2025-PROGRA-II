// Archivo: Main.java

import java.util.Scanner;
import modelo.Urgencia;
import servicio.GestorEmergencias;

public class Main {
    public static void main(String[] args) {
        GestorEmergencias sistema = new GestorEmergencias();
        Scanner scanner = new Scanner(System.in);

        // Datos iniciales
        for (int i = 1; i <= 10; i++) {
            sistema.altaMedico(i);
        }
        sistema.registrarPaciente("Paciente 1", Urgencia.ALTA);
        sistema.registrarPaciente("Paciente 2", Urgencia.MEDIA);
        sistema.registrarPaciente("Paciente 3", Urgencia.BAJA);

        while (true) {
            System.out.println("\n--- Menú de Centro de Emergencias ---");
            System.out.println("1. Registrar paciente");
            System.out.println("2. Dar de alta médico");
            System.out.println("3. Asignar médico a paciente");
            System.out.println("4. Liberar médico");
            System.out.println("5. Ver pacientes pendientes");
            System.out.println("0. Salir");
            System.out.print("Ingrese una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del paciente: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Nivel de urgencia (ALTA, MEDIA, BAJA): ");
                    String urg = scanner.nextLine().toUpperCase();
                    sistema.registrarPaciente(nombre, Urgencia.valueOf(urg));
                    break;
                case 2:
                    System.out.print("ID del médico: ");
                    int idMedico = scanner.nextInt();
                    sistema.altaMedico(idMedico);
                    break;
                case 3:
                    sistema.asignarMedico();
                    break;
                case 4:
                    System.out.print("ID del médico a liberar: ");
                    int idLib = scanner.nextInt();
                    sistema.liberarMedico(idLib);
                    break;
                case 5:
                    sistema.reportePendientes();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema.");
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}
