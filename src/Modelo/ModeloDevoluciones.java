package Modelo;

import DBRepositorio.PrestamoLibroRepositorio;
import DBRepositorio.PrestamoMonografiaRepositorio;

public class ModeloDevoluciones {

    private final PrestamoLibroRepositorio prestamoLibroRepositorio;
    private final PrestamoMonografiaRepositorio prestamoMonografiaRepositorio;

    public ModeloDevoluciones(PrestamoLibroRepositorio prestamoLibroRepositorio, PrestamoMonografiaRepositorio prestamoMonografiaRepositorio) {
        this.prestamoLibroRepositorio = prestamoLibroRepositorio;
        this.prestamoMonografiaRepositorio = prestamoMonografiaRepositorio;
    }

    public boolean devolverLibro(int idPrestamo) {
        return prestamoLibroRepositorio.eliminar(idPrestamo);
    }

    public boolean devolverMonografia(int idPrestamo) {
        return prestamoMonografiaRepositorio.eliminar(idPrestamo);
    }
}
