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
    /**
     * Método para verificar datos del usuario y enviarlo al registro de usuarioDAO.
     * @param cliente Cliente que se va a verificar.
     * @return true si los datos estan correctos.
     */
    public boolean registrarCliente(Cliente cliente) {
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
    /**
     * Método para cargar los clientes que esten activas que vienen de la parte de DAO.
     * @return Cliente: la lista de los clientes activas.
     */
    public ArrayList<Cliente> cargarClientesActivos(){
        return clientedao.cargarClientes(true);
    }
    /**
     * Método para cargar los clientes que vienen de la parte de DAO.
     * @return Cliente: la lista de los clientes.
     */
    public ArrayList<Cliente> cargarClientes(){
        return clientedao.cargarClientes(false);
    }
    /**
     * Recibe id de la interfaz para buscar el cliente con dicho id.
     * @param id int id del cliente a buscar.
     * @return Cliente encontrado.
     */
    public Cliente getCliente(int id) {
        if (id <= 0) {
            throw new MiError("Favor seleccionar un cliente");
        }
        return clientedao.seleccionarPorId(id);
    }
    /**
     * Recibe número de cedula de la interfaz para buscar un cliente con dicho id.
     * @param cedula String cedula del cliente a buscar.
     * @return Cliente encontrado.
     */
    public Cliente getClientePorCedula(String cedula) {
        return clientedao.seleccionarPorCedula(cedula);
    }
    /**
     * Método para "eliminar" (desactiva) los cliente que estan en la parte de DAO.
     * @param cliente Cliente se desea elimininar.
     * @return Cliente desactivado.
     */
    public boolean elmininarUsuario(Cliente cliente){
        return clientedao.eliminarCliente(cliente);
    }
}