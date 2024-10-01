package Controlador;

import Vista.BibliotecaVista;
import Vista.PrestamosVista;
import java.awt.BorderLayout;
import java.sql.Connection;

public class PnlPrestamosControlador {

    private final PrestamosVista vista;
    private PnlPrestamosActivosControlador controladorPrestamosActivos;
    private BibliotecaVista frmBiblioteca;

    public PnlPrestamosControlador(Connection openConexion) {
        vista = new PrestamosVista();
        frmBiblioteca = new BibliotecaVista();

        controladorPrestamosActivos = new PnlPrestamosActivosControlador(openConexion);

        vista.BtnPrestamosActivos.addActionListener((e) -> {
            controladorPrestamosActivos.mostrar(frmBiblioteca);
        });
    }

    public void mostrar(BibliotecaVista Padre) {
        Padre.PnlContenido.removeAll();
        Padre.PnlContenido.add(vista, BorderLayout.CENTER);
        Padre.PnlContenido.revalidate();
        Padre.PnlContenido.repaint();
    }
}
