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
public class Prestecs {
    
    private int idPrestec;
    private int idUsuari;
    private int idLlibre;
    private String dataPrestec;
    private String dataDevolucioPrevista;
    private String dataDevolucio;

    public int getIdPrestec() {
        return idPrestec;
    }

    public void setIdPrestec(int idPrestec) {
        this.idPrestec = idPrestec;
    }

    public int getIdUsuari() {
        return idUsuari;
    }

    public void setIdUsuari(int idUsuari) {
        this.idUsuari = idUsuari;
    }

    public int getIdLlibre() {
        return idLlibre;
    }

    public void setIdLlibre(int idLlibre) {
        this.idLlibre = idLlibre;
    }

    public String getDataPrestec() {
        return dataPrestec;
    }

    public void setDataPrestec(String dataPrestec) {
        this.dataPrestec = dataPrestec;
    }

    public String getDataDevolucioPrevista() {
        return dataDevolucioPrevista;
    }

    public void setDataDevolucioPrevista(String dataDevolucioPrevista) {
        this.dataDevolucioPrevista = dataDevolucioPrevista;
    }

    public String getDataDevolucio() {
        return dataDevolucio;
    }

    public void setDataDevolucio(String dataDevolucio) {
        this.dataDevolucio = dataDevolucio;
    }
    
    
    
}
