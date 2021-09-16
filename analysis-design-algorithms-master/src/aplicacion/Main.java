/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import controlador.ControladorVistas;
import javax.swing.UIManager;
import modelo.estructuras.ColaDeEspera;
import modelo.estructuras.ColaDeLlenado;
import modelo.estructuras.Lista;
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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Look and Feel según el sistema operativo.
        try {
            javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            System.out.println(ex.getMessage());
        }

        // Instancia de colas
        ColaDeEspera miColaDeEspera = new ColaDeEspera();
        ColaDeLlenado miColaDeLlenado = new ColaDeLlenado();
        ColaDeEspera miColaDeRechazados = new ColaDeEspera();

        // Instancia de lista enlanzada
        Lista miLista = new Lista();

        // Instancia ventana principal
        VentanaPrincipal miVentanaPrincipal = new VentanaPrincipal();

        // Instancias de paneles
        PanelRegistrarPedido miPanelRegistrarPedido = new PanelRegistrarPedido();
        PanelColaEspera miPanelColaEspera = new PanelColaEspera();
        PanelColaLlenado miPanelColaLlenado = new PanelColaLlenado();
        PanelPedidosRechazados miPanelPedidosRechazados = new PanelPedidosRechazados();
        PanelHistorialPedidos miPanelHistorialPedidos = new PanelHistorialPedidos();

        // Instancia de controlador vistas
        ControladorVistas miControladorVistas = new ControladorVistas();

        // Conectando lista enlazada con colas
        miLista.setColaDeEspera(miColaDeEspera);
        miLista.setColaDeLlenado(miColaDeLlenado);
        miLista.setColaDeRechazados(miColaDeRechazados);

        // Conectando controlador vistas con ventana principal
        miControladorVistas.setVentanaPrincipal(miVentanaPrincipal);
        // Conectando controlador vistas con paneles
        miControladorVistas.setPanelRegistrarPedido(miPanelRegistrarPedido);
        miControladorVistas.setPanelColaEspera(miPanelColaEspera);
        miControladorVistas.setPanelColaLlenado(miPanelColaLlenado);
        miControladorVistas.setPanelPedidosRechazados(miPanelPedidosRechazados);
        miControladorVistas.setPanelHistorialPedidos(miPanelHistorialPedidos);
        // Conectando controlador vistas con cola de espera
        miControladorVistas.setColaDeEspera(miColaDeEspera);
        // Conectando cotrolador vistas con cola de llenado
        miControladorVistas.setColaDeLlenado(miColaDeLlenado);
        // Conectando controlador vistas con cola de rechazados
        miControladorVistas.setColaDeRechazados(miColaDeRechazados);
        // Conectando cotrolador vistas con lista enlazada
        miControladorVistas.setListaEnlazada(miLista);

        // Conectando ventana principal con controlador vistas
        miVentanaPrincipal.setControladorVistas(miControladorVistas);

        // Conectando panel registrar pedido con lista enlazada
        miPanelRegistrarPedido.setListaEnlazada(miLista);

        // Conectando panel cola de espera con cola de espera
        miPanelColaEspera.setColaDeEspera(miColaDeEspera);
        // Conectando panel cola de espera con lista enlazada
        miPanelColaEspera.setListaEnlazada(miLista);

        // Conectando panel cola de llenado con cola de llenado
        miPanelColaLlenado.setColaDeLlenado(miColaDeLlenado);
        // Conectando panel cola de llenado con lista enlazada
        miPanelColaLlenado.setListaEnlazada(miLista);

        // Conectando panel pedidos rechazados con cola de rechazados
        miPanelPedidosRechazados.setColaDeRechazados(miColaDeRechazados);
        // Conectando panel pedidos rechazados con lista enlazada
        miPanelPedidosRechazados.setListaEnlazada(miLista);

        // Conectando panel hostorial con lista enlazada
        miPanelHistorialPedidos.setListaEnlazada(miLista);

        // Cargando datos almacenado en archivo a lista enlazada
        miControladorVistas.recuperarDatosDeArchivo();
    }

}
