// EJEMPLO PARCIAL DE COMO UTILIZAR COMMONFUNCTIONS EN EL CONTROLADOR DE MATERIALES
package Controlador;

//CLASES NECESARIAS
import DBRepositorio.Libro;
import DBRepositorio.Monografia;
import Modelo.MaterialesModelo;
import Vista.MaterialesVista;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public final class PnlMaterialesControlador {

    //ATRIBUTOS PRIVADOR
    //AHORA TODOS SON HERMANOS
    private final FrmBibliotecaControlador bibliotecaControlador;

    //LA VISTA DEL CONTROLADOR
    private MaterialesVista vista;

    //EL MODELO DEL CONTROLADOR
    private MaterialesModelo modelo;

    //LAS SELECCIONES QUE SE REALICEN EN LA TABLA(CON EL MOUSE)
    private Libro libroSeleccionado;
    private Monografia monografiaSeleccionada;

    //LAS ENTIDADES GENERADAS AL ESCRIBIR EN LOS TXT
    private Libro libroNuevo = new Libro();
    private Monografia monografiaNueva = new Monografia();

    //EVENTOS PARA EL CLICK EN LA TABLA
    private MouseAdapter clickLibro;
    private MouseAdapter clickMonografia;

    //EVENTOS PARA CHANGE TXT
    private DocumentListener cambiarTxtIsbn;
    private DocumentListener cambiarTxtIssn;
    private DocumentListener cambiarTxtTituloLibro;
    private DocumentListener cambiarTxtTituloMonografia;
    private DocumentListener cambiarTxtAutorLibro;
    private DocumentListener cambiarTxtAutorMonografia;
    private DocumentListener cambiarTxtVolumen;
    private DocumentListener cambiarTxtTemaLibro;
    private DocumentListener cambiarTxtTemaMonografia;
    private DocumentListener cambiarTxtStockTotalLibro;
    private DocumentListener cambiarTxtStockTotalMonografia;
    private DocumentListener cambiarTxtStockDisponibleLibro;
    private DocumentListener cambiarTxtStockDisponibleMonografia;

    private DocumentListener cambiarTxtFiltroTituloLibro;
    private DocumentListener cambiarTxtFiltroAutorLibro;
    private DocumentListener cambiarTxtFiltroTemasLibro;

    private DocumentListener cambiarTxtFiltroTituloMonografia;
    private DocumentListener cambiarTxtFiltroAutorMonografia;
    private DocumentListener cambiarTxtFiltroTemasMonografia;

    //EL ESTADO DE LA TABLA
    private String estado = "Libro";

    //Constructor
    PnlMaterialesControlador(Connection openConexion, FrmBibliotecaControlador bibliotecaControlador) {

        //BIBLIOTECA VISTA DE REFERENCIA
        this.bibliotecaControlador = bibliotecaControlador;

        //INICIALIZACION DE LA VISTA
        vista = new MaterialesVista();

        //INICIALIZACION DEL MODELO
        modelo = new MaterialesModelo(openConexion);
        modelo.generarModeloLibro(vista.TblMateriales);
        modelo.generarModeloMonografia(vista.TblMateriales);

        //LIBROS POR DEFECTO
        modelo.cargarModeloLibro(vista.TblMateriales);

        //EVENTOS DE CLICKS EN LA TABLA
        //EN ESTE CASO SE DEFINE UN EVENTO DE MOUSE QUE AUN NO ES ASIGNADO A NINGUN COMPONENTE (DIGASE BOTON, TABLA, COMBOBOX, ETC)
        setClickLibro();
        setClickMonografia();
        setTxtEventos();

        vista.TxtFiltro.getDocument().addDocumentListener(cambiarTxtFiltroTituloLibro);

        cargarEventosTxtLibro();

        //AQUI ES MAS DE LO MISMO PERO CON MONOGRAFIA
        //ASIGNACION INCIAL DE EVENTOS DE LIBROS
        cargarEventosTablaLibros();

        // EVENTOS DE COMPONENTES
        //EVENTO PARA COMBOBOX, AL CAMBIAR DEBE CARGAR UNA U OTRA TABLA
        vista.CmbTipoMaterial.addActionListener((e) -> {
            //EVALUA EL TIPO DE MATERIAL SELECCIONADO Y LO CAMBIO EN FUNCIÓN DE SU VALOR
            String opc = (String) vista.CmbTipoMaterial.getSelectedItem();

            if ("Libro".equals(opc) && !"Libro".equals(estado)) {
                modelo.cargarModeloLibro(vista.TblMateriales);
                ajustarALibros();
                limpiarCampos();
                cargarEventosTablaLibros();
                removerEventosTxtFiltroMonografia();
                cargarEventosTxtLibro();
                vista.TxtFiltro.getDocument().addDocumentListener(cambiarTxtFiltroTituloLibro);
                estado = "Libro";
                monografiaSeleccionada = null;
            } else if ("Monografía".equals(opc) && !"Monografía".equals(estado)) {
                modelo.cargarModeloMonografia(vista.TblMateriales);
                ajustarAMonografias();
                limpiarCampos();
                removerEventosTxtFiltroLibro();
                cargarEventosTablaMonografias();
                cargarEventosTxtMonografia();
                vista.TxtFiltro.getDocument().addDocumentListener(cambiarTxtFiltroTituloMonografia);
                estado = "Monografía";
                libroSeleccionado = null;

            }
        } //ASIGNACION DEL EVENTO
        );

        vista.CmbFiltro.addActionListener((e) -> {
            String opc = (String) vista.CmbFiltro.getSelectedItem();
            removerEventosTxtFiltroLibro();
            removerEventosTxtFiltroMonografia();

            if ("Libro".equals(estado)) {

                switch (opc) {
                    case "Título" -> {
                        vista.TxtFiltro.getDocument().addDocumentListener(cambiarTxtFiltroTituloLibro);
                        if (!"".equals(vista.TxtFiltro.getText().trim())) {
                            modelo.filtrarPorTituloLibro(vista.TxtFiltro.getText().trim(), vista.TblMateriales);
                        } else {
                            modelo.cargarModeloLibro(vista.TblMateriales);
                        }
                    }
                    case "Autor" -> {
                        vista.TxtFiltro.getDocument().addDocumentListener(cambiarTxtFiltroAutorLibro);
                        if (!"".equals(vista.TxtFiltro.getText().trim())) {
                            modelo.filtrarPorAutorLibro(vista.TxtFiltro.getText().trim(), vista.TblMateriales);
                        } else {
                            modelo.cargarModeloLibro(vista.TblMateriales);
                        }
                    }
                    case "Temas" -> {
                        vista.TxtFiltro.getDocument().addDocumentListener(cambiarTxtFiltroTemasLibro);
                        if (!"".equals(vista.TxtFiltro.getText().trim())) {
                            modelo.filtrarPorTemaLibro(vista.TxtFiltro.getText().trim(), vista.TblMateriales);
                        } else {
                            modelo.cargarModeloLibro(vista.TblMateriales);
                        }

                    }
                    case "Disponibilidad" -> {
                        modelo.filtrarPorDisponibilidadLibro(vista.TblMateriales);
                    }
                    default ->
                        throw new AssertionError();
                }
            } else {

                switch (opc) {
                    case "Título" -> {
                        vista.TxtFiltro.getDocument().addDocumentListener(cambiarTxtFiltroTituloMonografia);
                        if (!"".equals(vista.TxtFiltro.getText().trim())) {
                            modelo.filtrarPorTituloMonografia(vista.TxtFiltro.getText().trim(), vista.TblMateriales);
                        } else {
                            modelo.cargarModeloLibro(vista.TblMateriales);
                        }
                    }
                    case "Autor" -> {
                        vista.TxtFiltro.getDocument().addDocumentListener(cambiarTxtFiltroTituloMonografia);
                        if (!"".equals(vista.TxtFiltro.getText().trim())) {
                            modelo.filtrarPorAutorMonografia(vista.TxtFiltro.getText().trim(), vista.TblMateriales);
                        } else {
                            modelo.cargarModeloLibro(vista.TblMateriales);
                        }
                    }
                    case "Temas" -> {
                        vista.TxtFiltro.getDocument().addDocumentListener(cambiarTxtFiltroTemasMonografia);
                        if (!"".equals(vista.TxtFiltro.getText().trim())) {
                            modelo.filtrarPorTemaMonografia(vista.TxtFiltro.getText().trim(), vista.TblMateriales);
                        } else {
                            modelo.cargarModeloLibro(vista.TblMateriales);
                        }
                    }
                    case "Disponibilidad" -> {
                        modelo.filtrarPorDisponibilidadMonografia(vista.TblMateriales);
                    }
                    default ->
                        throw new AssertionError();
                }
            }

        });

        vista.TxtFiltro.getDocument().addDocumentListener(cambiarTxtIsbn);

        vista.BtnAgregar.addActionListener((ActionEvent e) -> {
            if ("Libro".equals(estado)) {
                if (!modelo.agregarLibro(libroNuevo)) {
                    System.out.println(modelo.mostrarError());
                } else {
                    modelo.generarModeloLibro(vista.TblMateriales);
                    modelo.cargarModeloLibro(vista.TblMateriales);
                    limpiarCampos();
                }
            } else {
                if (!modelo.agregarMonografia(monografiaNueva)) {
                    System.out.println(modelo.mostrarError());
                } else {
                    modelo.generarModeloMonografia(vista.TblMateriales);
                    modelo.cargarModeloMonografia(vista.TblMateriales);
                    limpiarCampos();
                }
            }
        });

        vista.BtnModificar.addActionListener((ActionEvent e) -> {
            if ("Libro".equals(estado)) {
                if (!modelo.modificarLibro(libroNuevo)) {
                    System.out.println(modelo.mostrarError());
                } else {
                    modelo.generarModeloLibro(vista.TblMateriales);
                    modelo.cargarModeloLibro(vista.TblMateriales);
                    limpiarCampos();
                }
            } else {
                if (!modelo.modificarMonografia(monografiaNueva)) {
                    System.out.println(modelo.mostrarError());
                } else {
                    modelo.generarModeloMonografia(vista.TblMateriales);
                    modelo.cargarModeloMonografia(vista.TblMateriales);
                    limpiarCampos();
                }
            }
        });

        vista.BtnEliminar.addActionListener((ActionEvent e) -> {
            if ("Libro".equals(estado)) {
                if (!modelo.eliminarLibro(libroNuevo)) {
                    System.out.println(modelo.mostrarError());
                } else {
                    modelo.generarModeloLibro(vista.TblMateriales);
                    modelo.cargarModeloLibro(vista.TblMateriales);
                    limpiarCampos();
                }
            } else {
                if (!modelo.agregarMonografia(monografiaNueva)) {
                    System.out.println(modelo.mostrarError());
                } else {
                    modelo.generarModeloMonografia(vista.TblMateriales);
                    modelo.cargarModeloMonografia(vista.TblMateriales);
                    limpiarCampos();
                }
            }
        });

        vista.BtnLimpiar.addActionListener((ActionEvent e) -> {
            limpiarCampos();
        });

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
        vista.TxtStockDisponible.setText(String.valueOf(libroSeleccionado.getStockDisponible()));
        vista.TxtStockTotal.setText(String.valueOf(libroSeleccionado.getStockTotal()));
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
        vista.TxtStockTotal.setText("");
        vista.TxtStockDisponible.setText("");
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

    public void cargarEventosTxtLibro() {
        //REMOVER
        vista.TxtCodigo.getDocument().removeDocumentListener(cambiarTxtIssn);
        vista.TxtTitulo.getDocument().removeDocumentListener(cambiarTxtTituloMonografia);
        vista.TxtAutor.getDocument().removeDocumentListener(cambiarTxtAutorMonografia);
        vista.TxtTema.getDocument().removeDocumentListener(cambiarTxtTemaMonografia);
        vista.TxtStockTotal.getDocument().removeDocumentListener(cambiarTxtStockTotalMonografia);
        vista.TxtStockDisponible.getDocument().removeDocumentListener(cambiarTxtStockDisponibleMonografia);

        //AGREGAR
        vista.TxtCodigo.getDocument().addDocumentListener(cambiarTxtIsbn);
        vista.TxtTitulo.getDocument().addDocumentListener(cambiarTxtTituloLibro);
        vista.TxtAutor.getDocument().addDocumentListener(cambiarTxtAutorLibro);
        vista.TxtVolumen.getDocument().addDocumentListener(cambiarTxtVolumen);
        vista.TxtTema.getDocument().addDocumentListener(cambiarTxtTemaLibro);
        vista.TxtStockTotal.getDocument().addDocumentListener(cambiarTxtStockTotalLibro);
        vista.TxtStockDisponible.getDocument().addDocumentListener(cambiarTxtStockDisponibleLibro);
    }

    public void cargarEventosTxtMonografia() {
        //REMOVER
        vista.TxtCodigo.getDocument().removeDocumentListener(cambiarTxtIsbn);
        vista.TxtTitulo.getDocument().removeDocumentListener(cambiarTxtTituloLibro);
        vista.TxtAutor.getDocument().removeDocumentListener(cambiarTxtAutorLibro);
        vista.TxtVolumen.getDocument().removeDocumentListener(cambiarTxtVolumen);
        vista.TxtTema.getDocument().removeDocumentListener(cambiarTxtTemaLibro);
        vista.TxtStockTotal.getDocument().removeDocumentListener(cambiarTxtStockTotalLibro);
        vista.TxtStockDisponible.getDocument().removeDocumentListener(cambiarTxtStockDisponibleLibro);

        //AGREGAR
        vista.TxtCodigo.getDocument().addDocumentListener(cambiarTxtIssn);
        vista.TxtTitulo.getDocument().addDocumentListener(cambiarTxtTituloMonografia);
        vista.TxtAutor.getDocument().addDocumentListener(cambiarTxtAutorMonografia);
        vista.TxtTema.getDocument().addDocumentListener(cambiarTxtTemaMonografia);
        vista.TxtStockTotal.getDocument().addDocumentListener(cambiarTxtStockTotalMonografia);
        vista.TxtStockDisponible.getDocument().addDocumentListener(cambiarTxtStockDisponibleMonografia);
    }

    private void setClickLibro() {
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
    }

    private void setClickMonografia() {
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
    }

    private void setTxtEventos() {

        cambiarTxtIsbn = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                libroNuevo.setIsbn(vista.TxtCodigo.getText());
                System.out.println(libroNuevo.getIsbn());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                libroNuevo.setIsbn(vista.TxtCodigo.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }

        };

        cambiarTxtIssn = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                monografiaNueva.setIssn(vista.TxtCodigo.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                monografiaNueva.setIssn(vista.TxtCodigo.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }

        };

        cambiarTxtTituloLibro = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                libroNuevo.setTitulo(vista.TxtTitulo.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                libroNuevo.setTitulo(vista.TxtTitulo.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }

        };

        cambiarTxtTituloMonografia = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                monografiaNueva.setTitulo(vista.TxtTitulo.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                monografiaNueva.setTitulo(vista.TxtTitulo.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }

        };

        cambiarTxtAutorLibro = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                libroNuevo.setAutor(vista.TxtAutor.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                libroNuevo.setAutor(vista.TxtAutor.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }

        };

        cambiarTxtAutorMonografia = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                monografiaNueva.setAutor(vista.TxtAutor.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                monografiaNueva.setAutor(vista.TxtAutor.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }

        };

        cambiarTxtVolumen = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String volumenTexto = vista.TxtVolumen.getText().trim();

                if (volumenTexto.matches("\\d+")) {
                    try {
                        libroNuevo.setVolumen(Integer.parseInt(volumenTexto));
                    } catch (NumberFormatException err) {
                        libroNuevo.setVolumen(-1);
                    }
                } else {
                    libroNuevo.setVolumen(-1);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String volumenTexto = vista.TxtVolumen.getText().trim();

                if (volumenTexto.matches("\\d+")) {
                    try {
                        libroNuevo.setVolumen(Integer.parseInt(volumenTexto));
                    } catch (NumberFormatException err) {
                        libroNuevo.setVolumen(-1);
                    }
                } else {
                    libroNuevo.setVolumen(-1);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }

        };

        cambiarTxtTemaLibro = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                libroNuevo.setTema(vista.TxtTema.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                libroNuevo.setTema(vista.TxtTema.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        };

        cambiarTxtTemaMonografia = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                monografiaNueva.setTema(vista.TxtTema.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                monografiaNueva.setTema(vista.TxtTema.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        };

        cambiarTxtStockTotalLibro = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String stockTotalTexto = vista.TxtStockTotal.getText().trim();

                if (stockTotalTexto.matches("\\d+")) {
                    try {
                        libroNuevo.setStockTotal(Integer.parseInt(stockTotalTexto));
                    } catch (NumberFormatException err) {
                        libroNuevo.setStockTotal(-1);
                    }
                } else {
                    libroNuevo.setStockTotal(-1);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String stockTotalTexto = vista.TxtStockTotal.getText().trim();

                if (stockTotalTexto.matches("\\d+")) {
                    try {
                        libroNuevo.setStockTotal(Integer.parseInt(stockTotalTexto));
                    } catch (NumberFormatException err) {
                        libroNuevo.setStockTotal(-1);
                    }
                } else {
                    libroNuevo.setStockTotal(-1);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }

        };

        cambiarTxtStockTotalMonografia = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String stockTotalTexto = vista.TxtStockTotal.getText().trim();

                if (stockTotalTexto.matches("\\d+")) {
                    try {
                        monografiaNueva.setStockTotal(Integer.parseInt(stockTotalTexto));
                    } catch (NumberFormatException err) {
                        monografiaNueva.setStockTotal(-1);
                    }
                } else {
                    monografiaNueva.setStockTotal(-1);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String stockTotalTexto = vista.TxtStockTotal.getText().trim();

                if (stockTotalTexto.matches("\\d+")) {
                    try {
                        monografiaNueva.setStockTotal(Integer.parseInt(stockTotalTexto));
                    } catch (NumberFormatException err) {
                        monografiaNueva.setStockTotal(-1);
                    }
                } else {
                    monografiaNueva.setStockTotal(-1);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }

        };

        cambiarTxtStockDisponibleLibro = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String stockDisponibleTexto = vista.TxtStockDisponible.getText().trim();

                if (stockDisponibleTexto.matches("\\d+")) {
                    try {
                        libroNuevo.setStockDisponible(Integer.parseInt(stockDisponibleTexto));
                    } catch (NumberFormatException err) {
                        libroNuevo.setStockDisponible(-1);
                    }
                } else {
                    libroNuevo.setStockDisponible(-1);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String stockDisponibleTexto = vista.TxtStockDisponible.getText().trim();

                if (stockDisponibleTexto.matches("\\d+")) {
                    try {
                        libroNuevo.setStockDisponible(Integer.parseInt(stockDisponibleTexto));
                    } catch (NumberFormatException err) {
                        libroNuevo.setStockDisponible(-1);
                    }
                } else {
                    libroNuevo.setStockDisponible(-1);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }

        };

        cambiarTxtStockDisponibleMonografia = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String stockDisponibleTexto = vista.TxtStockDisponible.getText().trim();

                if (stockDisponibleTexto.matches("\\d+")) {
                    try {
                        monografiaNueva.setStockDisponible(Integer.parseInt(stockDisponibleTexto));
                    } catch (NumberFormatException err) {
                        monografiaNueva.setStockDisponible(-1);
                    }
                } else {
                    monografiaNueva.setStockDisponible(-1);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String stockDisponibleTexto = vista.TxtStockDisponible.getText().trim();

                if (stockDisponibleTexto.matches("\\d+")) {
                    try {
                        libroNuevo.setStockDisponible(Integer.parseInt(stockDisponibleTexto));
                    } catch (NumberFormatException err) {
                        libroNuevo.setStockDisponible(-1);
                    }
                } else {
                    libroNuevo.setStockDisponible(-1);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }

        };

        cambiarTxtFiltroTituloLibro = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (!"".equals(vista.TxtFiltro.getText().trim())) {
                    modelo.filtrarPorTituloLibro(vista.TxtFiltro.getText().trim(), vista.TblMateriales);
                } else {
                    modelo.cargarModeloLibro(vista.TblMateriales);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (!"".equals(vista.TxtFiltro.getText().trim())) {
                    modelo.filtrarPorTituloLibro(vista.TxtFiltro.getText().trim(), vista.TblMateriales);
                } else {
                    modelo.cargarModeloLibro(vista.TblMateriales);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        };

        cambiarTxtFiltroTituloMonografia = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (!"".equals(vista.TxtFiltro.getText().trim())) {
                    modelo.filtrarPorTituloMonografia(vista.TxtFiltro.getText().trim(), vista.TblMateriales);
                } else {
                    modelo.cargarModeloMonografia(vista.TblMateriales);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (!"".equals(vista.TxtFiltro.getText().trim())) {
                    modelo.filtrarPorTituloMonografia(vista.TxtFiltro.getText().trim(), vista.TblMateriales);
                } else {
                    modelo.cargarModeloMonografia(vista.TblMateriales);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        };

        cambiarTxtFiltroAutorLibro = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (!"".equals(vista.TxtFiltro.getText().trim())) {
                    modelo.filtrarPorAutorMonografia(vista.TxtFiltro.getText().trim(), vista.TblMateriales);
                } else {
                    modelo.cargarModeloLibro(vista.TblMateriales);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (!"".equals(vista.TxtFiltro.getText().trim())) {
                    modelo.filtrarPorAutorMonografia(vista.TxtFiltro.getText().trim(), vista.TblMateriales);
                } else {
                    modelo.cargarModeloLibro(vista.TblMateriales);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        };

        cambiarTxtAutorMonografia = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (!"".equals(vista.TxtFiltro.getText().trim())) {
                    modelo.filtrarPorAutorMonografia(vista.TxtFiltro.getText().trim(), vista.TblMateriales);
                } else {
                    modelo.cargarModeloMonografia(vista.TblMateriales);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (!"".equals(vista.TxtFiltro.getText().trim())) {
                    modelo.filtrarPorAutorMonografia(vista.TxtFiltro.getText().trim(), vista.TblMateriales);
                } else {
                    modelo.cargarModeloMonografia(vista.TblMateriales);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        };

        cambiarTxtFiltroTemasLibro = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (!"".equals(vista.TxtFiltro.getText().trim())) {
                    modelo.filtrarPorTemaLibro(vista.TxtFiltro.getText().trim(), vista.TblMateriales);
                } else {
                    modelo.cargarModeloLibro(vista.TblMateriales);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (!"".equals(vista.TxtFiltro.getText().trim())) {
                    modelo.filtrarPorTemaLibro(vista.TxtFiltro.getText().trim(), vista.TblMateriales);
                } else {
                    modelo.cargarModeloLibro(vista.TblMateriales);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        };

        cambiarTxtFiltroTemasMonografia = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (!"".equals(vista.TxtFiltro.getText().trim())) {
                    modelo.filtrarPorTemaMonografia(vista.TxtFiltro.getText().trim(), vista.TblMateriales);
                } else {
                    modelo.cargarModeloMonografia(vista.TblMateriales);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (!"".equals(vista.TxtFiltro.getText().trim())) {
                    modelo.filtrarPorTemaMonografia(vista.TxtFiltro.getText().trim(), vista.TblMateriales);
                } else {
                    modelo.cargarModeloMonografia(vista.TblMateriales);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        };

    }

    public void removerEventosTxtFiltroLibro() {
        vista.TxtFiltro.getDocument().removeDocumentListener(cambiarTxtFiltroTituloLibro);
        vista.TxtFiltro.getDocument().removeDocumentListener(cambiarTxtFiltroAutorLibro);
        vista.TxtFiltro.getDocument().removeDocumentListener(cambiarTxtFiltroTemasLibro);
    }

    public void removerEventosTxtFiltroMonografia() {
        vista.TxtFiltro.getDocument().removeDocumentListener(cambiarTxtFiltroTituloMonografia);
        vista.TxtFiltro.getDocument().removeDocumentListener(cambiarTxtFiltroAutorMonografia);
        vista.TxtFiltro.getDocument().removeDocumentListener(cambiarTxtFiltroTemasMonografia);
    }

}
