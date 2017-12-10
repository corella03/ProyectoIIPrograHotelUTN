/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoiiprograhotelutn.dao;
import java.awt.Image;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import proyectoiiprograhotelutn.entities.Habitacion;
import proyectoiiprograhotelutn.entities.MiError;
/**
 **
 ** @author Luis Alonso Corella Chaves
 ** 24/11/2017
 **/
public class HabitacionDAO {
    public boolean insertarHabitacion(Habitacion habitacion) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "insert into habitacion(codigo, id_tipo_habitacion, foto, descripcion, "
                    + "estado_habitacion, cant_personas)"
                    + "values (?,?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, habitacion.getCodigo());
            stmt.setInt(2, habitacion.getIdTipoHabitacion().getId());
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write((RenderedImage) habitacion.getImagen(), "jpg", os);
            InputStream fis = new ByteArrayInputStream(os.toByteArray());
            stmt.setBinaryStream(3, fis);
            stmt.setString(4, habitacion.getDescripcion());
            stmt.setBoolean(5, habitacion.isEstado());
            stmt.setInt(6, habitacion.getCantPersonas());
            return stmt.executeUpdate() > 0;
        } 
//        catch(SQLException e) {
//            throw  new MiError("El código de la habitacion ya fue registrada.");
//        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new MiError("No se pudo registrar la habitación, favor intente nuevamente.");
        }
    }
    public ArrayList<Habitacion> cargarHabitaciones(Boolean estado_habitacion) {
        ArrayList<Habitacion> habitaciones = new ArrayList<>();
        try (Connection con = Conexion.getConexion()) {
            String sql = estado_habitacion ? "select * from habitacion where estado_habitacion = true"
                    : "select * from habitacion";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                habitaciones.add(cargarHabitacion(rs));
            }
        }catch (Exception ex) {
            System.out.println(ex.getMessage());// TODO: Eliminar esta  línea
            throw new MiError("Problemas al cargar la habitación, favor intente nuevamente.");
        }
        return habitaciones;
    }
    private Habitacion cargarHabitacion(ResultSet rs) throws SQLException, IOException {
        Habitacion habitacion = new Habitacion();
        habitacion.setId(rs.getInt("id"));
        habitacion.setCodigo(rs.getString("codigo"));
        TipoHabitacionDAO tipodao = new TipoHabitacionDAO();
        habitacion.setIdTipoHabitacion(tipodao.seleccionarPorId(rs.getInt("id_tipo_habitacion")));
        Image imgdb = null;
        InputStream fis = rs.getBinaryStream("foto");
        imgdb = ImageIO.read(fis);
        habitacion.setImagen(imgdb);
        habitacion.setDescripcion(rs.getString("descripcion"));
        habitacion.setEstado(rs.getBoolean("estado_habitacion"));
        habitacion.setCantPersonas(rs.getInt("cant_personas"));
        return habitacion;
    }
    public Habitacion seleccionarPorId(int id) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "select * from habitacion where id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return cargarHabitacion(rs);
            }
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar la habitación, favor intente nuevamente");
        }
        return null;
    }
    public boolean modificarHabitacion(Habitacion habitacion) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "update habitacion set codigo=?, id_tipo_habitacion=?, foto=?, descripcion=?"
                    + ",estado_habitacion=?,cant_personas=?"
                    + " where id = ?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, habitacion.getCodigo());
            stmt.setInt(2, habitacion.getIdTipoHabitacion().getId());
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write((RenderedImage) habitacion.getImagen(), "jpg", os);
            InputStream fis = new ByteArrayInputStream(os.toByteArray());
            stmt.setBinaryStream(3, fis);
            stmt.setString(4, habitacion.getDescripcion());
            stmt.setBoolean(5, habitacion.isEstado());
            stmt.setInt(6, habitacion.getCantPersonas());
            stmt.setInt(7, habitacion.getId());
            return stmt.executeUpdate() > 0;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new MiError("No se pudo modificar la habitación, favor intente nuevamente");
        }
    }
    public boolean eliminarHabitacion(Habitacion habitacion) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "update tipo_habitacion set estado_habitacion = false where id =?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, habitacion.getId());
            return stmt.executeUpdate() > 0;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new MiError("No se pudo Eliminar la habitación, favor intente nuevamente");
        }
    }
}
