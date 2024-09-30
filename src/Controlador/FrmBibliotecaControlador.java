package Controlador;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import Vista.BibliotecaVista;
import Vista.DevolucionesVista;
import Vista.MaterialesVista;
import Vista.PrestamosVista;
import Vista.SolicitudesVista;
import Vista.UsuariosVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JFrame;

public class FrmBibliotecaControlador {

    // Atributos privados
    private Connection openConexion;
    private static final String URL = "jdbc:mysql://autorack.proxy.rlwy.net:50572/railway";
    private static final String USER = "root";
    private static final String PASSWORD = "TuuSNAhxOdMuZfOaGnaMDytrIOeUpwcN";

    //Vista
    private BibliotecaVista frmBiblioteca;

    //Controladores
    private final PnlMaterialesControlador controladorMateriales;
    private final PnlDevolucionesControlador controladorDevoluciones;
    private final PnlPrestamosControlador controladorPrestamos;
    private final PnlUsuariosControlador controladorUsuarios;
    private final PnlSolicitudesControlador controladorSolicitudes;

    public FrmBibliotecaControlador() {
        Conectar();

        frmBiblioteca = new BibliotecaVista();

        controladorUsuarios = new PnlUsuariosControlador(openConexion);
        controladorPrestamos = new PnlPrestamosControlador(openConexion);
        controladorDevoluciones = new PnlDevolucionesControlador(openConexion);
        controladorMateriales = new PnlMaterialesControlador(openConexion);
        controladorSolicitudes = new PnlSolicitudesControlador(openConexion);

        SetEvents();
    }

    // Conexion con railway
    private void Conectar() {
        try {
            this.openConexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexion exitosa a la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
    }

    public final void SetEvents() {
        frmBiblioteca.BtnUsuarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controladorUsuarios.mostrar(frmBiblioteca);
            }
        });

        frmBiblioteca.BtnPrestamos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controladorPrestamos.mostrar(frmBiblioteca);
            }
        });

        frmBiblioteca.BtnDevolucion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controladorDevoluciones.mostrar(frmBiblioteca);
            }
        });

        frmBiblioteca.BtnMateriales.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controladorMateriales.mostrar(frmBiblioteca);
            }
        });

        frmBiblioteca.BtnSolicitudes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controladorSolicitudes.mostrar(frmBiblioteca);
            }
        });
    }

    public void iniciar() {
        this.frmBiblioteca.setLocationRelativeTo(null);
        this.frmBiblioteca.setVisible(true);
    }

}
