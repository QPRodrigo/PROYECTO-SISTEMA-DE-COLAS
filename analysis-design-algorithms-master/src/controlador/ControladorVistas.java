/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.LinkedList;
import modelo.archivos.Archivo;
import modelo.estructuras.ColaDeEspera;
import modelo.estructuras.ColaDeLlenado;
import modelo.estructuras.Lista;
import modelo.objetos.Pedido;
import vista.PanelColaEspera;
import vista.PanelColaLlenado;
import vista.PanelHistorialPedidos;
import vista.PanelPedidosRechazados;
import vista.PanelRegistrarPedido;
import vista.VentanaPrincipal;

/**
 *
 * @author krypt97
 */
public class ControladorVistas {

    // Atributos de clase
    private VentanaPrincipal miVentanaPrincipal;
    private PanelRegistrarPedido miPanelRegistrarPedido;
    private PanelColaEspera miPanelColaEspera;
    private PanelColaLlenado miPanelColaLlenado;
    private PanelPedidosRechazados miPanelPedidosRechazados;
    private PanelHistorialPedidos miPanelHistorialPedidos;
    private ColaDeEspera miColaDeEspera;
    private ColaDeLlenado miColaDeLlenado;
    private ColaDeEspera miColaDeRechazados;
    private Lista miLista;

    // Enlace a ventana principal
    public void setVentanaPrincipal(VentanaPrincipal miVentanaPrincipal) {
        this.miVentanaPrincipal = miVentanaPrincipal;
        this.miVentanaPrincipal.setSize(800, 930); // barra superior + area de diseño
        this.miVentanaPrincipal.setVisible(true);

    }

    // Enlace a panel registrar pedido
    public void setPanelRegistrarPedido(PanelRegistrarPedido miPanelRegistrarPedido) {
        this.miPanelRegistrarPedido = miPanelRegistrarPedido;
        this.miPanelRegistrarPedido.setSize(800, 780);
        this.miVentanaPrincipal.jPanel3.add(miPanelRegistrarPedido);
        this.miPanelRegistrarPedido.setVisible(false);
    }

    // Enlace a panel cola de espera
    public void setPanelColaEspera(PanelColaEspera miPanelColaEspera) {
        this.miPanelColaEspera = miPanelColaEspera;
        this.miPanelColaEspera.setSize(800, 780);
        this.miVentanaPrincipal.jPanel3.add(miPanelColaEspera);
        this.miPanelColaEspera.setVisible(false);
    }

    // Enlace a panel cola de llenado
    public void setPanelColaLlenado(PanelColaLlenado miPanelColaLlenado) {
        this.miPanelColaLlenado = miPanelColaLlenado;
        this.miPanelColaLlenado.setSize(800, 780);
        this.miVentanaPrincipal.jPanel3.add(miPanelColaLlenado);
        this.miPanelColaLlenado.setVisible(false);
    }

    // Enlace a panel pedidos rechazados
    public void setPanelPedidosRechazados(PanelPedidosRechazados miPanelPedidosRechazados) {
        this.miPanelPedidosRechazados = miPanelPedidosRechazados;
        this.miPanelPedidosRechazados.setSize(800, 780);
        miVentanaPrincipal.jPanel3.add(miPanelPedidosRechazados);
        this.miPanelPedidosRechazados.setVisible(false);
    }

    // Enlace a panel historial de pedidos
    public void setPanelHistorialPedidos(PanelHistorialPedidos miPanelHistorialPedidos) {
        this.miPanelHistorialPedidos = miPanelHistorialPedidos;
        this.miPanelHistorialPedidos.setSize(800, 780);
        miVentanaPrincipal.jPanel3.add(miPanelHistorialPedidos);
        this.miPanelHistorialPedidos.setVisible(false);
    }

    // Enlace a cola de espera
    public void setColaDeEspera(ColaDeEspera miColaDeEspera) {
        this.miColaDeEspera = miColaDeEspera;
    }
    
    // Enlace a cola de llenado
    public void setColaDeLlenado(ColaDeLlenado miColaDeLlenado) {
       this.miColaDeLlenado = miColaDeLlenado;
    }

    // Enlace a cola de rechazados
    public void setColaDeRechazados(ColaDeEspera miColaDeRechazados) {
        this.miColaDeRechazados = miColaDeRechazados;
    }
    
    // Enlace a lista enlazada
    public void setListaEnlazada(Lista miLista) {
       this.miLista = miLista;
    }

