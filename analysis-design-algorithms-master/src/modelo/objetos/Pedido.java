/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.objetos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author krypt97
 */
public class Pedido implements Serializable {

    // ATRIBUTOS DE CLASE
    private int id;
    private Date fecha;
    private Cliente cliente;
    private ArrayList<BalonOxigeno> balones;
    private int estado = 1; // 1=ColaEspera, 2=ColaLlenado, 3=Rechazados, 4=EliminadoLogico , 5=Despachado

    // CONSTRUCTOR
    public Pedido(int id, Date fecha, Cliente cliente, ArrayList<BalonOxigeno> balones) {
        this.id = id;
        this.fecha = fecha;
        this.cliente = cliente;
        this.balones = balones;
    }

    // GETTERS Y SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<BalonOxigeno> getBalones() {
        return balones;
    }

    public void setBalones(ArrayList<BalonOxigeno> balones) {
        this.balones = balones;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
