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
public class UsuarioRepositorio extends IConectar<Usuario, Integer> {

    private String hasBorrowBook;
    private String hasBorrowMonograph;

    public UsuarioRepositorio(Connection openConexion) {
        super(openConexion);
        this.insertQuery = "INSERT INTO usuario (idBiblio, dni, nombres) VALUES (?, ?, ?)";
        this.searchIDQuery = "SELECT * FROM usuario WHERE idBiblio = ?";
        this.searchAllQuery = "SELECT * FROM usuario";
        this.updateRowQuery = "UPDATE usuario SET dni = ?, nombres = ? WHERE idBiblio = ?";
        this.deleteRowQuery = "DELETE FROM usuario WHERE idBiblio = ?";
        this.hasBorrowBook = "SELECT * FROM prestamoLibro WHERE idBiblio = ?";
        this.hasBorrowMonograph = "SELECT * FROM prestamoMonografia WHERE idBiblio = ?";

    }

    public boolean tienePrestamo(int idBiblio) {

        boolean hasBorrow = false;

        try {
            PreparedStatement pstBook = conexion.prepareStatement(hasBorrowBook);
            pstBook.setInt(1, idBiblio);

            PreparedStatement pstMonograph = conexion.prepareStatement(hasBorrowMonograph);
            pstMonograph.setInt(1, idBiblio);

            ResultSet rsBook = pstBook.executeQuery();
            ResultSet rsMonograph = pstMonograph.executeQuery();

            while (rsBook.next() || rsMonograph.next()) {
                hasBorrow = true;
                break;
            }

        } catch (SQLException e) {
            System.out.println("Error al evaluar si el usuario tiene prestamos: " + e.getMessage());
        }

        return hasBorrow;

    }

    @Override
    public boolean agregar(Usuario filaNueva) {
        try {
            try (PreparedStatement pst = conexion.prepareStatement(insertQuery)) {
                pst.setInt(1, filaNueva.getIdBiblio());
                pst.setString(2, filaNueva.getDni());
                pst.setString(3, filaNueva.getNombres());

                pst.executeUpdate();
            }

            System.out.println("Usuario registrado con exito en la BD");
            return true;

        } catch (SQLException e) {
            System.out.println("Error al registrar en la BD: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Usuario obtenerPorId(Integer id) {

        Usuario encontrado = null;

        try {
            ResultSet rs;
            try (PreparedStatement pst = conexion.prepareStatement(searchIDQuery)) {
                pst.setInt(1, id);
                rs = pst.executeQuery();
                while (rs.next()) {
                    encontrado = new Usuario();
                    encontrado.setIdBiblio(rs.getInt("idBiblio"));
                    encontrado.setDni(rs.getString("dni"));
                    encontrado.setNombres(rs.getString("nombres"));
                }
            }
            rs.close();

            System.out.println("El usuario ha sido encontrado");
            return encontrado;

        } catch (SQLException e) {
            System.out.println("Error al buscar el usuario: " + e.getMessage());
            return encontrado;
        }

    }

    @Override
    public List<Usuario> obtenerTodos() {
        List<Usuario> usuarios = new ArrayList<>();

        try {
            ResultSet rs;
            try (PreparedStatement pst = conexion.prepareStatement(searchAllQuery)) {
                rs = pst.executeQuery();
                while (rs.next()) {
                    Usuario usuario = new Usuario(rs.getInt("idBiblio"), rs.getString("dni"), rs.getString("nombres"));
                    usuarios.add(usuario);
                }
                System.out.println("Usuarios recolectados");
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error al recopilar usuarios: " + e.getMessage());

        }

        return usuarios.isEmpty() ? new ArrayList<>() : usuarios;
    }

    @Override
    public boolean actualizar(Usuario filaActualizada) {
        try {
            try (PreparedStatement pst = conexion.prepareStatement(updateRowQuery)) {
                pst.setString(1, filaActualizada.getDni());
                pst.setString(2, filaActualizada.getNombres());
                pst.setInt(3, filaActualizada.getIdBiblio());

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
