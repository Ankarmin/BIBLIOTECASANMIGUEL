package Controlador;

import Vista.BibliotecaVista;
import Vista.DevolucionesVista;
import java.awt.BorderLayout;
import java.sql.Connection;

public class PnlDevolucionesControlador {

    private final DevolucionesVista vista;

    public PnlDevolucionesControlador(Connection openConexion) {
        vista = new DevolucionesVista();
    }

    public void mostrar(BibliotecaVista Padre) {
        Padre.PnlContenido.removeAll();
        Padre.PnlContenido.add(vista, BorderLayout.CENTER);
        Padre.PnlContenido.revalidate();
        Padre.PnlContenido.repaint();
    }

}
