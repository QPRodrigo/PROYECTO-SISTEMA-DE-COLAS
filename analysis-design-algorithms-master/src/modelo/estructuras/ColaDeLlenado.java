/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.estructuras;

import java.util.LinkedList;
import modelo.objetos.Pedido;

/**
 *
 * @author krypt97
 */
public class ColaDeLlenado implements Cola {

    // Atributos de clase
    Nodo cabeza;
    Nodo ultimo;
    int tamanio = 0;

    // Métodos de clase
    @Override
    public void encolar(Pedido pedido) {
        Nodo nuevoNodo = new Nodo(pedido);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            ultimo.siguiente = nuevoNodo;
        }
        ultimo = nuevoNodo;
        tamanio++;
    }

    @Override
    public void desencolar() {
        if (cabeza != null) {
            Nodo eliminar = cabeza;
            cabeza = cabeza.siguiente;
            eliminar.siguiente = null;
            if (cabeza == null) {
                ultimo = null;
            }
        }
    }

    @Override
    public Pedido obtener() {
        if (cabeza == null) {
            return null;
        } else {
            return cabeza.pedido;
        }
    }

    @Override
    public int getTamanio() {
        return tamanio;
    }

    @Override
    public LinkedList<Pedido> getCola() {
        LinkedList<Pedido> misPedidos = new LinkedList<>();
        Nodo actual = cabeza;
        while (actual != null) {
            misPedidos.add(actual.pedido);
            actual = actual.siguiente;
        }
        return misPedidos;
    }

}
