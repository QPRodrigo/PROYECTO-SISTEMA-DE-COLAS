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
public class Lista {

    // Atributos de clase
    Nodo cabeza;
    Nodo ultimo;
    int tamanio = 0;

    // Atributos a conectar
    private ColaDeEspera miColaDeEspera;
    private ColaDeLlenado miColaDeLlenado;
    private ColaDeEspera miColaDeRechazados;

    // Enlace cola de espera
    public void setColaDeEspera(ColaDeEspera miColaDeEspera) {
        this.miColaDeEspera = miColaDeEspera;
    }

    // Enlace cola de llenado
    public void setColaDeLlenado(ColaDeLlenado miColaDeLlenado) {
        this.miColaDeLlenado = miColaDeLlenado;
    }

    // Enlace cola de rechazados
    public void setColaDeRechazados(ColaDeEspera miColaDeRechazados) {
        this.miColaDeRechazados = miColaDeRechazados;
    }

    // Métodos de clase
    public void agregarPedido(Pedido miPedido) {
        Nodo nuevoNodo = new Nodo(miPedido);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            ultimo.siguiente = nuevoNodo;
        }
        ultimo = nuevoNodo;
        tamanio++;

        // Inserta en su respectiva cola segun estado del pedido
        switch (miPedido.getEstado()) {
            case 1:
                miColaDeEspera.encolar(miPedido);
                break;
            case 2:
                miColaDeLlenado.encolar(miPedido);
                break;
            case 3:
                miColaDeRechazados.encolar(miPedido);
                break;
        }
    }

    public void modificarEstado(int idPedido, int nuevoEstado) {
        // Busca pedido y modifica el estado
        if (cabeza != null) {
            Nodo actual = cabeza;
            while (actual.pedido.getId() != idPedido) {
                actual = actual.siguiente;
            }
            actual.pedido.setEstado(nuevoEstado);

            // Inserta en su respectiva cola segun nuevo estado
            switch (nuevoEstado) {
                case 1:
                    miColaDeEspera.encolar(actual.pedido);
                    break;
                case 2:
                    miColaDeLlenado.encolar(actual.pedido);
                    break;
                case 3:
                    miColaDeRechazados.encolar(actual.pedido);
                    break;
            }
        }
    }

    public Pedido obtenerPedido(int idPedido) throws NullPointerException {
        // Busca pedido en posición dada y lo retorna
        Pedido pedidoBuscado = null;
        if (cabeza != null) {
            Nodo actual = cabeza;
            while (actual.pedido.getId() != idPedido) {
                actual = actual.siguiente;
            }
            pedidoBuscado = actual.pedido;
        }
        return pedidoBuscado;
    }

    public void modificarPedidoPorID(int idPedido, Pedido pedidoModificado) {
        // Busca pedido en posición dada y lo modifica
        if (cabeza != null) {
            Nodo actual = cabeza;
            while (actual.pedido.getId() != idPedido) {
                actual = actual.siguiente;
            }
            actual.pedido = pedidoModificado;
            // Una vez modificado lo encola en la lista de espera
            miColaDeEspera.encolar(pedidoModificado);
        }
    }

    public int getTamanio() {
        return tamanio;
    }

    public boolean isEmpty() {
        // Retorna true si cabeza es nulo caso contrario false.
        return cabeza == null;
    }

    public LinkedList<Pedido> getListaEnlazada() {
        LinkedList<Pedido> misPedidos = new LinkedList<>();
        Nodo actual = cabeza;
        while (actual != null) {
            misPedidos.add(actual.pedido);
            actual = actual.siguiente;
        }
        return misPedidos;
    }
}
