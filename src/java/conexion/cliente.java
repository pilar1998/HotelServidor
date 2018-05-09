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
public class cliente {
    private int id;
    private String nombre;
    private String celular;

    public cliente(int id, String nombre, String celular) {
        this.id = id;
        this.nombre = nombre;
        this.celular = celular;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCelular() {
        return celular;
    }
    
}
