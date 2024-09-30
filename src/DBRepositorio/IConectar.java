package DBRepositorio;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class IConectar<T, I> {

    protected Connection conexion;
    protected String insertQuery, searchIDQuery, searchAllQuery, updateRowQuery, deleteRowQuery;

    public IConectar(Connection openConexion) {
        this.conexion = openConexion;
    }

    public void killConexion() {
        try {
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error de desconexion: " + e.getMessage());
        }
    }

    public abstract boolean agregar(T filaNueva);

    public abstract T obtenerPorId(I id);

    public abstract List<T> obtenerTodos();

    public abstract boolean actualizar(T filaActualizada);

    public abstract boolean eliminar(I id);

}
