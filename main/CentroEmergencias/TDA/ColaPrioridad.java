package com.centroemergencias.tda;

import com.centroemergencias.modelo.Paciente;
import com.centroemergencias.modelo.Urgencia;

public class ColaPrioridad {
    private Nodo cabeza;

    private class Nodo {
        Paciente paciente;
        Nodo siguiente;

        Nodo(Paciente paciente) {
            this.paciente = paciente;
        }
    }

    public ColaPrioridad() {
        cabeza = null;
    }

    public boolean isEmpty() {
        return cabeza == null;
    }

    // Método para insertar en orden de prioridad (ALTA > MEDIA > BAJA)
    public void acolar(Paciente paciente) {
        Nodo nuevo = new Nodo(paciente);
        // Si la cola está vacía o la urgencia del nuevo paciente es mayor que la cabeza
        if (isEmpty() || paciente.getUrgencia().ordinal() < cabeza.paciente.getUrgencia().ordinal()) {
            nuevo.siguiente = cabeza;
            cabeza = nuevo;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null &&
                    paciente.getUrgencia().ordinal() >= actual.siguiente.paciente.getUrgencia().ordinal()) {
                actual = actual.siguiente;
            }
            nuevo.siguiente = actual.siguiente;
            actual.siguiente = nuevo;
        }
    }

    // Método para retirar el paciente con mayor prioridad
    public Paciente desacolar() {
        if (isEmpty()) {
            return null; // o lanzar una excepción específica
        }
        Paciente pacienteAtendido = cabeza.paciente;
        cabeza = cabeza.siguiente;
        return pacienteAtendido;
    }
}
