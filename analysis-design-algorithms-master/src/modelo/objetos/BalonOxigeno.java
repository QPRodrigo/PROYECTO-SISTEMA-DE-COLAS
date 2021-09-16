/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.objetos;

import java.io.Serializable;

/**
 *
 * @author krypt97
 */
public class BalonOxigeno implements Serializable {

    // ATRIBUTOS DE CLASE
    private String codigo;
    private float capacidad;

    // CONSTRUCTOR
    public BalonOxigeno(String codigo, float capacidad) {
        this.codigo = codigo;
        this.capacidad = capacidad;
    }

    // SETTERS AND GETTERS
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public float getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(float capacidad) {
        this.capacidad = capacidad;
    }
}
