package com.centroemergencias.tda;

public interface IColaPrioridad<T> {
    void encolar(T elemento, int prioridad);
    T desencolar();
    T frente();
    boolean esVacia();
    int longitud();
}
