package Vista;

import Modelo.ModeloUsuarios;
import java.sql.Connection;

public class UsuariosVista extends javax.swing.JPanel {

    public UsuariosVista() {
        setSize(860, 640);
        setLocation(0, 0);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        TxtDNI = new javax.swing.JToggleButton();
        TxtNombre = new javax.swing.JToggleButton();
        LblNombre = new javax.swing.JLabel();
        LblDni = new javax.swing.JLabel();
        BtnAgregar = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        TxtIdBiblio = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        BtnBuscar = new javax.swing.JButton();
        BtnUsuarios_Morosos = new javax.swing.JButton();

        setBackground(new java.awt.Color(236, 226, 208));

        jPanel1.setBackground(new java.awt.Color(236, 226, 208));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setPreferredSize(new java.awt.Dimension(860, 110));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TxtDNI.setPreferredSize(new java.awt.Dimension(160, 30));
        TxtDNI.setRolloverEnabled(false);
        jPanel2.add(TxtDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, 160, 30));

        TxtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtNombreActionPerformed(evt);
            }
        });
        jPanel2.add(TxtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 160, 30));

        LblNombre.setText("Nombre:");
        jPanel2.add(LblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 70, 30));

        LblDni.setText("DNI:");
        jPanel2.add(LblDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 70, 30));

        BtnAgregar.setText("Agregar");
        BtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarActionPerformed(evt);
            }
        });
        jPanel2.add(BtnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 40, 120, 30));

        BtnEliminar.setText("Eliminar");
        BtnEliminar.setPreferredSize(new java.awt.Dimension(130, 30));
        BtnEliminar.setRolloverEnabled(false);
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });
        jPanel2.add(BtnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 40, 120, 30));

        TxtIdBiblio.setEditable(false);
        jPanel2.add(TxtIdBiblio, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, 110, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 110));

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

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 430));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 860, 430));

        jPanel3.setPreferredSize(new java.awt.Dimension(860, 110));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnBuscar.setText("Buscar");
        BtnBuscar.setPreferredSize(new java.awt.Dimension(130, 30));
        BtnBuscar.setRolloverEnabled(false);
        BtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarActionPerformed(evt);
            }
        });
        jPanel3.add(BtnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 120, 30));

        BtnUsuarios_Morosos.setText("Ver Morosos");
        BtnUsuarios_Morosos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnUsuarios_MorososActionPerformed(evt);
            }
        });
        jPanel3.add(BtnUsuarios_Morosos, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 40, 120, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, 860, 110));

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

    private void TxtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtNombreActionPerformed

    private void BtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarActionPerformed
        //agregarUsuario();
    }//GEN-LAST:event_BtnAgregarActionPerformed

    private void BtnUsuarios_MorososActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnUsuarios_MorososActionPerformed
        //cambiarUsuario();
    }//GEN-LAST:event_BtnUsuarios_MorososActionPerformed

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
        //eliminarUsuario();
    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void BtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarActionPerformed
        //buscarUsuario();
    }//GEN-LAST:event_BtnBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregar;
    private javax.swing.JButton BtnBuscar;
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnUsuarios_Morosos;
    private javax.swing.JLabel LblDni;
    private javax.swing.JLabel LblNombre;
    private javax.swing.JToggleButton TxtDNI;
    private javax.swing.JTextField TxtIdBiblio;
    private javax.swing.JToggleButton TxtNombre;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}    
    /*
    void eliminarUsuario() {
        int IdBiblio = Integer.parseInt(TxtIdBiblio.getText());
        usuarios.eliminarUsuario(IdBiblio);
    }

    void agregarUsuario() {
        String DNI = TxtDNI.getText();
        String Nombre = TxtNombre.getText();
        usuarios.agregarUsuario(Nombre, DNI);
    }
    
    void buscarUsuario() {
        int IdBiblio = Integer.parseInt(TxtIdBiblio.getText());
        usuarios.buscarUsuario(IdBiblio);
    }

    boolean cambiarUsuario() {
        return true;
    }
}
*/