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
    /**
     * Método para verficar datos al loguearse.
     * @param cedula String cedula del usuario.
     * @param contra String contraseña del usuario
     * @return true si los datos estan correctos.
     */
    public boolean login(String cedula, String contra) {
        if (cedula.isEmpty()) {
            throw new MiError("Favor digite la cédula del cliente");
        }
        if (contra.isEmpty()) {
            throw new MiError("Favor digite la contraseña del usuario");
        }
        contra = encriptar(contra);
        return ldao.autentificar(cedula, contra);
    }
    /**
     * Método que se utiliza para encritar la contraseña ingresada.
     * @param contra String con la contraseña.
     * @return true si los datos se pudieron encryptar.
     */
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
    /**
     *Método para obterner el usuario con el que se loguea.
     * @param cedula String cedula del usuario a loguearse.
     * @return Usuario logueado.
     */
    public Usuario getUsuarioLogeado(String cedula) {
        return ldao.seleccionarLogeado(cedula);
    }
}