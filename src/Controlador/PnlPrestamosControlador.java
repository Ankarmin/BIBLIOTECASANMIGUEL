package Controlador;

import Vista.BibliotecaVista;
import Vista.PrestamosVista;
import java.awt.BorderLayout;
import java.sql.Connection;

/**
 * @author Leonidas Garcia Lescano
 */
public class PnlPrestamosControlador {

    private PrestamosVista vista;

    public PnlPrestamosControlador(Connection openConexion) {
        vista = new PrestamosVista();
    }

    public void mostrar(BibliotecaVista Padre) {
        Padre.PnlContenido.removeAll();
        Padre.PnlContenido.add(vista, BorderLayout.CENTER);
        Padre.PnlContenido.revalidate();
        Padre.PnlContenido.repaint();
    }

}
