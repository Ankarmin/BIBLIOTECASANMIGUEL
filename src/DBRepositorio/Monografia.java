package DBRepositorio;

/**
 * @author Leonidas Garcia Lescano
 */
public class Monografia {

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
