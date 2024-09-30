package Common;

import DBRepositorio.Entidades;
import DBRepositorio.IConectar;
import DBRepositorio.Libro;
import DBRepositorio.PrestamoLibro;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * @author Leonidas Garcia Lescano
 * @param <T>
 */
// Generico de tipo
public class CommonFunctions {

    public static <T extends Entidades> void llenarTabla(JTable tabla, List<String> columnas, List<T> datos) {
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        int row = 0;
        int column = 0;
        for (String columna : columnas) {
            model.addColumn(columna);
            model.isCellEditable(row, column);
            column++;
        }

        for (T dato : datos) {
            model.addRow(dato.toArray());
            for (int i = 0; i < columnas.size(); i++) {
                model.isCellEditable(row, i);
            }
            row++;
        }

        tabla.setModel(model);

    }
}
