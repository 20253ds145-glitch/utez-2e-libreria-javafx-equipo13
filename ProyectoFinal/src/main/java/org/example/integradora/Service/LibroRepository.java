package org.example.integradora.Service;
import org.example.integradora.Model.Libro;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.*;
import java.util.Scanner;

public class LibroRepository {
    private static final String ARCHIVO = "libros.csv";
    private ObservableList<Libro> lista = FXCollections.observableArrayList();

    public LibroRepository() {
        cargar();
    }

    public ObservableList<Libro> getLista() {
        return lista;
    }
    public void agregar(Libro libro) {
        lista.add(libro);
        guardar();
    }

    public void eliminar(Libro libro) {
        lista.remove(libro);
        guardar();
    }

    public void actualizar() {
        guardar();
    }

    private void cargar() {
        File archivo = new File(ARCHIVO);
        if (!archivo.exists()) return;

        try {
            Scanner scanner = new Scanner(archivo);
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                if (!linea.isBlank()) {
                    lista.add(new Libro(linea));
                }
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("Error al cargar: " + e.getMessage());
        }
    }

    private void guardar() {
        try {
            PrintWriter pw = new PrintWriter(ARCHIVO);
            for (Libro l : lista) {
                pw.println(l.aTexto());
            }
            pw.close();
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }


    public void exportarReporte() {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter("reporte.csv"));
            pw.println("ISBN,Titulo,Autor,Año,Genero,Disponible");
            for (Libro l : lista) {
                pw.println(l.aTexto());
            }
            pw.close();
        } catch (IOException e) {
            System.out.println("Error al exportar: " + e.getMessage());
        }
    }
}