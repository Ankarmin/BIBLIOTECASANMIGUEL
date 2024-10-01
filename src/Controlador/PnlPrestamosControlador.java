package Controlador;

import DBRepositorio.Libro;
import DBRepositorio.Monografia;
import Vista.BibliotecaVista;
import Vista.PrestamosVista;
import java.awt.BorderLayout;
import java.sql.Connection;

public class PnlPrestamosControlador {

    private final FrmBibliotecaControlador bibliotecaControlador;
    private Libro libroEntrante;
    private Monografia monografiaEntrante;
    private final PrestamosVista vista;
    private BibliotecaVista frmBiblioteca;

    public PnlPrestamosControlador(Connection openConexion, FrmBibliotecaControlador bibliotecaControlador) {
        this.bibliotecaControlador = bibliotecaControlador;
        vista = new PrestamosVista();
        frmBiblioteca = new BibliotecaVista();

        vista.BtnPrestamosActivos.addActionListener((e) -> {
            irAPrestamosActivos();
        });
    }

    public void mostrar() {
        bibliotecaControlador.getFrmBiblioteca().PnlContenido.removeAll();
        bibliotecaControlador.getFrmBiblioteca().PnlContenido.add(vista, BorderLayout.CENTER);
        bibliotecaControlador.getFrmBiblioteca().PnlContenido.revalidate();
        bibliotecaControlador.getFrmBiblioteca().PnlContenido.repaint();
    }

    public void irAPrestamosActivos() {
        bibliotecaControlador.getFrmBiblioteca().PnlContenido.removeAll();
        bibliotecaControlador.getFrmBiblioteca().PnlContenido.add(bibliotecaControlador.getControladorPrestamosActivos().getVista(), BorderLayout.CENTER);
        bibliotecaControlador.getFrmBiblioteca().PnlContenido.revalidate();
        bibliotecaControlador.getFrmBiblioteca().PnlContenido.repaint();

        //SI QUIERES ENVIAR ARGUMENTOS
    }

    public PrestamosVista getVista() {
        return vista;
    }

    public void setLibroEntrante(Libro libroEntrante) {
        this.libroEntrante = libroEntrante;
        System.out.println("ola papichulo");
    }

    public void setMonografiaEntrante(Monografia monografiaEntrante) {
        this.monografiaEntrante = monografiaEntrante;
        System.out.println("adios papichulo");
    }

}
