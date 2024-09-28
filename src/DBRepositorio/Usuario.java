package DBRepositorio;

/**
 * @author Leonidas Garcia Lescano
 */
public class Usuario {

    private int idBiblio;
    private String dni, nombres;

    public Usuario(int idBiblio, String dni, String nombres) {
        this.idBiblio = idBiblio;
        this.dni = dni;
        this.nombres = nombres;
    }

    public Usuario() {
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

    public void setIdBiblio(int idBiblio) {
        this.idBiblio = idBiblio;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

}
