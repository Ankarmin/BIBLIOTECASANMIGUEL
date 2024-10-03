package DBRepositorio;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Leonidas Garcia Lescano
 */
public class MorosoUsuario extends Entidades {

    private int idBiblio;
    private String dni, nombres, fechaRecuperación;

    public MorosoUsuario(int idBiblio, String dni, String nombres, String fechaRecuperación) {
        this.idBiblio = idBiblio;
        this.dni = dni;
        this.nombres = nombres;
        this.fechaRecuperación = fechaRecuperación;
    }

    public MorosoUsuario() {
    }

    @Override
    public Object[] toArray() {
        return new Object[]{getIdBiblio(), getDni(), getNombres(), getFechaRecuperación()};
    }

    public static MorosoUsuario toMorosoUsuario(List<Object> datos) {
        return new MorosoUsuario(
                (Integer) datos.get(0),
                (String) datos.get(1),
                (String) datos.get(2),
                (String) datos.get(3)
        );
    }

    public static List<String> getColumnas() {
        List<String> columnas = new ArrayList<>();
        columnas.add("ID de biblioteca");
        columnas.add("DNI");
        columnas.add("Nombres");
        columnas.add("Fecha de recuperación");
        return columnas;
    }

    public int getIdBiblio() {
        return idBiblio;
    }

    public String getDni() {
        return dni;
    }

    public String getNombres() {
        return nombres;
    }

    public String getFechaRecuperación() {
        return fechaRecuperación;
    }

    public void setIdBiblio(int idBiblio) {
        this.idBiblio = idBiblio;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setFechaRecuperación(String fechaRecuperación) {
        this.fechaRecuperación = fechaRecuperación;
    }

}
