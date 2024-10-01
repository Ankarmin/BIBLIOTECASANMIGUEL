package Controlador;

import Vista.BibliotecaVista;
import Vista.DevolucionesVista;
import java.awt.BorderLayout;
import java.sql.Connection;

public class PnlDevolucionesControlador {

    private final FrmBibliotecaControlador bibliotecaControlador;
    
    private final DevolucionesVista vista;

    public PnlDevolucionesControlador(Connection openConexion, FrmBibliotecaControlador bibliotecaControlador) {
        vista = new DevolucionesVista();
        this.bibliotecaControlador = bibliotecaControlador;
    }

    public void mostrar() {
        bibliotecaControlador.getFrmBiblioteca().PnlContenido.removeAll();
        bibliotecaControlador.getFrmBiblioteca().PnlContenido.add(vista, BorderLayout.CENTER);
        bibliotecaControlador.getFrmBiblioteca().PnlContenido.revalidate();
        bibliotecaControlador.getFrmBiblioteca().PnlContenido.repaint();
    }

    public void irAPrestamosActivos() {
        
    }
    
}
