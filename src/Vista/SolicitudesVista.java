package Vista;


import java.awt.Color;
import java.util.List;
import DBRepositorio.Solicitud;
import javax.swing.table.DefaultTableModel;

public class SolicitudesVista extends javax.swing.JPanel {
    private DefaultTableModel modeloTabla;
    public SolicitudesVista() {
        setSize(860, 640);
        setLocation(0, 0);
        initComponents();
        initStyles();
        initTableModel();
    }

    private void initStyles() {
        LblAutor.putClientProperty("FlatLaf.style", "font: 14 $semibold.font");
        LblAutor.setForeground(Color.black);
        LblTema.putClientProperty("FlatLaf.style", "font: 14 $semibold.font");
        LblTema.setForeground(Color.black);
        LblTitulo.putClientProperty("FlatLaf.style", "font: 14 $semibold.font");
        LblTitulo.setForeground(Color.black);
        LblComentario.putClientProperty("FlatLaf.style", "font: 14 $semibold.font");
        LblComentario.setForeground(Color.black);
        TxtAutor.putClientProperty("FlatLaf.style", "font: 14 $h3.regular.font");
        TxtAutor.setForeground(Color.black);
        TxtTema.putClientProperty("FlatLaf.style", "font: 14 $h3.regular.font");
        TxtTema.setForeground(Color.black);
        TxtTitulo.putClientProperty("FlatLaf.style", "font: 14 $h3.regular.font");
        TxtTitulo.setForeground(Color.black);
        BtnAgregar.putClientProperty("JButton.buttonType", "roundRect");
        BtnAgregar.putClientProperty("FlatLaf.style", "font: 13 $semibold.font");
        BtnAgregar.setForeground(Color.black);
        BtnEliminar.putClientProperty("FlatLaf.style", "font: 13 $semibold.font");
        BtnEliminar.setForeground(Color.black);
    }
    private void initTableModel() {
        modeloTabla = new DefaultTableModel(
            new Object[]{"ID", "Título", "Autor", "Tema", "Comentario"}, 0
        );
        TblMateriales.setModel(modeloTabla);  // Asignar el modelo a la tabla
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelMateriales = new javax.swing.JPanel();
        PnlIzq = new javax.swing.JPanel();
        TxtTitulo = new javax.swing.JTextField();
        TxtAutor = new javax.swing.JTextField();
        TxtTema = new javax.swing.JTextField();
        BtnAgregar = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        LblTitulo = new javax.swing.JLabel();
        LblAutor = new javax.swing.JLabel();
        LblTema = new javax.swing.JLabel();
        LblComentario = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TxtAComentario = new javax.swing.JTextArea();
        PnlDer = new javax.swing.JPanel();
        SPTablaMateriales = new javax.swing.JScrollPane();
        TblMateriales = new javax.swing.JTable();

        setBackground(new java.awt.Color(236, 226, 208));

        PanelMateriales.setBackground(new java.awt.Color(236, 226, 208));
        PanelMateriales.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PnlIzq.setBackground(new java.awt.Color(236, 226, 208));

        BtnAgregar.setBackground(new java.awt.Color(255, 236, 200));
        BtnAgregar.setText("AGREGAR");

        BtnEliminar.setBackground(new java.awt.Color(255, 236, 200));
        BtnEliminar.setText("ELIMINAR");

        LblTitulo.setText("Título");

        LblAutor.setText("Autor");

        LblTema.setText("Tema");

        LblComentario.setText("Comentario");

        TxtAComentario.setColumns(20);
        TxtAComentario.setRows(5);
        jScrollPane1.setViewportView(TxtAComentario);

        javax.swing.GroupLayout PnlIzqLayout = new javax.swing.GroupLayout(PnlIzq);
        PnlIzq.setLayout(PnlIzqLayout);
        PnlIzqLayout.setHorizontalGroup(
            PnlIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlIzqLayout.createSequentialGroup()
                .addGroup(PnlIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlIzqLayout.createSequentialGroup()
                        .addContainerGap(26, Short.MAX_VALUE)
                        .addComponent(BtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PnlIzqLayout.createSequentialGroup()
                        .addGroup(PnlIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PnlIzqLayout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(PnlIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TxtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TxtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TxtTema, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(PnlIzqLayout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addGroup(PnlIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(LblTitulo)
                                            .addComponent(LblAutor)))
                                    .addGroup(PnlIzqLayout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(LblComentario, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(PnlIzqLayout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(LblTema, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PnlIzqLayout.setVerticalGroup(
            PnlIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlIzqLayout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(LblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(LblAutor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(LblTema, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtTema, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(LblComentario, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addGroup(PnlIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );

        PanelMateriales.add(PnlIzq, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 640));

        PnlDer.setBackground(new java.awt.Color(236, 226, 208));

        SPTablaMateriales.setForeground(new java.awt.Color(255, 255, 255));

        TblMateriales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        SPTablaMateriales.setViewportView(TblMateriales);

        javax.swing.GroupLayout PnlDerLayout = new javax.swing.GroupLayout(PnlDer);
        PnlDer.setLayout(PnlDerLayout);
        PnlDerLayout.setHorizontalGroup(
            PnlDerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlDerLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(SPTablaMateriales, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        PnlDerLayout.setVerticalGroup(
            PnlDerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlDerLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(SPTablaMateriales, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        PanelMateriales.add(PnlDer, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 610, 640));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelMateriales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelMateriales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BtnAgregar;
    public javax.swing.JButton BtnEliminar;
    public javax.swing.JLabel LblAutor;
    public javax.swing.JLabel LblComentario;
    public javax.swing.JLabel LblTema;
    public javax.swing.JLabel LblTitulo;
    public javax.swing.JPanel PanelMateriales;
    private javax.swing.JPanel PnlDer;
    public javax.swing.JPanel PnlIzq;
    private javax.swing.JScrollPane SPTablaMateriales;
    public javax.swing.JTable TblMateriales;
    public javax.swing.JTextArea TxtAComentario;
    public javax.swing.JTextField TxtAutor;
    public javax.swing.JTextField TxtTema;
    public javax.swing.JTextField TxtTitulo;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    // End of variables declaration                   
    public void cargarSolicitudesEnTabla(List<Solicitud> solicitudes) {
        modeloTabla.setRowCount(0); // Limpiar la tabla antes de agregar nuevas filas
        for (Solicitud solicitud : solicitudes) {
            modeloTabla.addRow(new Object[]{
                solicitud.getIdSolicitud(),
                solicitud.getTitulo(),
                solicitud.getAutor(),
                solicitud.getTema(),
                solicitud.getComentarios()
            });
        }
    }
    public Solicitud getSolicitudEnFila(int fila) {
        if (fila >= 0 && fila < modeloTabla.getRowCount()) {
            Solicitud solicitud = new Solicitud();
            solicitud.setIdSolicitud((int) modeloTabla.getValueAt(fila, 0));
            solicitud.setTitulo((String) modeloTabla.getValueAt(fila, 1));
            solicitud.setAutor((String) modeloTabla.getValueAt(fila, 2));
            solicitud.setTema((String) modeloTabla.getValueAt(fila, 3));
            solicitud.setComentarios((String) modeloTabla.getValueAt(fila, 4));
            return solicitud;
        }
        return null;
    }
}
