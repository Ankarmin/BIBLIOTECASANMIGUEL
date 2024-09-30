package Controlador;

import Vista.BibliotecaVista;
import Vista.UsuariosVista;
import java.awt.BorderLayout;
import java.sql.Connection;

/**
 * @author Leonidas Garcia Lescano
 */
public class PnlUsuariosControlador {

    private UsuariosVista vista;

    public PnlUsuariosControlador(Connection openConexion) {
        vista = new UsuariosVista();
    }

    public void mostrar(BibliotecaVista Padre) {
        Padre.PnlContenido.removeAll();
        Padre.PnlContenido.add(vista, BorderLayout.CENTER);
        Padre.PnlContenido.revalidate();
        Padre.PnlContenido.repaint();
    }
}
