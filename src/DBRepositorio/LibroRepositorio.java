//NO TIENES Q ENTENDER ESTO TIO, DEJALO SER
//NO, MENTIRA. PRIMERO CHECA ICONECTAR
package DBRepositorio;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;

//ACUERDATE DE LOS GENERICOS QUE TIENE ICONECTAR, FAMILIAR, NO?
public class LibroRepositorio extends IConectar<Libro, String> {

    //CONSTRUCTOR MAGICO
    public LibroRepositorio(Connection openConexion) {
        // SUPER! LLAMA AL CONSTRUCTOR PADRE DE LA CLASE (ICONECTAR, LO RECUERDAS?) Y ACTUA COMO SU REPRESENTANTE PARA
        // ENVIARLE LA CONEXION ABIERTA

        // SUPER NOTA: LOS ATRIBUTOS DE ICONECTAR TAMBIEN LE PERTENECEN A LIBROREPOSITORIO
        super(openConexion);
        this.insertQuery = "INSERT INTO libro (isbn, titulo, autor, volumen, tema, stockTotal, stockDisponible) VALUES (?, ?, ?, ?, ?, ?, ?)";
        this.searchIDQuery = "SELECT * FROM libro WHERE isbn = ?";
        this.searchAllQuery = "SELECT * FROM libro";
        this.updateRowQuery = "UPDATE libro SET titulo = ?, autor = ?, volumen = ?, tema = ?, stockTotal = ?, stockDisponible = ? WHERE isbn = ?";
        this.deleteRowQuery = "DELETE FROM libro WHERE isbn = ?";
    }

    //AQUI VAMOS A OVERRADEAR (SOBREESCRIBIR) O IMPLEMENTAR LOS MÉTODOS QUE PAPI ICONECTAR NOS PIDE Q IMPLEMENTEMOS
    //A LA FIRME TENDRIA Q EXPLICARTE SQL PARA Q SE ENTIENDA ASI Q T LO PUEDES SALTEAR
    //DEVUELVE TRUE SI SE AGREGÓ CORRECTAMENTE Y FALSE EN CASO CONTRARIO
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

    //DEVUELVE EL LIBRO BUSCADO POR ID (ISBN)
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

    //TE TRAE TODITITO
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

    //ACTUALIZA EN BASE A UNA INSTANCIA DE LIBRO
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

    //ELIMINA POR ID (ISBN)
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

    // SI SE NECESITARA, HABRAN MAS MÉTODOS. ESTOS NUEVOS METODOS SERAN SOLO DE LIBROREPOSITORIO POR LO QUE OVERRIDE NO LO UTILIZARE MAS
}
