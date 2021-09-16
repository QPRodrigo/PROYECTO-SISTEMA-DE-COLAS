/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.archivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import modelo.objetos.Pedido;

/**
 *
 * @author krypt97
 */
public class Archivo {

    // ATRIBUTOS DE CLASE
    private static final String PATH = "registro-de-pedidos.dat";
    private static File miFile;
    private static FileInputStream miFileInputStream;
    private static FileOutputStream miFileOutputStream;
    private static ObjectInputStream miObjectInputStream;
    private static ObjectOutputStream miObjectOutputStream;

    // MÉTODOS DE CLASE
    public static void guardarDatosEnArchivo(LinkedList<Pedido> miLista) {
        try {
            miFile = new File(PATH);
            miFileOutputStream = new FileOutputStream(miFile);
            miObjectOutputStream = new ObjectOutputStream(miFileOutputStream);
            miObjectOutputStream.writeObject(miLista);
            miObjectOutputStream.close();
        } catch (IOException e) {
        }
    }

    public static LinkedList<Pedido> recuperarDatosDeArchivo() throws NullPointerException {
        LinkedList<Pedido> datosRecuperados = null;
        try {
            miFile = new File(PATH);
            miFileInputStream = new FileInputStream(miFile);
            miObjectInputStream = new ObjectInputStream(miFileInputStream);
            datosRecuperados = (LinkedList<Pedido>) miObjectInputStream.readObject();
            miObjectInputStream.close();
        } catch (IOException | ClassNotFoundException ex) {
        }

        return datosRecuperados;
    }
}
