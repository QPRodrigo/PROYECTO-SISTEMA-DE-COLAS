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
public class Nodo {

    // Atributos de clase
    Pedido pedido;
    Nodo siguiente;

    // Constructor
    public Nodo(Pedido miPedido) {
        this.pedido = miPedido;
    }
}
