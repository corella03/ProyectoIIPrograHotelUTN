/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoiiprograhotelutn.bo;
import proyectoiiprograhotelutn.dao.PaisDAO;
import proyectoiiprograhotelutn.entities.MiError;
import proyectoiiprograhotelutn.entities.Pais;
/**
 **
 ** @author Luis Alonso Corella Chaves
 ** 24/11/2017
 **/
public class PaisBO {
    public boolean registrarPais(Pais pais) {
        if (pais.getNombre().isEmpty()) {
            throw new MiError("Se Requiere que ingrese el nombre del país.");
        }
        PaisDAO paisdao = new PaisDAO();
        if(paisdao.verificarExistenciaPais(pais.getNombre())){
            throw new MiError("El país ya ha sido registrado.");
        }
        return paisdao.insertarPais(pais);
    }
}