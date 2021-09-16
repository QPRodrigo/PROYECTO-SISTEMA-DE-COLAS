/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.estructuras;

import modelo.objetos.Pedido;

/**
 *
 * @author krypt97
 */
public class ColaDeEspera extends ColaDeLlenado implements ColaPrioridad {

    @Override
    public void ordenarPrioridad() {
        Nodo actual = cabeza;
        if (actual != null) {
            Pedido aux;
            Nodo nodoSiguiente;
            while (actual.siguiente != null) {
                nodoSiguiente = actual.siguiente;
                while (nodoSiguiente != null) {
                    if (actual.pedido.getCliente().getEstadoPaciente() > nodoSiguiente.pedido.getCliente().getEstadoPaciente()) {
                        aux = actual.pedido;
                        actual.pedido = nodoSiguiente.pedido;
                        nodoSiguiente.pedido = aux;
                    }
                    nodoSiguiente = nodoSiguiente.siguiente;
                }
                actual = actual.siguiente;
            }
        }
    }

}
