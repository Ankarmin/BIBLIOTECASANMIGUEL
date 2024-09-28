package Vista;

public class MaterialesVista extends javax.swing.JPanel {

    public MaterialesVista() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelMateriales = new javax.swing.JPanel();
        PanelIzq = new javax.swing.JPanel();
        CmbTipoMaterial = new javax.swing.JComboBox<>();
        TxtISBN = new javax.swing.JTextField();
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
        PanelDer = new javax.swing.JPanel();
        TxtFiltro = new javax.swing.JTextField();
        SPTablaMateriales = new javax.swing.JScrollPane();
        TablaMateriales = new javax.swing.JTable();
        CmbFiltro = new javax.swing.JComboBox<>();
        LblFiltros = new javax.swing.JLabel();

        setBackground(new java.awt.Color(236, 226, 208));

        PanelMateriales.setBackground(new java.awt.Color(236, 226, 208));
        PanelMateriales.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelIzq.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CmbTipoMaterial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Libro", "Monografia" }));
        PanelIzq.add(CmbTipoMaterial, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 120, 30));
        PanelIzq.add(TxtISBN, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 160, 30));
        PanelIzq.add(TxtTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 160, 30));
        PanelIzq.add(TxtAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 160, 30));
        PanelIzq.add(TxtVolumen, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 160, 30));
        PanelIzq.add(TxtTema, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 160, 30));

        BtnAgregar.setText("Agregar");
        PanelIzq.add(BtnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 590, 90, 30));

        BtnEliminar.setText("Eliminar");
        PanelIzq.add(BtnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 590, 90, 30));

        LblISBN.setText("ISBN:");
        PanelIzq.add(LblISBN, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, 20));

        LblTitulo.setText("Título");
        PanelIzq.add(LblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        LblAutor.setText("Autor:");
        PanelIzq.add(LblAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        LblVolumen.setText("Volumen:");
        PanelIzq.add(LblVolumen, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, -1, -1));

        LblTema.setText("Tema");
        PanelIzq.add(LblTema, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, -1, -1));

        LblTipoMaterial.setText("Tipo de material:");
        PanelIzq.add(LblTipoMaterial, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        PanelMateriales.add(PanelIzq, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 640));

        PanelDer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        PanelDer.add(TxtFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, 160, 30));

        TablaMateriales.setBackground(new java.awt.Color(153, 0, 153));
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

        PanelDer.add(SPTablaMateriales, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 570, 540));

        CmbFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Título", "Autor", "Temas", "Disponibilidad" }));
        PanelDer.add(CmbFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 120, 30));

        LblFiltros.setText("Filtros:");
        PanelDer.add(LblFiltros, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, -1));

        PanelMateriales.add(PanelDer, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 610, 640));

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
    private javax.swing.JLabel LblAutor;
    private javax.swing.JLabel LblFiltros;
    private javax.swing.JLabel LblISBN;
    private javax.swing.JLabel LblTema;
    private javax.swing.JLabel LblTipoMaterial;
    private javax.swing.JLabel LblTitulo;
    private javax.swing.JLabel LblVolumen;
    private javax.swing.JPanel PanelDer;
    private javax.swing.JPanel PanelIzq;
    private javax.swing.JPanel PanelMateriales;
    private javax.swing.JScrollPane SPTablaMateriales;
    private javax.swing.JTable TablaMateriales;
    public javax.swing.JTextField TxtAutor;
    public javax.swing.JTextField TxtFiltro;
    public javax.swing.JTextField TxtISBN;
    public javax.swing.JTextField TxtTema;
    public javax.swing.JTextField TxtTitulo;
    public javax.swing.JTextField TxtVolumen;
    // End of variables declaration//GEN-END:variables
}
