/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoiiprograhotelutn.bo;

import java.util.ArrayList;
import proyectoiiprograhotelutn.dao.ProvinciaDAO;
import proyectoiiprograhotelutn.entities.MiError;
import proyectoiiprograhotelutn.entities.Provincia;

/**
 **
 ** @author Luis Alonso Corella Chaves
 ** 26/11/2017
 **/
public class ProvinciaBO {
    public boolean registrarProvincia(Provincia provincia) {
        if (provincia.getNombre().isEmpty()) {
            throw new MiError("Se Requiere que ingrese el nombre de la provincia.");
        }
        if (String.valueOf(provincia.getIdPais()).isEmpty()) {
            throw new MiError("Se Requiere que ingrese el país que pertenece la provincia.");
        }
        ProvinciaDAO provinciadao = new ProvinciaDAO();
        if(provinciadao.verificarExistenciaProvincia(provincia.getNombre())){
            throw new MiError("La provincia ya ha sido registrado.");
        }
        return provinciadao.insertarProvincia(provincia);
    }
    public ArrayList<Provincia> cargarProvincias() {
        ProvinciaDAO provinciadao = new ProvinciaDAO();
        return provinciadao.cargarProvincias();
    }
}
