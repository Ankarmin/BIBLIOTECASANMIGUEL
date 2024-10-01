//EXPLICACION DE UNA ENTIDAD (APLICA PARA TODAS)
package DBRepositorio;

//CLASES NECESARIAS
import java.util.ArrayList;
import java.util.List;

/**
 * @author Leonidas Garcia Lescano
 */
//HEREDA DE ENTIDADES (ENTIDADES ES UNA CLASE ABSTRACTA)
public class Libro extends Entidades {

    //LOS ATRIBUTOS PRIVADOS REPRESETAN CADA COLUMNA DE LA TABLA CORRESPONDIENTE A LIBROS
    private String isbn, titulo, autor, tema;
    private int volumen, stockTotal, stockDisponible;

    // CONSTRUCTOR PARAMETRIZADO
    public Libro(String isbn, String titulo, String autor, int volumen, String tema, int stockTotal, int stockDisponible) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.volumen = volumen;
        this.tema = tema;
        this.stockDisponible = stockDisponible;
        this.stockTotal = stockTotal;
    }

    // CONSTRUCTOR POR DEFAULT (SE USA EN LOS REPOSITORIOS)
    public Libro() {
    }

    //IMPLEMENTACION DEL METODO TO ARRAY (SI ERES OBSERVADOR, SE USA EN LLENARTABLA)
    @Override
    public Object[] toArray() {
        return new Object[]{getIsbn(), getTitulo(), getAutor(), getVolumen(), getTema(), getStockTotal(), getStockDisponible()};
    }

    //MÉTODO ESTÁTICO PARA CONVERTIR UN ARRAY DE OBJETOS A LIBRO (UN ARRAY DE OBJETOS ES COMO UN COMODIN, LITERALEMENTE UN OBJETO
    // OBJECT PUEDE REPRESENTAR CUALQUIER TIPO DE DATO) Y LOS DEVUELVE
    public static Libro toLibro(List<Object> datos) {
        return new Libro((String) datos.get(0),
                //(TIPO DE DATO) SE USA PARA CASTEAR (CONVERTIR A CIERTO TIPO DE DATOS)
                (String) datos.get(1),
                (String) datos.get(2),
                (Integer) datos.get(3),
                (String) datos.get(4),
                (Integer) datos.get(5),
                (Integer) datos.get(6));
    }

    //MÉTODO ESTÁTICO PARA CONSEGUIR LAS COLUMNAS DE LA TABLA QUE LE CORRESPONDE A LA ENTIDAD
    public static List<String> getColumnas() {
        List<String> columnas = new ArrayList<>();
        columnas.add("ISBN");
        columnas.add("Titulo");
        columnas.add("Autor");
        columnas.add("Volumen");
        columnas.add("Tema");
        columnas.add("Stock Total");
        columnas.add("Stock Disponible");

        return columnas;
    }

    // SETTERS Y GETTERS
    public void setStockDisponible(int stockDisponible) {
        this.stockDisponible = stockDisponible;
    }

    public void setStockTotal(int stockTotal) {
        this.stockTotal = stockTotal;
    }

    public int getStockDisponible() {
        return stockDisponible;
    }

    public int getStockTotal() {
        return stockTotal;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getTema() {
        return tema;
    }

    public int getVolumen() {
        return volumen;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }

}
