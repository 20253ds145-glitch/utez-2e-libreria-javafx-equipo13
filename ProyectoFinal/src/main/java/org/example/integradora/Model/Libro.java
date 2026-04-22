package org.example.integradora.Model;
public class Libro {
    private String isbn;
    private String titulo;
    private String autor;
    private int anio;
    private String genero;
    private boolean disponible;
    public Libro(String isbn, String titulo, String autor, int anio, String genero, boolean disponible) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.genero = genero;
        this.disponible = disponible;
    }
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public int getAnio() { return anio; }
    public void setAnio(int anio) { this.anio = anio; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }

    // Convierte el libro a texto para guardar en archivo
    public String aTexto() {
        return isbn + "," + titulo + "," + autor + "," + anio + "," + genero + "," + disponible;
    }

    // Crea un Libro desde una línea del archivo
    public Libro(String linea) {
        String[] p = linea.split(",");
        this.isbn = p[0];
        this.titulo = p[1];
        this.autor = p[2];
        this.anio = Integer.parseInt(p[3]);
        this.genero = p[4];
        this.disponible = Boolean.parseBoolean(p[5]);
    }

}
