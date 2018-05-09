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
public class reservas {
    private String nombreCliente;
    private String diaEntrada;
    private String diaSalida;
    private String diaReserva;
    private int idHabitacion;

    public reservas(String nombreCliente, String diaEntrada, String diaSalida, String diaReserva, int idHabitacion) {
        this.nombreCliente = nombreCliente;
        this.diaEntrada = diaEntrada;
        this.diaSalida = diaSalida;
        this.diaReserva = diaReserva;
        this.idHabitacion = idHabitacion;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getDiaEntrada() {
        return diaEntrada;
    }

    public String getDiaSalida() {
        return diaSalida;
    }

    public String getDiaReserva() {
        return diaReserva;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public void setDiaEntrada(String diaEntrada) {
        this.diaEntrada = diaEntrada;
    }

    public void setDiaSalida(String diaSalida) {
        this.diaSalida = diaSalida;
    }

    public void setDiaReserva(String diaReserva) {
        this.diaReserva = diaReserva;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }
    
    
}
