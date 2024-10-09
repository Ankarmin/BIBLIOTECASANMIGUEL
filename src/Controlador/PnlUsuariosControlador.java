package Controlador;

import Vista.BibliotecaVista;
import Vista.UsuariosVista;
import Common.CommonFunctions;
import DBRepositorio.UsuarioRepositorio;
import DBRepositorio.MorosoRepositorio;
import DBRepositorio.UsuarioPrestamo;
import DBRepositorio.MorosoUsuario;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.TableModel;
import Modelo.ModeloUsuarios;
import javax.swing.JOptionPane;

public class PnlUsuariosControlador {

    private final FrmBibliotecaControlador bibliotecaControlador;

    private UsuariosVista vista;
    private final ModeloUsuarios usuarios;
    private final UsuarioRepositorio usuarioDriver;
    private final MorosoRepositorio morosoDriver;

    private UsuarioPrestamo usuarioSeleccionado;
    private MorosoUsuario morosoSeleccionado;

    private UsuarioPrestamo usuarioNuevo = new UsuarioPrestamo();
    private MorosoUsuario morosoNuevo = new MorosoUsuario();
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
        CommonFunctions.llenarTabla(vista.TblUsuarios, MorosoUsuario.getColumnas(), morosoDriver.obtenerHibridoMorosoUsuario());
        modeloMoroso = vista.TblUsuarios.getModel();

        CommonFunctions.llenarTabla(vista.TblUsuarios, UsuarioPrestamo.getColumnas(), usuarioDriver.obtenerHibridoUsuarioPrestamo());
        modeloUsuario = vista.TblUsuarios.getModel();

        clickUsuario = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                List<Object> datos = new ArrayList<>();
                int filaSeleccionada = vista.TblUsuarios.getSelectedRow();

                if (filaSeleccionada != -1) {
                    for (int i = 0; i < UsuarioPrestamo.getColumnas().size(); i++) {
                        datos.add(vista.TblUsuarios.getValueAt(filaSeleccionada, i));
                    }
                }

                usuarioSeleccionado = UsuarioPrestamo.toUsuarioPrestamo(datos);
                llenarCamposUsuario();

            }
        };
        clickMoroso = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                List<Object> datos = new ArrayList<>();
                int filaSeleccionada = vista.TblUsuarios.getSelectedRow();

                if (filaSeleccionada != -1) {
                    for (int i = 0; i < MorosoUsuario.getColumnas().size(); i++) {
                        datos.add(vista.TblUsuarios.getValueAt(filaSeleccionada, i));
                    }
                }

                morosoSeleccionado = MorosoUsuario.toMorosoUsuario(datos);
                llenarCamposMoroso();
            }
        };
        vista.BtnCambiarUsuarios.addActionListener((e) -> {
            if ("Usuario".equals(estado)) {
                vista.TblUsuarios.setModel(modeloMoroso);
                estado = "Moroso";
                limpiarCampos();
                cargarEventosTablaMoroso();
                vista.BtnAgregar.setVisible(false);
                vista.BtnCambiarUsuarios.setText("Ver Usuarios");
            } else {
                vista.TblUsuarios.setModel(modeloUsuario);
                estado = "Usuario";
                limpiarCampos();
                cargarEventosTablaUsuario();
                vista.BtnAgregar.setVisible(true);
                vista.BtnCambiarUsuarios.setText("Ver Morosos");
            }
        });
        vista.BtnEliminar.addActionListener((e) -> {
            setTxt();
            if ("Moroso".equals(estado)) {
                if (!usuarios.eliminarMoroso(morosoNuevo)) {
                    mostrarError("Error al Eliminar");
                } else {
                    usuarios.generarModeloMoroso(vista.TblUsuarios);
                    usuarios.cargarModeloMoroso(vista.TblUsuarios);
                    limpiarCampos();
                }
            }
            if ("Usuario".equals(estado)) {
                if (!usuarios.eliminarUsuario(usuarioNuevo)) {
                    mostrarError("Error al Eliminar");
                } else {
                    usuarios.generarModeloUsuario(vista.TblUsuarios);
                    usuarios.cargarModeloUsuario(vista.TblUsuarios);
                    limpiarCampos();
                }
            }
        }
        );
        vista.BtnAgregar.addActionListener((e) -> {
            setTxt();
            if ("Usuario".equals(estado)) {
                if (!usuarios.agregarUsuario(usuarioNuevo)) {
                    mostrarError("Error al Agregar");
                } else {
                    usuarios.generarModeloUsuario(vista.TblUsuarios);
                    usuarios.cargarModeloUsuario(vista.TblUsuarios);
                }
            }

        });
        vista.BtnBuscar.addActionListener((e) -> {
            setTxt();
            if ("Usuario".equals(estado)) {
                usuarios.filtrarPorNombreUsuario(usuarioNuevo.getNombres(), vista.TblUsuarios);
            }
            if ("Moroso".equals(estado)) {
                usuarios.filtrarPorNombreMoroso(morosoNuevo.getNombres(), vista.TblUsuarios);
            }
        });

    }

    public void setTxt() {
        if ("Usuario".equals(estado)) {
            usuarioNuevo.setIdBiblioteca(Integer.parseInt(vista.TxtIdBiblio.getText()));
            usuarioNuevo.setDni(vista.TxtDNI.getText());
            usuarioNuevo.setNombres(vista.TxtNombre.getText());
            usuarioNuevo.setLibrosPendientes(vista.TxtLibrosPendientes.getText());
        } else {
            morosoNuevo.setIdBiblio(Integer.parseInt(vista.TxtIdBiblio.getText()));
        }
    }

    public void mostrarError(String tipoError) {
        JOptionPane.showMessageDialog(vista,
                usuarios.mostrarError(), tipoError,
                JOptionPane.ERROR_MESSAGE);
    }

    public void mostrar() {
        bibliotecaControlador.getFrmBiblioteca().PnlContenido.removeAll();
        bibliotecaControlador.getFrmBiblioteca().PnlContenido.add(vista, BorderLayout.CENTER);
        bibliotecaControlador.getFrmBiblioteca().PnlContenido.revalidate();
        bibliotecaControlador.getFrmBiblioteca().PnlContenido.repaint();
        cargarEventosTablaUsuario();
    }

    public void llenarCamposUsuario() {
        vista.TxtIdBiblio.setText(String.valueOf(usuarioSeleccionado.getIdBiblioteca()));
        vista.TxtNombre.setText(usuarioSeleccionado.getNombres());
        vista.TxtDNI.setText(usuarioSeleccionado.getDni());
        vista.TxtLibrosPendientes.setText(usuarioSeleccionado.getLibrosPendientes());
    }

    public void llenarCamposMoroso() {
        vista.TxtIdBiblio.setText(String.valueOf(morosoSeleccionado.getIdBiblio()));
        vista.TxtDNI.setText(morosoSeleccionado.getDni());
        vista.TxtNombre.setText(morosoSeleccionado.getNombres());
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
}
