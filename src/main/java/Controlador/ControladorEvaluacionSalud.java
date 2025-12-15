/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Gestor.GestorEvaluacionSalud;
import Modelo.EvaluacionSalud;

/**
 *
 * @author USUARIO
 */
public class ControladorEvaluacionSalud {
    GestorEvaluacionSalud GestEvaSalud;
    
    public ControladorEvaluacionSalud(ControladorMain mc) {
        GestEvaSalud = new GestorEvaluacionSalud(mc);
    }
    
    public EvaluacionSalud buscarEvaluacionSaludPorTrabajador(String n) {
        EvaluacionSalud v = new EvaluacionSalud();
        try {
            v = GestEvaSalud.buscarEvaluacionSalud(n);
        } catch (Exception e) {
            e.printStackTrace();
            v = null;
        }
        return v;
    }
    
      public EvaluacionSalud buscarEvaluacionSaludPorPosicion(int n) {
        EvaluacionSalud v = new EvaluacionSalud();
        try {
            v = GestEvaSalud.buscarEvaluacionSaludPorPosicion(n);
        } catch (Exception e) {
            e.printStackTrace();
            v = null;
        }
        return v;
    }
    
    
    public String[][] buscarEvaluacionSaludArreglo() {
        String[][] dato;
        try {
            dato = GestEvaSalud.buscarEvaluacionesSalud();
        } catch (Exception e) {
            e.printStackTrace();
            dato = null;
        }
        return dato;
    }
    
    public String agregarEvaluacionSalud(EvaluacionSalud v) {
        String msg = "";
        try {
            boolean add = GestEvaSalud.agregarEvaluacionSalud(v);
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
    
    public String eliminarEvaluacionSalud(String n) {
        String msg = "";
        try {
            boolean res = GestEvaSalud.eliminarEvaluacionSalud(n);
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
    
    public String editarEvaluacionSalud(EvaluacionSalud v) {
        String msg = "";
        try {
            boolean add = GestEvaSalud.actualizarEvaluacionSalud(v);
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
    
    
    public String[][] BuscarEvaluacionPorTrabajador(String n) {
        String[][] dato;
        try {
            dato = GestEvaSalud.buscarTrabajadoresPorNombre(n);
        } catch (Exception e) {
            e.printStackTrace();
            dato = null;
        }
        return dato;
    }
}
