package Controlador;

import Vista.BibliotecaVista;
import Vista.UsuariosVista;
import java.awt.BorderLayout;
import java.sql.Connection;

public class PnlUsuariosControlador {

    private final FrmBibliotecaControlador bibliotecaControlador;

    private final UsuariosVista vista;

    public PnlUsuariosControlador(Connection openConexion, FrmBibliotecaControlador bibliotecaControlador) {

        this.bibliotecaControlador = bibliotecaControlador;

        vista = new UsuariosVista();
    }

    public void mostrar() {
        bibliotecaControlador.getFrmBiblioteca().PnlContenido.removeAll();
        bibliotecaControlador.getFrmBiblioteca().PnlContenido.add(vista, BorderLayout.CENTER);
        bibliotecaControlador.getFrmBiblioteca().PnlContenido.revalidate();
        bibliotecaControlador.getFrmBiblioteca().PnlContenido.repaint();
    }
}
