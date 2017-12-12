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
import java.util.ArrayList;
import proyectoiiprograhotelutn.entities.MiError;
import proyectoiiprograhotelutn.entities.Usuario;

/**
 **
 ** @author Luis Alonso Corella Chaves
 ** 24/11/2017
 **/
public class UsuarioDAO {
    public boolean insertarUsuario(Usuario usuario) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "insert into usuario(nombre, apellido, cedula, telefono, contrasena, direccion, id_distrito, id_puesto)"
                    + "values (?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getApellido());
            stmt.setString(3, usuario.getCedula());
            stmt.setInt(4, usuario.getTelefono());
            stmt.setString(5, usuario.getContrasena());
            stmt.setString(6, usuario.getDireccion());
            stmt.setInt(7, usuario.getIdDistrito().getId());
            stmt.setInt(8, usuario.getIdPuesto().getId());
            return stmt.executeUpdate() > 0;
        }
//        catch(SQLException e) {
//            throw  new MiError("La cédula del usuario ya fue registrada.");
//        } 
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new MiError("No se pudo registrar el usuario, favor intente nuevamente.");
        }
    }
    public ArrayList<Usuario> cargarUsuarios(boolean activo) {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try (Connection con = Conexion.getConexion()) {
            String sql = activo ? "select * from usuario where activo = true"
                    : "select * from usuario";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                usuarios.add(cargarUsuario(rs));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());// TODO: Eliminar esta  línea
            throw new MiError("Problemas al cargar los usuarios, favor intente nuevamente.");
        }
        return usuarios;
    }
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
    public Usuario seleccionarPorId(int id) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "select * from usuario where id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return cargarUsuario(rs);
            }
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar el Usuario, favor intente nuevamente");
        }
        return null;
    }
    public boolean modificarUsuario(Usuario usuario) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "update usuario set nombre =?, apellido=?, cedula=?, telefono=?, "
                    + "contrasena=?, direccion=?, id_distrito=?, id_puesto=?, activo=?"
                    + " where id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getApellido());
            stmt.setString(3, usuario.getCedula());
            stmt.setInt(4, usuario.getTelefono());
            stmt.setString(5, usuario.getContrasena());
            stmt.setString(6, usuario.getDireccion());
            stmt.setInt(7, usuario.getIdDistrito().getId());
            stmt.setInt(8, usuario.getIdPuesto().getId());
            stmt.setBoolean(9, usuario.isActivo());
            stmt.setInt(10, usuario.getId());
            return stmt.executeUpdate() > 0;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new MiError("No se pudo modificar el Usuario, favor intente nuevamente");
        }
    }
    public boolean eliminarUsuario(Usuario usuario) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "update usuario set activo = false where id =?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, usuario.getId());
            return stmt.executeUpdate() > 0;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new MiError("No se pudo Eliminar el Usuario, favor intente nuevamente");
        }
    }
}