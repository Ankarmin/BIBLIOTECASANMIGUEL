package Controlador;

import Vista.BibliotecaVista;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//CONTROLADOR DEL JFRAME DE LA BIBLIOTECA (LA VENTANA)
public class FrmBibliotecaControlador {

    //ATRIBUTOS DESTINADOS A CONECTARSE CON LA BASE DE DATOS
    private Connection openConexion; // ESTA CONEXION SERÁ UTILIZADA POR TODOS LOS CONTROLADORES
    private static final String URL = "jdbc:mysql://autorack.proxy.rlwy.net:50572/railway";
    private static final String USER = "root";
    private static final String PASSWORD = "TuuSNAhxOdMuZfOaGnaMDytrIOeUpwcN";

    //LA VISTA DEL CONTROLADOR (ES LA VENTANA QUE APARECE AL INCIAR EL PROGRAMA)
    private final BibliotecaVista frmBiblioteca;

    //TODOS LOS DEMAS CONTROLADORES ESTAN AQUI
    private final PnlMaterialesControlador controladorMateriales;
    private final PnlDevolucionesControlador controladorDevoluciones;
    private final PnlPrestamosControlador controladorPrestamos;
    private final PnlPrestamosActivosControlador controladorPrestamosActivos;
    private final PnlUsuariosControlador controladorUsuarios;
    private final PnlSolicitudesControlador controladorSolicitudes;

    //CONSTRUCTOR DEL CONTROLADOR DEL FRAME BIBLIOTECA
    public FrmBibliotecaControlador() {

        //INICIALIZA CONEXION (SI ESTO FALLA SE VA TODO A LA MRD XD)
        Conectar();

        //INSTANCIACIÓN DEL FRAME DE BIBLIOTECA
        frmBiblioteca = new BibliotecaVista();

        //INSTANCIACIÓN DE LOS CONTROLADORES
        controladorUsuarios = new PnlUsuariosControlador(openConexion, this);
        controladorPrestamos = new PnlPrestamosControlador(openConexion, this);
        controladorDevoluciones = new PnlDevolucionesControlador(openConexion, this);
        controladorMateriales = new PnlMaterialesControlador(openConexion, this);
        controladorSolicitudes = new PnlSolicitudesControlador(openConexion);
        controladorPrestamosActivos = new PnlPrestamosActivosControlador(openConexion, this);

        //MÉTODO QUE AGREGA LOS EVENTOS DE LOS BOTONES DE BIBLIOTECAVISTA
        SetEvents();
    }

    //MÉTODO PARA CONECTARSE A LA BASE DE DATOS (INICIALIZA OPENCONEXION)
    private void Conectar() {
        try {
            this.openConexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexion exitosa a la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
    }

    //MÉTODO QUE CONFIGURA LOS EVENTOS DE CLICK DE LOS BOTONES DE BIBLIOTECAVISTA
    public final void SetEvents() {
        frmBiblioteca.BtnUsuarios.addActionListener((e) -> {
            controladorUsuarios.mostrar();
        });

        frmBiblioteca.BtnPrestamos.addActionListener((e) -> {
            controladorPrestamos.mostrar();
        });

        frmBiblioteca.BtnDevolucion.addActionListener((e) -> {
            controladorDevoluciones.mostrar();
        });

        frmBiblioteca.BtnMateriales.addActionListener((e) -> {
            controladorMateriales.mostrar();
        });

        frmBiblioteca.BtnSolicitudes.addActionListener((e) -> {
            controladorSolicitudes.mostrar(frmBiblioteca);
        });
    }

    //MÉTODO QUE CENTRA Y VUELVE VISIBLE AL JFRAME BIBLIOTECAVISTA 
    public void iniciar() {
        frmBiblioteca.setLocationRelativeTo(null);
        frmBiblioteca.setVisible(true);
    }

    public PnlDevolucionesControlador getControladorDevoluciones() {
        return controladorDevoluciones;
    }

    public PnlPrestamosControlador getControladorPrestamos() {
        return controladorPrestamos;
    }

    public PnlPrestamosActivosControlador getControladorPrestamosActivos() {
        return controladorPrestamosActivos;
    }

    public BibliotecaVista getFrmBiblioteca() {
        return frmBiblioteca;
    }

}
