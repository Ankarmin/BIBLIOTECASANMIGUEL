package Vista;

import com.formdev.flatlaf.intellijthemes.FlatSolarizedLightIJTheme;
import java.awt.BorderLayout;
import java.awt.Color;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.JPanel;
import javax.swing.UIManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BibliotecaVista extends javax.swing.JFrame {

    private final String textoa = "<html><p> Este proyecto ha sido posible gracias al compromiso de Alejandro Rivas, director ejecutivo de la Institución, quien continúa impulsando el acceso a la educación de calidad. </p></html>";
    private final String textob = "<html><p> Esta herramienta le permitirá llevar un control completo de su biblioteca. Tendrá acceso a herramientas específicas tal como lo son:";

    public BibliotecaVista() {
        initComponents();
        initStyles();
        setDate();
    }

    // Metodos propios
    private void initStyles() {
        nombreApp1.putClientProperty("FlatLaf.style", "font: 30 bold $h3.regular.font");
        nombreApp1.setForeground(Color.black);
        nombreApp2.putClientProperty("FlatLaf.style", "font: 30 bold $h3.regular.font");
        nombreApp2.setForeground(Color.black);
        saludo.putClientProperty("FlatLaf.style", "font: 20 bold $h3.regular.font");
        saludo.setForeground(Color.black);
        fecha.putClientProperty("FlatLaf.style", "font: 26 $h3.regular.font");
        fecha.setForeground(Color.black);
        texto1.putClientProperty("FlatLaf.style", "font: 16 $semibold.font");
        texto1.setForeground(Color.black);
        texto2.setText(textoa);
        texto2.putClientProperty("FlatLaf.style", "font: 14 $h3.regular.font");
        texto2.setForeground(Color.black);
        texto3.setText(textob);
        texto3.putClientProperty("FlatLaf.style", "font: 14 $h3.regular.font");
        texto3.setForeground(Color.black);
        texto4.putClientProperty("FlatLaf.style", "font: 14 $h3.regular.font");
        texto4.setForeground(Color.black);
        texto5.putClientProperty("FlatLaf.style", "font: 14 $h3.regular.font");
        texto5.setForeground(Color.black);
        texto6.putClientProperty("FlatLaf.style", "font: 14 $h3.regular.font");
        texto6.setForeground(Color.black);
        texto7.putClientProperty("FlatLaf.style", "font: 14 $h3.regular.font");
        texto7.setForeground(Color.black);
        texto8.putClientProperty("FlatLaf.style", "font: 14 $h3.regular.font");
        texto8.setForeground(Color.black);
        BtnDevolucion.putClientProperty("JButton.buttonType", "roundRect");
        BtnMateriales.putClientProperty("JButton.buttonType", "roundRect");
        BtnPrestamos.putClientProperty("JButton.buttonType", "roundRect");
        BtnSolicitudes.putClientProperty("JButton.buttonType", "roundRect");
        BtnUsuarios.putClientProperty("JButton.buttonType", "roundRect");
        BtnDevolucion.putClientProperty("FlatLaf.style", "font: 16 $semibold.font");
        BtnDevolucion.setForeground(Color.black);
        BtnMateriales.putClientProperty("FlatLaf.style", "font: 16 $semibold.font");
        BtnMateriales.setForeground(Color.black);
        BtnPrestamos.putClientProperty("FlatLaf.style", "font: 16 $semibold.font");
        BtnPrestamos.setForeground(Color.black);
        BtnSolicitudes.putClientProperty("FlatLaf.style", "font: 16 $semibold.font");
        BtnSolicitudes.setForeground(Color.black);
        BtnUsuarios.putClientProperty("FlatLaf.style", "font: 16 $semibold.font");
        BtnUsuarios.setForeground(Color.black);
        UIManager.put("Button.arc", 999);
        UIManager.put("Component.arc", 999);
        UIManager.put("ProgressBar.arc", 999);
        UIManager.put("TextComponent.arc", 999);
    }

    private void setDate() {
        LocalDate now = LocalDate.now();
        fecha.setText(now.format(DateTimeFormatter.ofPattern("'Hoy es 'EEEE dd 'de' MMMM 'de' yyyy", Locale.of("es", "PE"))));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        nombre = new javax.swing.JPanel();
        nombreApp1 = new javax.swing.JLabel();
        nombreApp2 = new javax.swing.JLabel();
        menu = new javax.swing.JPanel();
        BtnUsuarios = new javax.swing.JButton();
        BtnDevolucion = new javax.swing.JButton();
        BtnPrestamos = new javax.swing.JButton();
        BtnMateriales = new javax.swing.JButton();
        BtnSolicitudes = new javax.swing.JButton();
        PnlContenido = new javax.swing.JPanel();
        encabezado = new javax.swing.JPanel();
        saludo = new javax.swing.JLabel();
        fecha = new javax.swing.JLabel();
        texto1 = new javax.swing.JLabel();
        texto2 = new javax.swing.JLabel();
        texto3 = new javax.swing.JLabel();
        texto4 = new javax.swing.JLabel();
        texto5 = new javax.swing.JLabel();
        texto6 = new javax.swing.JLabel();
        texto7 = new javax.swing.JLabel();
        texto8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1140, 640));

        background.setBackground(new java.awt.Color(236, 226, 208));

        nombre.setBackground(new java.awt.Color(217, 199, 199));
        nombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

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
                .addGap(25, 25, 25)
                .addComponent(nombreApp1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nombreApp2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        menu.setBackground(new java.awt.Color(181, 141, 142));
        menu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        BtnUsuarios.setBackground(new java.awt.Color(255, 249, 237));
        BtnUsuarios.setText("Usuarios");
        BtnUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnUsuariosActionPerformed(evt);
            }
        });

        BtnDevolucion.setBackground(new java.awt.Color(255, 249, 237));
        BtnDevolucion.setText("Devolución");
        BtnDevolucion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnDevolucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDevolucionActionPerformed(evt);
            }
        });

        BtnPrestamos.setBackground(new java.awt.Color(255, 249, 237));
        BtnPrestamos.setText("Préstamos");
        BtnPrestamos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnPrestamos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPrestamosActionPerformed(evt);
            }
        });

        BtnMateriales.setBackground(new java.awt.Color(255, 249, 237));
        BtnMateriales.setText("Materiales");
        BtnMateriales.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnMateriales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnMaterialesActionPerformed(evt);
            }
        });

        BtnSolicitudes.setBackground(new java.awt.Color(255, 249, 237));
        BtnSolicitudes.setText("Solicitudes");
        BtnSolicitudes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnSolicitudes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSolicitudesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnSolicitudes, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                    .addComponent(BtnMateriales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnDevolucion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnPrestamos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(BtnUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnPrestamos, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnMateriales, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnSolicitudes, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        PnlContenido.setBackground(new java.awt.Color(236, 226, 208));

        encabezado.setBackground(new java.awt.Color(217, 199, 199));
        encabezado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        saludo.setText("¡Bueno/as (días/tardes/noches) bibliotecario encargado!");

        fecha.setText("Hoy es <fecha actual>.");

        javax.swing.GroupLayout encabezadoLayout = new javax.swing.GroupLayout(encabezado);
        encabezado.setLayout(encabezadoLayout);
        encabezadoLayout.setHorizontalGroup(
            encabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(encabezadoLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(encabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(saludo, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
                    .addComponent(fecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        encabezadoLayout.setVerticalGroup(
            encabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(encabezadoLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(saludo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        texto1.setText("Sistema de gestión de biblioteca para la institución privada educativa San Miguel");

        texto4.setText("• Gestión de préstamos y devoluciones");

        texto5.setText("• Búsqueda avanzada de libros");

        texto6.setText("• Inventario automatizado");

        texto7.setText("• Gestión de actividad");

        texto8.setText("• Solicitudes de libros");

        javax.swing.GroupLayout PnlContenidoLayout = new javax.swing.GroupLayout(PnlContenido);
        PnlContenido.setLayout(PnlContenidoLayout);
        PnlContenidoLayout.setHorizontalGroup(
            PnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(encabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PnlContenidoLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(PnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(texto8, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(texto7, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(texto6, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(texto5, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(texto4, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(texto3, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(texto1, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(texto2, javax.swing.GroupLayout.PREFERRED_SIZE, 681, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PnlContenidoLayout.setVerticalGroup(
            PnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlContenidoLayout.createSequentialGroup()
                .addComponent(encabezado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(texto1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(texto2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(texto3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(texto4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(texto5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(texto6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(texto7, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(texto8, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(PnlContenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(PnlContenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void BtnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnUsuariosActionPerformed
        //ShowJPanel(new Usuarios(openConexion));
    }//GEN-LAST:event_BtnUsuariosActionPerformed

    private void BtnPrestamosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPrestamosActionPerformed
        //ShowJPanel(new Prestamos());
    }//GEN-LAST:event_BtnPrestamosActionPerformed

    private void BtnDevolucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDevolucionActionPerformed
        //ShowJPanel(new Devolucion());
    }//GEN-LAST:event_BtnDevolucionActionPerformed

    private void BtnMaterialesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMaterialesActionPerformed
        //ShowJPanel(new MaterialesVista());
    }//GEN-LAST:event_BtnMaterialesActionPerformed

    private void BtnSolicitudesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSolicitudesActionPerformed
        //ShowJPanel(new Solicitudes());
    }//GEN-LAST:event_BtnSolicitudesActionPerformed

    public static void main(String args[]) {

        FlatSolarizedLightIJTheme.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BibliotecaVista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BtnDevolucion;
    public javax.swing.JButton BtnMateriales;
    public javax.swing.JButton BtnPrestamos;
    public javax.swing.JButton BtnSolicitudes;
    public javax.swing.JButton BtnUsuarios;
    public javax.swing.JPanel PnlContenido;
    private javax.swing.JPanel background;
    private javax.swing.JPanel encabezado;
    private javax.swing.JLabel fecha;
    private javax.swing.JPanel menu;
    private javax.swing.JPanel nombre;
    private javax.swing.JLabel nombreApp1;
    private javax.swing.JLabel nombreApp2;
    private javax.swing.JLabel saludo;
    private javax.swing.JLabel texto1;
    private javax.swing.JLabel texto2;
    private javax.swing.JLabel texto3;
    private javax.swing.JLabel texto4;
    private javax.swing.JLabel texto5;
    private javax.swing.JLabel texto6;
    private javax.swing.JLabel texto7;
    private javax.swing.JLabel texto8;
    // End of variables declaration//GEN-END:variables
}
