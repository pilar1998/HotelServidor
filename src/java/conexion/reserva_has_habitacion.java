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
public class reserva_has_habitacion {
    private int idReserva_has_habitacion;
    private int idReserva;
    private int idHabitacion;
    private String diaReserva;

    public reserva_has_habitacion(int idReserva_has_habitacion, int idReserva, int idHabitacion, String diaReserva) {
        this.idReserva_has_habitacion = idReserva_has_habitacion;
        this.idReserva = idReserva;
        this.idHabitacion = idHabitacion;
        this.diaReserva = diaReserva;
    }

    public int getIdReserva_has_habitacion() {
        return idReserva_has_habitacion;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public String getDiaReserva() {
        return diaReserva;
    }

    public void setIdReserva_has_habitacion(int idReserva_has_habitacion) {
        this.idReserva_has_habitacion = idReserva_has_habitacion;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public void setIdHabitacion(int idhabitacion) {
        this.idHabitacion = idhabitacion;
    }

    public void setDiaReserva(String diaReserva) {
        this.diaReserva = diaReserva;
    }

    
    
}
