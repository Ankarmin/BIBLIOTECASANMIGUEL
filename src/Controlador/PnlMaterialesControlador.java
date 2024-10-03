// EJEMPLO PARCIAL DE COMO UTILIZAR COMMONFUNCTIONS EN EL CONTROLADOR DE MATERIALES
package Controlador;

//CLASES NECESARIAS
import Common.CommonFunctions;
import DBRepositorio.Libro;
import DBRepositorio.LibroRepositorio;
import DBRepositorio.Monografia;
import DBRepositorio.MonografiaRepositorio;
import Vista.MaterialesVista;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.TableModel;

public class PnlMaterialesControlador {

    //ATRIBUTOS PRIVADOR
    //AHORA TODOS SON HERMANOS
    private final FrmBibliotecaControlador bibliotecaControlador;

    //LA VISTA DEL CONTROLADOR
    private MaterialesVista vista;

    //LOS REPOSITORIOS A UTILIZAR
    private final LibroRepositorio libroDriver;
    private final MonografiaRepositorio monografiaDriver;

    //LAS SELECCIONES QUE SE REALICEN EN LA TABLA(CON EL MOUSE)
    private Libro libroSeleccionado;
    private Monografia monografiaSeleccionada;

    //LOS MODELO QUE SE VAN A CARGAR (LOS DEFINO AQUI PARA QUE NO SE RECARGUEN EN CADA CAMBIO YA QUE SERIA UNA TOTAL MIERDA
    //SI SE RECARGARAN EN CADA CAMBIO)
    private TableModel modeloLibros;
    private TableModel modeloMonografias;

    //EVENTOS PARA EL CLICK EN LA TABLA
    private final MouseAdapter clickLibro;
    private final MouseAdapter clickMonografia;

    //EL ESTADO DE LA TABLA
    private String estado = "Libro";

