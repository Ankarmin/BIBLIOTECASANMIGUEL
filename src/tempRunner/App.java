package tempRunner;

import DBRepositorio.LibroRepositorio;
import DBRepositorio.Libro;
import DBRepositorio.Monografia;
import DBRepositorio.MonografiaRepositorio;
import DBRepositorio.PrestamoLibroRepositorio;
import DBRepositorio.PrestamoMonografiaRepositorio;
import java.util.List;

public class App {

    public static void main(String[] args) {

        MonografiaRepositorio libroDriver = new MonografiaRepositorio();
        
        System.out.println("Monografias");
        Monografia nuevoLibro = new Monografia("1325324321", "jarri", "leonidas", "guayar", 1, 1);
        libroDriver.agregar(nuevoLibro);
        nuevoLibro.setAutor("leonidas 2");
        libroDriver.actualizar(nuevoLibro);
        libroDriver.eliminar("1325324321");
        libroDriver.obtenerPorId("3132334455");
    }
}
