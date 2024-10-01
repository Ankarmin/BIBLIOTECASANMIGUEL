package DBRepositorio;

import java.util.ArrayList;
import java.util.List;

public class PrestamoMonografia extends Entidades {

    private int idPrestamo, idBiblio;
    private String issn, fechaPrestamo, fechaDevolucion;

    public PrestamoMonografia(int idPrestamo, String issn, int idBiblio, String fechaPrestamo, String fechaDevolucion) {
        this.idPrestamo = idPrestamo;
        this.idBiblio = idBiblio;
        this.issn = issn;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    public PrestamoMonografia() {
    }

    @Override
    public Object[] toArray() {
        return new Object[]{getIdPrestamo(), getIssn(), getIdBiblio(), getFechaPrestamo(), getFechaDevolucion()};
    }

    public static PrestamoMonografia toPrestamoMonografia(List<Object> datos) {
        return new PrestamoMonografia((Integer) datos.get(0),
                (String) datos.get(1),
                (Integer) datos.get(2),
                (String) datos.get(3),
                (String) datos.get(4));
    }

    public static List<String> getColumnas() {
        List<String> columnas = new ArrayList<>();
        columnas.add("ID Prestamo");
        columnas.add("ISSN");
        columnas.add("ID Biblioteca");
        columnas.add("Fecha de Préstramo");
        columnas.add("Fecha de devolución");

        return columnas;
    }
    
    public int getIdPrestamo() {
        return idPrestamo;
    }

    public int getIdBiblio() {
        return idBiblio;
    }

    public String getIssn() {
        return issn;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public void setIdBiblio(int idBiblio) {
        this.idBiblio = idBiblio;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

}
