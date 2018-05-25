/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

/**
 *
 * @author Noralba
 */
public class reserva_usuario {
    private int idReserva;
    private int idReserva_habitacion;
    private int idCliente;
    private String nombreCliente;
    private String diaEntrada;
    private String diaSalida;
    private String diaReserva;
    private int idHabitacion;
    private String tipoHabitacion;
    private String estado_reserva;

    public reserva_usuario(int idReserva, int idReserva_habitacion, int idCliente, String nombreCliente, String diaEntrada, String diaSalida, String diaReserva, int idHabitacion, String tipoHabitacion, String estado_reserva) {
        this.idReserva = idReserva;
        this.idReserva_habitacion = idReserva_habitacion;
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.diaEntrada = diaEntrada;
        this.diaSalida = diaSalida;
        this.diaReserva = diaReserva;
        this.idHabitacion = idHabitacion;
        this.tipoHabitacion = tipoHabitacion;
        this.estado_reserva = estado_reserva;
    }

    public String getEstado_reserva() {
        return estado_reserva;
    }

    public void setEstado_reserva(String estado_reserva) {
        this.estado_reserva = estado_reserva;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdReserva_habitacion() {
        return idReserva_habitacion;
    }

    public void setIdReserva_habitacion(int idReserva_habitacion) {
        this.idReserva_habitacion = idReserva_habitacion;
    }

    

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDiaEntrada() {
        return diaEntrada;
    }

    public void setDiaEntrada(String diaEntrada) {
        this.diaEntrada = diaEntrada;
    }

    public String getDiaSalida() {
        return diaSalida;
    }

    public void setDiaSalida(String diaSalida) {
        this.diaSalida = diaSalida;
    }

    public String getDiaReserva() {
        return diaReserva;
    }

    public void setDiaReserva(String diaReserva) {
        this.diaReserva = diaReserva;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }
    
    
}
