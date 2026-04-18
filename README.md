# utez-2e-libreria-javafx-equipo13
Sistema de gestión de catálogo de libros en JavaFX con persistencia en archivo
Sistema de Gestión de Biblioteca Este proyecto es una aplicación de escritorio desarrollada en JavaFX para la gestión de un catálogo de libros. Permite realizar operaciones CRUD con persistencia de datos en un archivo local,garantizando que la información se mantenga entre ejecuciones.

Pasos de ejecucion: 1.Crea una carpeta y trata de ponerle el mismo nombre del proyecto. 2.Adentro de esa carpeta abre la terminal y clona el repositorio ,usa este comando : git clone https://github.com/20253ds145-glitch/utez-2e-libreria-javafx-equipo13.git 3.Ahora abre tu intellij ,selecciona File>open y busca la carpeta proyectoFinal. 4.Verifica que el proyecto este utilizando JDK 17 o superior. 5.Para ejecutar la aplicacion ,dirigete a la clase llamada launcher y dale run .


explicacion del crud 
La aplicacion utiliza un archivo libros.csv como base de datos local.
Lectura: Al iniciar, la clase LibroRepository carga los datos del archivo a una ObservableList mediante un BufferedReader.
Escritura: Cada vez que se agrega, edita o elimina un libro, el sistema sobreescribe el archivo CSV para asegurar que los cambios sean permanentes.
Seguridad: Se utiliza el bloque try-catch para evitar que el programa truene si el archivo no existe o esta dañado.

Exportacion.
Acceso a los datos: El método exportarReporte() dentro de LibroRepository toma la ObservableList.
Creacion del archivo: Se utiliza la clase BufferedWriter para crear un nuevo archivo llamado reporte.csv.
Encabezado : aqui se escribe una primera linea con los titulos de las columnas: "id,Titulo,Autor,Año,Genero,Disponible". 
Ciclo de Escritura: El sistema recorre la lista libro por libro y utiliza el método l.aTexto() para convertir cada objeto en una linea de texto separada por comas, agregandola al archivo.