    // Métodos de clase controlador
    public void recuperarDatosDeArchivo() {
        // Si existe el archivo, carga los pedidos en la lista enlazada
       if (Archivo.recuperarDatosDeArchivo() != null) {
           LinkedList<Pedido> misPedidosRecuperado = Archivo.recuperarDatosDeArchivo();
           for (int i = 0; i < misPedidosRecuperado.size(); i++) {
               miLista.agregarPedido(misPedidosRecuperado.get(i));
           }
       }
    }
    
    public void guardarDatosEnArchivo() {
        // Si la lista enlazada no está vacia, guarda los datos en archivo
        if (!miLista.isEmpty()) {
            Archivo.guardarDatosEnArchivo(miLista.getListaEnlazada());
        }
    }
    
    public void mostrarPanelRegistrarPedido() {
        this.miPanelColaEspera.setVisible(false);
        this.miPanelColaLlenado.setVisible(false);
        this.miPanelPedidosRechazados.setVisible(false);
        this.miPanelHistorialPedidos.setVisible(false);

        this.miPanelRegistrarPedido.setVisible(true);

    }

    public void mostrarPanelColaEspera() {
        this.miPanelRegistrarPedido.setVisible(false);
        this.miPanelColaLlenado.setVisible(false);
        this.miPanelPedidosRechazados.setVisible(false);
        this.miPanelHistorialPedidos.setVisible(false);

        this.miPanelColaEspera.setVisible(true);
        
        // Si la cola no esta vacia, carga las tablas
        if (miColaDeEspera.obtener() != null) {
            this.miColaDeEspera.ordenarPrioridad();
            this.miPanelColaEspera.setTblColaEspera(miColaDeEspera.getCola());
            this.miPanelColaEspera.setFormularioCliente(miColaDeEspera.obtener());
            this.miPanelColaEspera.setTblBalonesOxigeno(miColaDeEspera.obtener().getBalones());
        }
    }

    public void mostrarPanelColaLlenado() {
        this.miPanelRegistrarPedido.setVisible(false);
        this.miPanelColaEspera.setVisible(false);
        this.miPanelPedidosRechazados.setVisible(false);
        this.miPanelHistorialPedidos.setVisible(false);

        this.miPanelColaLlenado.setVisible(true);
        
        // Si la cola no está vacia, carga las tablas
        if (miColaDeLlenado.obtener() != null) {
            this.miPanelColaLlenado.setTblColaLlenado(miColaDeLlenado.getCola());
            this.miPanelColaLlenado.setFormularioCliente(miColaDeLlenado.obtener());
            this.miPanelColaLlenado.setTblBalonesOxigeno(miColaDeLlenado.obtener().getBalones());
        }
    }

    public void mostrarPanelPedidosRechazados() {
        this.miPanelRegistrarPedido.setVisible(false);
        this.miPanelColaEspera.setVisible(false);
        this.miPanelColaLlenado.setVisible(false);
        this.miPanelHistorialPedidos.setVisible(false);

        this.miPanelPedidosRechazados.setVisible(true);
        
        // Si la cola no esta vacia, carga las tablas
        if (miColaDeRechazados.obtener() != null) {
            this.miColaDeRechazados.ordenarPrioridad();
            this.miPanelPedidosRechazados.setTblColaRechazados(miColaDeRechazados.getCola());
            this.miPanelPedidosRechazados.setFormularioCliente(miColaDeRechazados.obtener());
            this.miPanelPedidosRechazados.setTblBalonesOxigeno(miColaDeRechazados.obtener().getBalones());
            
            // Guarda el id del pedido en una variable del panel
            this.miPanelPedidosRechazados.idPedido = miColaDeRechazados.obtener().getId();
            
            // Guarda los balones de oxigeno del pedido en una variable del panel para su posterior modificación
            this.miPanelPedidosRechazados.misBalonesOxigeno = miColaDeRechazados.obtener().getBalones();
        }
    }

    public void mostrarPanelHistorialPedidos() {
        this.miPanelRegistrarPedido.setVisible(false);
        this.miPanelColaEspera.setVisible(false);
        this.miPanelColaLlenado.setVisible(false);
        this.miPanelPedidosRechazados.setVisible(false);

        this.miPanelHistorialPedidos.setVisible(true);
        
        this.miPanelHistorialPedidos.limpiarCampos();
        
        // Si la lista no está vacia, carga las tablas
        if (!miLista.isEmpty()) {
            this.miPanelHistorialPedidos.setTblListaEnlazada(miLista.getListaEnlazada());
        }
    }
}
