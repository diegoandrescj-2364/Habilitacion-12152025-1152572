/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author USUARIO
 */
public class Trabajador {

    String id;
    String nombre;
    String direccion;
    String telefono;
    String cargo;
    String fecha;
    String capacitaciones;

    public Trabajador() {
    }

    public Trabajador(String id, String nombre, String direccion, String telefono, String cargo, String fecha, String capacitaciones) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.cargo = cargo;
        this.fecha = fecha;
        this.capacitaciones = capacitaciones;
    }

    public String getId() {
        return id;
    }

    public void setId(String codigoVoluntario) {
        this.id = codigoVoluntario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String email) {
        this.direccion = email;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String carrera) {
        this.cargo = carrera;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String sector) {
        this.fecha = sector;
    }
    
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCapacitaciones() {
        return capacitaciones;
    }

    public void setCapacitaciones(String capacitaciones) {
        this.capacitaciones = capacitaciones;
    }
}
