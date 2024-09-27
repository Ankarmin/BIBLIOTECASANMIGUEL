package DBRepositorio;

/**
 * @author Leonidas Garcia Lescano
 */
public class PrestamoMonografia {

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
