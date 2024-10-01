package Controlador;

import Vista.BibliotecaVista;
import Vista.SolicitudesVista;
import java.awt.BorderLayout;
import java.sql.Connection;

public class PnlSolicitudesControlador {

    private final SolicitudesVista vista;

    public PnlSolicitudesControlador(Connection openConexion) {
        vista = new SolicitudesVista();
    }
    
    public void mostrar(BibliotecaVista Padre) {
        Padre.PnlContenido.removeAll();
        Padre.PnlContenido.add(vista, BorderLayout.CENTER);
        Padre.PnlContenido.revalidate();
        Padre.PnlContenido.repaint();
    }
    
}
