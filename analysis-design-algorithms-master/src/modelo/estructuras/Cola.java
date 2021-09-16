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
public interface Cola {

    // Métodos a implementar
    public void encolar(Pedido miPedido);

    public void desencolar();

    public Pedido obtener();

    public int getTamanio();
    
    public LinkedList<Pedido> getCola();
}
