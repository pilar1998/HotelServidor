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
public class reserva {
    private String diaEntrada;
    private String diaSalida;
    private int idCliente;
    private int idReserva;

    public reserva(String diaEntrada, String diaSalida, int idCliente,int idReserva) {
        this.diaEntrada = diaEntrada;
        this.diaSalida = diaSalida;
        this.idCliente = idCliente;
        this.idReserva = idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setDiaEntrada(String diaEntrada) {
        this.diaEntrada = diaEntrada;
    }

    public void setDiaSalida(String diaSalida) {
        this.diaSalida = diaSalida;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getDiaEntrada() {
        return diaEntrada;
    }

    public String getDiaSalida() {
        return diaSalida;
    }

    public int getIdCliente() {
        return idCliente;
    }

}
