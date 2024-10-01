package DBRepositorio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;

public class SolicitudRepositorio extends IConectar<Solicitud, Integer> {

    public SolicitudRepositorio(Connection openConexion) {
        super(openConexion);
        this.insertQuery = "INSERT INTO solicitud (idSolicitud, titulo, tema, autor, comentarios) VALUES (?, ?, ?, ?, ?)";
        this.searchIDQuery = "SELECT * FROM solicitud WHERE idSolicitud = ?";
        this.searchAllQuery = "SELECT * FROM solicitud";
        this.updateRowQuery = "UPDATE solicitud SET titulo = ?, tema = ?, autor = ?, comentarios = ? WHERE idSolicitud = ?";
        this.deleteRowQuery = "DELETE FROM solicitud WHERE idSolicitud = ?";
    }

    @Override
    public boolean agregar(Solicitud filaNueva) {
        try {
            try (PreparedStatement pst = conexion.prepareStatement(insertQuery)) {
                pst.setInt(1, filaNueva.getIdSolicitud());
                pst.setString(2, filaNueva.getTitulo());
                pst.setString(3, filaNueva.getTema());
                pst.setString(4, filaNueva.getAutor());
                pst.setString(5, filaNueva.getComentarios());

                pst.executeUpdate();
            }

            System.out.println("Solicitud registrada con exito en la BD");
            return true;

        } catch (SQLException e) {
            System.out.println("Error al registrar en la BD: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Solicitud obtenerPorId(Integer id) {

        Solicitud encontrado = null;

        try {
            ResultSet rs;
            try (PreparedStatement pst = conexion.prepareStatement(searchIDQuery)) {
                pst.setInt(1, id);
                rs = pst.executeQuery();
                while (rs.next()) {
                    encontrado = new Solicitud();
                    encontrado.setIdSolicitud(rs.getInt("idSolicitud"));
                    encontrado.setTitulo(rs.getString("titulo"));
                    encontrado.setTema(rs.getString("tema"));
                    encontrado.setAutor(rs.getString("autor"));
                    encontrado.setComentarios(rs.getString("comentarios"));
                }
            }
            rs.close();

            System.out.println("La solicitud ha sido encontrada");
            return encontrado;

        } catch (SQLException e) {
            System.out.println("Error al buscar la solicitud: " + e.getMessage());
            return encontrado;
        }

    }

    @Override
    public List<Solicitud> obtenerTodos() {
        List<Solicitud> solicitudes = new ArrayList<>();

        try {
            ResultSet rs;
            try (PreparedStatement pst = conexion.prepareStatement(searchAllQuery)) {
                rs = pst.executeQuery();
                while (rs.next()) {
                    Solicitud solicitud = new Solicitud(rs.getInt("idSolicitud"), rs.getString("titulo"), rs.getString("tema"), rs.getString("autor"), rs.getString("comentarios"));
                    solicitudes.add(solicitud);
                }
                System.out.println("Usuarios recolectados");
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error al recopilar usuarios: " + e.getMessage());

        }

        return solicitudes.isEmpty() ? new ArrayList<>() : solicitudes;
    }

    @Override
    public boolean actualizar(Solicitud filaActualizada) {
        try {
            try (PreparedStatement pst = conexion.prepareStatement(updateRowQuery)) {
                pst.setString(1, filaActualizada.getTitulo());
                pst.setString(2, filaActualizada.getTema());
                pst.setString(3, filaActualizada.getAutor());
                pst.setString(4, filaActualizada.getComentarios());
                pst.setInt(5, filaActualizada.getIdSolicitud());

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
