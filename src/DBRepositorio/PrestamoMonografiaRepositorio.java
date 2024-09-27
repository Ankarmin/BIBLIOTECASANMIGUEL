package DBRepositorio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Leonidas Garcia Lescano
 */
public class PrestamoMonografiaRepositorio extends IConectar<PrestamoMonografia, Integer> {

    public PrestamoMonografiaRepositorio() {
        this.insertQuery = "INSERT INTO prestamoMonografia (idPrestamo, issn, idBiblio, fechaPrestamo, fechaDevolucion) VALUES (?, ?, ?, ?, ?)";
        this.searchIDQuery = "SELECT * FROM prestamoMonografia WHERE idPrestamo = ?";
        this.searchAllQuery = "SELECT * FROM prestamoMonografia";
        this.updateRowQuery = "UPDATE prestamoMonografia SET issn = ?, idBiblio = ?, fechaPrestamo = ?, fechaDevolucion = ? WHERE idPrestamo = ?";
        this.deleteRowQuery = "DELETE FROM prestamoMonografia WHERE idPrestamo = ?";
    }

    @Override
    public boolean agregar(PrestamoMonografia filaNueva) {
        try {
            try (PreparedStatement pst = conexion.prepareStatement(insertQuery)) {
                pst.setInt(1, filaNueva.getIdPrestamo());
                pst.setString(2, filaNueva.getIssn());
                pst.setInt(3, filaNueva.getIdBiblio());
                pst.setString(4, filaNueva.getFechaPrestamo());
                pst.setString(5, filaNueva.getFechaDevolucion());

                pst.executeUpdate();
            }

            System.out.println("Prestamo de monografia registrado con exito en la BD");
            return true;

        } catch (SQLException e) {
            System.out.println("Error al registrar en la BD: " + e.getMessage());
            return false;
        }
    }

    @Override
    public PrestamoMonografia obtenerPorId(Integer id) {

        PrestamoMonografia encontrado = null;

        try {
            ResultSet rs;
            try (PreparedStatement pst = conexion.prepareStatement(searchIDQuery)) {
                pst.setInt(1, id);
                rs = pst.executeQuery();
                while (rs.next()) {
                    encontrado = new PrestamoMonografia();
                    encontrado.setIdPrestamo(rs.getInt("idPrestamo"));
                    encontrado.setIssn(rs.getString("issn"));
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
    public List<PrestamoMonografia> obtenerTodos() {
        List<PrestamoMonografia> prestamosMonografias = new ArrayList<>();

        try {
            ResultSet rs;
            try (PreparedStatement pst = conexion.prepareStatement(searchAllQuery)) {
                rs = pst.executeQuery();
                while (rs.next()) {
                    PrestamoMonografia prestamoMonografia = new PrestamoMonografia(rs.getInt("idPrestamo"), rs.getString("issn"), rs.getInt("idBiblio"), rs.getString("fechaPrestamo"), rs.getString("fechaDevolucion"));
                    prestamosMonografias.add(prestamoMonografia);
                }
                System.out.println("Prestamos de monografias recolectados");
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error al recopilar las monografias: " + e.getMessage());

        }

        return prestamosMonografias.isEmpty() ? new ArrayList<>() : prestamosMonografias;
    }

    @Override
    public boolean actualizar(PrestamoMonografia filaActualizada) {
        try {
            try (PreparedStatement pst = conexion.prepareStatement(updateRowQuery)) {
                pst.setString(1, filaActualizada.getIssn());
                pst.setInt(2, filaActualizada.getIdBiblio());
                pst.setString(3, filaActualizada.getFechaPrestamo());
                pst.setString(4, filaActualizada.getFechaDevolucion());
                pst.setInt(5, filaActualizada.getIdPrestamo());

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
