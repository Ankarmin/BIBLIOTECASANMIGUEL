package Modelo;

import DBRepositorio.UsuarioRepositorio;
import DBRepositorio.MorosoRepositorio;
import DBRepositorio.Moroso;
import DBRepositorio.Usuario;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;

public class ModeloUsuarios {

    UsuarioRepositorio UsuarioRepo;
    MorosoRepositorio MorosoRepo;

    public ModeloUsuarios(Connection openConexion) {
        this.UsuarioRepo= new UsuarioRepositorio(openConexion);
        this.MorosoRepo = new MorosoRepositorio(openConexion);
    }

    public List<Usuario> llenarTablaUsuarios(JTable Table) {
        List<Usuario> Usuarios = UsuarioRepo.obtenerTodos();

        DefaultTableModel model = new DefaultTableModel() {
            @Override
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

    public List<Moroso> llenarTablaMorosos(JTable Table) {
        List<Moroso> Morosos = MorosoRepo.obtenerTodos();
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        model.addColumn("IdBiblioteca");
        model.addColumn("DNI");
        model.addColumn("Nombres");
        model.addColumn("Fecha de retorno");
        return Morosos;
    }

    public void eliminarUsuario(int IdBiblio) {
        UsuarioRepo.eliminar(IdBiblio);
    }

    public void agregarUsuario(String nombre, String DNI) {
        Usuario temp = new Usuario(0, nombre, DNI);
        UsuarioRepo.agregar(temp);
    }

    public void actualizarUsuario(String nombre, String DNI) {
        Usuario temp = new Usuario(0, nombre, DNI);
        UsuarioRepo.actualizar(temp);
    }

    public void buscarUsuario(int idBiblio) {
        Usuario temp = new Usuario();
        temp = UsuarioRepo.obtenerPorId(idBiblio);
    }

    public boolean cambiarUsuario() {
        return true;
    }
}
