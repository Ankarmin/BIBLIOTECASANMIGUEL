package DBRepositorio;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class IConectar<T, I> {

    protected Connection conexion;
    private static final String URL = "jdbc:mysql://autorack.proxy.rlwy.net:50572/railway";
    private static final String USER = "root";
    private static final String PASSWORD = "TuuSNAhxOdMuZfOaGnaMDytrIOeUpwcN";
    protected String insertQuery, searchIDQuery, searchAllQuery, updateRowQuery, deleteRowQuery;

    public IConectar() {
        try {
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexion exitosa a la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
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
