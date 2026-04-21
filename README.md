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



Capturas del codigo:
<img width="1920" height="1077" alt="image" src="https://github.com/user-attachments/assets/e2f00909-5fcc-41bd-a87f-5e6f7aff2720" />
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/a5a1b4e2-2322-4df0-8fed-3caca236c556" />
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/cd87991c-627b-4d2a-b8f9-86760276db1d" />
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/3f4c0487-0e1f-41b5-9b3e-7da35adcbc93" />
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/1560cdf3-fb28-4be4-86c4-bb6fdc97442a" />
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/ac30bda5-25d8-4798-80b6-f628b46bfda3" />
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/d68f0597-d0b2-4c69-b499-1d1f1d5d705e" />
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/bb40385b-a30c-4a67-b1bc-eade3ca1a315" />
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/2c3123be-d554-4037-ac74-11a9de48cd20" />
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/9f12d1a2-649d-45e1-aae4-094c73ad83bd" />
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/8808dfbd-0e67-435b-9e71-7638e3d4ace1" />
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/0ac91f0c-4511-48ff-8fc4-ed30208fd43f" />
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/5e7ff217-ffa4-4553-b59c-e067fd917411" />
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/996600ae-20fa-4bb9-acf0-b815d50a72aa" />




