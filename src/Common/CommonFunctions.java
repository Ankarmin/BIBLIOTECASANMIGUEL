package Common;

import DBRepositorio.Entidades;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

// Generico de tipo
// HOLA EN ESTA CLASE USAMOS GENERICOS PARA GENERAR TABLAS ADAPTABLES A CUALQUIER TIPO DE ENTIDAD
// ¿NO SABES QUE ES UNA ENTIDAD? PUES EN ESTE PROGRAMA UTILIZAMOS VARIOS DE ESOS, SON LAS CLASES QUE REPRESENTAN
// CADA REGISTRO DE CADA TABLA DE NUESTRA BASE DE DATOS (RABIOSOSGRRRR)
// ESTA CLASE EN PARTICULAR ESTA DESTINADA A SERVIR COMO UN ALOJADOR DE FUNCIONES QUE SE VAN A COMPARTIR ENTRE TODOS LOS
// CONTROLADORES QUE NO SEAN EL FAMOSO FRMBIBLIOTECACONTROLADOR
public class CommonFunctions {

    // PRIMERO QUE NADA: STATIC? <T extends Entidades>? List<T>?
    //STATIC:
    // UN MÉTODO ESTÁTICO FUNCIONA COMO UNA FUNCIÓN (VALGA LA REDUNDANCIA) QUE PUEDE SER LLAMADA SIN LA NECESIDAD DE
    // INSTANCIAR A LA CLASE QUE LA CONTIENE. EN ESTE CASO, LA FUNCIÓN LLENARTABLA PUEDE SER INVOCADA DE LA SIGUIENTE MANERA
    // CommonFunctions.llenarTabla(args...)
    // LO VES? NO ES NECESARIO CREAR UNA INSTANCIA PARA ACCEDER A ESTE METODO (AUNQUE TAMBIEN PODRIAS HACERLO EHHH)
    //<T extends Entidades> y List<T>
    // NO ES TAN COMPLEJO COMO UNA PODRIA IMAGINAR, SIMPLEMENTE "T" REPRESENTA UN TIPO DE DATOS QUE AUN NO HA SIDO DEFINIDO
    // POR EJEMPLO: T PUEDE SER A CONVENIENCIA UN STRING, INT, DOUBLE, FLOAT, ETC....
    // extends Entidades
    // EN EL PAQUETE DBREPOSITORIO SE ENCUENTRA UNA CLASE LLAMADA "ENTIDADES", SI REVISAS BIEN A LAS ENTIDADES MENCIONADAS AL PRINCIPIO
    // VERAS ESTO: public class Libro extends Entidades, POR EJEMPLO
    // EXTENDS ES UNA PALABRA CLAVE DE JAVA QUE INDICA HERENCIA ENTRE CLASES, EN PALABRAS SIMPLES, LO QUE TENGA ENTIDADES LO TIENE LA
    // CLASE QUE HEREDA DE ELLA, PIOLA NO?
    // NO VOY A AHONDAR EN LO QUE ES UNA CLASE ABSTRACTA PERO EN ESTE CASO EN PARTICULAR CUANDO VEMOS <T extends Entidades> NOS REFERIMOS
    // A QUE T SOLO PUEDE SER CUALQUIER TIPO DE DATO QUE HEREDE DE LA CLASE "ENTIDADES" POR LO QUE SU CONJUNTO DE VALORES SE VE
    // LIMITADO A LAS ENTIDADES YA MENCIONADAS
    // CUANDO T TOMA ALGUN VALOR, LIST<T> TAMBIEN LO TOMA, POR EJEMPLO: T = Libro -> List<Libro>  mas claro, no?
    // ANALIZANDO ESTE MÉTODO, ES UN MÉTODO PUBLICO Y ESTÁTICO, QUE UTILIZA UN GENERICO QUE SOLO PUEDE TOMAR EL VALOR DE ALGUNA ENTIDAD
    // Y NO DEVUELVE NADA (VOID)
    //Args: TABLA->LA TABLA QUE SERA LLENADA, COLUMNAS->LA LISTA DE COLUMNAS QUE TENDRA LA TABLA, DATOS->LOS DATOS QUE SE CARGARAN EN LA TABLA
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
    
    //PROBABLEMENTE EXISTAN MAS MÉTODOS ESTATICOS POR AQUI, SIGAN VIENDO
    
}
