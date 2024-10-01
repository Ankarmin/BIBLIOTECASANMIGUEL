package Controlador;

import Vista.BibliotecaVista;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//CONTROLADOR DEL JFRAME DE LA BIBLIOTECA (LA VENTANA)
public class FrmBibliotecaControlador {

    //ATRIBUTOS DESTINADOS A CONECTARSE CON LA BASE DE DATOS
    private Connection openConexion; // ANOTACION: ESTA CONEXION SERÁ UTILIZADA POR TODOS LOS CONTROLADORES
    private static final String URL = "jdbc:mysql://autorack.proxy.rlwy.net:50572/railway";
    private static final String USER = "root";
    private static final String PASSWORD = "TuuSNAhxOdMuZfOaGnaMDytrIOeUpwcN";

    //LA VISTA DEL CONTROLADOR (ES LA VENTANA QUE APARECE AL INCIAR EL PROGRAMA)
    private final BibliotecaVista frmBiblioteca;

    //TODOS LOS DEMAS CONTROLADORES ESTAN AQUI
    private final PnlMaterialesControlador controladorMateriales;
    private final PnlDevolucionesControlador controladorDevoluciones;
    private final PnlPrestamosControlador controladorPrestamos;
    private final PnlUsuariosControlador controladorUsuarios;
    private final PnlSolicitudesControlador controladorSolicitudes;

    //CONSTRUCTOR DEL CONTROLADOR DEL FRAME BIBLIOTECA
    public FrmBibliotecaControlador() {

        //INICIALIZA CONEXION (SI ESTO FALLA SE VA TODO A LA MRD XD)
        Conectar();

        //INSTANCIACIÓN DEL FRAME DE BIBLIOTECA
        frmBiblioteca = new BibliotecaVista();

        //INSTANCIACIÓN DE LOS CONTROLADORES
        controladorUsuarios = new PnlUsuariosControlador(openConexion);
        controladorPrestamos = new PnlPrestamosControlador(openConexion);
        controladorDevoluciones = new PnlDevolucionesControlador(openConexion);
        controladorMateriales = new PnlMaterialesControlador(openConexion);
        controladorSolicitudes = new PnlSolicitudesControlador(openConexion);

        //MÉTODO QUE AGREGA LOS EVENTOS DE LOS BOTONES DE BIBLIOTECAVISTA (LO QUE APARECE EN EL MOQUPS YA TE LA SABES: USUARIOS,
        //PRESTAMOS, DEVOLUCIONES, ETC...)
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

    //MÉTODO QUE CONFIGURA LOS EVENTOS DE CLICK DE LOS BOTONES DE BIBLITOECAVISTA
    public final void SetEvents() {
        // OBSERVAMOS EL SIGUIENTE EJEMPLO: BASICAMENTE AÑADE UN EVENTO QUE "ESCUCHA" EL CLICK SOBRE EL BOTON
        frmBiblioteca.BtnUsuarios.addActionListener((e) -> {
            // POR EJEMPLO, AQUI EL EVENTO CONSISTE EN LA LLAMADA AL MÉTODO MOSTRAR DEL CONTROLADOR DE USUARIOS
            controladorUsuarios.mostrar(frmBiblioteca);
        } // ESTE ES EL EVENTO EN CUESTIÓN, SOBREESCRIBE UN MÉTODO YA EXISTENTE (QUIERE DECIR QUE CAMBIA EL MÉTODO
        // POR DEFECTO Y AGREGA EL QUE NOSOTROS LE INDIQUEMOS)
        );
        // Y ASI CON TODOS LOS DEMAS C:
        frmBiblioteca.BtnPrestamos.addActionListener((e) -> {
            controladorPrestamos.mostrar(frmBiblioteca);
        });

        frmBiblioteca.BtnDevolucion.addActionListener((e) -> {
            controladorDevoluciones.mostrar(frmBiblioteca);
        });

        frmBiblioteca.BtnMateriales.addActionListener((e) -> {
            controladorMateriales.mostrar(frmBiblioteca);
        });

        frmBiblioteca.BtnSolicitudes.addActionListener((e) -> {
            controladorSolicitudes.mostrar(frmBiblioteca);
        });
    }

    //MÉTODO QUE CENTRA Y VUELVE VISIBLE AL JFRAME BIBLIOTECAVISTA 
    public void iniciar() {
        this.frmBiblioteca.setLocationRelativeTo(null);
        this.frmBiblioteca.setVisible(true);
    }

}
