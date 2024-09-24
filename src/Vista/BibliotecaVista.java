package Vista;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.BorderLayout;
import java.awt.Color;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.JPanel;

public class BibliotecaVista extends javax.swing.JFrame {

    public BibliotecaVista() {
        initComponents();
        initStyles();
        setDate();
    }

    private void initStyles() {
        nombreApp1.putClientProperty("FlatLaf.style", "font: 24 bold $h3.regular.font");
        nombreApp1.setForeground(Color.black);
        nombreApp2.putClientProperty("FlatLaf.style", "font: 24 bold $h3.regular.font");
        nombreApp2.setForeground(Color.black);
        saludo.putClientProperty("FlatLaf.style", "font: 14 bold $h3.regular.font");
        saludo.setForeground(Color.black);
        fecha.putClientProperty("FlatLaf.style", "font: 24 $regular.font");
        fecha.setForeground(Color.black);
    }

    private void setDate() {
        LocalDate now = LocalDate.now();
        fecha.setText(now.format(DateTimeFormatter.ofPattern("'Hoy es 'EEEE dd 'de' MMMM 'de' yyyy", new Locale("es", "PE"))));
    }

    private void ShowJPanel(JPanel p) {
        p.setSize(860, 640);
        p.setLocation(0, 0);

        contenido.removeAll();
        contenido.add(p, BorderLayout.CENTER);
        contenido.revalidate();
        contenido.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        nombre = new javax.swing.JPanel();
        nombreApp1 = new javax.swing.JLabel();
        nombreApp2 = new javax.swing.JLabel();
        menu = new javax.swing.JPanel();
        usuarios = new javax.swing.JButton();
        devolucion = new javax.swing.JButton();
        prestamos = new javax.swing.JButton();
        materiales = new javax.swing.JButton();
        solicitudes = new javax.swing.JButton();
        contenido = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        saludo = new javax.swing.JLabel();
        fecha = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1140, 640));

        background.setBackground(new java.awt.Color(236, 226, 208));

        nombre.setBackground(new java.awt.Color(206, 190, 190));
        nombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        nombreApp1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreApp1.setText("Biblioteca");

        nombreApp2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreApp2.setText("San Miguel");

        javax.swing.GroupLayout nombreLayout = new javax.swing.GroupLayout(nombre);
        nombre.setLayout(nombreLayout);
        nombreLayout.setHorizontalGroup(
            nombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nombreLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(nombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nombreApp2, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                    .addComponent(nombreApp1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        nombreLayout.setVerticalGroup(
            nombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nombreLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(nombreApp1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nombreApp2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        menu.setBackground(new java.awt.Color(181, 141, 142));
        menu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        usuarios.setBackground(new java.awt.Color(255, 249, 237));
        usuarios.setText("Usuarios");
        usuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        usuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuariosActionPerformed(evt);
            }
        });

        devolucion.setBackground(new java.awt.Color(255, 249, 237));
        devolucion.setText("Devolución");
        devolucion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        devolucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                devolucionActionPerformed(evt);
            }
        });

        prestamos.setBackground(new java.awt.Color(255, 249, 237));
        prestamos.setText("Préstamos");
        prestamos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        prestamos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prestamosActionPerformed(evt);
            }
        });

        materiales.setBackground(new java.awt.Color(255, 249, 237));
        materiales.setText("Materiales");
        materiales.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        materiales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materialesActionPerformed(evt);
            }
        });

        solicitudes.setBackground(new java.awt.Color(255, 249, 237));
        solicitudes.setText("Solicitudes");
        solicitudes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        solicitudes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                solicitudesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(solicitudes, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                    .addComponent(materiales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(devolucion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(prestamos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(usuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(usuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(prestamos, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(devolucion, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(materiales, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(solicitudes, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        contenido.setBackground(new java.awt.Color(236, 226, 208));

        jPanel3.setBackground(new java.awt.Color(206, 190, 190));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        saludo.setText("¡Bueno/as (días/tardes/noches) bibliotecario encargado!");

        fecha.setText("Hoy es <fecha actual>.");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(saludo, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
                    .addComponent(fecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(saludo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout contenidoLayout = new javax.swing.GroupLayout(contenido);
        contenido.setLayout(contenidoLayout);
        contenidoLayout.setHorizontalGroup(
            contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contenidoLayout.setVerticalGroup(
            contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenidoLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 460, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(contenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(contenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void usuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuariosActionPerformed
        ShowJPanel(new Usuarios());
    }//GEN-LAST:event_usuariosActionPerformed

    private void prestamosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prestamosActionPerformed
        ShowJPanel(new Prestamos());
    }//GEN-LAST:event_prestamosActionPerformed

    private void devolucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_devolucionActionPerformed
        ShowJPanel(new Devolucion());
    }//GEN-LAST:event_devolucionActionPerformed

    private void materialesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materialesActionPerformed
        ShowJPanel(new Materiales());
    }//GEN-LAST:event_materialesActionPerformed

    private void solicitudesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_solicitudesActionPerformed
        ShowJPanel(new Solicitudes());
    }//GEN-LAST:event_solicitudesActionPerformed

    public static void main(String args[]) {

        FlatLightLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BibliotecaVista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JPanel contenido;
    private javax.swing.JButton devolucion;
    private javax.swing.JLabel fecha;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton materiales;
    private javax.swing.JPanel menu;
    private javax.swing.JPanel nombre;
    private javax.swing.JLabel nombreApp1;
    private javax.swing.JLabel nombreApp2;
    private javax.swing.JButton prestamos;
    private javax.swing.JLabel saludo;
    private javax.swing.JButton solicitudes;
    private javax.swing.JButton usuarios;
    // End of variables declaration//GEN-END:variables
}
