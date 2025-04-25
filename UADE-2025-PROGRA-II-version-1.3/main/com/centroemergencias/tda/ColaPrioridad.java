package com.centroemergencias.tda;

public class ColaPrioridad<T> implements IColaPrioridad<T> {
    private class NodoPrioridad {
        T elemento;
        int prioridad;
        NodoPrioridad siguiente;

        NodoPrioridad(T elemento, int prioridad) {
            this.elemento = elemento;
            this.prioridad = prioridad;
            this.siguiente = null;
        }
    }

    private NodoPrioridad frente;
    private int tamano;

    public ColaPrioridad() {
        this.frente = null;
        this.tamano = 0;
    }

    @Override
    public void encolar(T elemento, int prioridad) {
        NodoPrioridad nuevoNodo = new NodoPrioridad(elemento, prioridad);

        // Si la cola está vacía o el nuevo elemento tiene mayor prioridad que el frente
        if (esVacia() || prioridad > frente.prioridad) {
            nuevoNodo.siguiente = frente;
            frente = nuevoNodo;
        } else {
            // Buscar la posición adecuada según la prioridad
            NodoPrioridad actual = frente;
            while (actual.siguiente != null && actual.siguiente.prioridad >= prioridad) {
                actual = actual.siguiente;
            }
            nuevoNodo.siguiente = actual.siguiente;
            actual.siguiente = nuevoNodo;
        }

        tamano++;
    }

    @Override
    public T desencolar() {
        if (esVacia()) {
            return null;
        }

        T elemento = frente.elemento;
        frente = frente.siguiente;
        tamano--;

        return elemento;
    }

    @Override
    public T frente() {
        return esVacia() ? null : frente.elemento;
    }

    @Override
    public boolean esVacia() {
        return frente == null;
    }

    @Override
    public int longitud() {
        return tamano;
    }

    // Método adicional para recorrer la cola sin modificarla
    public void mostrarElementos(IVisitante<T> visitante) {
        NodoPrioridad actual = frente;
        while (actual != null) {
            visitante.visitar(actual.elemento);
            actual = actual.siguiente;
        }
    }
}

