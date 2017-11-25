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
import proyectoiiprograhotelutn.entities.Puesto;

/**
 **
 ** @author Luis Alonso Corella Chaves
 ** 24/11/2017
 **/
public class PuestoDAO {
    public boolean insertar(Puesto puesto) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "insert into puesto(nombre, descripcion)"
                    + "values (?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, puesto.getNombre());
            stmt.setString(2, puesto.getDescripcion());
            return stmt.executeUpdate() > 0;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new MiError("No se pudo registrar el puesto, favor intente nuevamente.");
        }
    }

    public boolean verificarExistenciaPuesto(String nombre) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "select * from puesto where nombre = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nombre.toLowerCase());
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar, favor intente nuevamente");
        }
    }
}