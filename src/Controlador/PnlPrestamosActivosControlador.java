package Controlador;

import DBRepositorio.PrestamoLibro;
import DBRepositorio.PrestamoMonografia;
import Modelo.ModeloPrestamosActivos;
import Vista.PrestamosActivosVista;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class PnlPrestamosActivosControlador {

    private final FrmBibliotecaControlador bibliotecaControlador;
    private final MouseAdapter clickLibroPrestamo;
    private final MouseAdapter clickMonografiaPrestamo;
    private PrestamoLibro prestamoLibroSeleccionado;
    private PrestamoMonografia prestamoMonografiaSeleccionada;
    private final PrestamosActivosVista vista;
    private ModeloPrestamosActivos modeloPrestamosActivos;

    public PnlPrestamosActivosControlador(Connection openConexion, FrmBibliotecaControlador bibliotecaControlador) {

        this.bibliotecaControlador = bibliotecaControlador;

        vista = new PrestamosActivosVista();

        modeloPrestamosActivos = new ModeloPrestamosActivos(openConexion);
        modeloPrestamosActivos.generarModeloLibro(vista.TblPrestamosActivos);
        modeloPrestamosActivos.generarModeloMonografia(vista.TblPrestamosActivos);
        modeloPrestamosActivos.cargarModeloLibro(vista.TblPrestamosActivos);

        clickLibroPrestamo = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                List<Object> datos = new ArrayList<>();
                int filaSeleccionada = vista.TblPrestamosActivos.getSelectedRow();

                if (filaSeleccionada != -1) {
                    for (int i = 0; i < PrestamoLibro.getColumnas().size(); i++) {
                        datos.add(vista.TblPrestamosActivos.getValueAt(filaSeleccionada, i));
                    }
                }

                prestamoLibroSeleccionado = PrestamoLibro.toPrestamoLibro(datos);

                if (e.getClickCount() == 2) {
                    irADevoluciones(prestamoLibroSeleccionado);
                }
            }
        };

        clickMonografiaPrestamo = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                List<Object> datos = new ArrayList<>();
                int filaSeleccionada = vista.TblPrestamosActivos.getSelectedRow();

                if (filaSeleccionada != -1) {
                    for (int i = 0; i < PrestamoMonografia.getColumnas().size(); i++) {
                        datos.add(vista.TblPrestamosActivos.getValueAt(filaSeleccionada, i));
                    }
                }

                prestamoMonografiaSeleccionada = PrestamoMonografia.toPrestamoMonografia(datos);

                if (e.getClickCount() == 2) {
                    irADevoluciones(prestamoMonografiaSeleccionada);
                }
            }
        };

        vista.TblPrestamosActivos.removeMouseListener(clickMonografiaPrestamo);
        vista.TblPrestamosActivos.addMouseListener(clickLibroPrestamo);

        vista.CmbTipoMaterial.addActionListener((e) -> {
            String opc = (String) vista.CmbTipoMaterial.getSelectedItem();

            if ("Libro".equals(opc)) {
                modeloPrestamosActivos.cargarModeloLibro(vista.TblPrestamosActivos);
                vista.TblPrestamosActivos.removeMouseListener(clickMonografiaPrestamo);
                vista.TblPrestamosActivos.addMouseListener(clickLibroPrestamo);
            } else if ("Monografía".equals(opc)) {
                modeloPrestamosActivos.cargarModeloMonografia(vista.TblPrestamosActivos);
                vista.TblPrestamosActivos.removeMouseListener(clickLibroPrestamo);
                vista.TblPrestamosActivos.addMouseListener(clickMonografiaPrestamo);
            }
        });
    }

    public void mostrar() {
        bibliotecaControlador.getFrmBiblioteca().PnlContenido.removeAll();
        bibliotecaControlador.getFrmBiblioteca().PnlContenido.add(vista, BorderLayout.CENTER);
    }

    public PrestamosActivosVista getVista() {
        return vista;
    }

    public void irADevoluciones(PrestamoLibro prestamoLibroSeleccionado) {
        bibliotecaControlador.getFrmBiblioteca().PnlContenido.removeAll();
        bibliotecaControlador.getFrmBiblioteca().PnlContenido.add(bibliotecaControlador.getControladorDevoluciones().getVista(), BorderLayout.CENTER);
        bibliotecaControlador.getFrmBiblioteca().PnlContenido.revalidate();
        bibliotecaControlador.getFrmBiblioteca().PnlContenido.repaint();
        bibliotecaControlador.getControladorDevoluciones().setLibroEntrante(prestamoLibroSeleccionado);
    }

    public void irADevoluciones(PrestamoMonografia prestamoMonografiaSeleccionada) {
        bibliotecaControlador.getFrmBiblioteca().PnlContenido.removeAll();
        bibliotecaControlador.getFrmBiblioteca().PnlContenido.add(bibliotecaControlador.getControladorDevoluciones().getVista(), BorderLayout.CENTER);
        bibliotecaControlador.getFrmBiblioteca().PnlContenido.revalidate();
        bibliotecaControlador.getFrmBiblioteca().PnlContenido.repaint();
        bibliotecaControlador.getControladorDevoluciones().setMonografiaEntrante(prestamoMonografiaSeleccionada);
    }

    public ModeloPrestamosActivos getModeloPrestamosActivos() {
        return modeloPrestamosActivos;
    }
    
    
    
}
