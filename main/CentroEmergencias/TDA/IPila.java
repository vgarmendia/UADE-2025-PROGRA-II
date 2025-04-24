package com.centroemergencias.tda;

public interface IPila<T> {
    void apilar(T elemento);
    T desapilar();
    T tope();
    boolean esVacia();
    int longitud();
}
