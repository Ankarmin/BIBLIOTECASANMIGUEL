package Controlador;

import DBRepositorio.Solicitud;
import DBRepositorio.SolicitudRepositorio;
import Modelo.ModeloSolicitudes;
import Vista.BibliotecaVista;
import Vista.SolicitudesVista;
import java.awt.BorderLayout;
import java.sql.Connection;
import javax.swing.JOptionPane;

public class PnlSolicitudesControlador {

    private final SolicitudesVista vista;
    private final ModeloSolicitudes modeloSolicitudes;

    public PnlSolicitudesControlador(Connection openConexion) {

        vista = new SolicitudesVista();
        modeloSolicitudes = new ModeloSolicitudes(new SolicitudRepositorio(openConexion));

        //EVENTO BOTON AGREGAR
        vista.BtnAgregar.addActionListener((e) -> {
            agregarSolicitud();
        });
    }

    public void mostrar(BibliotecaVista Padre) {
        Padre.PnlContenido.removeAll();
        Padre.PnlContenido.add(vista, BorderLayout.CENTER);
        Padre.PnlContenido.revalidate();
        Padre.PnlContenido.repaint();
    }

    public void agregarSolicitud() {
        if (vista.TxtAComentario.getText().isEmpty()) {
            JOptionPane.showMessageDialog(vista, "El comentario no puede estar vacío", "Error de Llenado", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String titulo = vista.TxtTitulo.getText();
        String autor = vista.TxtTema.getText().trim();
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
        } else {
            JOptionPane.showMessageDialog(vista, "Error al agregar la solicitud.", null, JOptionPane.ERROR_MESSAGE);
        }
    }
}
