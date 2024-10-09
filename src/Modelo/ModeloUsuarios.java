package Modelo;

import Common.CommonFunctions;
import DBRepositorio.UsuarioRepositorio;
import DBRepositorio.MorosoRepositorio;
import DBRepositorio.Moroso;
import DBRepositorio.Usuario;
import DBRepositorio.UsuarioPrestamo;
import DBRepositorio.MorosoUsuario;
import java.sql.Connection;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class ModeloUsuarios {

    private String error = "";
    UsuarioRepositorio UsuarioRepo;
    MorosoRepositorio MorosoRepo;
    
    List<UsuarioPrestamo> usuariosActuales;
    List<MorosoUsuario> morososActuales;
    private TableModel modeloTablaUsuario;
    private TableModel modeloTablaMoroso;

    public ModeloUsuarios(Connection openConexion) {
        this.UsuarioRepo = new UsuarioRepositorio(openConexion);
        this.MorosoRepo = new MorosoRepositorio(openConexion);
    }

    //CRUD Usuarios y Morosos
    public boolean eliminarUsuario(UsuarioPrestamo usuario) {
        if (usuario != null) {
            if ("No".equals(usuario.getLibrosPendientes())) {
                if (UsuarioRepo.eliminar(usuario.getIdBiblioteca())) {
                    return true;
                } else {
                    this.error = "No se pudo eliminar al usuario";
                    return false;
                }
            } else {
                this.error = "No se pudo eliminar al usuario";
                return false;
            }
        }
        this.error = "No has seleccionado ningun usuario";
        return false;

    }

    public boolean agregarUsuario(UsuarioPrestamo usuario) {
        if (usuario != null) {
            {
                if (validarAgregarUsuario(usuario)) {
                    Usuario user = convertirUsuario(usuario);
                    if (UsuarioRepo.agregar(user)) {
                        return true;
                    } else {
                        this.error = "No se pudo agregar al usuario";
                        return false;
                    }
                } else {
                    this.error = "No se pudo agregar al usuario";
                    return false;
                }
            }
        }
        this.error = "No has seleccionado ningun usuario";
        return false;
    }

    public boolean eliminarMoroso(MorosoUsuario moroso) {
        if (moroso != null) {
            if (MorosoRepo.eliminar(moroso.getIdBiblio())) {
                return true;
            } else {
                this.error = "No se pudo eliminar al moroso";
                return false;
            }
        }
        this.error = "No has seleccionado ningun moroso";
        return false;
    }

    //trim
    public void trimUsuario(UsuarioPrestamo usuario) {
        usuario.setDni(usuario.getDni().trim());
        usuario.setNombres(usuario.getNombres().trim());
    }

    //Validaciones
    public boolean validarAgregarUsuario(UsuarioPrestamo usuario) {
        trimUsuario(usuario);
        return validarDNI(usuario.getDni())
                && validarNombres(usuario.getNombres());
    }

    public boolean validarDNI(String DNI) {
        if (DNI.length() == 8) {
            if (DNI.matches("\\d{8}")) {
                return true;
            }
        }
        this.error = "El DNI es invalido.";
        return false;
    }

    public boolean validarNombres(String nombres) {
        if (nombres.length() != 0) {
            return true;
        }
        this.error = "El nombre es invalido.";
        return false;
    }

    //Varios
    public Usuario convertirUsuario(UsuarioPrestamo usuario) {
        Usuario user = new Usuario();
        user.setIdBiblio(0);
        user.setDni(usuario.getDni());
        user.setNombres(usuario.getNombres());
        return user;
    }

    public String mostrarError() {
        String errorActual = this.error;
        this.error = "";
        return errorActual;
    }

    //Filtros
    public void filtrarPorNombreUsuario(String nombre, JTable tablaUsuarios) {
        List<UsuarioPrestamo> nombres = new ArrayList<>();

        for (UsuarioPrestamo usuario : usuariosActuales) {

            try {
                String nombreActual = usuario.getNombres();
                String subStrNombreActual = nombreActual.substring(0, nombre.length());

                nombre = nombre.toLowerCase();
                subStrNombreActual = subStrNombreActual.toLowerCase();

                String nombreNormalizado = Normalizer.normalize(nombre, Normalizer.Form.NFD)
                        .replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
                String subStrNombreActualNormalizado = Normalizer.normalize(subStrNombreActual, Normalizer.Form.NFD)
                        .replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");

                if (nombreNormalizado.equals(subStrNombreActualNormalizado)) {
                    nombres.add(usuario);
                }
            } catch (StringIndexOutOfBoundsException e) {

            }
        }

        CommonFunctions.llenarTabla(tablaUsuarios, UsuarioPrestamo.getColumnas(), nombres);
    }

    public void filtrarPorNombreMoroso(String nombre, JTable tablaUsuarios) {
        List<MorosoUsuario> nombres = new ArrayList<>();

        for (MorosoUsuario moroso : morososActuales) {

            try {
                String nombreActual = moroso.getNombres();
                String subStrNombreActual = nombreActual.substring(0, nombre.length());

                nombre = nombre.toLowerCase();
                subStrNombreActual = subStrNombreActual.toLowerCase();

                String nombreNormalizado = Normalizer.normalize(nombre, Normalizer.Form.NFD)
                        .replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
                String subStrNombreActualNormalizado = Normalizer.normalize(subStrNombreActual, Normalizer.Form.NFD)
                        .replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");

                if (nombreNormalizado.equals(subStrNombreActualNormalizado)) {
                    nombres.add(moroso);
                }
            } catch (StringIndexOutOfBoundsException e) {

            }
        }

        CommonFunctions.llenarTabla(tablaUsuarios, MorosoUsuario.getColumnas(), nombres);
    }

    //Tablas
    public void generarModeloUsuario(JTable tblUsuarios) {
        usuariosActuales = UsuarioRepo.obtenerHibridoUsuarioPrestamo();
        CommonFunctions.llenarTabla(tblUsuarios, UsuarioPrestamo.getColumnas(), usuariosActuales);
        modeloTablaUsuario = tblUsuarios.getModel();
        tblUsuarios.setModel(new DefaultTableModel());
    }

    public void cargarModeloUsuario(JTable tblUsuarios) {
        tblUsuarios.setModel(this.modeloTablaUsuario);
    }

    public void generarModeloMoroso(JTable tblUsuarios) {
        morososActuales = MorosoRepo.obtenerHibridoMorosoUsuario();
        CommonFunctions.llenarTabla(tblUsuarios, MorosoUsuario.getColumnas(), morososActuales);
        modeloTablaMoroso = tblUsuarios.getModel();
        tblUsuarios.setModel(new DefaultTableModel());
    }

    public void cargarModeloMoroso(JTable tblUsuarios) {
        tblUsuarios.setModel(this.modeloTablaMoroso);
    }
}
