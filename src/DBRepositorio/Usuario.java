package DBRepositorio;

import java.util.ArrayList;
import java.util.List;

public class Usuario extends Entidades {

    private int idBiblio;
    private String dni, nombres;

    public Usuario(int idBiblio, String dni, String nombres) {
        this.idBiblio = idBiblio;
        this.dni = dni;
        this.nombres = nombres;
    }

    public Usuario() {
    }

    @Override
    public Object[] toArray() {
        return new Object[]{getIdBiblio(), getDni(), getNombres()};
    }

    public static Usuario toUsuario(List<Object> datos) {
        return new Usuario((Integer) datos.get(0),
                (String) datos.get(1),
                (String) datos.get(2));
    }

    public static List<String> getColumnas() {
        List<String> columnas = new ArrayList<>();
        columnas.add("ID Biblioteca");
        columnas.add("DNI");
        columnas.add("Nombres");

        return columnas;
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
