package Vista;

import java.awt.Color;

public class PrestamosActivosVista extends javax.swing.JPanel {

    public PrestamosActivosVista() {
        setSize(860, 640);
        setLocation(0, 0);
        initComponents();
        initStyles();
    }

    private void initStyles() {
        CmbTipoMaterial.putClientProperty("FlatLaf.style", "font: 14 $h3.regular.font");
        CmbTipoMaterial.setForeground(Color.black);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        SPTablaMateriales = new javax.swing.JScrollPane();
        TblPrestamosActivos = new javax.swing.JTable();
        CmbTipoMaterial = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(236, 226, 208));

        jPanel1.setBackground(new java.awt.Color(236, 226, 208));

        SPTablaMateriales.setForeground(new java.awt.Color(255, 255, 255));

        TblPrestamosActivos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        SPTablaMateriales.setViewportView(TblPrestamosActivos);

        CmbTipoMaterial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Libro", "Monografía" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CmbTipoMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SPTablaMateriales, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(CmbTipoMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(SPTablaMateriales, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
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
    public javax.swing.JComboBox<String> CmbTipoMaterial;
    private javax.swing.JScrollPane SPTablaMateriales;
    public javax.swing.JTable TblPrestamosActivos;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
