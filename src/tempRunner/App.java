package tempRunner;

import Controlador.FrmBibliotecaControlador;
import Vista.BibliotecaVista;
import com.formdev.flatlaf.intellijthemes.FlatSolarizedLightIJTheme;

public class App {

    public static void main(String[] args) {
        FlatSolarizedLightIJTheme.setup();
        FrmBibliotecaControlador controladorBiblioteca = new FrmBibliotecaControlador();

        controladorBiblioteca.iniciar();

        //BibliotecaVista ola = new BibliotecaVista();
        //ola.setVisible(true);
        //App miApp = new App();
        //UsuarioRepositorio usuarioDriver = new UsuarioRepositorio(miApp.Conectar());
        //usuarioDriver.obtenerPorId(1);
        //PrestamoMonografia pLibro = new PrestamoMonografia(0, "1234567892", 1, "", "2024-10-22");
        //usuarioDriver.agregar(pLibro);
    }
}
