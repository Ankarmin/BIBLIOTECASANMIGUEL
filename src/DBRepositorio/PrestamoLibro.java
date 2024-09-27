package DBRepositorio;

/**
 * @author Leonidas Garcia Lescano
 */
public class PrestamoLibro {

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
