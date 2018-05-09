/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reserva;
import conexion.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Noralba
 */
@WebService(serviceName = "Hotel")
public class Hotel {


    /**
     * Web service operation
     */
    @WebMethod(operationName = "AgregarCliente")
    public String AgregarCliente(@WebParam(name = "id") int id, @WebParam(name = "nombre") String nombre, @WebParam(name = "celular") String celular) {
        String comprobar = "disponible";
        conexion c = new conexion();
        Connection cn = c.conectar();
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM cliente WHERE idCliente='"+id+"'");
            while (rs.next()){
                comprobar = "no disponible";
            }     
            if(comprobar.equals("disponible")){
                PreparedStatement pst = cn.prepareCall("INSERT INTO cliente(idCliente,Nombre,Celular) VALUES(?,?,?)");
                pst.setInt(1,id);
                pst.setString(2,nombre);
                pst.setString(3,celular);
                pst.executeUpdate();
                System.out.println (pst.toString());
            }else{
                return ("El id de cliente ya existe");
            }
        } catch (Exception ex) {
            System.out.println( ex);
        }
        return comprobar;
    }

    /**
     * Web service operation
     */
    

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ListarHabitaciones")
    public List<habitacion> ListarHabitaciones() {
        conexion c = new conexion();
        Connection cn = c.conectar();
        List<habitacion> habitacion = new ArrayList<habitacion>();
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM habitacion ");
            while (rs.next()){
                habitacion.add(new habitacion(rs.getInt(1),rs.getString(2),rs.getString(3)));
            }
        } catch (Exception ex) {
            System.out.println( ex);
        }
        return habitacion;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "AgregarHabitacion")
    public String AgregarHabitacion(@WebParam(name = "estado") String estado,@WebParam(name = "tipo") String tipo) {
        String comprobar = "disponible";
        conexion c = new conexion();
        Connection cn = c.conectar();
        try{
            Statement st = cn.createStatement();
            PreparedStatement pst = cn.prepareCall("INSERT INTO habitacion(Estado,tipo) VALUES(?,?)");
            pst.setString(1,estado);
            pst.setString(2,tipo);
            pst.executeUpdate();
            System.out.println (pst.toString());
            
        } catch (Exception ex) {
            System.out.println( ex);
        }
        return comprobar;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "AgregarReserva")
    public String AgregarReserva(@WebParam(name = "diaEntrada") String diaEntrada, @WebParam(name = "diaSalida") String diaSalida, @WebParam(name = "idCliente") int idCliente, @WebParam(name = "diaReserva") String diaReserva, @WebParam(name = "idHabitacion") int idHabitacion) {
        String comprobar = "no disponible";
        String comprobar1 = "disponible";
        conexion c = new conexion();
        Connection cn = c.conectar();
        int idReserva=0;
        try{
            
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM cliente WHERE idCliente='"+idCliente+"'");
            while (rs.next()){
                comprobar = "disponible";
            }  
            PreparedStatement rs4 = cn.prepareCall("UPDATE habitacion SET Estado='Ocupada' WHERE idHabitacion ='"+idHabitacion+"'");
            rs4.executeUpdate();
            if(comprobar.equals("disponible")){
                    PreparedStatement pst = cn.prepareCall("INSERT INTO reserva(DiaEntrada,DiaSalida,Cliente_idCliente) VALUES(?,?,?)");
                    pst.setString(1,diaEntrada);
                    pst.setString(2,diaSalida);
                    pst.setInt(3,idCliente);
                    pst.executeUpdate();                   
                    ResultSet rs2 = st.executeQuery("SELECT * FROM reserva WHERE DiaEntrada='"+diaEntrada+"' and DiaSalida='"+diaSalida+"' and Cliente_idCliente ='"+idCliente+"'");                  
                    while (rs2.next()){
                        reserva otro=new reserva(rs2.getString(2),rs2.getString(3),rs2.getInt(4),rs2.getInt(1));
                        idReserva=otro.getIdReserva();
                    } 
                    AgregarReserva2(idReserva,diaReserva,idHabitacion);
                  
                
                
            }else{
                return "No existe id de cliente";
            }
        } catch (Exception ex) {
            System.out.println( ex);
        }
        return "no disponible";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "AgregarReservaC")
    public String AgregarReservaC(@WebParam(name = "idCliente") int idCliente, @WebParam(name = "nombre") String nombre, @WebParam(name = "celular") String celular, @WebParam(name = "diaEntrada") String diaEntrada, @WebParam(name = "diaSalida") String diaSalida, @WebParam(name = "diaReserva") String diaReserva, @WebParam(name = "idHabitacion") int idHabitacion,@WebParam(name = "usuario") String usuario, @WebParam(name = "password") String password, @WebParam(name = "privilegio") String privilegio) {
        String comprobar = "disponible", privile="";
        conexion c = new conexion();
        Connection cn = c.conectar();
        int idReserva=0;
        try{
            Statement st1 = cn.createStatement();
            ResultSet rs1 = st1.executeQuery("SELECT * FROM usuario WHERE usuario='"+usuario+"'");
            while (rs1.next()){
                cliente cl=new cliente(rs1.getInt(1),rs1.getString(2),rs1.getString(3));
                comprobar=String.valueOf(cl.getId());
                comprobar = "no disponible";
                return comprobar;
            }     
            
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM cliente WHERE idCliente='"+idCliente+"'");
            while (rs.next()){                
                comprobar = "no disponible";
                return comprobar;
            }     
            if(comprobar.equals("disponible")){
                PreparedStatement rs4 = cn.prepareCall("UPDATE habitacion SET Estado='Ocupada' WHERE idHabitacion ='"+idHabitacion+"'");
                rs4.executeUpdate();
                PreparedStatement pst4 = cn.prepareCall("INSERT INTO usuario(usuario,password,privilegio) VALUES(?,?,?)");
                pst4.setString(1,usuario);
                pst4.setString(2,password);
                pst4.setString(3,privilegio);
                pst4.executeUpdate();
                PreparedStatement pst1 = cn.prepareCall("INSERT INTO cliente(idCliente,Nombre,Email) VALUES(?,?,?)");
                pst1.setInt(1,idCliente);
                pst1.setString(2,nombre);
                pst1.setString(3,celular);
                pst1.executeUpdate();
                PreparedStatement pst = cn.prepareCall("INSERT INTO reserva(DiaEntrada,DiaSalida,Cliente_idCliente) VALUES(?,?,?)");
                pst.setString(1,diaEntrada);
                pst.setString(2,diaSalida);
                pst.setInt(3,idCliente);
                pst.executeUpdate();
                ResultSet rs2 = st.executeQuery("SELECT * FROM reserva WHERE DiaEntrada='"+diaEntrada+"' and DiaSalida='"+diaSalida+"' and Cliente_idCliente ='"+idCliente+"'");                  
                while (rs2.next()){
                    reserva otro=new reserva(rs2.getString(2),rs2.getString(3),rs2.getInt(4),rs2.getInt(1));
                    idReserva=otro.getIdReserva();
                }                 
                AgregarReserva2(idReserva,diaReserva,idHabitacion);
                return comprobar;
            }else{
                return comprobar;
            }
        } catch (Exception ex) {
            System.out.println( ex);
        }
        return comprobar;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "AgregarReserva2")
    public int AgregarReserva2(@WebParam(name = "idReserva") int idReserva, @WebParam(name = "diaReserva") String diaReserva, @WebParam(name = "idHabitacion") int idHabitacion) {
        String comprobar = "disponible";        
        conexion c = new conexion();
        Connection cn = c.conectar();        
        try{    
            Statement st = cn.createStatement();
            PreparedStatement pst = cn.prepareCall("INSERT INTO reserva_has_habitacion(Reserva_idReserva,Habitacion_idHabitacion,diaReserva) VALUES(?,?,?)");
            pst.setInt(1,idReserva);
            pst.setInt(2,idHabitacion);
            pst.setString(3,diaReserva);
            pst.executeUpdate();           
            System.out.println (pst.toString());
            return idReserva+1;
            
        } catch (Exception ex) {
            System.out.println( ex);
        }
        return idReserva;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ListarReservas")
    public List<reservas> ListarReservas() {
        conexion c = new conexion();
        Connection cn = c.conectar();
        List<reservas> reservas = new ArrayList<reservas>();
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT cliente.Nombre, reserva.DiaEntrada, reserva.DiaSalida, reserva_has_habitacion.DiaReserva,reserva_has_habitacion.Habitacion_idHabitacion from cliente inner join reserva on cliente.idCliente=reserva.Cliente_idCliente INNER JOIN reserva_has_habitacion on reserva.idReserva=reserva_has_habitacion.Reserva_idReserva INNER JOIN habitacion on habitacion.idHabitacion=reserva_has_habitacion.Habitacion_idHabitacion");
            while (rs.next()){
                reservas.add(new reservas(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5)));
            }
        } catch (Exception ex) {
            System.out.println( ex);
        }
        return reservas;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "NuevoUsuario")
    public String NuevoUsuario(@WebParam(name = "usuario") String usuario, @WebParam(name = "password") String password, @WebParam(name = "privilegio") String privilegio) {
        String comprobar = "disponible";
        conexion c = new conexion();
        Connection cn = c.conectar();
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM usuario WHERE usuario='"+usuario+"'");
            while (rs.next()){
                comprobar = "no disponible";
            }     
            if(comprobar.equals("disponible")){
                PreparedStatement pst = cn.prepareCall("INSERT INTO usuario(usuario,password,privilegio) VALUES(?,?,?)");
                pst.setString(1,usuario);
                pst.setString(2,password);
                pst.setString(3,privilegio);
                pst.executeUpdate();
                System.out.println (pst.toString());
            }else{
                return comprobar;
            }
        } catch (Exception ex) {
            System.out.println( ex);
        }
        return comprobar;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ingresar")
    public String ingresar(@WebParam(name = "usuario") String usuario, @WebParam(name = "contrase\u00f1a") String password) {
        
        conexion c = new conexion();
        Connection cn = c.conectar();
        String privilegio="";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM usuario WHERE usuario='"+usuario+"' and password='"+password+"'");
            while (rs.next()){
                usuario otro=new usuario(rs.getString(1),rs.getString(2),rs.getString(3));
                    privilegio=otro.getPrivilegio();
            }     
            return privilegio;
        } catch (Exception ex) {
            System.out.println( ex);
        }
        return privilegio;
    }

    /**
     * This is a sample web service operation
     */
    
}
