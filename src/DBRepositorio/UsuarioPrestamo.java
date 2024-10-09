package DBRepositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author Leonidas Garcia Lescano
 */
public class UsuarioPrestamo extends Entidades {

    private int idBiblioteca;
    private String dni, nombres, librosPendientes;

    public UsuarioPrestamo(int idBiblioteca, String dni, String nombres, String librosPendientes) {
        this.idBiblioteca = idBiblioteca;
        this.dni = dni;
        this.nombres = nombres;
        this.librosPendientes = librosPendientes;
    }

    public UsuarioPrestamo() {}

    @Override
    public Object[] toArray() {
        return new Object[]{getIdBiblioteca(), getDni(), getNombres(), getLibrosPendientes()};
    }

    public static UsuarioPrestamo toUsuarioPrestamo(List<Object> datos) {
        return new UsuarioPrestamo(
                (Integer) datos.get(0),
                (String) datos.get(1),
                (String) datos.get(2),
                (String) datos.get(3));
    }

    public static List<String> getColumnas() {
        List<String> columnas = new ArrayList<>();
        columnas.add("Id de biblioteca");
        columnas.add("DNI");
        columnas.add("Nombres");
        columnas.add("Tiene libros pendientes");

        return columnas;
    }

    public int getIdBiblioteca() {
        return idBiblioteca;
    }

    public String getDni() {
        return dni;
    }

    public String getNombres() {
        return nombres;
    }

    public String getLibrosPendientes() {
        return librosPendientes;
    }

    public void setIdBiblioteca(int idBiblioteca) {
        this.idBiblioteca = idBiblioteca;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setLibrosPendientes(String librosPendientes) {
        this.librosPendientes = librosPendientes;
    }

}
