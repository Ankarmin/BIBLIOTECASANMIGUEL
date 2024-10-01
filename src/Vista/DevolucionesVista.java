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
        LblIdPrestamos.putClientProperty("FlatLaf.style", "font: 20 bold $h3.regular.font");
        LblIdPrestamos.setForeground(Color.black);
        LblFechaDevolucion.putClientProperty("FlatLaf.style", "font: 20 bold $h3.regular.font");
        LblFechaDevolucion.setForeground(Color.black);
        CmbMaterial.putClientProperty("FlatLaf.style", "font: 20 $h3.regular.font");
        CmbMaterial.setForeground(Color.black);
        TxtIdPrestamo.putClientProperty("FlatLaf.style", "font: 20 $h3.regular.font");
        TxtIdPrestamo.setForeground(Color.black);
        TxtFechaDevolucion.putClientProperty("FlatLaf.style", "font: 20 $h3.regular.font");
        TxtFechaDevolucion.setForeground(Color.black);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        CmbMaterial = new javax.swing.JComboBox<>();
        LblIdPrestamos = new javax.swing.JLabel();
        LblFechaDevolucion = new javax.swing.JLabel();
        TxtIdPrestamo = new javax.swing.JTextField();
        TxtFechaDevolucion = new javax.swing.JTextField();

        setBackground(new java.awt.Color(236, 226, 208));

        jPanel1.setBackground(new java.awt.Color(236, 226, 208));

        CmbMaterial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Libro", "Monografía" }));

        LblIdPrestamos.setText("Id Préstamos:");

        LblFechaDevolucion.setText("Fecha de devolución:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TxtFechaDevolucion, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                    .addComponent(TxtIdPrestamo)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(CmbMaterial, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LblFechaDevolucion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LblIdPrestamos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(643, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(CmbMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(LblIdPrestamos)
                .addGap(18, 18, 18)
                .addComponent(TxtIdPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(LblFechaDevolucion)
                .addGap(18, 18, 18)
                .addComponent(TxtFechaDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(265, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CmbMaterial;
    private javax.swing.JLabel LblFechaDevolucion;
    private javax.swing.JLabel LblIdPrestamos;
    private javax.swing.JTextField TxtFechaDevolucion;
    private javax.swing.JTextField TxtIdPrestamo;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
