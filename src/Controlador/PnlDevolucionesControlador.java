package Controlador;

import DBRepositorio.PrestamoLibro;
import DBRepositorio.PrestamoLibroRepositorio;
import DBRepositorio.PrestamoMonografia;
import DBRepositorio.PrestamoMonografiaRepositorio;
import Modelo.ModeloDevoluciones;
import Vista.DevolucionesVista;
import java.awt.BorderLayout;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class PnlDevolucionesControlador {

    private final FrmBibliotecaControlador bibliotecaControlador;
    private PrestamoLibro prestamoLibroEntrante;
    private PrestamoMonografia prestamoMonografiaEntrante;
    private final ModeloDevoluciones modeloDevoluciones;
    private final DevolucionesVista vista;
    private final PrestamoLibroRepositorio prestamoLibroRepositorio;
    private final PrestamoMonografiaRepositorio prestamoMonografiaRepositorio;

    public PnlDevolucionesControlador(Connection openConexion, FrmBibliotecaControlador bibliotecaControlador) {
        this.bibliotecaControlador = bibliotecaControlador;

        vista = new DevolucionesVista();
        modeloDevoluciones = new ModeloDevoluciones(new PrestamoLibroRepositorio(openConexion), new PrestamoMonografiaRepositorio(openConexion));
        prestamoLibroRepositorio = new PrestamoLibroRepositorio(openConexion);
        prestamoMonografiaRepositorio = new PrestamoMonografiaRepositorio(openConexion);

        vista.BtnPrestamosActivos.addActionListener((e) -> {
            irAPrestamosActivos();
        });

        //EVENTO BOTON DEVOLVER
        vista.BtnDevolver.addActionListener((e) -> {
            if (vista.CmbMaterial.getSelectedItem() == "Libro") {
                devolverLibro();
            } else if (vista.CmbMaterial.getSelectedItem() == "Monografía") {
                devolverMonografia();
            }
        });
    }

    public void mostrar() {
        bibliotecaControlador.getFrmBiblioteca().PnlContenido.removeAll();
        bibliotecaControlador.getFrmBiblioteca().PnlContenido.add(vista, BorderLayout.CENTER);
        bibliotecaControlador.getFrmBiblioteca().PnlContenido.revalidate();
        bibliotecaControlador.getFrmBiblioteca().PnlContenido.repaint();
    }

    public void devolverLibro() {
        try {
            int idPrestamo = Integer.parseInt(vista.TxtIdPrestamo.getText().trim());
            PrestamoLibro prestamoLibro = prestamoLibroRepositorio.obtenerPorId(idPrestamo);
            if (prestamoLibro == null) {
                JOptionPane.showMessageDialog(vista,
                        "El ID de Préstamo no existe.",
                        "Error de ID",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            String fechaDevolucionIngresadaStr = vista.TxtFechaDevolucion.getText().trim();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaDevolucionIngresada = dateFormat.parse(fechaDevolucionIngresadaStr);
            Date fechaDevolucionOriginalDate = dateFormat.parse(prestamoLibroEntrante.getFechaDevolucion());
            Date fechaPrestamoDate = dateFormat.parse(prestamoLibroEntrante.getFechaPrestamo());

            if (fechaDevolucionIngresada.before(fechaPrestamoDate)) {
                JOptionPane.showMessageDialog(vista,
                        "La fecha de devolución no puede ser anterior a la fecha de préstamo.",
                        "Error de Fecha",
                        JOptionPane.ERROR_MESSAGE);
                        
                return;
            }

            boolean resultado = modeloDevoluciones.devolverLibro(idPrestamo);
            if (resultado && fechaDevolucionIngresada.after(fechaDevolucionOriginalDate)) {
                JOptionPane.showMessageDialog(vista,
                        "La devolución se realizó después de la fecha original: " + dateFormat.format(fechaDevolucionOriginalDate),
                        "Devolución tardía",
                        JOptionPane.WARNING_MESSAGE);
            } else if (resultado) {
                JOptionPane.showMessageDialog(vista,
                        "Devolución hecha con éxito.");
            } else {
                JOptionPane.showMessageDialog(vista,
                        "Error al devolver el Libro.",
                        null,
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista,
                    "El ID de Prestamo debe ser un número entero.",
                    "Error de Formato",
                    JOptionPane.ERROR_MESSAGE);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(vista,
                    "La fecha de devolución no tiene el formato correcto. Use el formato yyyy-MM-dd.",
                    "Error de Formato de Fecha",
                    JOptionPane.ERROR_MESSAGE);
        }
        actualizarTablaPrestamosActivosLibros();
    }

    public void devolverMonografia() {
        try {
            int idPrestamo = Integer.parseInt(vista.TxtIdPrestamo.getText().trim());
            PrestamoMonografia prestamoMonografia = prestamoMonografiaRepositorio.obtenerPorId(idPrestamo);
            if (prestamoMonografia == null) {
                JOptionPane.showMessageDialog(vista,
                        "El ID de Préstamo no existe.",
                        "Error de ID",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            String fechaDevolucionIngresadaStr = vista.TxtFechaDevolucion.getText().trim();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaDevolucionIngresada = dateFormat.parse(fechaDevolucionIngresadaStr);
            Date fechaDevolucionOriginalDate = dateFormat.parse(prestamoMonografiaEntrante.getFechaDevolucion());
            Date fechaPrestamoDate = dateFormat.parse(prestamoMonografiaEntrante.getFechaPrestamo());

            if (fechaDevolucionIngresada.before(fechaPrestamoDate)) {
                JOptionPane.showMessageDialog(vista,
                        "La fecha de devolución no puede ser anterior a la fecha de préstamo.",
                        "Error de Fecha",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            boolean resultado = modeloDevoluciones.devolverMonografia(idPrestamo);
            if (resultado && fechaDevolucionIngresada.after(fechaDevolucionOriginalDate)) {
                JOptionPane.showMessageDialog(vista,
                        "La devolución se realizó después de la fecha original: " + dateFormat.format(fechaDevolucionOriginalDate),
                        "Devolución tardía",
                        JOptionPane.WARNING_MESSAGE);
            } else if (resultado) {
                JOptionPane.showMessageDialog(vista,
                        "Devolución hecha con éxito.");
            } else {
                JOptionPane.showMessageDialog(vista,
                        "Error al devolver el Monografía.",
                        null,
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista,
                    "El ID de Prestamo debe ser un número entero.",
                    "Error de Formato",
                    JOptionPane.ERROR_MESSAGE);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(vista,
                    "La fecha de devolución no tiene el formato correcto. Use el formato yyyy-MM-dd.",
                    "Error de Formato de Fecha",
                    JOptionPane.ERROR_MESSAGE);
        }
        actualizarTablaPrestamosActivosMonografias();

    }

    public void setLibroEntrante(PrestamoLibro prestamoLibroEntrante) {
        this.prestamoLibroEntrante = prestamoLibroEntrante;
        vista.CmbMaterial.setSelectedItem("Libro");
        if (prestamoLibroEntrante != null) {
            vista.TxtIdPrestamo.setText(String.valueOf(prestamoLibroEntrante.getIdPrestamo()));
        }
    }

    public void setMonografiaEntrante(PrestamoMonografia prestamoMonografiaEntrante) {
        this.prestamoMonografiaEntrante = prestamoMonografiaEntrante;
        vista.CmbMaterial.setSelectedItem("Monografía");
        if (prestamoMonografiaEntrante != null) {
            vista.TxtIdPrestamo.setText(String.valueOf(prestamoMonografiaEntrante.getIdPrestamo()));
        }
    }

    public DevolucionesVista getVista() {
        return vista;
    }

    private void irAPrestamosActivos() {
        bibliotecaControlador.getFrmBiblioteca().PnlContenido.removeAll();
        bibliotecaControlador.getFrmBiblioteca().PnlContenido.add(bibliotecaControlador.getControladorPrestamosActivos().getVista(), BorderLayout.CENTER);
        bibliotecaControlador.getFrmBiblioteca().PnlContenido.revalidate();
        bibliotecaControlador.getFrmBiblioteca().PnlContenido.repaint();
    }

    private void actualizarTablaPrestamosActivosLibros() {
        bibliotecaControlador.
                getControladorPrestamosActivos().
                getModeloPrestamosActivos().
                generarModeloLibro(bibliotecaControlador.
                        getControladorPrestamosActivos().
                        getVista().TblPrestamosActivos);

        bibliotecaControlador.
                getControladorPrestamosActivos().
                getModeloPrestamosActivos().
                cargarModeloLibro(bibliotecaControlador.
                        getControladorPrestamosActivos().
                        getVista().TblPrestamosActivos);
    }

    private void actualizarTablaPrestamosActivosMonografias() {
        bibliotecaControlador.
                getControladorPrestamosActivos().
                getModeloPrestamosActivos().
                generarModeloMonografia(bibliotecaControlador.
                        getControladorPrestamosActivos().
                        getVista().TblPrestamosActivos);

        bibliotecaControlador.
                getControladorPrestamosActivos().
                getModeloPrestamosActivos().
                generarModeloMonografia(bibliotecaControlador.
                        getControladorPrestamosActivos().
                        getVista().TblPrestamosActivos);
    }
}
