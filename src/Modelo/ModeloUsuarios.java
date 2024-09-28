/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import DBRepositorio.UsuarioRepositorio;
import DBRepositorio.MorosoRepositorio;
import DBRepositorio.Moroso;
import DBRepositorio.Usuario;
import DBRepositorio.PrestamoLibro;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Nick Emanuel Salcedo Alfaro
 */

public class ModeloUsuarios {
    UsuarioRepositorio UsuarioRepo; 
    MorosoRepositorio MorosoRepo;
    public ModeloUsuarios()
    {
        this.UsuarioRepo= new UsuarioRepositorio();
        this.MorosoRepo = new MorosoRepositorio();
    }
    public List<Usuario> llenarTablaUsuarios(JTable Table){
        List<Usuario> Usuarios = UsuarioRepo.obtenerTodos();
        
        DefaultTableModel model = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        model.addColumn("IdBiblioteca");
        model.addColumn("DNI");
        model.addColumn("Nombres");
        model.addColumn("Estado del usuario");
        return Usuarios;
    }
    public List<Moroso> llenarTablaMorosos(JTable Table){
        List<Moroso> Morosos = MorosoRepo.obtenerTodos();
        DefaultTableModel model = new DefaultTableModel(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        model.addColumn("IdBiblioteca");
        model.addColumn("DNI");
        model.addColumn("Nombres");
        model.addColumn("Fecha de retorno");
        return Morosos;
    }
    public void eliminarUsuario(int IdBiblio){
        UsuarioRepo.eliminar(IdBiblio);
    }
    public void agregarUsuario(String nombre, String DNI){
        Usuario temp = new Usuario(0,nombre,DNI);
        UsuarioRepo.agregar(temp);
    }
    public void actualizarUsuario(String nombre, String DNI){
        Usuario temp = new Usuario(0, nombre, DNI);
        UsuarioRepo.actualizar(temp);
    }
    public void buscarUsuario(int idBiblio){
        Usuario temp = new Usuario();
        temp = UsuarioRepo.obtenerPorId(idBiblio);
    }
    public boolean cambiarUsuario(){
        return true;
    }
}
