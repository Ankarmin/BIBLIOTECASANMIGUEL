package Vista;

import java.awt.*;

public class DevolucionesVista extends javax.swing.JPanel {

    public DevolucionesVista() {
        setSize(860, 640);
        setLocation(0, 0);
        initComponents();
        initStyles();
    }

    private void initStyles() {
        LblIdPrestamos.putClientProperty("FlatLaf.style", "font: 16 $semibold.font");
        LblIdPrestamos.setForeground(Color.black);
        LblFechaDevolucion.putClientProperty("FlatLaf.style", "font: 16 $semibold.font");
        LblFechaDevolucion.setForeground(Color.black);
        CmbMaterial.putClientProperty("FlatLaf.style", "font: 16 $h3.regular.font");
        CmbMaterial.setForeground(Color.black);
        TxtIdPrestamo.putClientProperty("FlatLaf.style", "font: 16 $h3.regular.font");
        TxtIdPrestamo.setForeground(Color.black);
        TxtFechaDevolucion.putClientProperty("FlatLaf.style", "font: 16 $h3.regular.font");
        TxtFechaDevolucion.setForeground(Color.black);
        BtnDevolver.putClientProperty("FlatLaf.style", "font: 15 $semibold.font");
        BtnDevolver.setForeground(Color.black);
        BtnPrestamosActivos.putClientProperty("FlatLaf.style", "font: 15 $semibold.font");
        BtnPrestamosActivos.setForeground(Color.black);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        TxtIdPrestamo = new javax.swing.JTextField();
        CmbMaterial = new javax.swing.JComboBox<>();
        LblFechaDevolucion = new javax.swing.JLabel();
        LblIdPrestamos = new javax.swing.JLabel();
        TxtFechaDevolucion = new javax.swing.JTextField();
        BtnDevolver = new javax.swing.JButton();
        PnlImagen = new javax.swing.JPanel();
        BtnPrestamosActivos = new javax.swing.JButton();

        setBackground(new java.awt.Color(236, 226, 208));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(236, 226, 208));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(TxtIdPrestamo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 130, 57));

        CmbMaterial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Libro", "Monografía" }));
        jPanel2.add(CmbMaterial, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, -1, 40));

        LblFechaDevolucion.setText("Fecha de devolución");
        jPanel2.add(LblFechaDevolucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 192, -1));

        LblIdPrestamos.setText("Id Préstamo");
        jPanel2.add(LblIdPrestamos, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 192, -1));
        jPanel2.add(TxtFechaDevolucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 130, 57));

        BtnDevolver.setBackground(new java.awt.Color(255, 236, 200));
        BtnDevolver.setText("DEVOLVER");
        jPanel2.add(BtnDevolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 410, 175, 50));

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

        BtnPrestamosActivos.setBackground(new java.awt.Color(255, 236, 200));
        BtnPrestamosActivos.setText("PRESTAMOS ACTIVOS");
        jPanel2.add(BtnPrestamosActivos, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 410, 175, 50));

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BtnDevolver;
    public javax.swing.JButton BtnPrestamosActivos;
    public javax.swing.JComboBox<String> CmbMaterial;
    private javax.swing.JLabel LblFechaDevolucion;
    private javax.swing.JLabel LblIdPrestamos;
    private javax.swing.JPanel PnlImagen;
    public javax.swing.JTextField TxtFechaDevolucion;
    public javax.swing.JTextField TxtIdPrestamo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
