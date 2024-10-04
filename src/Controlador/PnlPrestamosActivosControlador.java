package Controlador;

import Common.CommonFunctions;
import DBRepositorio.PrestamoLibro;
import DBRepositorio.PrestamoLibroRepositorio;
import DBRepositorio.PrestamoMonografia;
import DBRepositorio.PrestamoMonografiaRepositorio;
import Vista.PrestamosActivosVista;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.TableModel;

public class PnlPrestamosActivosControlador {

    private final FrmBibliotecaControlador bibliotecaControlador;
    private final MouseAdapter clickLibroPrestamo;
    private final MouseAdapter clickMonografiaPrestamo;
    private PrestamoLibro prestamoLibroSeleccionado;
    private PrestamoMonografia prestamoMonografiaSeleccionada;
    private final PrestamoLibroRepositorio prestamoLibroDriver;
    private final PrestamoMonografiaRepositorio prestamoMonografiaDriver;
    private final TableModel modeloPrestamoLibro;
    private final TableModel modeloPrestamoMonografia;
    private final PrestamosActivosVista vista;

    public PnlPrestamosActivosControlador(Connection openConexion, FrmBibliotecaControlador bibliotecaControlador) {

        this.bibliotecaControlador = bibliotecaControlador;

        vista = new PrestamosActivosVista();

        prestamoLibroDriver = new PrestamoLibroRepositorio(openConexion);
        prestamoMonografiaDriver = new PrestamoMonografiaRepositorio(openConexion);

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

        modeloPrestamoLibro = vista.TblPrestamosActivos.getModel();
        modeloPrestamoMonografia = vista.TblPrestamosActivos.getModel();

        cargarTablaPrestamosLibros();
        cargarEventosTablaPrestamosLibros();

        vista.CmbTipoMaterial.addActionListener((e) -> {
            // EVALUA EL TIPO DE MATERIAL SELECCIONADO Y LO CAMBIO EN FUNCIÓN DE SU VALOR
            String opc = (String) vista.CmbTipoMaterial.getSelectedItem();

            if ("Libro".equals(opc)) {
                vista.TblPrestamosActivos.setModel(modeloPrestamoLibro);
                cargarTablaPrestamosLibros();
                cargarEventosTablaPrestamosLibros();
            } else if ("Monografía".equals(opc)) {
                vista.TblPrestamosActivos.setModel(modeloPrestamoMonografia);
                cargarTablaPrestamosMonografias();
                cargarEventosTablPrestamosMonografias();
            }
        });
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

    public void cargarEventosTablaPrestamosLibros() {
        vista.TblPrestamosActivos.removeMouseListener(clickMonografiaPrestamo);
        vista.TblPrestamosActivos.addMouseListener(clickLibroPrestamo);
    }

    public void cargarEventosTablPrestamosMonografias() {
        vista.TblPrestamosActivos.removeMouseListener(clickLibroPrestamo);
        vista.TblPrestamosActivos.addMouseListener(clickMonografiaPrestamo);
    }

    public void cargarTablaPrestamosLibros() {
        CommonFunctions.llenarTabla(vista.TblPrestamosActivos, PrestamoLibro.getColumnas(), prestamoLibroDriver.obtenerTodos());
    }

    public void cargarTablaPrestamosMonografias() {
        CommonFunctions.llenarTabla(vista.TblPrestamosActivos, PrestamoMonografia.getColumnas(), prestamoMonografiaDriver.obtenerTodos());
    }
}
