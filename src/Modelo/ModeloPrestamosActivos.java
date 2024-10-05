package Modelo;

import Common.CommonFunctions;
import DBRepositorio.PrestamoLibro;
import DBRepositorio.PrestamoLibroRepositorio;
import DBRepositorio.PrestamoMonografia;
import DBRepositorio.PrestamoMonografiaRepositorio;
import javax.swing.JTable;
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class ModeloPrestamosActivos {

    PrestamoLibroRepositorio prestamoLibroDriver;
    PrestamoMonografiaRepositorio prestamoMonografiaDriver;

    private TableModel modeloTablaPrestamoLibros;
    private TableModel modeloTablaPrestamoMonografias;

    public ModeloPrestamosActivos(Connection openConexion) {
        prestamoLibroDriver = new PrestamoLibroRepositorio(openConexion);
        prestamoMonografiaDriver = new PrestamoMonografiaRepositorio(openConexion);
    }

    public void generarModeloLibro(JTable tblMateriales) {
        CommonFunctions.llenarTabla(tblMateriales, PrestamoLibro.getColumnas(), prestamoLibroDriver.obtenerTodos());
        modeloTablaPrestamoLibros = tblMateriales.getModel();
        tblMateriales.setModel(new DefaultTableModel());
    }

    public void generarModeloMonografia(JTable tblMateriales) {
        CommonFunctions.llenarTabla(tblMateriales, PrestamoMonografia.getColumnas(), prestamoMonografiaDriver.obtenerTodos());
        modeloTablaPrestamoMonografias = tblMateriales.getModel();
        tblMateriales.setModel(new DefaultTableModel());
    }

    public void cargarModeloLibro(JTable tblMateriales) {
        tblMateriales.setModel(this.modeloTablaPrestamoLibros);
    }

    public void cargarModeloMonografia(JTable tblMateriales) {
        tblMateriales.setModel(this.modeloTablaPrestamoMonografias);
    }
}
