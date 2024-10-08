package tempRunner;

import Controlador.FrmBibliotecaControlador;
import DBRepositorio.MorosoRepositorio;
import DBRepositorio.MorosoUsuario;
import DBRepositorio.UsuarioPrestamo;
import DBRepositorio.UsuarioRepositorio;
import com.formdev.flatlaf.intellijthemes.FlatSolarizedLightIJTheme;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.UIManager;
import java.sql.Connection;
import java.util.List;

public class App {

    //METODO MAIN PARA INCIAR EL PROGRAMA
    public static void main(String[] args) {

        String URL = "jdbc:mysql://autorack.proxy.rlwy.net:50572/railway";
        String USER = "root";
        String PASSWORD = "TuuSNAhxOdMuZfOaGnaMDytrIOeUpwcN";

        //FUNCION RARA PARA INCIAR LOS ESTILOS DE FLATLAF
        FlatSolarizedLightIJTheme.setup();
        UIManager.put("Button.arc", 999);
        UIManager.put("Component.arc", 999);
        UIManager.put("ProgressBar.arc", 999);
        UIManager.put("TextComponent.arc", 999);
        UIManager.put("Component.focusWidth", 0);

        //INSTANCIACION DEL CONTROLADOR MAESTRO
        FrmBibliotecaControlador controladorBiblioteca = new FrmBibliotecaControlador();

        //METODO QUE CARGA EL JFRAME INICIAL (LA VENTANA)
        //controladorBiblioteca.iniciar();
        try {
            Connection openConexion = DriverManager.getConnection(URL, USER, PASSWORD);
            UsuarioRepositorio libroDriver = new UsuarioRepositorio(openConexion);

            List<UsuarioPrestamo> lista = libroDriver.obtenerHibridoUsuarioPrestamo();

            for (UsuarioPrestamo el : lista) {
                System.out.println(el.getIdBiblioteca());
            }

        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }

    }

}
