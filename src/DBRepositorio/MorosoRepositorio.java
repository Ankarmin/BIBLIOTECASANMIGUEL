package DBRepositorio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Leonidas Garcia Lescano
 */
public class MorosoRepositorio extends IConectar<Moroso, Integer> {

    public MorosoRepositorio() {
        this.insertQuery = "INSERT INTO moroso (idBiblio, fechaRecuperacion) VALUES (?, ?)";
        this.searchIDQuery = "SELECT * FROM moroso WHERE idBiblio = ?";
        this.searchAllQuery = "SELECT * FROM moroso";
        this.updateRowQuery = "UPDATE moroso SET fechaRecuperacion = ? WHERE idBiblio = ?";
        this.deleteRowQuery = "DELETE FROM moroso WHERE idBiblio = ?";
    }

    @Override
    public boolean agregar(Moroso filaNueva) {
        try {
            try (PreparedStatement pst = conexion.prepareStatement(insertQuery)) {
                pst.setInt(1, filaNueva.getIdBiblio());
                pst.setString(2, filaNueva.getFechaRecuperacion());

                pst.executeUpdate();
            }

            System.out.println("Moroso registrado con exito en la BD");
            return true;

        } catch (SQLException e) {
            System.out.println("Error al registrar en la BD: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Moroso obtenerPorId(Integer id) {

        Moroso encontrado = null;

        try {
            ResultSet rs;
            try (PreparedStatement pst = conexion.prepareStatement(searchIDQuery)) {
                pst.setInt(1, id);
                rs = pst.executeQuery();
                while (rs.next()) {
                    encontrado = new Moroso();
                    encontrado.setIdBiblio(rs.getInt("idBiblio"));
                    encontrado.setFechaRecuperacion(rs.getString("fechaRecuperacion"));
                }
            }
            rs.close();

            System.out.println("El moroso ha sido encontrado");
            return encontrado;

        } catch (SQLException e) {
            System.out.println("Error al buscar al moroso: " + e.getMessage());
            return encontrado;
        }

    }

    @Override
    public List<Moroso> obtenerTodos() {
        List<Moroso> morosos = new ArrayList<>();

        try {
            ResultSet rs;
            try (PreparedStatement pst = conexion.prepareStatement(searchAllQuery)) {
                rs = pst.executeQuery();
                while (rs.next()) {
                    Moroso moroso = new Moroso(rs.getInt("idBiblio"), rs.getString("fechaRecuperacion"));
                    morosos.add(moroso);
                }
                System.out.println("Morosos recolectados");
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error al recopilar morosos: " + e.getMessage());

        }

        return morosos.isEmpty() ? new ArrayList<>() : morosos;
    }

    @Override
    public boolean actualizar(Moroso filaActualizada) {
        try {
            try (PreparedStatement pst = conexion.prepareStatement(updateRowQuery)) {
                pst.setString(1, filaActualizada.getFechaRecuperacion());
                pst.setInt(2, filaActualizada.getIdBiblio());

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
