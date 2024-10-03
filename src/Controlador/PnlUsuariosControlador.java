package Controlador;

import Vista.BibliotecaVista;
import Vista.UsuariosVista;
import Common.CommonFunctions;
import DBRepositorio.UsuarioRepositorio;
import DBRepositorio.MorosoRepositorio;
import DBRepositorio.Usuario;
import DBRepositorio.Moroso;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.TableModel;
import Modelo.ModeloUsuarios;

public class PnlUsuariosControlador {

    private final FrmBibliotecaControlador bibliotecaControlador;

    private UsuariosVista vista;

    private final UsuarioRepositorio usuarioDriver;
    private final MorosoRepositorio morosoDriver;

    //LAS SELECCIONES QUE SE REALICEN EN LA TABLA(CON EL MOUSE)
    private Usuario usuarioSeleccionado;
    private Moroso morosoSeleccionado;
    private ModeloUsuarios usuarios;
    //LOS MODELO QUE SE VAN A CARGAR (LOS DEFINO AQUI PARA QUE NO SE RECARGUEN EN CADA CAMBIO YA QUE SERIA UNA TOTAL MIERDA
    //SI SE RECARGARAN EN CADA CAMBIO)
    private TableModel modeloUsuario;
    private TableModel modeloMoroso;

    //EVENTOS PARA EL CLICK EN LA TABLA
    private final MouseAdapter clickUsuario;
    private final MouseAdapter clickMoroso;

    //EL ESTADO DE LA TABLA
    private String estado = "Usuario";

    public PnlUsuariosControlador(Connection openConexion, FrmBibliotecaControlador bibliotecaControlador) {

        this.bibliotecaControlador = bibliotecaControlador;

        vista = new UsuariosVista();
        usuarioDriver = new UsuarioRepositorio(openConexion);
        morosoDriver = new MorosoRepositorio(openConexion);
        usuarios = new ModeloUsuarios(openConexion);
        CommonFunctions.llenarTabla(vista.TblUsuarios, Moroso.getColumnas(), morosoDriver.obtenerTodos());
        modeloMoroso = vista.TblUsuarios.getModel();

        CommonFunctions.llenarTabla(vista.TblUsuarios, Usuario.getColumnas(), usuarioDriver.obtenerTodos());
        modeloUsuario = vista.TblUsuarios.getModel();

        clickUsuario = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                List<Object> datos = new ArrayList<>();
                int filaSeleccionada = vista.TblUsuarios.getSelectedRow();

                if (filaSeleccionada != -1) {
                    for (int i = 0; i < Usuario.getColumnas().size(); i++) {
                        datos.add(vista.TblUsuarios.getValueAt(filaSeleccionada, i));
                    }
                }

                usuarioSeleccionado = Usuario.toUsuario(datos);
                llenarCamposUsuario();

            }
        };
        clickMoroso = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                List<Object> datos = new ArrayList<>();
                //ACCEDIENDO A LA FILA SELECCIONADA
                int filaSeleccionada = vista.TblUsuarios.getSelectedRow();

                if (filaSeleccionada != -1) {
                    for (int i = 0; i < Moroso.getColumnas().size(); i++) {
                        datos.add(vista.TblUsuarios.getValueAt(filaSeleccionada, i));
                    }
                }

                morosoSeleccionado = Moroso.toMoroso(datos);
                llenarCamposMoroso();
            }
        };
        vista.BtnCambiarUsuarios.addActionListener((e) -> {
            if ("Usuario".equals(estado)) {
                vista.TblUsuarios.setModel(modeloMoroso);
                estado = "Moroso";
                limpiarCampos();
                cargarEventosTablaMoroso();
                vista.BtnCambiarUsuarios.setText("Ver Usuarios");
            } else {
                vista.TblUsuarios.setModel(modeloUsuario);
                estado = "Usuario";
                limpiarCampos();
                cargarEventosTablaUsuario();
               
                vista.BtnCambiarUsuarios.setText("Ver Morosos");
            }
        });
        vista.BtnEliminar.addActionListener((e) -> {
            if ("Usuario".equals(estado)) {
                eliminarUsuario();
                limpiarCampos();
                actualizarTablaUsuario();
            } else {
                eliminarMoroso();
                limpiarCampos();
                cargarEventosTablaMoroso();
            }
        });
        vista.BtnAgregar.addActionListener((e)->{
           if ("Usuario".equals(estado)){
               agregarUsuario();
               limpiarCampos();
               actualizarTablaUsuario();
           } else{
               agregarMoroso();
               limpiarCampos();
               actualizarTablaMoroso();
           }
        });
        vista.BtnBuscar.addActionListener((e)->{
           if ("Usuario".equals(estado)){
               buscarUsuario();
           } else{
               buscarMoroso();
           }
        });
    }

    public void mostrar() {
        bibliotecaControlador.getFrmBiblioteca().PnlContenido.removeAll();
        bibliotecaControlador.getFrmBiblioteca().PnlContenido.add(vista, BorderLayout.CENTER);
        bibliotecaControlador.getFrmBiblioteca().PnlContenido.revalidate();
        bibliotecaControlador.getFrmBiblioteca().PnlContenido.repaint();
        cargarEventosTablaUsuario();
    }

    public void llenarCamposUsuario() {
        vista.TxtIdBiblio.setText(String.valueOf(usuarioSeleccionado.getIdBiblio()));
        vista.TxtNombre.setText(usuarioSeleccionado.getNombres());
        vista.TxtDNI.setText(usuarioSeleccionado.getDni());
    }

    public void llenarCamposMoroso() {
        vista.TxtIdBiblio.setText(String.valueOf(morosoSeleccionado.getIdBiblio()));
        //Nombres
        //DNI
    }

    public void limpiarCampos() {
        vista.TxtIdBiblio.setText("");
        vista.TxtDNI.setText("");
        vista.TxtNombre.setText("");
    }

    public void cargarEventosTablaUsuario() {
        vista.TblUsuarios.removeMouseListener(clickMoroso);
        vista.TblUsuarios.addMouseListener(clickUsuario);
    }

    public void cargarEventosTablaMoroso() {
        vista.TblUsuarios.removeMouseListener(clickUsuario);
        vista.TblUsuarios.addMouseListener(clickMoroso);
    }
    public void agregarUsuario(){
        String nombre=vista.TxtNombre.getText();
        String dni =vista.TxtDNI.getText();
        usuarios.agregarUsuario(dni, nombre );
    }
    public void agregarMoroso(){
        String nombre=vista.TxtNombre.getText();
        String dni =vista.TxtDNI.getText();
        usuarios.agregarMoroso(dni, nombre);
    }
    public  void eliminarUsuario(){
        int idBiblio = Integer.parseInt(vista.TxtIdBiblio.getText());
        usuarios.eliminarUsuario(idBiblio);
    }
    public void eliminarMoroso(){
        int idBiblio = Integer.parseInt(vista.TxtIdBiblio.getText());
        usuarios.eliminarMoroso(idBiblio);
    }
    public void buscarUsuario(){
        
    }
    public void buscarMoroso(){
        
    }
    public void actualizarTablaUsuario(){
        CommonFunctions.llenarTabla(vista.TblUsuarios, Usuario.getColumnas(), usuarioDriver.obtenerTodos());
        modeloUsuario = vista.TblUsuarios.getModel();
    }
    public void actualizarTablaMoroso(){
        CommonFunctions.llenarTabla(vista.TblUsuarios, Moroso.getColumnas(), morosoDriver.obtenerTodos());
        modeloMoroso = vista.TblUsuarios.getModel();
    }
}
