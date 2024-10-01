package tempRunner;

import Controlador.FrmBibliotecaControlador;
import Vista.BibliotecaVista;
import com.formdev.flatlaf.intellijthemes.FlatSolarizedLightIJTheme;

public class App {

    //METODO MAIN PARA INCIAR EL PROGRAMA
    public static void main(String[] args) {
        //FUNCION RARA PARA INCIAR LOS ESTILOS DE FLATLAF
        FlatSolarizedLightIJTheme.setup();
        
        //INSTANCIACION DEL CONTROLADOR MAESTRO
        FrmBibliotecaControlador controladorBiblioteca = new FrmBibliotecaControlador();

        //METODO QUE CARGA EL JFRAME INICIAL (LA VENTANA)
        controladorBiblioteca.iniciar();
    }
}
