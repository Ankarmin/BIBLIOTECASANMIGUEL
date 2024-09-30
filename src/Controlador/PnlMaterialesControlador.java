package Controlador;

import Common.CommonFunctions;
import DBRepositorio.Libro;
import DBRepositorio.LibroRepositorio;
import DBRepositorio.Monografia;
import DBRepositorio.MonografiaRepositorio;

import Vista.BibliotecaVista;
import Vista.MaterialesVista;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.TableModel;

/**
 * @author Leonidas Garcia Lescano
 */
public class PnlMaterialesControlador {

    private MaterialesVista vista;

    private final LibroRepositorio libroDriver;
    private final MonografiaRepositorio monografiaDriver;

    private Libro libroSeleccionado;
    private Monografia monografiaSeleccionada;
    
    private TableModel modeloLibros;
    private TableModel modeloMonografias;
    
    private MouseAdapter clickLibro;
    private MouseAdapter clickMonografia;
    
    private String estado = "Libro";

    //Constructor
    PnlMaterialesControlador(Connection openConexion) {
        vista = new MaterialesVista();
        
        libroDriver = new LibroRepositorio(openConexion);
        monografiaDriver = new MonografiaRepositorio(openConexion);

        CommonFunctions.llenarTabla(vista.TablaMateriales, Monografia.getColumnas(), monografiaDriver.obtenerTodos());
        modeloMonografias = vista.TablaMateriales.getModel();

        CommonFunctions.llenarTabla(vista.TablaMateriales, Libro.getColumnas(), libroDriver.obtenerTodos());
        modeloLibros = vista.TablaMateriales.getModel();

        //Eventos de tabla
        clickLibro = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                List<Object> datos = new ArrayList<>();
                int filaSeleccionada = vista.TablaMateriales.getSelectedRow();

                if (filaSeleccionada != -1) {
                    for (int i = 0; i < Libro.getColumnas().size(); i++) {
                        datos.add(vista.TablaMateriales.getValueAt(filaSeleccionada, i));
                    }
                }

                libroSeleccionado = Libro.toLibro(datos);
                llenarCamposLibro();

            }
        };
        clickMonografia = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                List<Object> datos = new ArrayList<>();
                int filaSeleccionada = vista.TablaMateriales.getSelectedRow();

                if (filaSeleccionada != -1) {
                    for (int i = 0; i < Monografia.getColumnas().size(); i++) {
                        datos.add(vista.TablaMateriales.getValueAt(filaSeleccionada, i));
                    }
                }

                monografiaSeleccionada = Monografia.toMonografia(datos);
                llenarCamposMonografia();

            }
        };

        cargarEventosTablaLibros();

        // Eventos de componentes
        vista.CmbTipoMaterial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String opc = (String) vista.CmbTipoMaterial.getSelectedItem();

                if ("Libro".equals(opc) && !"Libro".equals(estado)) {
                    vista.TablaMateriales.setModel(modeloLibros);
                    ajustarALibros();
                    limpiarCampos();
                    cargarEventosTablaLibros();
                    estado = "Libro";
                } else if ("Monografia".equals(opc) && !"Monografia".equals(estado)) {
                    vista.TablaMateriales.setModel(modeloMonografias);
                    ajustarAMonografias();
                    limpiarCampos();
                    cargarEventosTablaMonografias();
                    estado = "Monografia";

                }

            }

        });

    }

    //Metodo usado por FrmBibliotecaControlador
    public void mostrar(BibliotecaVista Padre) {
        Padre.PnlContenido.removeAll();
        Padre.PnlContenido.add(vista, BorderLayout.CENTER);
        Padre.PnlContenido.revalidate();
        Padre.PnlContenido.repaint();
    }

    //
    public void cargarEventosTablaLibros() {

        vista.TablaMateriales.removeMouseListener(clickMonografia);
        vista.TablaMateriales.addMouseListener(clickLibro);

    }

    public void cargarEventosTablaMonografias() {

        vista.TablaMateriales.removeMouseListener(clickLibro);
        vista.TablaMateriales.addMouseListener(clickMonografia);

    }

    public void llenarCamposLibro() {
        vista.TxtCodigo.setText(libroSeleccionado.getIsbn());
        vista.TxtTitulo.setText(libroSeleccionado.getTitulo());
        vista.TxtAutor.setText(libroSeleccionado.getAutor());
        vista.TxtVolumen.setText(String.valueOf(libroSeleccionado.getVolumen()));
        vista.TxtTema.setText(libroSeleccionado.getTema());
    }

    public void llenarCamposMonografia() {
        vista.TxtCodigo.setText(monografiaSeleccionada.getIssn());
        vista.TxtTitulo.setText(monografiaSeleccionada.getTitulo());
        vista.TxtAutor.setText(monografiaSeleccionada.getAutor());
        vista.TxtTema.setText(monografiaSeleccionada.getTema());
    }

    public void limpiarCampos() {
        vista.TxtCodigo.setText("");
        vista.TxtTitulo.setText("");
        vista.TxtAutor.setText("");
        vista.TxtVolumen.setText("");
        vista.TxtTema.setText("");
    }

    public void ajustarALibros() {
        vista.TxtVolumen.setEnabled(true);
    }

    public void ajustarAMonografias() {
        vista.TxtVolumen.setText("");
        vista.TxtVolumen.setEnabled(false);
    }

}
