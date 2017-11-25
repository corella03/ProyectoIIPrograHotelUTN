/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoiiprograhotelutn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import proyectoiiprograhotelutn.entities.MiError;
import proyectoiiprograhotelutn.entities.TipoHabitacion;

/**
 **
 ** @author Luis Alonso Corella Chaves
 ** 24/11/2017
 **/
public class TipoHabitacionDAO {
    public boolean insertarTipoHabitacion(TipoHabitacion tipo) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "insert into tipo_habitacion(id, descripcion, precio)"
                    + "values (?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, tipo.getId());
            stmt.setString(2, tipo.getDescripcion());
            stmt.setInt(3, tipo.getPrecio());
            return stmt.executeUpdate() > 0;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new MiError("No se pudo registrar el tipo de habitación, favor intente nuevamente.");
        }
    }
    public boolean verificarExistenciaTipoHabitacion(String id) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "select id from tipo_habitacion where id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, id.toLowerCase());
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar, favor intente nuevamente.");
        }
    }
}
