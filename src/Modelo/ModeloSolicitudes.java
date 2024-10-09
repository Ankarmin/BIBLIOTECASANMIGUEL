package Modelo;

import DBRepositorio.Solicitud;
import DBRepositorio.SolicitudRepositorio;

public class ModeloSolicitudes {

    private final SolicitudRepositorio solicitudRepositorio;

    public ModeloSolicitudes(SolicitudRepositorio solicitudRepositorio) {
        this.solicitudRepositorio = solicitudRepositorio;
    }

    public boolean agregarSolicitud(Solicitud solicitud) {
        return solicitudRepositorio.agregar(solicitud);
    }
}
