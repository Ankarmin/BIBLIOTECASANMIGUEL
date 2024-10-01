package tempRunner;

import Controlador.FrmBibliotecaControlador;
import com.formdev.flatlaf.intellijthemes.FlatSolarizedLightIJTheme;
import javax.swing.UIManager;

public class App {

    //METODO MAIN PARA INCIAR EL PROGRAMA
    public static void main(String[] args) {
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
        controladorBiblioteca.iniciar();
    }
}
