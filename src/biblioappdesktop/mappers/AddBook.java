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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class AddBook {
    
    private String titulLlibre;
    private String dataPublicacio;
    private int copiesDisponibles;
    private String isbn;
    private String descripcio;
    private int idAutor;
    private int idCategoria;
    
}
