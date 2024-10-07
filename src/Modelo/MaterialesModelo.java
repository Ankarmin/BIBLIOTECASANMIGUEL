package Modelo;

import DBRepositorio.Libro;
import DBRepositorio.LibroRepositorio;
import DBRepositorio.Monografia;
import Common.CommonFunctions;
import DBRepositorio.MonografiaRepositorio;
import java.sql.Connection;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class MaterialesModelo {

    private String error = "";

    LibroRepositorio libroDriver;
    MonografiaRepositorio monografiaDriver;

    List<Libro> librosActuales;
    List<Monografia> monografiasActuales;

    private TableModel modeloTablaLibros;
    private TableModel modeloTablaMonografias;

    public MaterialesModelo(Connection openConexion) {
        libroDriver = new LibroRepositorio(openConexion);
        monografiaDriver = new MonografiaRepositorio(openConexion);

    }

    public boolean agregarLibro(Libro libro) {

        if (libro != null) {
            if (validarRegistroLibro(libro)) {
                if (libroDriver.agregar(libro)) {
                    return true;
                } else {
                    this.error = "No se pudo agregar el libro";
                    return false;
                }

            }
            return false;
        } else {
            this.error = "No has seleccionado ningun libro";
            return false;
        }

    }

    public boolean agregarMonografia(Monografia monografia) {
        if (monografia != null) {
            if (validarRegistroMonografia(monografia)) {
                if (monografiaDriver.agregar(monografia)) {
                    return true;
                } else {
                    this.error = "No se pudo agregar la monografia";
                    return false;
                }
            }
            return false;
        } else {
            this.error = "No has seleccionado ninguna monografía";
            return false;
        }
    }

    public boolean eliminarLibro(Libro libro) {
        if (libro != null) {
            if (validarCodigo(libro.getIsbn())) {
                if (libroDriver.eliminar(libro.getIsbn())) {
                    return true;
                } else {
                    this.error = "No se pudo agregar el libro";
                    return false;
                }

            }
            return false;
        } else {
            this.error = "No has seleccionado ningun libro";
            return false;
        }
    }

    public boolean eliminarMonografia(Monografia monografia) {
        if (monografia != null) {
            if (validarCodigo(monografia.getIssn())) {
                if (monografiaDriver.eliminar(monografia.getIssn())) {
                    return true;
                } else {
                    this.error = "No se pudo eliminar la monografia";
                    return false;
                }
            }
            return false;
        } else {
            this.error = "No has seleccionado ninguna monografía";
            return false;
        }
    }

    public boolean modificarLibro(Libro libro) {
        if (libro != null) {
            if (validarRegistroLibro(libro)) {
                if (libroDriver.actualizar(libro)) {
                    return true;
                } else {
                    this.error = "No se pudo modificar el libro";
                    return false;
                }

            }
            return false;
        } else {
            this.error = "No has seleccionado ningun libro";
            return false;
        }
    }

    public boolean modificarMonografia(Monografia monografia) {
        if (monografia != null) {
            if (validarRegistroMonografia(monografia)) {
                if (monografiaDriver.actualizar(monografia)) {
                    return true;
                } else {
                    this.error = "No se pudo modificar la monografia";
                    return false;
                }
            }
            return false;
        } else {
            this.error = "No has seleccionado ninguna monografía";
            return false;
        }
    }

    public void filtrarPorTituloLibro(String titulo, JTable tablaMateriales) {

        List<Libro> titulos = new ArrayList<>();

        for (Libro libro : librosActuales) {

            try {
                String tituloActual = libro.getTitulo();
                String subStrTituloActual = tituloActual.substring(0, titulo.length());

                titulo = titulo.toLowerCase();
                subStrTituloActual = subStrTituloActual.toLowerCase();

                String tituloNormalizado = Normalizer.normalize(titulo, Normalizer.Form.NFD)
                        .replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
                String subStrTituloActualNormalizado = Normalizer.normalize(subStrTituloActual, Normalizer.Form.NFD)
                        .replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");

                if (tituloNormalizado.equals(subStrTituloActualNormalizado)) {
                    titulos.add(libro);
                }
            } catch (StringIndexOutOfBoundsException e) {

            }
        }

        CommonFunctions.llenarTabla(tablaMateriales, Libro.getColumnas(), titulos);
    }

    public void filtrarPorAutorLibro(String autor, JTable tablaMateriales) {
        List<Libro> autores = new ArrayList<>();

        for (Libro libro : librosActuales) {

            try {
                String autorActual = libro.getAutor();
                String subStrAutorActual = autorActual.substring(0, autor.length());

                autor = autor.toLowerCase();
                subStrAutorActual = subStrAutorActual.toLowerCase();

                String autorNormalizado = Normalizer.normalize(autor, Normalizer.Form.NFD)
                        .replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
                String subStrAutorActualNormalizado = Normalizer.normalize(subStrAutorActual, Normalizer.Form.NFD)
                        .replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");

                if (autorNormalizado.equals(subStrAutorActualNormalizado)) {
                    autores.add(libro);
                }
            } catch (StringIndexOutOfBoundsException e) {

            }
        }

        CommonFunctions.llenarTabla(tablaMateriales, Libro.getColumnas(), autores);
    }

    public void filtrarPorTemaLibro(String tema, JTable tablaMateriales) {
        List<Libro> temas = new ArrayList<>();

        for (Libro libro : librosActuales) {

            try {
                String temaActual = libro.getTema();
                String subStrTemaActual = temaActual.substring(0, tema.length());

                tema = tema.toLowerCase();
                subStrTemaActual = subStrTemaActual.toLowerCase();

                String temaNormalizado = Normalizer.normalize(tema, Normalizer.Form.NFD)
                        .replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
                String subStrTemaActualNormalizado = Normalizer.normalize(subStrTemaActual, Normalizer.Form.NFD)
                        .replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");

                if (temaNormalizado.equals(subStrTemaActualNormalizado)) {
                    temas.add(libro);
                }
            } catch (StringIndexOutOfBoundsException e) {

            }
        }

        CommonFunctions.llenarTabla(tablaMateriales, Libro.getColumnas(), temas);
    }

    public void filtrarPorDisponibilidadLibro(JTable tablaMateriales) {
        List<Libro> disponibles = new ArrayList<>();

        for (Libro libro : librosActuales) {
            if (libro.getStockDisponible() > 0) {
                disponibles.add(libro);
            }
        }

        CommonFunctions.llenarTabla(tablaMateriales, Libro.getColumnas(), disponibles);
    }

    public void filtrarPorTituloMonografia(String titulo, JTable tablaMateriales) {
        List<Monografia> titulos = new ArrayList<>();

        for (Monografia monografia : monografiasActuales) {
            try {
                String tituloActual = monografia.getTitulo();
                String subStrTituloActual = tituloActual.substring(0, titulo.length());

                titulo = titulo.toLowerCase();
                subStrTituloActual = subStrTituloActual.toLowerCase();

                String tituloNormalizado = Normalizer.normalize(titulo, Normalizer.Form.NFD)
                        .replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
                String subStrTituloActualNormalizado = Normalizer.normalize(subStrTituloActual, Normalizer.Form.NFD)
                        .replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");

                if (tituloNormalizado.equals(subStrTituloActualNormalizado)) {
                    titulos.add(monografia);
                }
            } catch (StringIndexOutOfBoundsException e) {

            }
        }

        CommonFunctions.llenarTabla(tablaMateriales, Monografia.getColumnas(), titulos);
    }

    public void filtrarPorAutorMonografia(String autor, JTable tablaMateriales) {
        List<Monografia> autores = new ArrayList<>();

        for (Monografia monografia : monografiasActuales) {
            try {
                String autorActual = monografia.getAutor();
                String subStrAutorActual = autorActual.substring(0, autor.length());

                autor = autor.toLowerCase();
                subStrAutorActual = subStrAutorActual.toLowerCase();

                String autorNormalizado = Normalizer.normalize(autor, Normalizer.Form.NFD)
                        .replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
                String subStrAutorActualNormalizado = Normalizer.normalize(subStrAutorActual, Normalizer.Form.NFD)
                        .replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");

                if (autorNormalizado.equals(subStrAutorActualNormalizado)) {
                    autores.add(monografia);
                }
            } catch (StringIndexOutOfBoundsException e) {

            }
        }

        CommonFunctions.llenarTabla(tablaMateriales, Monografia.getColumnas(), autores);
    }

    public void filtrarPorTemaMonografia(String tema, JTable tablaMateriales) {
        List<Monografia> temas = new ArrayList<>();

        for (Monografia monografia : monografiasActuales) {
            try {
                String temaActual = monografia.getTema();
                String subStrTemaActual = temaActual.substring(0, tema.length());

                tema = tema.toLowerCase();
                subStrTemaActual = subStrTemaActual.toLowerCase();

                String temaNormalizado = Normalizer.normalize(tema, Normalizer.Form.NFD)
                        .replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
                String subStrTemaActualNormalizado = Normalizer.normalize(subStrTemaActual, Normalizer.Form.NFD)
                        .replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");

                if (temaNormalizado.equals(subStrTemaActualNormalizado)) {
                    temas.add(monografia);
                }
            } catch (StringIndexOutOfBoundsException e) {

            }
        }

        CommonFunctions.llenarTabla(tablaMateriales, Monografia.getColumnas(), temas);
    }

    public void filtrarPorDisponibilidadMonografia(JTable tablaMateriales) {
        List<Monografia> disponibles = new ArrayList<>();

        for (Monografia monografia : monografiasActuales) {
            if (monografia.getStockDisponible() > 0) {
                disponibles.add(monografia);
            }
        }

        CommonFunctions.llenarTabla(tablaMateriales, Monografia.getColumnas(), disponibles);
    }

    public void trimLibro(Libro libro) {
        libro.setIsbn(libro.getIsbn().trim());
        libro.setTitulo(libro.getTitulo().trim());
        libro.setAutor(libro.getAutor().trim());
        libro.setTema(libro.getTema().trim());
    }

    public void trimMonografia(Monografia monografia) {
        monografia.setIssn(monografia.getIssn().trim());
        monografia.setTitulo(monografia.getTitulo().trim());
        monografia.setAutor(monografia.getAutor().trim());
        monografia.setTema(monografia.getTema().trim());
    }

    public boolean validarRegistroLibro(Libro libro) {
        trimLibro(libro);
        return validarCodigo(libro.getIsbn())
                && validarTitulo(libro.getTitulo())
                && validarAutor(libro.getAutor())
                && validarVolumen(libro.getVolumen())
                && validarTema(libro.getTema())
                && validarStockTotal(libro.getStockTotal())
                && validarStockDisponible(libro.getStockDisponible());
    }

    public boolean validarRegistroMonografia(Monografia monografia) {
        trimMonografia(monografia);
        return validarCodigo(monografia.getIssn())
                && validarTitulo(monografia.getTitulo())
                && validarAutor(monografia.getAutor())
                && validarTema(monografia.getTema())
                && validarStockTotal(monografia.getStockTotal())
                && validarStockDisponible(monografia.getStockDisponible());
    }

    public boolean validarCodigo(String codigo) {
        if (codigo.length() == 10) {
            if (codigo.matches("\\d{10}")) {
                return true;
            }
        }
        this.error = "El código del material es inválido";
        return false;
    }

    public boolean validarTitulo(String titulo) {
        if (titulo.length() != 0) {
            return true;
        }
        this.error = "El titulo no puede estar vacio";
        return false;
    }

    public boolean validarAutor(String autor) {
        if (autor.length() != 0) {
            return true;
        }
        this.error = "El nombre del autor no puede estar vacio";
        return false;
    }

    public boolean validarVolumen(int volumen) {
        if (volumen > 0) {
            return true;
        }
        this.error = "El volumen no puede ser menor o igual a 0";
        return false;
    }

    public boolean validarTema(String tema) {
        if (tema.length() != 0) {
            return true;
        }
        this.error = "El tema no puede estar vacio";
        return false;
    }

    public boolean validarStockTotal(int stockTotal) {
        if (stockTotal > 0) {
            return true;
        }
        this.error = "El stock total no puede ser menor o igual a 0";
        return false;
    }

    public boolean validarStockDisponible(int stockDisponible) {
        if (stockDisponible >= 0) {
            return true;
        }
        this.error = "El stock disponible no puede ser menor o igual a 0";
        return false;
    }

    public String mostrarError() {
        String errorActual = this.error;
        this.error = "";
        return errorActual;
    }

    public void generarModeloLibro(JTable tblMateriales) {
        librosActuales = libroDriver.obtenerTodos();
        CommonFunctions.llenarTabla(tblMateriales, Libro.getColumnas(), librosActuales);
        modeloTablaLibros = tblMateriales.getModel();
        tblMateriales.setModel(new DefaultTableModel());
    }

    public void generarModeloMonografia(JTable tblMateriales) {
        monografiasActuales = monografiaDriver.obtenerTodos();
        CommonFunctions.llenarTabla(tblMateriales, Monografia.getColumnas(), monografiasActuales);
        modeloTablaMonografias = tblMateriales.getModel();
        tblMateriales.setModel(new DefaultTableModel());
    }

    public void cargarModeloLibro(JTable tblMateriales) {
        tblMateriales.setModel(this.modeloTablaLibros);
    }

    public void cargarModeloMonografia(JTable tblMateriales) {
        tblMateriales.setModel(this.modeloTablaMonografias);
    }

}

/* 
AGREGAR (VALIDACIONES)
    LIBRO 
    MONOGRAFIA
        VALIDAR LIBRO
        VALIDAR MONOGRAFIA
ELIMINAR
BUSQUEDA EN TIEMPO REAL CON DOCUMENT LISTENER
 */
