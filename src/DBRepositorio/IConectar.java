// OLA
package DBRepositorio;

import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;

// UNA CLASE ABSTRACTA CON GENERICOS, AEA Q TROLL
public abstract class IConectar<T extends Entidades, I> {

    //ATRIBUTOS PRIVADOS PARA ALOJAR LA CONEXION ABIERTA CON LA BASE DE DATOS Y
    //LOS QUERYS DE LA BASE DE DATOS (FORMA DE INTERACCION DIRECTA CON LA BASE DE DATOS) AQUI SE OCULTA TODA LA MAGIA
    // DETRAS DEL PROGRAMA
    protected Connection conexion;
    protected String insertQuery, searchIDQuery, searchAllQuery, updateRowQuery, deleteRowQuery;

    //CONSTRUCTOR QUE RECIBE UNA CONEXION ABIERTA
    //NOTA: CUALQUIERA CLASE QUE HEREDE ICONECTAR TAMBIE HERADA EL CONSTRUCTOR DE ICONECTAR
    public IConectar(Connection openConexion) {
        this.conexion = openConexion;
    }

    //MATAR LA CONEXION :C
    public void killConexion() {
        try {
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error de desconexion: " + e.getMessage());
        }
    }

    //ESTOS MÉTODOS LOS DEBEN IMPLEMENTAR CUALQUIERA DE LOS QUE SE ATREVAN A HEREDAR DEL PODEROSO ICONECTAR (NO HACE NADA POR SI SOLO XD)
    public abstract boolean agregar(T filaNueva);

    public abstract T obtenerPorId(I id);

    public abstract List<T> obtenerTodos();

    public abstract boolean actualizar(T filaActualizada);

    public abstract boolean eliminar(I id);

}

// EN LIBROREPOSITORIO ESTA EL UNICO EJEMPLO Q T VOY A EXPLICAR YA QUE LOS DEMAS SON CASI IGUALES
