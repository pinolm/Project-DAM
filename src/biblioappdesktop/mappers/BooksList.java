/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioappdesktop.mappers;

/**
 *
 * @author Cristian
 */
public class BooksList {
    
    private int idLlibre;
    private String titulLlibre;
    private String dataPublicacio;
    private int copiesDisponibles;
    private String isbn;
    private String descripcio;
    private int idAutor;
    private int idCategoria;
    
    

    public int getIdLlibre() {
        return idLlibre;
    }

    public void setIdLlibre(int idLlibre) {
        this.idLlibre = idLlibre;
    }

    public String getTitulLlibre() {
        return titulLlibre;
    }

    public void setTitulLlibre(String titulLlibre) {
        this.titulLlibre = titulLlibre;
    }

    public String getDataPublicacio() {
        return dataPublicacio;
    }

    public void setDataPublicacio(String dataPublicacio) {
        this.dataPublicacio = dataPublicacio;
    }

    public int getCopiesDisponibles() {
        return copiesDisponibles;
    }

    public void setCopiesDisponibles(int copiesDisponibles) {
        this.copiesDisponibles = copiesDisponibles;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
    
    
    
    
}
