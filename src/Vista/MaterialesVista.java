package Vista;

public class MaterialesVista extends javax.swing.JPanel {

    public MaterialesVista() {
        setSize(860, 640);
        setLocation(0, 0);
        initComponents();
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
        LblISBN = new javax.swing.JLabel();
        LblTitulo = new javax.swing.JLabel();
        LblAutor = new javax.swing.JLabel();
        LblVolumen = new javax.swing.JLabel();
        LblTema = new javax.swing.JLabel();
        LblTipoMaterial = new javax.swing.JLabel();
        PnlDer = new javax.swing.JPanel();
        TxtFiltro = new javax.swing.JTextField();
        SPTablaMateriales = new javax.swing.JScrollPane();
        TablaMateriales = new javax.swing.JTable();
        CmbFiltro = new javax.swing.JComboBox<>();
        LblFiltros = new javax.swing.JLabel();

        setBackground(new java.awt.Color(236, 226, 208));

        PanelMateriales.setBackground(new java.awt.Color(236, 226, 208));
        PanelMateriales.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CmbTipoMaterial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Libro", "Monografia" }));

        BtnAgregar.setText("Agregar");

        BtnEliminar.setText("Eliminar");

        LblISBN.setText("ISBN:");

        LblTitulo.setText("Título");

        LblAutor.setText("Autor:");

        LblVolumen.setText("Volumen:");

        LblTema.setText("Tema");

        LblTipoMaterial.setText("Tipo de material:");

        javax.swing.GroupLayout PnlIzqLayout = new javax.swing.GroupLayout(PnlIzq);
        PnlIzq.setLayout(PnlIzqLayout);
        PnlIzqLayout.setHorizontalGroup(
            PnlIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlIzqLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(LblTipoMaterial))
            .addGroup(PnlIzqLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(CmbTipoMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PnlIzqLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(LblISBN))
            .addGroup(PnlIzqLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(TxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PnlIzqLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(LblTitulo))
            .addGroup(PnlIzqLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(TxtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PnlIzqLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(LblAutor))
            .addGroup(PnlIzqLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(TxtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PnlIzqLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(LblVolumen, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PnlIzqLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(TxtVolumen, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PnlIzqLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(LblTema, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PnlIzqLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(TxtTema, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PnlIzqLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(BtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PnlIzqLayout.setVerticalGroup(
            PnlIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlIzqLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(LblTipoMaterial)
                .addGap(4, 4, 4)
                .addComponent(CmbTipoMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(LblISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(TxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(LblTitulo)
                .addGap(14, 14, 14)
                .addComponent(TxtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(LblAutor)
                .addGap(14, 14, 14)
                .addComponent(TxtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(LblVolumen, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(TxtVolumen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(LblTema, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(TxtTema, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addGroup(PnlIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        PanelMateriales.add(PnlIzq, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 640));

        PnlDer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        PnlDer.add(TxtFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, 160, 30));

        SPTablaMateriales.setForeground(new java.awt.Color(255, 255, 255));

        TablaMateriales.setBackground(new java.awt.Color(255, 255, 255));
        TablaMateriales.setForeground(new java.awt.Color(0, 0, 0));
        TablaMateriales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        SPTablaMateriales.setViewportView(TablaMateriales);

        PnlDer.add(SPTablaMateriales, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 570, 540));

        CmbFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Título", "Autor", "Temas", "Disponibilidad" }));
        PnlDer.add(CmbFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 120, 30));

        LblFiltros.setText("Filtros:");
        PnlDer.add(LblFiltros, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, -1));

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
    private javax.swing.JLabel LblFiltros;
    public javax.swing.JLabel LblISBN;
    public javax.swing.JLabel LblTema;
    private javax.swing.JLabel LblTipoMaterial;
    public javax.swing.JLabel LblTitulo;
    public javax.swing.JLabel LblVolumen;
    public javax.swing.JPanel PanelMateriales;
    private javax.swing.JPanel PnlDer;
    public javax.swing.JPanel PnlIzq;
    private javax.swing.JScrollPane SPTablaMateriales;
    public javax.swing.JTable TablaMateriales;
    public javax.swing.JTextField TxtAutor;
    public javax.swing.JTextField TxtCodigo;
    public javax.swing.JTextField TxtFiltro;
    public javax.swing.JTextField TxtTema;
    public javax.swing.JTextField TxtTitulo;
    public javax.swing.JTextField TxtVolumen;
    // End of variables declaration//GEN-END:variables
}
