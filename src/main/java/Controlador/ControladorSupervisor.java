/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Gestor.GestorSupervisor;
import Modelo.Supervisor;

/**
 *
 * @author USUARIO
 */
public class ControladorSupervisor {
    
    GestorSupervisor GestSuperv;
    
    public ControladorSupervisor(ControladorMain mc) {
        GestSuperv = new GestorSupervisor(mc);
    }
    
    public Supervisor buscarSupervisor(String n) {
        Supervisor v = new Supervisor();
        try {
            v = GestSuperv.buscarSupervisor(n);
        } catch (Exception e) {
            e.printStackTrace();
            v = null;
        }
        return v;
    }
    
    public String[][] buscarSupervisorArreglo() {
        String[][] dato;
        try {
            dato = GestSuperv.buscarSupervisores();
        } catch (Exception e) {
            e.printStackTrace();
            dato = null;
        }
        return dato;
    }
    
    public String agregarSupervisor(Supervisor v) {
        String msg = "";
        try {
            boolean add = GestSuperv.agregarSupervisor(v);
            if(add){
                msg = "Registro guardado con exito";
            } else {
                msg = "Error: No se pudo guardar el registro";
            }
        } catch (Exception e) {
            e.printStackTrace();
            msg = null;
        }
        return msg;
    }
    
    public String eliminarSupervisor(String n) {
        String msg = "";
        try {
            boolean res = GestSuperv.eliminarSupervisor(n);
            if (res) {
                msg = "Registro eliminado con exito";
            } else {
                msg = "Error al eliminar el registro";
            }
        } catch (Exception e) {
            msg = "Error al eliminar el registro";
            e.printStackTrace();
        }
        return msg;
    }
    
    public String editarSupervisor(Supervisor v) {
        String msg = "";
        try {
            boolean add = GestSuperv.actualizarSupervisor(v);
            if(add){
                msg = "Registro actualizado con exito";
            } else {
                msg = "Error: No se pudo actualizar el registro";
            }
        } catch (Exception e) {
            e.printStackTrace();
            msg = null;
        }
        return msg;
    }
    
    public String[][] buscarSupervisorPorNombre(String n) {
        String[][] dato;
        try {
            dato = GestSuperv.buscarSupervisorPorNombre(n);
        } catch (Exception e) {
            e.printStackTrace();
            dato = null;
        }
        return dato;
    }
    
    public String[][] buscarSupervisorPorCargo(String n) {
        String[][] dato;
        try {
            dato = GestSuperv.buscarSupervisorPorCargo(n);
        } catch (Exception e) {
            e.printStackTrace();
            dato = null;
        }
        return dato;
    }
}
