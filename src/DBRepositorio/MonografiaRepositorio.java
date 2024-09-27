package DBRepositorio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Leonidas Garcia Lescano
 */
public class MonografiaRepositorio extends IConectar<Monografia, String> {

    public MonografiaRepositorio() {
        this.insertQuery = "INSERT INTO monografia (issn, titulo, autor, tema, stockTotal, stockDisponible) VALUES (?, ?, ?, ?, ?, ?)";
        this.searchIDQuery = "SELECT * FROM monografia WHERE issn = ?";
        this.searchAllQuery = "SELECT * FROM monografia";
        this.updateRowQuery = "UPDATE monografia SET titulo = ?, autor = ?, tema = ?, stockTotal = ?, stockDisponible = ? WHERE issn = ?";
        this.deleteRowQuery = "DELETE FROM monografia WHERE issn = ?";
    }

    @Override
    public boolean agregar(Monografia filaNueva) {
        try {
            try (PreparedStatement pst = conexion.prepareStatement(insertQuery)) {
                pst.setString(1, filaNueva.getIssn());
                pst.setString(2, filaNueva.getTitulo());
                pst.setString(3, filaNueva.getAutor());
                pst.setString(4, filaNueva.getTema());
                pst.setInt(5, filaNueva.getStockTotal());
                pst.setInt(6, filaNueva.getStockDisponible());

                pst.executeUpdate();
            }

            System.out.println("Monografia registrada con exito en la BD");
            return true;

        } catch (SQLException e) {
            System.out.println("Error al registrar en la BD: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Monografia obtenerPorId(String id) {

        Monografia encontrado = null;

        try {
            ResultSet rs;
            try (PreparedStatement pst = conexion.prepareStatement(searchIDQuery)) {
                pst.setString(1, id);
                rs = pst.executeQuery();
                while (rs.next()) {
                    encontrado = new Monografia();
                    encontrado.setIssn(rs.getString("isbn"));
                    encontrado.setTitulo(rs.getString("titulo"));
                    encontrado.setAutor(rs.getString("autor"));
                    encontrado.setTema(rs.getString("tema"));
                    encontrado.setStockTotal(rs.getInt("stockTotal"));
                    encontrado.setStockDisponible(rs.getInt("stockDisponible"));
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
    public List<Monografia> obtenerTodos() {
        List<Monografia> monografias = new ArrayList<>();

        try {
            ResultSet rs;
            try (PreparedStatement pst = conexion.prepareStatement(searchAllQuery)) {
                rs = pst.executeQuery();
                while (rs.next()) {
                    Monografia monografia = new Monografia(rs.getString("issn"), rs.getString("titulo"), rs.getString("autor"), rs.getString("tema"), rs.getInt("stockTotal"), rs.getInt("stockDisponible"));
                    monografias.add(monografia);
                }
                System.out.println("Monografias recolectadas");
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error al recopilar las monografias: " + e.getMessage());

        }

        return monografias.isEmpty() ? new ArrayList<>() : monografias;
    }

    @Override
    public boolean actualizar(Monografia filaActualizada) {
        try {
            try (PreparedStatement pst = conexion.prepareStatement(updateRowQuery)) {
                pst.setString(1, filaActualizada.getTitulo());
                pst.setString(2, filaActualizada.getAutor());
                pst.setString(3, filaActualizada.getTema());
                pst.setInt(4, filaActualizada.getStockTotal());
                pst.setInt(5, filaActualizada.getStockDisponible());
                pst.setString(6, filaActualizada.getIssn());

                pst.executeUpdate();
            }

            System.out.println("Fila de monografia actualizada");
            return true;

        } catch (SQLException e) {
            System.out.println("No se pudo actualizar la fila de monografia: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminar(String id) {
        try {
            try (PreparedStatement pst = conexion.prepareStatement(deleteRowQuery)) {
                pst.setString(1, id);

                pst.executeUpdate();

                System.out.println("Fila de monografia eliminada con exito");
            }

            return true;

        } catch (SQLException e) {
            System.out.println("No se pudo eliminar la fila de monografia: " + e.getMessage());
            return false;
        }
    }

}
