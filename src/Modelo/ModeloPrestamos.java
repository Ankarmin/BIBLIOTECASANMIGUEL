package Modelo;

import DBRepositorio.PrestamoLibro;
import DBRepositorio.PrestamoLibroRepositorio;
import DBRepositorio.PrestamoMonografia;
import DBRepositorio.PrestamoMonografiaRepositorio;

public class ModeloPrestamos {

    private final PrestamoLibroRepositorio prestamoLibroRepositorio;
    private final PrestamoMonografiaRepositorio prestamoMonografiaRepositorio;

    public ModeloPrestamos(PrestamoLibroRepositorio prestamoLibroRepositorio, PrestamoMonografiaRepositorio prestamoMonografiaRepositorio) {
        this.prestamoLibroRepositorio = prestamoLibroRepositorio;
        this.prestamoMonografiaRepositorio = prestamoMonografiaRepositorio;
    }

    public boolean prestarLibro(PrestamoLibro prestamoLibro) {
        return prestamoLibroRepositorio.agregar(prestamoLibro);
    }

    public boolean prestarMonografia(PrestamoMonografia prestamoMonografia) {
        return prestamoMonografiaRepositorio.agregar(prestamoMonografia);
    }
}
