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
        BtnAgregar.putClientProperty("JButton.buttonType", "roundRect");
        BtnAgregar.putClientProperty("FlatLaf.style", "font: 13 $semibold.font");
        BtnAgregar.setForeground(Color.black);
        BtnEliminar.putClientProperty("JButton.buttonType", "roundRect");
        BtnEliminar.putClientProperty("FlatLaf.style", "font: 13 $semibold.font");
        BtnEliminar.setForeground(Color.black);
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
        PnlDer = new javax.swing.JPanel();
        TxtFiltro = new javax.swing.JTextField();
        SPTablaMateriales = new javax.swing.JScrollPane();
        TblMateriales = new javax.swing.JTable();
        CmbFiltro = new javax.swing.JComboBox<>();
        LblFiltros = new javax.swing.JLabel();

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
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
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

        CmbFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Título", "Autor", "Temas", "Disponibilidad" }));

        LblFiltros.setText("Filtros");

        javax.swing.GroupLayout PnlDerLayout = new javax.swing.GroupLayout(PnlDer);
        PnlDer.setLayout(PnlDerLayout);
        PnlDerLayout.setHorizontalGroup(
            PnlDerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlDerLayout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(LblFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PnlDerLayout.createSequentialGroup()
                .addGap(290, 290, 290)
                .addComponent(CmbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(TxtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PnlDerLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(SPTablaMateriales, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PnlDerLayout.setVerticalGroup(
            PnlDerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlDerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LblFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PnlDerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CmbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(SPTablaMateriales, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
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
    private javax.swing.JButton BtnAgregar;
    public javax.swing.JButton BtnEliminar;
    private javax.swing.JComboBox<String> CmbFiltro;
    public javax.swing.JComboBox<String> CmbTipoMaterial;
    public javax.swing.JLabel LblAutor;
    public javax.swing.JLabel LblCodigoMaterial;
    private javax.swing.JLabel LblFiltros;
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
    public javax.swing.JTextField TxtTema;
    public javax.swing.JTextField TxtTitulo;
    public javax.swing.JTextField TxtVolumen;
    // End of variables declaration//GEN-END:variables
}
