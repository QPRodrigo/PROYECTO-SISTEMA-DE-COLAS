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
public class Cliente implements Serializable {

    // ATRIBUTOS DE CLASE
    private String dni;
    private String nombre;
    private String apellido;
    private int estadoPaciente; // 1=Grave, 2=Moderado, 3=Leve

    // CONSTRUCTOR
    public Cliente(String dni, String nombre, String apellido, int estadoPaciente) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.estadoPaciente = estadoPaciente;
    }

    // SETTERS AND GETTERS
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEstadoPaciente() {
        return estadoPaciente;
    }

    public void setEstadoPaciente(int estadoPaciente) {
        this.estadoPaciente = estadoPaciente;
    }

    @Override
    public String toString() {
        return "Cliente{" + "dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", estado_paciente=" + estadoPaciente + '}';
    }

}
