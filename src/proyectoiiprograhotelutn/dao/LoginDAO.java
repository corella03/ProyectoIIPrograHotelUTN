/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoiiprograhotelutn.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import proyectoiiprograhotelutn.entities.MiError;
import proyectoiiprograhotelutn.entities.Usuario;
/**
 **
 ** @author Luis Alonso Corella Chaves
 ** 10/12/2017
 **/
public class LoginDAO {
    /**
     * Método para autentificar los datos del usuario que se esta loguando con los de los usuarios en la BD.
     * @param cedula String cedula ingresada
     * @param contra String contraseña ingresada
     * @return true si los datos son iguales
     */
    public boolean autentificar(String cedula, String contra) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "select * from usuario where cedula = ? "
                    + "and contrasena = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cedula);
            stmt.setString(2, contra);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            throw new MiError(ex.getMessage());
        }
        return false;
    }
    /**
     * Método para cargar los datos de un usuario en la entidad Usuario.
     * @param rs ResultSet una sentencia que trae una consulta para BD.
     * @return Usuario: datos del usuario seleccionada.
     * @throws SQLException Controla los errores.
     */
    private Usuario cargarUsuario(ResultSet rs) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setId(rs.getInt("id"));
        usuario.setNombre(rs.getString("nombre"));
        usuario.setApellido(rs.getString("apellido"));
        usuario.setCedula(rs.getString("cedula"));
        usuario.setTelefono(rs.getInt("telefono"));
        usuario.setContrasena(rs.getString("contrasena"));
        usuario.setDireccion(rs.getString("direccion"));
        DistritoDAO disritodao = new DistritoDAO();
        usuario.setIdDistrito(disritodao.seleccionarPorId(rs.getInt("id_distrito")));
        PuestoDAO puestodao = new PuestoDAO();
        usuario.setIdPuesto(puestodao.seleccionarPorId(rs.getInt("id_puesto")));
        usuario.setActivo(rs.getBoolean("activo"));
        return usuario;
    }
    /**
     * Método para seleccionar al logueado.
     * @param cedula String cedula.
     * @return Usuario : el usuario que se logueo.
     */
    public Usuario seleccionarLogeado(String cedula) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "select * from usuario where cedula = ? ";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cedula);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return cargarUsuario(rs);
            }
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar el Usuario, favor intente nuevamente");
        }
        return null;
    }
}