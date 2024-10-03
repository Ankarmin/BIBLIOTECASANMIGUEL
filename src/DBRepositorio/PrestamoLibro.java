package DBRepositorio;

import java.util.ArrayList;
import java.util.List;

public class PrestamoLibro extends Entidades {

    private int idPrestamo, idBiblio;
    private String isbn, fechaPrestamo, fechaDevolucion;

    public PrestamoLibro(int idPrestamo, String isbn, int idBiblio, String fechaPrestamo, String fechaDevolucion) {
        this.idPrestamo = idPrestamo;
        this.idBiblio = idBiblio;
        this.isbn = isbn;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    public PrestamoLibro() {
    }

    @Override
    public Object[] toArray() {
        return new Object[]{getIdPrestamo(), getIsbn(), getIdBiblio(), getFechaPrestamo(), getFechaDevolucion()};
    }

    public static PrestamoLibro toPrestamoLibro(List<Object> datos) {
        return new PrestamoLibro((Integer) datos.get(0),
                (String) datos.get(1),
                (Integer) datos.get(2),
                (String) datos.get(3),
                (String) datos.get(4));
    }

    public static List<String> getColumnas() {
        List<String> columnas = new ArrayList<>();
        columnas.add("ID Prestamo");
        columnas.add("ISBN");
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

    public String getIsbn() {
        return isbn;
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

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

}
