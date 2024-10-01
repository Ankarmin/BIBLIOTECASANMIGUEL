Hola mi gente latino. Aqui vamos a documentar muchas cosas relacionadas con el proyecto.

# MARTES 1 DE OCTUBRE

Se ha corregido la estructura inicial del programa para adaptar las llamadas "conexiones" entre paneles. Ahora cada controlador, que no sea el controlador de biblioteca, contiene una instancia única del controlador de la biblioteca. Esto con el motivo de propiciar la conexión de una forma más sencilla para nosotros.

Lista de cambios:

- El **FrmBibliotecaControlador** ahora tiene getters que devuelven a los controladores implicados en las conexiones (`controladorDevoluciones`, `controladorPrestamos`, `controladorPrestamosActivos`) además de un getter adicional de `frmBiblioteca`
- Ahora, cada constructor de los controladores que no sean, obviamente, **FrmBibliotecaControlador** y **PnlSolicitudesControlador** tienen que recibir un parámetro adicional que referencia a una instancia de **FrmBibliotecaControlador** y que se guarda en el atributo privado `bibliotecaControlador`
- Los métodos __mostrar__ de los controladores han sido parcialmente modificados debido a la agregación del nuevo atributo `bibliotecaControlador` (a excepción de **PnlSolicitudesControlador**)
- **PnlPrestamosControlador** ha recibido dos nuevos atributos: `Libro libroEntrante` y `Monografia monografiaEntrante`. Ademas de dos setters para poder modificar estos atributos desde **PnlMaterialesControlador**

Eso sería todo muxaxones owo
