package org.sntiago.java.listasenlazdasfx.listas_enlazadas_fx.model;

public class ListaEnlazada<T> {
    public Nodo<T> ptr;
    public Nodo<T> t;
    private int contador;

    public ListaEnlazada() {
        contador = 0;
    }


    public void ingresar(Nodo<T> nodo, Direccion dir) {
        if (dir.equals(Direccion.IZQUIERDA)) {
            ingresarPorIzquierda(nodo);
        } else {
            ingresarPorDerecha(nodo);
        }
        contador++;
    }

    private void ingresarPorIzquierda(Nodo<T> nodo) {
        if (ptr != null) nodo.siguiente = ptr;
        if (ptr == null) t = nodo;
        ptr = nodo;
    }

    private void ingresarPorDerecha(Nodo<T> nodo) {
        if (ptr == null) {
            ptr = nodo;
        } else {
            t.siguiente = nodo;
        }
        t = nodo;
    }

    public void recorrer() {
        Nodo<T> auxiliar = this.ptr;
        while (auxiliar != null) {
            System.out.println(auxiliar);
            auxiliar = auxiliar.siguiente;
        }
    }

    public int getTotal() {
        return contador;
    }

    public boolean noEstaVacia() {
        return this.contador > 0;
    }

}
