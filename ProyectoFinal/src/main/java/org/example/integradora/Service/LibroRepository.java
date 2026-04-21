package org.example.integradora.Service;
import org.example.integradora.Model.Libro;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.*;
public class LibroRepository  {
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
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (!linea.isBlank()) {
                    lista.add(Libro.desdeTexto(linea));
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar: " + e.getMessage());
        }
    }
    private void guardar() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO))) {
            for (Libro l : lista) {
                bw.write(l.aTexto());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }
    public void exportarReporte() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("reporte.csv"))) {
            bw.write("ISBN,Titulo,Autor,Año,Genero,Disponible");
            bw.newLine();
            for (Libro l : lista) {
                bw.write(l.aTexto());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al exportar: " + e.getMessage());
        }
    }
}