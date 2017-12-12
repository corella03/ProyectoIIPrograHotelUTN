/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoiiprograhotelutn.entities;

import java.util.Date;

/**
 **
 ** @author Luis Alonso Corella Chaves
 ** 10/12/2017
 **/
public class DetalleReservacion {
    private int id;
    private Usuario idUsuario;
    private Cliente idCliente;
    private Habitacion idHabitacion;
    private AgenciaDeViajes idAgencia;
    private Date fechaReservacion;
    private Date fechaEntrada;
    private Date fechaSalida;
    private boolean desayuno;
    private int cantPersonas;
    private int telefono;
    public DetalleReservacion() {
    }

    public DetalleReservacion(int id, Usuario idUsuario, Cliente idCliente, Habitacion idHabitacion,
            AgenciaDeViajes idAgencia, Date fechaReservacion, Date fechaEntrada, Date fechaSalida,
            boolean desayuno, int cantPersonas, int telefono) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idCliente = idCliente;
        this.idHabitacion = idHabitacion;
        this.idAgencia = idAgencia;
        this.fechaReservacion = fechaReservacion;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.desayuno = desayuno;
        this.cantPersonas = cantPersonas;
        this.telefono = telefono;
    }

    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Usuario getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }
    public Cliente getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }
    public Habitacion getIdHabitacion() {
        return idHabitacion;
    }
    public void setIdHabitacion(Habitacion idHabitacion) {
        this.idHabitacion = idHabitacion;
    }
    public AgenciaDeViajes getIdAgencia() {
        return idAgencia;
    }
    public void setIdAgencia(AgenciaDeViajes idAgencia) {
        this.idAgencia = idAgencia;
    }
    public Date getFechaReservacion() {
        return fechaReservacion;
    }
    public void setFechaReservacion(Date fechaReservacion) {
        this.fechaReservacion = fechaReservacion;
    }
    public Date getFechaEntrada() {
        return fechaEntrada;
    }
    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }
    public Date getFechaSalida() {
        return fechaSalida;
    }
    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
    public boolean isDesayuno() {
        return desayuno;
    }
    public void setDesayuno(boolean desayuno) {
        this.desayuno = desayuno;
    }
    public int getCantPersonas() {
        return cantPersonas;
    }
    public void setCantPersonas(int cantPersonas) {
        this.cantPersonas = cantPersonas;
    }
    public int getTelefono() {
        return telefono;
    }
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}

