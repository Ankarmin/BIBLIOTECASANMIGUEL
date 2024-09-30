package DBRepositorio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;

/**
 * @author Leonidas Garcia Lescano
 */
public class PrestamoLibroRepositorio extends IConectar<PrestamoLibro, Integer> {
    
    public PrestamoLibroRepositorio(Connection openConexion) {
        super(openConexion);
        this.insertQuery = "INSERT INTO prestamoLibro (idPrestamo, isbn, idBiblio, fechaDevolucion) VALUES (?, ?, ?, ?)";
        this.searchIDQuery = "SELECT * FROM prestamoLibro WHERE idPrestamo = ?";
        this.searchAllQuery = "SELECT * FROM prestamoLibro";
        this.updateRowQuery = "UPDATE prestamoLibro SET isbn = ?, idBiblio = ?, fechaDevolucion = ? WHERE idPrestamo = ?";
        this.deleteRowQuery = "DELETE FROM prestamoLibro WHERE idPrestamo = ?";
    }
    
    @Override
    public boolean agregar(PrestamoLibro filaNueva) {
        try {
            try (PreparedStatement pst = conexion.prepareStatement(insertQuery)) {
                pst.setInt(1, filaNueva.getIdPrestamo());
                pst.setString(2, filaNueva.getIsbn());
                pst.setInt(3, filaNueva.getIdBiblio());
                pst.setString(4, filaNueva.getFechaDevolucion());

                pst.executeUpdate();
            }

            System.out.println("Prestamo de libro registrado con exito en la BD");
            return true;

        } catch (SQLException e) {
            System.out.println("Error al registrar en la BD: " + e.getMessage());
            return false;
        }
    }

    @Override
    public PrestamoLibro obtenerPorId(Integer id) {

        PrestamoLibro encontrado = null;

        try {
            ResultSet rs;
            try (PreparedStatement pst = conexion.prepareStatement(searchIDQuery)) {
                pst.setInt(1, id);
                rs = pst.executeQuery();
                while (rs.next()) {
                    encontrado = new PrestamoLibro();
                    encontrado.setIdPrestamo(rs.getInt("idPrestamo"));
                    encontrado.setIsbn(rs.getString("isbn"));
                    encontrado.setIdBiblio(rs.getInt("idBiblio"));
                    encontrado.setFechaPrestamo(rs.getString("fechaPrestamo"));
                    encontrado.setFechaDevolucion(rs.getString("fechaDevolucion"));
                }
            }
            rs.close();

            System.out.println("La monografia ha sido encontrada");
            return encontrado;

        } catch (SQLException e) {
            System.out.println("Error al buscar la monografia: " + e.getMessage());
            return encontrado;
        }

    }

    @Override
    public List<PrestamoLibro> obtenerTodos() {
        List<PrestamoLibro> prestamosLibros = new ArrayList<>();

        try {
            ResultSet rs;
            try (PreparedStatement pst = conexion.prepareStatement(searchAllQuery)) {
                rs = pst.executeQuery();
                while (rs.next()) {
                    PrestamoLibro prestamoLibro = new PrestamoLibro(rs.getInt("idPrestamo"), rs.getString("isbn"), rs.getInt("idBiblio"), rs.getString("fechaPrestamo"), rs.getString("fechaDevolucion"));
                    prestamosLibros.add(prestamoLibro);
                }
                System.out.println("Prestamos de monografias recolectados");
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error al recopilar las monografias: " + e.getMessage());

        }

        return prestamosLibros.isEmpty() ? new ArrayList<>() : prestamosLibros;
    }

    @Override
    public boolean actualizar(PrestamoLibro filaActualizada) {
        try {
            try (PreparedStatement pst = conexion.prepareStatement(updateRowQuery)) {
                pst.setString(1, filaActualizada.getIsbn());
                pst.setInt(2, filaActualizada.getIdBiblio());
                pst.setString(3, filaActualizada.getFechaDevolucion());
                pst.setInt(4, filaActualizada.getIdPrestamo());

                pst.executeUpdate();
            }

            System.out.println("Fila actualizada");
            return true;

        } catch (SQLException e) {
            System.out.println("No se pudo actualizar la fila: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminar(Integer id) {
        try {
            try (PreparedStatement pst = conexion.prepareStatement(deleteRowQuery)) {
                pst.setInt(1, id);

                pst.executeUpdate();

                System.out.println("Fila eliminada con exito");
            }

            return true;

        } catch (SQLException e) {
            System.out.println("No se pudo eliminar la fila: " + e.getMessage());
            return false;
        }
    }

}
