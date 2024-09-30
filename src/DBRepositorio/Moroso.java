package DBRepositorio;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Leonidas Garcia Lescano
 */
public class Moroso extends Entidades {

    private int idBiblio;
    private String fechaRecuperacion;

    public Moroso(int idBiblio, String fechaRecuperacion) {
        this.idBiblio = idBiblio;
        this.fechaRecuperacion = fechaRecuperacion;
    }

    public Moroso() {
    }

    @Override
    public Object[] toArray() {
        return new Object[]{getIdBiblio(), getFechaRecuperacion()};
    }

    public static Moroso toMoroso(List<Object> datos) {
        return new Moroso((Integer) datos.get(0),
                (String) datos.get(1));
    }

    public static List<String> getColumnas() {
        List<String> columnas = new ArrayList<>();
        columnas.add("ID Biblioteca");
        columnas.add("Fecha Recuperación");

        return columnas;
    }

    public int getIdBiblio() {
        return idBiblio;
    }

    public String getFechaRecuperacion() {
        return fechaRecuperacion;
    }

    public void setIdBiblio(int idBiblio) {
        this.idBiblio = idBiblio;
    }

    public void setFechaRecuperacion(String fechaRecuperacion) {
        this.fechaRecuperacion = fechaRecuperacion;
    }

}
