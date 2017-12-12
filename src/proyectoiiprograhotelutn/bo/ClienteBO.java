/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoiiprograhotelutn.bo;
import java.util.ArrayList;
import proyectoiiprograhotelutn.dao.ClienteDAO;
import proyectoiiprograhotelutn.entities.Cliente;
import proyectoiiprograhotelutn.entities.MiError;
import proyectoiiprograhotelutn.entities.Usuario;
/**
 **
 ** @author Luis Alonso Corella Chaves
 ** 11/12/2017
 **/
public class ClienteBO {
    ClienteDAO clientedao;
    public ClienteBO() {
        clientedao = new ClienteDAO();
    }
    public boolean registrarUsuario(Cliente cliente) {
        if(cliente.getCedula().isEmpty()) {
            throw new MiError("Se Requiere que ingrese el número de cédula del cliente.");
        }
        if(cliente.getNombre().isEmpty()) {
            throw new MiError("Se Requiere que ingrese el nombre del cliente.");
        }
        if(cliente.getApellido().isEmpty()) {
            throw new MiError("Se Requiere que ingrese el apellido del cliente.");
        }
        if(cliente.getNumeroTarjeta().isEmpty()) {
            throw new MiError("Se Requiere que ingrese la contraseña del usuario.");
        }
        if(cliente.getDireccion().isEmpty()) {
            throw new MiError("Se Requiere que ingrese la dirección del cliente.");
        }
        if(cliente.getId() == 0) {
            return clientedao.insertarCliente(cliente);
        } else {
            return clientedao.modificarCliente(cliente);
        }
    }
    public ArrayList<Cliente> cargarClientesActivos(){
        return clientedao.cargarClientes(true);
    }
    public ArrayList<Cliente> cargarClientes(){
        return clientedao.cargarClientes(false);
    }
    public Cliente getCliente(int id) {
        if (id <= 0) {
            throw new MiError("Favor seleccionar un cliente");
        }
        return clientedao.seleccionarPorId(id);
    }
    public Cliente getClientePorCedula(String cedula) {
        return clientedao.seleccionarPorCedula(cedula);
    }
    public boolean elmininarUsuario(Cliente cliente){
        return clientedao.eliminarCliente(cliente);
    }
}