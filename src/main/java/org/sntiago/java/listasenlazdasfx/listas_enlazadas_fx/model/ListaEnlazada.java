package org.sntiago.java.listasenlazdasfx.listas_enlazadas_fx.model;

public class ListaEnlazada<T> {
    public Nodo<T> ptr;
    public Nodo<T> t;


    public ListaEnlazada() {

    }


    public void ingresar(Nodo<T> nodo, Direccion dir) {
        if (ptr == null) {
            ptr = nodo;
            t = ptr;
        } else {
            if (dir.equals(Direccion.IZQUIERDA)) {
                ingresarPorIzquierda(nodo);
            } else {
                ingresarPorDerecha(nodo);
            }
        }

    }

    private void ingresarPorIzquierda(Nodo<T> nodo) {
        nodo.siguiente = ptr;
        ptr = nodo;
    }

    private void ingresarPorDerecha(Nodo<T> nodo) {
        t.siguiente = nodo;
        t = nodo;
    }

    public void recorrer() {
        Nodo<T> auxiliar = this.ptr;
        while (auxiliar != null) {
            System.out.println(auxiliar);
            auxiliar = auxiliar.siguiente;
        }
    }


    public void limpiar() {
        ptr = null;
        t = null;
    }
}
