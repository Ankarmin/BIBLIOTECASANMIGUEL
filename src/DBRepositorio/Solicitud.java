package DBRepositorio;

/**
 * @author Leonidas Garcia Lescano
 */
public class Solicitud {

    private int idSolicitud;
    private String titulo, tema, autor, comentarios;

    public Solicitud(int idSolicitud, String titulo, String tema, String autor, String comentarios) {
        this.idSolicitud = idSolicitud;
        this.titulo = titulo;
        this.tema = tema;
        this.autor = autor;
        this.comentarios = comentarios;
    }

    public Solicitud() {
    }

    public int getIdSolicitud() {
        return idSolicitud;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getTema() {
        return tema;
    }

    public String getAutor() {
        return autor;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

}
