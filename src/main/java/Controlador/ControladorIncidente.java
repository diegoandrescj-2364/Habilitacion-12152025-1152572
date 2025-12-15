/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Gestor.GestorIncidente;
import Modelo.Incidente;

/**
 *
 * @author USUARIO
 */
public class ControladorIncidente {
    GestorIncidente GestIncidente;
    
    public ControladorIncidente(ControladorMain mc) {
        GestIncidente = new GestorIncidente(mc);
    }
    
    public Incidente buscarIncidente(String t, String f, String d, String n) {
        Incidente v = new Incidente();
        try {
            v = GestIncidente.buscarIncidente(t,f,d,n);
        } catch (Exception e) {
            e.printStackTrace();
            v = null;
        }
        return v;
    }
    
    public String[][] buscarIncidenteArreglo() {
        String[][] dato;
        try {
            dato = GestIncidente.buscarIncidentes();
        } catch (Exception e) {
            e.printStackTrace();
            dato = null;
        }
        return dato;
    }
    
    public String agregarIncidente(Incidente v) {
        String msg = "";
        try {
            boolean add = GestIncidente.agregarIncidente(v);
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
    
    public String eliminarIncidente(String n) {
        String msg = "";
        try {
            boolean res = GestIncidente.eliminarIncidente(n);
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
    
    public String editarIncidente(Incidente v) {
        String msg = "";
        try {
            boolean add = GestIncidente.actualizarIncidente(v);
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
    
    
    public String[][] buscarIncindentesPorFecha(String n) {
        String[][] dato;
        try {
            dato = GestIncidente.BuscarIncidentePorFecha(n);
        } catch (Exception e) {
            e.printStackTrace();
            dato = null;
        }
        return dato;
    }
    
       public String[][] BuscarIncidentePorTrabajador(String n) {
        String[][] dato;
        try {
            dato = GestIncidente.BuscarIncidentePorTrabajador(n);
        } catch (Exception e) {
            e.printStackTrace();
            dato = null;
        }
        return dato;
    }
       
              public String[][] BuscarIncidentePorTipo(String n) {
        String[][] dato;
        try {
            dato = GestIncidente.buscarIncindentesPorTipo(n);
        } catch (Exception e) {
            e.printStackTrace();
            dato = null;
        }
        return dato;
    }
    
}
