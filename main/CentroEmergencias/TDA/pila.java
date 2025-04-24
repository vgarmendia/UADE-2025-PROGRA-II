package com.centroemergencias.tda;

public class Pila<T> implements IPila<T> {
    private Nodo<T> tope;
    private int tamano;

    public Pila() {
        this.tope = null;
        this.tamano = 0;
    }

    @Override
    public void apilar(T elemento) {
        Nodo<T> nuevo = new Nodo<>(elemento);
        nuevo.setSiguiente(tope);
        tope = nuevo;
        tamano++;
    }

    @Override
    public T desapilar() {
        if (esVacia()) {
            return null;
        }

        T dato = tope.getDato();
        tope = tope.getSiguiente();
        tamano--;

        return dato;
    }

    @Override
    public T tope() {
        return esVacia() ? null : tope.getDato();
    }

    @Override
    public boolean esVacia() {
        return tope == null;
    }

    @Override
    public int longitud() {
        return tamano;
    }

    // Método adicional para recorrer la pila sin modificarla
    public void mostrarElementos(IVisitante<T> visitante) {
        Nodo<T> actual = tope;
        while (actual != null) {
            visitante.visitar(actual.getDato());
            actual = actual.getSiguiente();
        }
    }
}