    //Constructor
    PnlMaterialesControlador(Connection openConexion, FrmBibliotecaControlador bibliotecaControlador) {

        //BIBLIOTECA VISTA DE REFERENCIA
        this.bibliotecaControlador = bibliotecaControlador;

        //INICIALIZACION DE LA VISTA
        vista = new MaterialesVista();

        //INCIALIZACION DE LOS REPOSITORIOS
        libroDriver = new LibroRepositorio(openConexion);
        monografiaDriver = new MonografiaRepositorio(openConexion);

        //GENERACION DE LOS MODELOS (PUEDES HACERLO ASI O RECARGAR CADA VEZ QUE SE CAMBIE DE TABLA, DEPENDIENDO DE TI AH)
        CommonFunctions.llenarTabla(vista.TblMateriales, Monografia.getColumnas(), monografiaDriver.obtenerTodos());

        //AQUI EXTRAEMOS EL MODELOD DE LA TABLA PARA TENERLO LISTO PARA EL CAMBIO
        modeloMonografias = vista.TblMateriales.getModel();

        // COMO ES EL SEGUNDO EN SER LLAMADO, LOS LIBROS SE VERAN PRIMERO EN LA TABLA
        CommonFunctions.llenarTabla(vista.TblMateriales, Libro.getColumnas(), libroDriver.obtenerTodos());
        modeloLibros = vista.TblMateriales.getModel();

        //EVENTOS DE CLICKS EN LA TABLA
        //EN ESTE CASO SE DEFINE UN EVENTO DE MOUSE QUE AUN NO ES ASIGNADO A NINGUN COMPONENTE (DIGASE BOTON, TABLA, COMBOBOX, ETC)
        clickLibro = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                // BASICAMENTE LO QUE HACE ES RECUPERAR LOS DATOS DE UNA FILA DE LA TABLA Y LOS 
                // ASIGNA AL ATRIBUTO LIBROSELECCIONADO, PARA LUEGO COLOCARLO EN LOS CAMPOS
                // TEXTFIELD
                List<Object> datos = new ArrayList<>();
                int filaSeleccionada = vista.TblMateriales.getSelectedRow();

                if (filaSeleccionada != -1) {
                    for (int i = 0; i < Libro.getColumnas().size(); i++) {
                        datos.add(vista.TblMateriales.getValueAt(filaSeleccionada, i));
                    }
                }

                libroSeleccionado = Libro.toLibro(datos);
                llenarCamposLibro();

                if (e.getClickCount() == 2) {
                    irAPrestamos(libroSeleccionado);
                }

            }
        };

        //AQUI ES MAS DE LO MISMO PERO CON MONOGRAFIA
        clickMonografia = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                List<Object> datos = new ArrayList<>();
                //ACCEDIENDO A LA FILA SELECCIONADA
                int filaSeleccionada = vista.TblMateriales.getSelectedRow();

                if (filaSeleccionada != -1) {
                    for (int i = 0; i < Monografia.getColumnas().size(); i++) {
                        datos.add(vista.TblMateriales.getValueAt(filaSeleccionada, i));
                    }
                }

                monografiaSeleccionada = Monografia.toMonografia(datos);
                llenarCamposMonografia();

                if (e.getClickCount() == 2) {
                    irAPrestamos(monografiaSeleccionada);
                }

            }
        };

        //ASIGNACION INCIAL DE EVENTOS DE LIBROS
        cargarEventosTablaLibros();

        // EVENTOS DE COMPONENTES
        //EVENTO PARA COMBOBOX, AL CAMBIAR DEBE CARGAR UNA U OTRA TABLA
        vista.CmbTipoMaterial.addActionListener((e) -> {
            //EVALUA EL TIPO DE MATERIAL SELECCIONADO Y LO CAMBIO EN FUNCIÓN DE SU VALOR
            String opc = (String) vista.CmbTipoMaterial.getSelectedItem();

            if ("Libro".equals(opc) && !"Libro".equals(estado)) {
                vista.TblMateriales.setModel(modeloLibros);
                // MÉTODOS QUE SE VEN MAS ABAJO
                ajustarALibros();
                limpiarCampos();
                cargarEventosTablaLibros();
                estado = "Libro";
            } else if ("Monografía".equals(opc) && !"Monografía".equals(estado)) {
                vista.TblMateriales.setModel(modeloMonografias);
                ajustarAMonografias();
                limpiarCampos();
                cargarEventosTablaMonografias();
                estado = "Monografía";

            }
        } //ASIGNACION DEL EVENTO
        );

    }

    //ESTE METODO CARGA EL PANEL DE MATERIALES EN EL FRAME QUE SE LE ENVIE COMO PARAMETRO (EN ESTE CASO, BIBLIOTECA VISTA)
    public void mostrar() {
        bibliotecaControlador.getFrmBiblioteca().PnlContenido.removeAll();
        bibliotecaControlador.getFrmBiblioteca().PnlContenido.add(vista, BorderLayout.CENTER);
        bibliotecaControlador.getFrmBiblioteca().PnlContenido.revalidate();
        bibliotecaControlador.getFrmBiblioteca().PnlContenido.repaint();
    }

    //QUITA EL EVENTO DE LA MONOGRAFIA QUE VIMOS MAS ARRIBA Y LO CAMBIA POR EL DE LOS LIBROS
    public void cargarEventosTablaLibros() {

        vista.TblMateriales.removeMouseListener(clickMonografia);
        vista.TblMateriales.addMouseListener(clickLibro);

    }

    //XD NO T VOY A EXPLICAR ESTO
    public void cargarEventosTablaMonografias() {

        vista.TblMateriales.removeMouseListener(clickLibro);
        vista.TblMateriales.addMouseListener(clickMonografia);

    }

    //LLENA LOS TEXTFIELDS CON LA INFORMACION DEL LIBRO
    public void llenarCamposLibro() {
        vista.TxtCodigo.setText(libroSeleccionado.getIsbn());
        vista.TxtTitulo.setText(libroSeleccionado.getTitulo());
        vista.TxtAutor.setText(libroSeleccionado.getAutor());
        vista.TxtVolumen.setText(String.valueOf(libroSeleccionado.getVolumen()));
        vista.TxtTema.setText(libroSeleccionado.getTema());
    }

    //LLENA LOS TEXTFIELDS CON LA INFORMACION DE LA MONOGRAFIA
    public void llenarCamposMonografia() {
        vista.TxtCodigo.setText(monografiaSeleccionada.getIssn());
        vista.TxtTitulo.setText(monografiaSeleccionada.getTitulo());
        vista.TxtAutor.setText(monografiaSeleccionada.getAutor());
        vista.TxtTema.setText(monografiaSeleccionada.getTema());
    }

    //LIMPIA PE
    public void limpiarCampos() {
        vista.TxtCodigo.setText("");
        vista.TxtTitulo.setText("");
        vista.TxtAutor.setText("");
        vista.TxtVolumen.setText("");
        vista.TxtTema.setText("");
    }

    //ACTIVA EL TEXTFIELD DE VOLUMEN Y CAMBIA EL LBL DE TXTCODIGO
    public void ajustarALibros() {
        vista.TxtVolumen.setEnabled(true);
        vista.LblCodigoMaterial.setText("ISBN");
    }

    //DESACTIVA EL TEXTFIELD DE VOLUMEN Y CAMBIA EL LBL DE TXTCODIGO
    public void ajustarAMonografias() {
        vista.TxtVolumen.setText("");
        vista.TxtVolumen.setEnabled(false);
        vista.LblCodigoMaterial.setText("ISSN");
    }

    public void irAPrestamos(Libro libroSeleccionado) {
        bibliotecaControlador.getFrmBiblioteca().PnlContenido.removeAll();
        bibliotecaControlador.getFrmBiblioteca().PnlContenido.add(bibliotecaControlador.getControladorPrestamos().getVista(), BorderLayout.CENTER);
        bibliotecaControlador.getFrmBiblioteca().PnlContenido.revalidate();
        bibliotecaControlador.getFrmBiblioteca().PnlContenido.repaint();
        bibliotecaControlador.getControladorPrestamos().setLibroEntrante(libroSeleccionado);
    }

    public void irAPrestamos(Monografia monografiaSeleccionada) {
        bibliotecaControlador.getFrmBiblioteca().PnlContenido.removeAll();
        bibliotecaControlador.getFrmBiblioteca().PnlContenido.add(bibliotecaControlador.getControladorPrestamos().getVista(), BorderLayout.CENTER);
        bibliotecaControlador.getFrmBiblioteca().PnlContenido.revalidate();
        bibliotecaControlador.getFrmBiblioteca().PnlContenido.repaint();
        bibliotecaControlador.getControladorPrestamos().setMonografiaEntrante(monografiaSeleccionada);
    }

}
