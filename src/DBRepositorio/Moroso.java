package DBRepositorio;

/**
 * @author Leonidas Garcia Lescano
 */

public class Moroso {
    private int idBiblio;
    private String fechaRecuperacion;
    
    public Moroso (int idBiblio, String fechaRecuperacion) {
        this.idBiblio = idBiblio;
        this.fechaRecuperacion = fechaRecuperacion;
    }
    
    public Moroso () {}

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
