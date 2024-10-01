package Vista;

import java.awt.Color;

public class UsuariosVista extends javax.swing.JPanel {

    public UsuariosVista() {
        setSize(860, 640);
        setLocation(0, 0);
        initComponents();
        initStyles();
    }

    private void initStyles() {
        TxtIdBiblio.setVisible(false);
        LblDni.putClientProperty("FlatLaf.style", "font: 14 $semibold.font");
        LblDni.setForeground(Color.black);
        LblNombre.putClientProperty("FlatLaf.style", "font: 14 $semibold.font");
        LblNombre.setForeground(Color.black);
        TxtDNI.putClientProperty("FlatLaf.style", "font: 14 $h3.regular.font");
        TxtDNI.setForeground(Color.black);
        TxtNombre.putClientProperty("FlatLaf.style", "font: 14 $h3.regular.font");
        TxtNombre.setForeground(Color.black);
        BtnAgregar.putClientProperty("JButton.buttonType", "roundRect");
        BtnAgregar.putClientProperty("FlatLaf.style", "font: 13 $semibold.font");
        BtnAgregar.setForeground(Color.black);
        BtnBuscar.putClientProperty("JButton.buttonType", "roundRect");
        BtnBuscar.putClientProperty("FlatLaf.style", "font: 13 $semibold.font");
        BtnBuscar.setForeground(Color.black);
        BtnEliminar.putClientProperty("JButton.buttonType", "roundRect");
        BtnEliminar.putClientProperty("FlatLaf.style", "font: 13 $semibold.font");
        BtnEliminar.setForeground(Color.black);
        BtnUsuariosMorosos.putClientProperty("JButton.buttonType", "roundRect");
        BtnUsuariosMorosos.putClientProperty("FlatLaf.style", "font: 13 $semibold.font");
        BtnUsuariosMorosos.setForeground(Color.black);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        LblNombre = new javax.swing.JLabel();
        LblDni = new javax.swing.JLabel();
        BtnAgregar = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        TxtNombre = new javax.swing.JTextField();
        TxtDNI = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        BtnBuscar = new javax.swing.JButton();
        BtnUsuariosMorosos = new javax.swing.JButton();
        TxtIdBiblio = new javax.swing.JTextField();

        setBackground(new java.awt.Color(236, 226, 208));

        jPanel1.setBackground(new java.awt.Color(236, 226, 208));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(236, 226, 208));
        jPanel2.setPreferredSize(new java.awt.Dimension(860, 110));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LblNombre.setText("Nombre");
        jPanel2.add(LblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 60, 40));

        LblDni.setText("DNI");
        jPanel2.add(LblDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, 30, 40));

        BtnAgregar.setBackground(new java.awt.Color(255, 236, 200));
        BtnAgregar.setText("AGREGAR");
        jPanel2.add(BtnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 30, 120, 40));

        BtnEliminar.setBackground(new java.awt.Color(255, 236, 200));
        BtnEliminar.setText("ELIMINAR");
        BtnEliminar.setPreferredSize(new java.awt.Dimension(130, 30));
        BtnEliminar.setRolloverEnabled(false);
        jPanel2.add(BtnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 30, 120, 40));
        jPanel2.add(TxtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 160, 40));
        jPanel2.add(TxtDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 160, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 100));

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 820, 420));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 860, 460));

        jPanel3.setBackground(new java.awt.Color(236, 226, 208));
        jPanel3.setPreferredSize(new java.awt.Dimension(860, 110));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnBuscar.setBackground(new java.awt.Color(255, 236, 200));
        BtnBuscar.setText("BUSCAR");
        BtnBuscar.setPreferredSize(new java.awt.Dimension(130, 30));
        BtnBuscar.setRolloverEnabled(false);
        jPanel3.add(BtnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 120, 40));

        BtnUsuariosMorosos.setBackground(new java.awt.Color(255, 236, 200));
        BtnUsuariosMorosos.setText("VER MOROSOS");
        jPanel3.add(BtnUsuariosMorosos, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, 140, 40));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 560, 860, 90));

        TxtIdBiblio.setEditable(false);
        jPanel1.add(TxtIdBiblio, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, 110, 30));

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
    private javax.swing.JButton BtnAgregar;
    private javax.swing.JButton BtnBuscar;
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnUsuariosMorosos;
    private javax.swing.JLabel LblDni;
    private javax.swing.JLabel LblNombre;
    private javax.swing.JTextField TxtDNI;
    private javax.swing.JTextField TxtIdBiblio;
    private javax.swing.JTextField TxtNombre;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
