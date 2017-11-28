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
import proyectoiiprograhotelutn.entities.TipoHabitacion;
/**
 **
 ** @author Luis Alonso Corella Chaves
 ** 24/11/2017
 **/
public class TipoHabitacionDAO {
    public boolean insertarTipoHabitacion(TipoHabitacion tipo) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "insert into tipo_habitacion(codigo, descripcion, precio)"
                    + "values (?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, tipo.getCodigo());
            stmt.setString(2, tipo.getDescripcion());
            stmt.setInt(3, tipo.getPrecio());
            return stmt.executeUpdate() > 0;
        } 
        catch(SQLException e) {
            throw  new MiError("El código de la habitacion ya fue registrada.");
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new MiError("No se pudo registrar el tipo de habitación, favor intente nuevamente.");
        }
    }
//    public ArrayList<TipoHabitacion> cargarTiposDeHabitaciones() {
//        ArrayList<TipoHabitacion> tipos = new ArrayList<>();
//        try (Connection con = Conexion.getConexion()) {
//            String sql = "select * from tipo_habitacion";
//            PreparedStatement stmt = con.prepareStatement(sql);
//            ResultSet rs = stmt.executeQuery();
//            while (rs.next()) {
//                tipos.add(cargarTipoDeHabitacion(rs));
//            }
//        }catch (Exception ex) {
//            System.out.println(ex.getMessage());// TODO: Eliminar esta  línea
//            throw new MiError("Problemas al cargar los tipos de habitación, favor intente nuevamente.");
//        }
//        return tipos;
//    }
//    private TipoHabitacion cargarTipoDeHabitacion(ResultSet rs) throws SQLException {
//        TipoHabitacion tipo = new TipoHabitacion();
//        tipo.setId(rs.getString("id"));
//        tipo.setDescripcion(rs.getString("descripcion"));
//        tipo.setPrecio(rs.getInt("precio"));
//        return tipo;
//    }
}
