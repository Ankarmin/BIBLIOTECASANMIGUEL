package Modelo;

import DBRepositorio.Libro;
import DBRepositorio.LibroRepositorio;
import DBRepositorio.Monografia;
import Common.CommonFunctions;
import DBRepositorio.MonografiaRepositorio;
import java.util.List;
import java.sql.Connection;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class MaterialesModelo {

    private String error = "";

    LibroRepositorio libroDriver;
    MonografiaRepositorio monografiaDriver;

    private TableModel modeloTablaLibros;
    private TableModel modeloTablaMonografias;

    public MaterialesModelo(Connection openConexion) {
        libroDriver = new LibroRepositorio(openConexion);
        monografiaDriver = new MonografiaRepositorio(openConexion);
    }

    public boolean agregarLibro(Libro libro) {

        System.out.println(libro.getIsbn());
        System.out.println(libro.getTitulo());
        System.out.println(libro.getAutor());
        System.out.println(libro.getTema());
        System.out.println(libro.getVolumen());
        System.out.println(libro.getTema());
        System.out.println(libro.getStockTotal());
        System.out.println(libro.getStockDisponible());

        if (libro != null) {
            if (validarRegistroLibro(libro)) {
                if (libroDriver.agregar(libro)) {
                    return true;
                } else {
                    this.error = "No se pudo agregar el libro";
                    return false;
                }

            }
            return false;
        } else {
            this.error = "No has seleccionado ningun libro";
            return false;
        }

    }

    public boolean agregarMonografia(Monografia monografia) {
        if (monografia != null) {
            if (validarRegistroMonografia(monografia)) {
                if (monografiaDriver.agregar(monografia)) {
                    return true;
                } else {
                    this.error = "No se pudo agregar la monografia";
                    return false;
                }
            }
            return false;
        } else {
            this.error = "No has seleccionado ninguna monografía";
            return false;
        }
    }

    public void eliminarLibro() {

    }

    public void eliminarMonografia() {

    }

    public void modificarLibro() {

    }

    public void modificarMonografia() {

    }

    public void filtrarPorTitulo() {

    }

    public void filtrarPorAutor() {

    }

    public void filtrarPorTema() {

    }

    public void filtrarPorDisponibilidad() {

    }

    public void trimLibro(Libro libro) {
        libro.setIsbn(libro.getIsbn().trim());
        libro.setTitulo(libro.getTitulo().trim());
        libro.setAutor(libro.getAutor().trim());
        libro.setTema(libro.getTema().trim());
    }

    public void trimMonografia(Monografia monografia) {
        monografia.setIssn(monografia.getIssn().trim());
        monografia.setTitulo(monografia.getTitulo().trim());
        monografia.setAutor(monografia.getAutor().trim());
        monografia.setTema(monografia.getTema().trim());
    }

    public boolean validarRegistroLibro(Libro libro) {
        trimLibro(libro);
        return validarCodigo(libro.getIsbn())
                && validarTitulo(libro.getTitulo())
                && validarAutor(libro.getAutor())
                && validarVolumen(libro.getVolumen())
                && validarTema(libro.getTema())
                && validarStockTotal(libro.getStockTotal())
                && validarStockDisponible(libro.getStockDisponible());
    }

    public boolean validarRegistroMonografia(Monografia monografia) {
        trimMonografia(monografia);
        return validarCodigo(monografia.getIssn())
                && validarTitulo(monografia.getTitulo())
                && validarAutor(monografia.getAutor())
                && validarTema(monografia.getTema())
                && validarStockTotal(monografia.getStockTotal())
                && validarStockDisponible(monografia.getStockDisponible());
    }

    public boolean validarCodigo(String codigo) {
        if (codigo.length() == 10) {
            if (codigo.matches("\\d{10}")) {
                return true;
            }
        }
        this.error = "El código del material es inválido";
        return false;
    }

    public boolean validarTitulo(String titulo) {
        if (titulo.length() != 0) {
            return true;
        }
        this.error = "El titulo no puede estar vacio";
        return false;
    }

    public boolean validarAutor(String autor) {
        if (autor.length() != 0) {
            return true;
        }
        this.error = "El nombre del autor no puede estar vacio";
        return false;
    }

    public boolean validarVolumen(int volumen) {
        if (volumen > 0) {
            return true;
        }
        this.error = "El volumen no puede ser menor o igual a 0";
        return false;
    }

    public boolean validarTema(String tema) {
        if (tema.length() != 0) {
            return true;
        }
        this.error = "El tema no puede estar vacio";
        return false;
    }

    public boolean validarStockTotal(int stockTotal) {
        if (stockTotal > 0) {
            return true;
        }
        this.error = "El stock total no puede ser menor o igual a 0";
        return false;
    }

    public boolean validarStockDisponible(int stockDisponible) {
        if (stockDisponible > 0) {
            return true;
        }
        this.error = "El stock disponible no puede ser menor o igual a 0";
        return false;
    }

    public String mostrarError() {
        String errorActual = this.error;
        this.error = "";
        return errorActual;
    }

    public void generarModeloLibro(JTable tblMateriales) {
        CommonFunctions.llenarTabla(tblMateriales, Libro.getColumnas(), libroDriver.obtenerTodos());
        modeloTablaLibros = tblMateriales.getModel();
        tblMateriales.setModel(new DefaultTableModel());
    }

    public void generarModeloMonografia(JTable tblMateriales) {
        CommonFunctions.llenarTabla(tblMateriales, Monografia.getColumnas(), monografiaDriver.obtenerTodos());
        modeloTablaMonografias = tblMateriales.getModel();
        tblMateriales.setModel(new DefaultTableModel());
    }

    public void cargarModeloLibro(JTable tblMateriales) {
        tblMateriales.setModel(this.modeloTablaLibros);
    }

    public void cargarModeloMonografia(JTable tblMateriales) {
        tblMateriales.setModel(this.modeloTablaMonografias);
    }

}

/* 
AGREGAR (VALIDACIONES)
    LIBRO 
    MONOGRAFIA
        VALIDAR LIBRO
        VALIDAR MONOGRAFIA
ELIMINAR
BUSQUEDA EN TIEMPO REAL CON DOCUMENT LISTENER
 */
