/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoiiprograhotelutn.bo;
import java.util.ArrayList;
import proyectoiiprograhotelutn.dao.UsuarioDAO;
import proyectoiiprograhotelutn.entities.MiError;
import proyectoiiprograhotelutn.entities.Usuario;
/**
 **
 ** @author Luis Alonso Corella Chaves
 ** 24/11/2017
 **/
public class UsuarioBO {
    UsuarioDAO usuariodao;
    public UsuarioBO() {
        usuariodao = new UsuarioDAO();
    }
    public boolean registrarUsuario(Usuario usuario) {
        if(usuario.getNombre().isEmpty()) {
            throw new MiError("Se Requiere que ingrese el nombre del usuario.");
        }
        if(usuario.getApellido().isEmpty()) {
            throw new MiError("Se Requiere que ingrese el apellido del usuario.");
        }
        if(usuario.getCedula().isEmpty()) {
            throw new MiError("Se Requiere que ingrese el número de cédula del usuario.");
        }
        if(String.valueOf(usuario.getTelefono()).isEmpty()) {
            throw new MiError("Se Requiere que ingrese el telefono del usuario.");
        }
        if(usuario.getContrasena().isEmpty()) {
            throw new MiError("Se Requiere que ingrese la contraseña del usuario.");
        }
        if(usuario.getDireccion().isEmpty()) {
            throw new MiError("Se Requiere que ingrese la dirección del usuario.");
        }
        if(String.valueOf(usuario.getIdDistrito().getId()).isEmpty()) {
            throw new MiError("Se Requiere que ingrese el distrito a donde pertenece el usuario.");
        }
        if(String.valueOf(usuario.getIdPuesto().getId()).isEmpty()) {
            throw new MiError("Se Requiere que ingrese el puesto del usuario.");
        }
        usuario.setContrasena(encriptar(usuario.getContrasena()));
        if(usuario.getId() == 0) {
            return usuariodao.insertarUsuario(usuario);
        } else {
            return usuariodao.modificarUsuario(usuario);
        }
    }
    private String encriptar(String contra) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(contra.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
            throw new MiError("Favor digitar una nueva contraseña");
        }
    }
    public ArrayList<Usuario> cargarUsuarioActivos(){
        return usuariodao.cargarUsuarios(true);
    }
    public ArrayList<Usuario> cargarUsuario(){
        return usuariodao.cargarUsuarios(false);
    }
    public Usuario getUsuario(int id) {
        if (id <= 0) {
            throw new MiError("Favor seleccionar un usuario");
        }
        return usuariodao.seleccionarPorId(id);
    }
    public boolean elmininarUsuario(Usuario usuario){
        return usuariodao.eliminarUsuario(usuario);
    }
}