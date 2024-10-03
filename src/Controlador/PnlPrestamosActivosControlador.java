package Controlador;

import Vista.PrestamosActivosVista;
import java.awt.BorderLayout;
import java.sql.Connection;

public class PnlPrestamosActivosControlador {

    private final FrmBibliotecaControlador bibliotecaControlador;

    private final PrestamosActivosVista vista;

    public PnlPrestamosActivosControlador(Connection openConexion, FrmBibliotecaControlador bibliotecaControlador) {

        this.bibliotecaControlador = bibliotecaControlador;

        vista = new PrestamosActivosVista();
    }

    public void mostrar() {
        bibliotecaControlador.getFrmBiblioteca().PnlContenido.removeAll();
        bibliotecaControlador.getFrmBiblioteca().PnlContenido.add(vista, BorderLayout.CENTER);
        bibliotecaControlador.getFrmBiblioteca().PnlContenido.revalidate();
        bibliotecaControlador.getFrmBiblioteca().PnlContenido.repaint();
    }

    public PrestamosActivosVista getVista() {
        return vista;
    }

}
