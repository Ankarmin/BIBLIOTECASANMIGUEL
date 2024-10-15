package Modelo;

import DBRepositorio.Solicitud;
import DBRepositorio.SolicitudRepositorio;
import java.util.List;

public class ModeloSolicitudes {

    private final SolicitudRepositorio solicitudRepositorio;


    public ModeloSolicitudes(SolicitudRepositorio solicitudRepositorio) {
        this.solicitudRepositorio = solicitudRepositorio;
    }

    public boolean agregarSolicitud(Solicitud solicitud) {
        return solicitudRepositorio.agregar(solicitud);
    }
    public List<Solicitud> obtenerTodas() {
        return solicitudRepositorio.obtenerTodos();
    }
    public boolean eliminarSolicitud(Solicitud solicitud){
        return solicitudRepositorio.eliminar(solicitud.getIdSolicitud());
    }
}