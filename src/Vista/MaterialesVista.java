package Vista;

import java.awt.Color;

public class MaterialesVista extends javax.swing.JPanel {

    public MaterialesVista() {
        setSize(860, 640);
        setLocation(0, 0);
        initComponents();
        initStyles();
    }

    private void initStyles() {
        LblAutor.putClientProperty("FlatLaf.style", "font: 14 $semibold.font");
        LblAutor.setForeground(Color.black);
        LblFiltros.putClientProperty("FlatLaf.style", "font: 14 $semibold.font");
        LblFiltros.setForeground(Color.black);
        LblCodigoMaterial.putClientProperty("FlatLaf.style", "font: 14 $semibold.font");
        LblCodigoMaterial.setForeground(Color.black);
        LblTema.putClientProperty("FlatLaf.style", "font: 14 $semibold.font");
        LblTema.setForeground(Color.black);
        LblTipoMaterial.putClientProperty("FlatLaf.style", "font: 14 $semibold.font");
        LblTipoMaterial.setForeground(Color.black);
        LblTitulo.putClientProperty("FlatLaf.style", "font: 14 $semibold.font");
        LblTitulo.setForeground(Color.black);
        LblVolumen.putClientProperty("FlatLaf.style", "font: 14 $semibold.font");
        LblVolumen.setForeground(Color.black);
        TxtAutor.putClientProperty("FlatLaf.style", "font: 14 $h3.regular.font");
        TxtAutor.setForeground(Color.black);
        TxtCodigo.putClientProperty("FlatLaf.style", "font: 14 $h3.regular.font");
        TxtCodigo.setForeground(Color.black);
        TxtFiltro.putClientProperty("FlatLaf.style", "font: 14 $h3.regular.font");
        TxtFiltro.setForeground(Color.black);
        TxtTema.putClientProperty("FlatLaf.style", "font: 14 $h3.regular.font");
        TxtTema.setForeground(Color.black);
        TxtTitulo.putClientProperty("FlatLaf.style", "font: 14 $h3.regular.font");
        TxtTitulo.setForeground(Color.black);
        TxtVolumen.putClientProperty("FlatLaf.style", "font: 14 $h3.regular.font");
        TxtVolumen.setForeground(Color.black);
        BtnAgregar.putClientProperty("FlatLaf.style", "font: 13 $semibold.font");
        BtnAgregar.setForeground(Color.black);
        BtnEliminar.putClientProperty("FlatLaf.style", "font: 13 $semibold.font");
        BtnEliminar.setForeground(Color.black);
        BtnModificar.putClientProperty("FlatLaf.style", "font: 13 $semibold.font");
        BtnModificar.setForeground(Color.black);
        CmbFiltro.putClientProperty("FlatLaf.style", "font: 14 $h3.regular.font");
        CmbFiltro.setForeground(Color.black);
        CmbTipoMaterial.putClientProperty("FlatLaf.style", "font: 14 $h3.regular.font");
        CmbTipoMaterial.setForeground(Color.black);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelMateriales = new javax.swing.JPanel();
        PnlIzq = new javax.swing.JPanel();
        CmbTipoMaterial = new javax.swing.JComboBox<>();
        TxtCodigo = new javax.swing.JTextField();
        TxtTitulo = new javax.swing.JTextField();
        TxtAutor = new javax.swing.JTextField();
        TxtVolumen = new javax.swing.JTextField();
        TxtTema = new javax.swing.JTextField();
        BtnAgregar = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        LblTitulo = new javax.swing.JLabel();
        LblAutor = new javax.swing.JLabel();
        LblVolumen = new javax.swing.JLabel();
        LblTema = new javax.swing.JLabel();
        LblTipoMaterial = new javax.swing.JLabel();
        LblCodigoMaterial = new javax.swing.JLabel();
        BtnModificar = new javax.swing.JButton();
        PnlDer = new javax.swing.JPanel();
        TxtFiltro = new javax.swing.JTextField();
        SPTablaMateriales = new javax.swing.JScrollPane();
        TblMateriales = new javax.swing.JTable();
        CmbFiltro = new javax.swing.JComboBox<>();
        LblFiltros = new javax.swing.JLabel();
        TxtStockTotal = new javax.swing.JTextField();
        TxtStockDisponible = new javax.swing.JTextField();
        LblStockDisponible = new javax.swing.JLabel();
        LblStockTotal = new javax.swing.JLabel();

        setBackground(new java.awt.Color(236, 226, 208));

        PanelMateriales.setBackground(new java.awt.Color(236, 226, 208));
        PanelMateriales.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PnlIzq.setBackground(new java.awt.Color(236, 226, 208));

        CmbTipoMaterial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Libro", "Monografía" }));

        BtnAgregar.setBackground(new java.awt.Color(255, 236, 200));
        BtnAgregar.setText("AGREGAR");

        BtnEliminar.setBackground(new java.awt.Color(255, 236, 200));
        BtnEliminar.setText("ELIMINAR");

        LblTitulo.setText("Título");

        LblAutor.setText("Autor");

        LblVolumen.setText("Volumen");

        LblTema.setText("Tema");

        LblTipoMaterial.setText("Tipo de material");

        LblCodigoMaterial.setText("ISBN");

        BtnModificar.setBackground(new java.awt.Color(255, 236, 200));
        BtnModificar.setText("MODIFICAR");

        javax.swing.GroupLayout PnlIzqLayout = new javax.swing.GroupLayout(PnlIzq);
        PnlIzq.setLayout(PnlIzqLayout);
        PnlIzqLayout.setHorizontalGroup(
            PnlIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlIzqLayout.createSequentialGroup()
                .addGroup(PnlIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnlIzqLayout.createSequentialGroup()
                        .addGroup(PnlIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PnlIzqLayout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(PnlIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CmbTipoMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TxtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TxtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TxtVolumen, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TxtTema, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(PnlIzqLayout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addGroup(PnlIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(LblTitulo)
                                            .addComponent(LblAutor)))
                                    .addGroup(PnlIzqLayout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(LblTema, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(PnlIzqLayout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(LblTipoMaterial))
                            .addGroup(PnlIzqLayout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(LblVolumen, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlIzqLayout.createSequentialGroup()
                        .addContainerGap(26, Short.MAX_VALUE)
                        .addGroup(PnlIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlIzqLayout.createSequentialGroup()
                                .addComponent(BtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BtnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlIzqLayout.createSequentialGroup()
                                .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62)))))
                .addContainerGap())
            .addGroup(PnlIzqLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(LblCodigoMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PnlIzqLayout.setVerticalGroup(
            PnlIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlIzqLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(LblTipoMaterial)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CmbTipoMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(LblCodigoMaterial)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(LblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(LblAutor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(LblVolumen, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtVolumen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(LblTema, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtTema, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(PnlIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
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

        CmbFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Título", "Autor", "Temas", "Disponibilidad" }));

        LblFiltros.setText("Filtros");

        TxtStockTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtStockTotalActionPerformed(evt);
            }
        });

        LblStockDisponible.setText("Stock Disponible");

        LblStockTotal.setText("Stock Total");

        javax.swing.GroupLayout PnlDerLayout = new javax.swing.GroupLayout(PnlDer);
        PnlDer.setLayout(PnlDerLayout);
        PnlDerLayout.setHorizontalGroup(
            PnlDerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlDerLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PnlDerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(SPTablaMateriales, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PnlDerLayout.createSequentialGroup()
                        .addGroup(PnlDerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtStockDisponible, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LblStockDisponible))
                        .addGap(29, 29, 29)
                        .addGroup(PnlDerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtStockTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LblStockTotal))
                        .addGap(63, 63, 63)
                        .addGroup(PnlDerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LblFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PnlDerLayout.createSequentialGroup()
                                .addComponent(CmbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(TxtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(66, 66, 66))
        );
        PnlDerLayout.setVerticalGroup(
            PnlDerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlDerLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(PnlDerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblStockDisponible)
                    .addComponent(LblStockTotal)
                    .addComponent(LblFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PnlDerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CmbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtStockTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtStockDisponible, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(SPTablaMateriales, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
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

    private void TxtStockTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtStockTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtStockTotalActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BtnAgregar;
    public javax.swing.JButton BtnEliminar;
    public javax.swing.JButton BtnModificar;
    private javax.swing.JComboBox<String> CmbFiltro;
    public javax.swing.JComboBox<String> CmbTipoMaterial;
    public javax.swing.JLabel LblAutor;
    public javax.swing.JLabel LblCodigoMaterial;
    private javax.swing.JLabel LblFiltros;
    private javax.swing.JLabel LblStockDisponible;
    private javax.swing.JLabel LblStockTotal;
    public javax.swing.JLabel LblTema;
    private javax.swing.JLabel LblTipoMaterial;
    public javax.swing.JLabel LblTitulo;
    public javax.swing.JLabel LblVolumen;
    public javax.swing.JPanel PanelMateriales;
    private javax.swing.JPanel PnlDer;
    public javax.swing.JPanel PnlIzq;
    private javax.swing.JScrollPane SPTablaMateriales;
    public javax.swing.JTable TblMateriales;
    public javax.swing.JTextField TxtAutor;
    public javax.swing.JTextField TxtCodigo;
    public javax.swing.JTextField TxtFiltro;
    public javax.swing.JTextField TxtStockDisponible;
    public javax.swing.JTextField TxtStockTotal;
    public javax.swing.JTextField TxtTema;
    public javax.swing.JTextField TxtTitulo;
    public javax.swing.JTextField TxtVolumen;
    // End of variables declaration//GEN-END:variables
}
