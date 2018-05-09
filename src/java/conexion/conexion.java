/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import com.sun.istack.logging.Logger;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import java.sql.*;

/**
 *
 * @author Noralba
 */
public class conexion {

    static String db = "mydb";
    static String url = "jdbc:mysql://localhost/" + db;
    static String user = "root";
    static String pass = "";
    static Connection con = null;

    public static Connection conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url,user,pass);
            System.out.println("Conexion exitosa");
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return con;

    }

    

}
