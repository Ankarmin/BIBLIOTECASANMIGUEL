package Modelo;

import DBRepositorio.UsuarioRepositorio;
import DBRepositorio.MorosoRepositorio;
import DBRepositorio.Moroso;
import DBRepositorio.Usuario;
import java.sql.Connection;

public class ModeloUsuarios {

    UsuarioRepositorio UsuarioRepo;
    MorosoRepositorio MorosoRepo;

    public ModeloUsuarios(Connection openConexion) {
        this.UsuarioRepo= new UsuarioRepositorio(openConexion);
        this.MorosoRepo = new MorosoRepositorio(openConexion);
    }

    public void eliminarUsuario(int IdBiblio) {
        UsuarioRepo.eliminar(IdBiblio);
    }

    public void agregarUsuario(String DNI, String nombre) {
        Usuario temp = new Usuario(0, DNI, nombre);
        UsuarioRepo.agregar(temp);
    }

    public void actualizarUsuario(String DNI, String nombre) {
        Usuario temp = new Usuario(0, DNI, nombre);
        UsuarioRepo.actualizar(temp);
    }

    public void buscarUsuario(Integer idBiblio) {
        Usuario temp = new Usuario();
        temp = UsuarioRepo.obtenerPorId(idBiblio);
    }
    public void eliminarMoroso(Integer IdBiblio){
        MorosoRepo.eliminar(IdBiblio);
    }
    public void agregarMoroso(String DNI, String nombre){
        //Moroso temp = new Moroso(0,nombre,DNI); Esperar a la actualizacion
        //MorosoRepo.agregar(temp);
    }
    public void actualizarMoroso(String nombre, String DNI){
        //Moroso temp = new Moroso(0,nombre,DNI); Esperar a la actualizacion
        //MorosoRepo.actualizar(temp);
    }
    public void buscarMoroso(int IdBiblio){
        Moroso temp = new Moroso();
        temp = MorosoRepo.obtenerPorId(IdBiblio);
    }
}
