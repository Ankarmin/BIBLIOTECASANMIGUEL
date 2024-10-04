package Vista;

import java.awt.Color;

public class PrestamosVista extends javax.swing.JPanel {

    public PrestamosVista() {
        setSize(860, 640);
        setLocation(0, 0);
        initComponents();
        initStyles();
    }

    private void initStyles() {
        BtnPrestamosActivos.putClientProperty("FlatLaf.style", "font: 15 $semibold.font");
        BtnPrestamosActivos.setForeground(Color.black);
        BtnPrestar.putClientProperty("FlatLaf.style", "font: 15 $semibold.font");
        BtnPrestar.setForeground(Color.black);
        CmbMaterial.putClientProperty("FlatLaf.style", "font: 16 $h3.regular.font");
        CmbMaterial.setForeground(Color.black);
        LblCodigoMaterial.putClientProperty("FlatLaf.style", "font: 16 $semibold.font");
        LblCodigoMaterial.setForeground(Color.black);
        LblFechaDevolucion.putClientProperty("FlatLaf.style", "font: 16 $semibold.font");
        LblFechaDevolucion.setForeground(Color.black);
        LblIDBiblioteca.putClientProperty("FlatLaf.style", "font: 16 $semibold.font");
        LblIDBiblioteca.setForeground(Color.black);
        TxtCodigoMaterial.putClientProperty("FlatLaf.style", "font: 16 $h3.regular.font");
        TxtCodigoMaterial.setForeground(Color.black);
        TxtFechaDevolucion.putClientProperty("FlatLaf.style", "font: 16 $h3.regular.font");
        TxtFechaDevolucion.setForeground(Color.black);
        TxtIDBiblioteca.putClientProperty("FlatLaf.style", "font: 16 $h3.regular.font");
        TxtIDBiblioteca.setForeground(Color.black);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        CmbMaterial = new javax.swing.JComboBox<>();
        LblIDBiblioteca = new javax.swing.JLabel();
        TxtIDBiblioteca = new javax.swing.JTextField();
        TxtFechaDevolucion = new javax.swing.JTextField();
        LblCodigoMaterial = new javax.swing.JLabel();
        TxtCodigoMaterial = new javax.swing.JTextField();
        BtnPrestar = new javax.swing.JButton();
        BtnPrestamosActivos = new javax.swing.JButton();
        LblFechaDevolucion = new javax.swing.JLabel();
        PnlImagen = new javax.swing.JPanel();

        setBackground(new java.awt.Color(236, 226, 208));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(236, 226, 208));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CmbMaterial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Libro", "Monografía" }));
        jPanel2.add(CmbMaterial, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, -1, 40));

        LblIDBiblioteca.setText("ID Biblioteca");
        jPanel2.add(LblIDBiblioteca, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 192, -1));
        jPanel2.add(TxtIDBiblioteca, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 130, 57));
        jPanel2.add(TxtFechaDevolucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 130, 57));

        LblCodigoMaterial.setText("ISBN");
        jPanel2.add(LblCodigoMaterial, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, 192, -1));
        jPanel2.add(TxtCodigoMaterial, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, 130, 57));

        BtnPrestar.setBackground(new java.awt.Color(255, 236, 200));
        BtnPrestar.setText("PRESTAR");
        jPanel2.add(BtnPrestar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 430, 150, 50));

        BtnPrestamosActivos.setBackground(new java.awt.Color(255, 236, 200));
        BtnPrestamosActivos.setText("PRÉSTAMOS ACTIVOS");
        jPanel2.add(BtnPrestamosActivos, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 430, 198, 50));

        LblFechaDevolucion.setText("Fecha de devolución");
        jPanel2.add(LblFechaDevolucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 192, -1));

        PnlImagen.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout PnlImagenLayout = new javax.swing.GroupLayout(PnlImagen);
        PnlImagen.setLayout(PnlImagenLayout);
        PnlImagenLayout.setHorizontalGroup(
            PnlImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 206, Short.MAX_VALUE)
        );
        PnlImagenLayout.setVerticalGroup(
            PnlImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 286, Short.MAX_VALUE)
        );

        jPanel2.add(PnlImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 210, 290));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(105, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BtnPrestamosActivos;
    public javax.swing.JButton BtnPrestar;
    public javax.swing.JComboBox<String> CmbMaterial;
    public javax.swing.JLabel LblCodigoMaterial;
    private javax.swing.JLabel LblFechaDevolucion;
    private javax.swing.JLabel LblIDBiblioteca;
    private javax.swing.JPanel PnlImagen;
    public javax.swing.JTextField TxtCodigoMaterial;
    public javax.swing.JTextField TxtFechaDevolucion;
    public javax.swing.JTextField TxtIDBiblioteca;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
