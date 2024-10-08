package DBRepositorio;

import java.util.List;
import java.sql.Connection;

public abstract class IConectar<T extends Entidades, I> {

    protected Connection conexion;
    protected String insertQuery, searchIDQuery, searchAllQuery, updateRowQuery, deleteRowQuery;

    public IConectar(Connection openConexion) {
        this.conexion = openConexion;
    }

    public abstract boolean agregar(T filaNueva);

    public abstract T obtenerPorId(I id);

    public abstract List<T> obtenerTodos();

    public abstract boolean actualizar(T filaActualizada);

    public abstract boolean eliminar(I id);

}


