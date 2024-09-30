package DBRepositorio;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Leonidas Garcia Lescano
 */
public class Solicitud extends Entidades {

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

    @Override
    public Object[] toArray() {
        return new Object[]{getIdSolicitud(), getTitulo(), getTema(), getAutor(), getComentarios()};
    }

    public static Solicitud toSolicitud(List<Object> datos) {
        return new Solicitud((Integer) datos.get(0),
                (String) datos.get(1),
                (String) datos.get(2),
                (String) datos.get(3),
                (String) datos.get(4));
    }

    public static List<String> getColumnas() {
        List<String> columnas = new ArrayList<>();
        columnas.add("ID Solicitud");
        columnas.add("Titulo");
        columnas.add("Tema");
        columnas.add("Autor");
        columnas.add("Comentarios");

        return columnas;
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
