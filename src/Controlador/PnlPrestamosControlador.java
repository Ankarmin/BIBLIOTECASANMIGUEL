package Controlador;

import DBRepositorio.Libro;
import DBRepositorio.Monografia;
import DBRepositorio.PrestamoLibro;
import DBRepositorio.PrestamoLibroRepositorio;
import DBRepositorio.PrestamoMonografia;
import DBRepositorio.PrestamoMonografiaRepositorio;
import Modelo.ModeloPrestamos;
import Vista.PrestamosVista;
import java.awt.BorderLayout;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class PnlPrestamosControlador {

    private final FrmBibliotecaControlador bibliotecaControlador;
    private Libro libroEntrante;
    private Monografia monografiaEntrante;
    private final PrestamosVista vista;
    private final ModeloPrestamos modeloPrestamos;
    private int stockDisponible;

    public PnlPrestamosControlador(Connection openConexion, FrmBibliotecaControlador bibliotecaControlador) {
        this.bibliotecaControlador = bibliotecaControlador;

        //INICIALIZANDO EN EL CONSTRUCTOR
        vista = new PrestamosVista();
        modeloPrestamos = new ModeloPrestamos(new PrestamoLibroRepositorio(openConexion), new PrestamoMonografiaRepositorio(openConexion));

        //EVENTO BOTON PRRESTAMOS ACTIVOS
        vista.BtnPrestamosActivos.addActionListener((e) -> {
            irAPrestamosActivos();
        });

        //EVENTO BOTON PRESTAR
        vista.BtnPrestar.addActionListener((e) -> {
            if (vista.CmbMaterial.getSelectedItem() == "Libro") {
                prestarLibro();
            } else if (vista.CmbMaterial.getSelectedItem() == "Monografia") {
                prestarMonografia();
            }
        });

        //EVENTO ITEM DE COMBOBOX
        vista.CmbMaterial.addActionListener((e) -> {
            String opc = (String) vista.CmbMaterial.getSelectedItem();
            if ("Libro".equals(opc)) {
                vista.LblCodigoMaterial.setText("ISBN");
            } else if ("Monografía".equals(opc)) {
                vista.LblCodigoMaterial.setText("ISSN");
            }
        });
    }

    private void prestarLibro() {
        try {
            // VALIDAR STOCK DISPONIBLE
            if (stockDisponible <= 0) {
                JOptionPane.showMessageDialog(vista,
                        "No hay stock disponible para prestar este libro.",
                        "Error de Stock",
                        JOptionPane.ERROR_MESSAGE);
                return; // SALIMOS DEL MÉTODO C:
            }

            // VALIDAR ID BIBLIOTECA
            int idBiblioteca = Integer.parseInt(vista.TxtIDBiblioteca.getText().trim());

            // VALIDAR FECHA DEVOLUCIÓN
            String fechaDevolucionStr = vista.TxtFechaDevolucion.getText().trim();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            dateFormat.setLenient(false);
            Date fechaDevolucion = dateFormat.parse(fechaDevolucionStr);

            // VALIDAR CODIGO MATERIAL
            String codigoMaterial = vista.TxtCodigoMaterial.getText().trim();

            PrestamoLibro nuevoPrestamo = new PrestamoLibro();
            nuevoPrestamo.setIdBiblio(idBiblioteca);
            nuevoPrestamo.setFechaDevolucion(fechaDevolucionStr);
            nuevoPrestamo.setIsbn(codigoMaterial);

            // AQUÍ REGISTRAMOS EL PRESTAMO EN LA BASE DE DATOS A TRAVÉS DEL MODELO
            boolean resultado = modeloPrestamos.prestarLibro(nuevoPrestamo);
            if (resultado) {
                JOptionPane.showMessageDialog(vista,
                        "Préstamo de Libro registrado con éxito.");
            } else {
                JOptionPane.showMessageDialog(vista,
                        "Error al registrar el préstamo.",
                        null,
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vista,
                    "El ID de Biblioteca debe ser un número entero.",
                    "Error de formato",
                    JOptionPane.ERROR_MESSAGE);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(vista,
                    "La fecha de devolución no tiene el formato correcto. Use el formato yyyy-MM-dd.",
                    "Error de Formato de Fecha",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void prestarMonografia() {
        try {
            // VALIDAR STOCK DISPONIBLE
            if (stockDisponible <= 0) {
                JOptionPane.showMessageDialog(vista,
                        "No hay stock disponible para prestar esta monografía.",
                        "Error de Stock",
                        JOptionPane.ERROR_MESSAGE);
                return; // SALIMOS DEL MÉTODO C:
            }

            // VALIDAR ID BIBLIOTECA
            int idBiblioteca = Integer.parseInt(vista.TxtIDBiblioteca.getText().trim());

            // VALIDAR FECHA DEVOLUCIÓN
            String fechaDevolucionStr = vista.TxtFechaDevolucion.getText().trim();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            dateFormat.setLenient(false);
            Date fechaDevolucion = dateFormat.parse(fechaDevolucionStr);

            // VALIDAR CODIGO MATERIAL
            String codigoMaterial = vista.TxtCodigoMaterial.getText().trim();

            PrestamoMonografia nuevoPrestamo = new PrestamoMonografia();
            nuevoPrestamo.setIdBiblio(idBiblioteca);
            nuevoPrestamo.setFechaDevolucion(fechaDevolucionStr);
            nuevoPrestamo.setIssn(codigoMaterial);

            // AQUÍ REGISTRAMOS EL PRESTAMO EN LA BASE DE DATOS A TRAVÉS DEL MODELO
            boolean resultado = modeloPrestamos.prestarMonografia(nuevoPrestamo);
            if (resultado) {
                JOptionPane.showMessageDialog(vista,
                        "Préstamo de Monografía registrado con éxito.");
            } else {
                JOptionPane.showMessageDialog(vista,
                        "Error al registrar el préstamo.",
                        null,
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vista,
                    "El ID de Biblioteca debe ser un número entero.",
                    "Error de formato",
                    JOptionPane.ERROR_MESSAGE);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(vista,
                    "La fecha de devolución no tiene el formato correcto. Use el formato yyyy-MM-dd.",
                    "Error de Formato de Fecha",
                    JOptionPane.ERROR_MESSAGE);
        }
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
    }

    public PrestamosVista getVista() {
        return vista;
    }

    public void setLibroEntrante(Libro libroEntrante) {
        this.libroEntrante = libroEntrante;
        vista.CmbMaterial.setSelectedItem("Libro");
        if (libroEntrante != null) {
            vista.TxtCodigoMaterial.setText(libroEntrante.getIsbn());
            stockDisponible = libroEntrante.getStockDisponible();
        }
    }

    public void setMonografiaEntrante(Monografia monografiaEntrante) {
        this.monografiaEntrante = monografiaEntrante;
        vista.CmbMaterial.setSelectedItem("Monografía");
        if (monografiaEntrante != null) {
            vista.TxtCodigoMaterial.setText(monografiaEntrante.getIssn());
            stockDisponible = monografiaEntrante.getStockDisponible();
        }
    }
}
