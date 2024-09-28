package DBRepositorio;

/**
 * @author Leonidas Garcia Lescano
 */
public class Libro {

    private String isbn, titulo, autor, tema;
    private int volumen, stockTotal, stockDisponible;

    public Libro(String isbn, String titulo, String autor, int volumen, String tema, int stockTotal, int stockDisponible) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.volumen = volumen;
        this.tema = tema;
        this.stockDisponible = stockDisponible;
        this.stockTotal = stockTotal;
    }
    
    public Libro() {};

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
