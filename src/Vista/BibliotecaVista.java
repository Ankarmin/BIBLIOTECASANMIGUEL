package Vista;

import java.awt.Color;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class BibliotecaVista extends javax.swing.JFrame {

    private final String textoa = "<html><p> Este proyecto ha sido posible gracias al compromiso de Alejandro Rivas, director ejecutivo de la Institución, quien continúa impulsando el acceso a la educación de calidad.";
    private final String textob = "<html><p> Esta herramienta le permitirá llevar un control completo de su biblioteca. Tendrá acceso a herramientas específicas tal como lo son:";

    public BibliotecaVista() {
        initComponents();
        initStyles();
        setDate();
    }

    // Metodos propios
    private void initStyles() {
        LblNombreApp1.putClientProperty("FlatLaf.style", "font: 30 bold $h3.regular.font");
        LblNombreApp1.setForeground(Color.black);
        LblNombreApp2.putClientProperty("FlatLaf.style", "font: 30 bold $h3.regular.font");
        LblNombreApp2.setForeground(Color.black);
        LblSaludo.putClientProperty("FlatLaf.style", "font: 20 bold $h3.regular.font");
        LblSaludo.setForeground(Color.black);
        LblFecha.putClientProperty("FlatLaf.style", "font: 26 $h3.regular.font");
        LblFecha.setForeground(Color.black);
        LblTexto1.putClientProperty("FlatLaf.style", "font: 16 $semibold.font");
        LblTexto1.setForeground(Color.black);
        LblTexto2.setText(textoa);
        LblTexto2.putClientProperty("FlatLaf.style", "font: 14 $h3.regular.font");
        LblTexto2.setForeground(Color.black);
        LblTexto3.setText(textob);
        LblTexto3.putClientProperty("FlatLaf.style", "font: 14 $h3.regular.font");
        LblTexto3.setForeground(Color.black);
        LblTexto4.putClientProperty("FlatLaf.style", "font: 14 $h3.regular.font");
        LblTexto4.setForeground(Color.black);
        LblTexto5.putClientProperty("FlatLaf.style", "font: 14 $h3.regular.font");
        LblTexto5.setForeground(Color.black);
        LblTexto6.putClientProperty("FlatLaf.style", "font: 14 $h3.regular.font");
        LblTexto6.setForeground(Color.black);
        LblTexto7.putClientProperty("FlatLaf.style", "font: 14 $h3.regular.font");
        LblTexto7.setForeground(Color.black);
        LblTexto8.putClientProperty("FlatLaf.style", "font: 14 $h3.regular.font");
        LblTexto8.setForeground(Color.black);
        BtnDevolucion.putClientProperty("JButton.buttonType", "roundRect");
        BtnDevolucion.putClientProperty("FlatLaf.style", "font: 14 $semibold.font");
        BtnDevolucion.setForeground(Color.black);
        BtnMateriales.putClientProperty("JButton.buttonType", "roundRect");
        BtnMateriales.putClientProperty("FlatLaf.style", "font: 14 $semibold.font");
        BtnMateriales.setForeground(Color.black);
        BtnPrestamos.putClientProperty("JButton.buttonType", "roundRect");
        BtnPrestamos.putClientProperty("FlatLaf.style", "font: 14 $semibold.font");
        BtnPrestamos.setForeground(Color.black);
        BtnSolicitudes.putClientProperty("JButton.buttonType", "roundRect");
        BtnSolicitudes.putClientProperty("FlatLaf.style", "font: 14 $semibold.font");
        BtnSolicitudes.setForeground(Color.black);
        BtnUsuarios.putClientProperty("JButton.buttonType", "roundRect");
        BtnUsuarios.putClientProperty("FlatLaf.style", "font: 14 $semibold.font");
        BtnUsuarios.setForeground(Color.black);
    }

    private void setDate() {
        LocalDate now = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        String saludo;

        if (currentTime.isBefore(LocalTime.NOON)) {
            saludo = "¡Buenos días bibliotecario encargado!";
        } else if (currentTime.isBefore(LocalTime.of(18, 0))) {
            saludo = "¡Buenas tardes bibliotecario encargado!";
        } else {
            saludo = "¡Buenas noches bibliotecario encargado!";
        }

        LblSaludo.setText(saludo);
        LblFecha.setText(now.format(DateTimeFormatter.ofPattern("'Hoy es 'EEEE dd 'de' MMMM 'de' yyyy", Locale.of("es", "PE"))));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        nombre = new javax.swing.JPanel();
        LblNombreApp1 = new javax.swing.JLabel();
        LblNombreApp2 = new javax.swing.JLabel();
        menu = new javax.swing.JPanel();
        BtnUsuarios = new javax.swing.JButton();
        BtnDevolucion = new javax.swing.JButton();
        BtnPrestamos = new javax.swing.JButton();
        BtnMateriales = new javax.swing.JButton();
        BtnSolicitudes = new javax.swing.JButton();
        PnlContenido = new javax.swing.JPanel();
        encabezado = new javax.swing.JPanel();
        LblSaludo = new javax.swing.JLabel();
        LblFecha = new javax.swing.JLabel();
        LblTexto1 = new javax.swing.JLabel();
        LblTexto2 = new javax.swing.JLabel();
        LblTexto3 = new javax.swing.JLabel();
        LblTexto4 = new javax.swing.JLabel();
        LblTexto5 = new javax.swing.JLabel();
        LblTexto6 = new javax.swing.JLabel();
        LblTexto7 = new javax.swing.JLabel();
        LblTexto8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1140, 640));

        background.setBackground(new java.awt.Color(236, 226, 208));

        nombre.setBackground(new java.awt.Color(217, 199, 199));
        nombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        LblNombreApp1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblNombreApp1.setText("Biblioteca");

        LblNombreApp2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblNombreApp2.setText("San Miguel");

        javax.swing.GroupLayout nombreLayout = new javax.swing.GroupLayout(nombre);
        nombre.setLayout(nombreLayout);
        nombreLayout.setHorizontalGroup(
            nombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nombreLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(nombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LblNombreApp2, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                    .addComponent(LblNombreApp1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        nombreLayout.setVerticalGroup(
            nombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nombreLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(LblNombreApp1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LblNombreApp2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        menu.setBackground(new java.awt.Color(196, 163, 163));
        menu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        BtnUsuarios.setBackground(new java.awt.Color(255, 236, 200));
        BtnUsuarios.setText("USUARIOS");
        BtnUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        BtnDevolucion.setBackground(new java.awt.Color(255, 236, 200));
        BtnDevolucion.setText("DEVOLUCIÓN");
        BtnDevolucion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        BtnPrestamos.setBackground(new java.awt.Color(255, 236, 200));
        BtnPrestamos.setText("PRÉSTAMOS");
        BtnPrestamos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        BtnMateriales.setBackground(new java.awt.Color(255, 236, 200));
        BtnMateriales.setText("MATERIALES");
        BtnMateriales.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        BtnSolicitudes.setBackground(new java.awt.Color(255, 236, 200));
        BtnSolicitudes.setText("SOLICITUDES");
        BtnSolicitudes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuLayout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnSolicitudes, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(BtnMateriales, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnDevolucion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnPrestamos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnUsuarios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(48, 48, 48))
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(BtnUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnPrestamos, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnMateriales, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnSolicitudes, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        PnlContenido.setBackground(new java.awt.Color(236, 226, 208));

        encabezado.setBackground(new java.awt.Color(217, 199, 199));
        encabezado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        LblSaludo.setText("¡Bueno/as (días/tardes/noches) bibliotecario encargado!");

        LblFecha.setText("Hoy es <fecha actual>.");

        javax.swing.GroupLayout encabezadoLayout = new javax.swing.GroupLayout(encabezado);
        encabezado.setLayout(encabezadoLayout);
        encabezadoLayout.setHorizontalGroup(
            encabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(encabezadoLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(encabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LblSaludo, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
                    .addComponent(LblFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        encabezadoLayout.setVerticalGroup(
            encabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(encabezadoLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(LblSaludo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(LblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        LblTexto1.setText("Sistema de gestión de biblioteca para la institución privada educativa San Miguel");

        LblTexto4.setText("• Gestión de préstamos y devoluciones");

        LblTexto5.setText("• Búsqueda avanzada de libros");

        LblTexto6.setText("• Inventario automatizado");

        LblTexto7.setText("• Gestión de actividad");

        LblTexto8.setText("• Solicitudes de libros");

        javax.swing.GroupLayout PnlContenidoLayout = new javax.swing.GroupLayout(PnlContenido);
        PnlContenido.setLayout(PnlContenidoLayout);
        PnlContenidoLayout.setHorizontalGroup(
            PnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(encabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PnlContenidoLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(PnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LblTexto8, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblTexto7, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblTexto6, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblTexto5, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblTexto4, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblTexto3, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblTexto1, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblTexto2, javax.swing.GroupLayout.PREFERRED_SIZE, 681, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PnlContenidoLayout.setVerticalGroup(
            PnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlContenidoLayout.createSequentialGroup()
                .addComponent(encabezado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(LblTexto1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LblTexto2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LblTexto3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LblTexto4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LblTexto5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LblTexto6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LblTexto7, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LblTexto8, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BtnDevolucion;
    public javax.swing.JButton BtnMateriales;
    public javax.swing.JButton BtnPrestamos;
    public javax.swing.JButton BtnSolicitudes;
    public javax.swing.JButton BtnUsuarios;
    private javax.swing.JLabel LblFecha;
    private javax.swing.JLabel LblNombreApp1;
    private javax.swing.JLabel LblNombreApp2;
    private javax.swing.JLabel LblSaludo;
    private javax.swing.JLabel LblTexto1;
    private javax.swing.JLabel LblTexto2;
    private javax.swing.JLabel LblTexto3;
    private javax.swing.JLabel LblTexto4;
    private javax.swing.JLabel LblTexto5;
    private javax.swing.JLabel LblTexto6;
    private javax.swing.JLabel LblTexto7;
    private javax.swing.JLabel LblTexto8;
    public javax.swing.JPanel PnlContenido;
    private javax.swing.JPanel background;
    private javax.swing.JPanel encabezado;
    private javax.swing.JPanel menu;
    private javax.swing.JPanel nombre;
    // End of variables declaration//GEN-END:variables
}
