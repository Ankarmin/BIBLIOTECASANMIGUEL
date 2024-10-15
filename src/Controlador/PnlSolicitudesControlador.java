

package Controlador;

import DBRepositorio.Solicitud;
import DBRepositorio.SolicitudRepositorio;
import Modelo.ModeloSolicitudes;
import Vista.BibliotecaVista;
import Vista.SolicitudesVista;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.util.List;

public class PnlSolicitudesControlador {

    private final SolicitudesVista vista;
    private final ModeloSolicitudes modeloSolicitudes;
    private Solicitud solicitudSeleccionada;
    
    public PnlSolicitudesControlador(Connection openConexion) {

        vista = new SolicitudesVista();
        modeloSolicitudes = new ModeloSolicitudes(new SolicitudRepositorio(openConexion));
        // Cargar solicitudes por defecto
        cargarSolicitudesEnTabla();
         // Evento para el botón Eliminar
        vista.BtnEliminar.addActionListener((e) -> {
            eliminarSolicitud();
        });

        //EVENTO BOTON AGREGAR
        vista.BtnAgregar.addActionListener((e) -> {
            agregarSolicitud();
        });
        vista.TblMateriales.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionarSolicitud();
            }
        });
    }
    private void cargarSolicitudesEnTabla() {
        List<Solicitud> solicitudes = modeloSolicitudes.obtenerTodas();
        vista.cargarSolicitudesEnTabla(solicitudes); // Asegúrate de que este método esté definido en la vista
    }

    public void mostrar(BibliotecaVista padre) {
        padre.PnlContenido.removeAll();
        padre.PnlContenido.add(vista, BorderLayout.CENTER);
        padre.PnlContenido.revalidate();
        padre.PnlContenido.repaint();
    }
    private void eliminarSolicitud() {
        if (solicitudSeleccionada == null) {
            JOptionPane.showMessageDialog(vista, "Seleccione una solicitud para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Confirmar la eliminación
        int confirmacion = JOptionPane.showConfirmDialog(vista, "¿Está seguro que desea eliminar la solicitud seleccionada?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            boolean resultado = modeloSolicitudes.eliminarSolicitud(solicitudSeleccionada);
            if (resultado) {
                JOptionPane.showMessageDialog(vista, "Solicitud eliminada con éxito.");
                cargarSolicitudesEnTabla(); // Refrescar la tabla
                limpiarCampos(); // Limpiar los campos de texto
            } else {
                JOptionPane.showMessageDialog(vista, "Error al eliminar la solicitud.", null, JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    private void seleccionarSolicitud() {
        int filaSeleccionada = vista.TblMateriales.getSelectedRow();
        if (filaSeleccionada != -1) {
            solicitudSeleccionada = vista.getSolicitudEnFila(filaSeleccionada); // Obtener la solicitud seleccionada

            // Rellenar los campos de texto con los datos de la solicitud seleccionada
            vista.TxtTitulo.setText(solicitudSeleccionada.getTitulo());
            vista.TxtAutor.setText(solicitudSeleccionada.getAutor());
            vista.TxtTema.setText(solicitudSeleccionada.getTema());
            vista.TxtAComentario.setText(solicitudSeleccionada.getComentarios());
        }
    }
    
    public void agregarSolicitud() {
         // Verificación individual de los campos de texto
        if (vista.TxtTitulo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(vista, "El campo 'Título' no puede estar vacío.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            vista.TxtTitulo.requestFocus();  // Colocar el cursor en el campo vacío
            return;
        }

        if (vista.TxtAutor.getText().isEmpty()) {
            JOptionPane.showMessageDialog(vista, "El campo 'Autor' no puede estar vacío.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            vista.TxtAutor.requestFocus();  // Colocar el cursor en el campo vacío
            return;
        }

        if (vista.TxtTema.getText().isEmpty()) {
            JOptionPane.showMessageDialog(vista, "El campo 'Tema' no puede estar vacío.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            vista.TxtTema.requestFocus();  // Colocar el cursor en el campo vacío
            return;
        }

        String titulo = vista.TxtTitulo.getText();
        String autor = vista.TxtAutor.getText().trim();
        String tema = vista.TxtTema.getText();
        String comentario = vista.TxtAComentario.getText();

        Solicitud solicitud = new Solicitud();
        solicitud.setTitulo(titulo);
        solicitud.setAutor(autor);
        solicitud.setTema(tema);
        solicitud.setComentarios(comentario);

        boolean resultado = modeloSolicitudes.agregarSolicitud(solicitud);
        if (resultado) {
                JOptionPane.showMessageDialog(vista, "Solicitud agregada con éxito.");
                cargarSolicitudesEnTabla();
                limpiarCampos();        
        } else {
            JOptionPane.showMessageDialog(vista, "Error al agregar la solicitud.", null, JOptionPane.ERROR_MESSAGE);
        }
    }
    private void limpiarCampos() {
        vista.TxtTitulo.setText("");
        vista.TxtAutor.setText("");
        vista.TxtTema.setText("");
        vista.TxtAComentario.setText("");
        solicitudSeleccionada = null;
    }
}


