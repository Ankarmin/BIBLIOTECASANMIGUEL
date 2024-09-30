package DBRepositorio;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Leonidas Garcia Lescano
 */
public class Monografia extends Entidades {

    private String issn, titulo, autor, tema;
    private int stockTotal, stockDisponible;

    public Monografia(String issn, String titulo, String autor, String tema, int stockTotal, int stockDisponible) {
        this.issn = issn;
        this.titulo = titulo;
        this.autor = autor;
        this.tema = tema;
        this.stockTotal = stockTotal;
        this.stockDisponible = stockDisponible;
    }

    public Monografia() {
    }

    @Override
    public Object[] toArray() {
        return new Object[]{getIssn(), getTitulo(), getAutor(), getTema(), getStockTotal(), getStockDisponible()};
    }

    public static Monografia toMonografia(List<Object> datos) {
        return new Monografia((String) datos.get(0),
                (String) datos.get(1),
                (String) datos.get(2),
                (String) datos.get(3),
                (Integer) datos.get(4),
                (Integer) datos.get(5));
    }

    public static List<String> getColumnas() {
        List<String> columnas = new ArrayList<>();
        columnas.add("ISSN");
        columnas.add("Titulo");
        columnas.add("Autor");
        columnas.add("Tema");
        columnas.add("Stock Total");
        columnas.add("Stock Disponible");

        return columnas;
    }

    public String getIssn() {
        return issn;
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

    public int getStockTotal() {
        return stockTotal;
    }

    public int getStockDisponible() {
        return stockDisponible;
    }

    public void setIssn(String issn) {
        this.issn = issn;
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

    public void setStockTotal(int stockTotal) {
        this.stockTotal = stockTotal;
    }

    public void setStockDisponible(int stockDisponible) {
        this.stockDisponible = stockDisponible;
    }

}
