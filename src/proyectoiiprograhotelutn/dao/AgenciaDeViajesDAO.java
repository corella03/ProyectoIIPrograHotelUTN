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
import proyectoiiprograhotelutn.entities.AgenciaDeViajes;
import proyectoiiprograhotelutn.entities.MiError;
/**
 **
 ** @author Luis Alonso Corella Chaves
 ** 24/11/2017
 **/
public class AgenciaDeViajesDAO {
    public boolean insertarAgencia(AgenciaDeViajes agencia) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "insert into agencia_de_viajes(id, nombre, comision)"
                    + "values (?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, agencia.getId());
            stmt.setString(2, agencia.getNombre());
            stmt.setInt(3, agencia.getComision());
            return stmt.executeUpdate() > 0;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new MiError("No se pudo registrar la agencia, favor intente nuevamente.");
        }
    }
    public ArrayList<AgenciaDeViajes> cargarAgenciasDeViajes() {
        ArrayList<AgenciaDeViajes> agencia = new ArrayList<>();
        try (Connection con = Conexion.getConexion()) {
            String sql = "select * from agencia_de_viajes";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                agencia.add(cargarAgenciaDeViajes(rs));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());// TODO: Eliminar esta  línea
            throw new MiError("Problemas al cargar las agencias de viajes, favor intente nuevamente.");
        }
        return agencia;
    }
    private AgenciaDeViajes cargarAgenciaDeViajes(ResultSet rs) throws SQLException {
        AgenciaDeViajes agencia = new AgenciaDeViajes();
        agencia.setId(rs.getString("id"));
        agencia.setNombre(rs.getString("nombre"));
        agencia.setComision(rs.getInt("comision"));
        return agencia;
    }
    public boolean verificarExistenciaAgencia(String id) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "select id from agencia_de_viajes where id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, id.toLowerCase());
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar, favor intente nuevamente.");
        }
    }
}