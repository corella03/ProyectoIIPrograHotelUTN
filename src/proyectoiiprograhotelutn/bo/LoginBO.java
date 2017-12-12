/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoiiprograhotelutn.bo;
import proyectoiiprograhotelutn.dao.LoginDAO;
import proyectoiiprograhotelutn.entities.MiError;
import proyectoiiprograhotelutn.entities.Usuario;
/**
 **
 ** @author Luis Alonso Corella Chaves
 ** 10/12/2017
 **/
public class LoginBO {
    LoginDAO ldao;
    public LoginBO() {
        ldao = new LoginDAO();
    }
    public boolean login(String cedula, String contra) {
        if (cedula.isEmpty()) {
            throw new MiError("Favor digite la cédula del cliente");
        }
        if (contra.isEmpty()) {
            throw new MiError("Favor digite la contraseña del usuario");
        }
        contra = encriptar(contra);
        //usuario.setPassword(encriptar(usuario.getPassword()));
        return ldao.autentificar(cedula, contra);
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
    public Usuario getUsuarioLogeado(String cedula) {
        return ldao.seleccionarLogeado(cedula);
    }
}