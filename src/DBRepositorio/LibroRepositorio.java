package DBRepositorio;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

public class LibroRepositorio extends IConectar<Libro, String> {

    public LibroRepositorio() {
        this.insertQuery = "INSERT INTO libro (isbn, titulo, autor, volumen, tema, stockTotal, stockDisponible) VALUES (?, ?, ?, ?, ?, ?, ?)";
        this.searchIDQuery = "SELECT * FROM libro WHERE isbn = ?";
        this.searchAllQuery = "SELECT * FROM libro";
        this.updateRowQuery = "UPDATE libro SET titulo = ?, autor = ?, volumen = ?, tema = ?, stockTotal = ?, stockDisponible = ? WHERE isbn = ?";
        this.deleteRowQuery = "DELETE FROM libro WHERE isbn = ?";
    }

    @Override
    public boolean agregar(Libro filaNueva) {
        try {
            try (PreparedStatement pst = conexion.prepareStatement(insertQuery)) {
                pst.setString(1, filaNueva.getIsbn());
                pst.setString(2, filaNueva.getTitulo());
                pst.setString(3, filaNueva.getAutor());
                pst.setInt(4, filaNueva.getVolumen());
                pst.setString(5, filaNueva.getTema());
                pst.setInt(6, filaNueva.getStockTotal());
                pst.setInt(7, filaNueva.getStockDisponible());

                pst.executeUpdate();
            }

            System.out.println("Libro registrado con exito en la BD");
            return true;

        } catch (SQLException e) {
            System.out.println("Error al registrar en la BD: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Libro obtenerPorId(String id) {

        Libro encontrado = null;

        try {
            ResultSet rs;
            try (PreparedStatement pst = conexion.prepareStatement(searchIDQuery)) {
                pst.setString(1, id);
                rs = pst.executeQuery();
                while (rs.next()) {
                    encontrado = new Libro();
                    encontrado.setIsbn(rs.getString("isbn"));
                    encontrado.setTitulo(rs.getString("titulo"));
                    encontrado.setAutor(rs.getString("autor"));
                    encontrado.setVolumen(rs.getInt("volumen"));
                    encontrado.setTema(rs.getString("tema"));
                    encontrado.setStockTotal(rs.getInt("stockTotal"));
                    encontrado.setStockDisponible(rs.getInt("stockDisponible"));
                }
            }
            rs.close();

            System.out.println("El libro ha sido encontrado");
            return encontrado;

        } catch (SQLException e) {
            System.out.println("Error al buscar el libro: " + e.getMessage());
            return encontrado;
        }

    }

    @Override
    public List<Libro> obtenerTodos() {
        List<Libro> libros = new ArrayList<>();

        try {
            ResultSet rs;
            try (PreparedStatement pst = conexion.prepareStatement(searchAllQuery)) {
                rs = pst.executeQuery();
                while (rs.next()) {
                    Libro libro = new Libro(rs.getString("isbn"), rs.getString("titulo"), rs.getString("autor"), rs.getInt("volumen"), rs.getString("tema"), rs.getInt("stockTotal"), rs.getInt("stockDisponible"));
                    libros.add(libro);
                }
                System.out.println("Libros recolectados");
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error al recopilar los libros: " + e.getMessage());

        }

        return libros.isEmpty() ? new ArrayList<>() : libros;
    }

    @Override
    public boolean actualizar(Libro filaActualizada) {
        try {
            try (PreparedStatement pst = conexion.prepareStatement(updateRowQuery)) {
                pst.setString(1, filaActualizada.getTitulo());
                pst.setString(2, filaActualizada.getAutor());
                pst.setInt(3, filaActualizada.getVolumen());
                pst.setString(4, filaActualizada.getTema());
                pst.setInt(5, filaActualizada.getStockTotal());
                pst.setInt(6, filaActualizada.getStockDisponible());
                pst.setString(7, filaActualizada.getIsbn());

                pst.executeUpdate();
            }

            System.out.println("Fila de libro actualizada");
            return true;

        } catch (SQLException e) {
            System.out.println("No se pudo actualizar la fila de libro: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminar(String id) {
        try {
            try (PreparedStatement pst = conexion.prepareStatement(deleteRowQuery)) {
                pst.setString(1, id);

                pst.executeUpdate();

                System.out.println("Fila de libro eliminada con exito");
            }

            return true;

        } catch (SQLException e) {
            System.out.println("No se pudo eliminar la fila de libro: " + e.getMessage());
            return false;
        }
    }
}
