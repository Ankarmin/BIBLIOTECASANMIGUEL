package Controlador;

import Vista.BibliotecaVista;
import Vista.PrestamosActivosVista;
import java.awt.BorderLayout;
import java.sql.Connection;

public class PnlPrestamosActivosControlador {

    private final PrestamosActivosVista vista;

    public PnlPrestamosActivosControlador(Connection openConexion) {
        vista = new PrestamosActivosVista();
    }

    public void mostrar(BibliotecaVista Padre) {
        Padre.PnlContenido.removeAll();
        Padre.PnlContenido.add(vista, BorderLayout.CENTER);
        Padre.PnlContenido.revalidate();
        Padre.PnlContenido.repaint();
    }
}
