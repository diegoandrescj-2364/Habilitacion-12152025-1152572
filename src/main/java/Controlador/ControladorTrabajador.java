/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Trabajador;
import Modelo.Gestor.GestorTrabajador;

/**
 *
 * @author D
 */
public class ControladorTrabajador {

    GestorTrabajador GestTrab;

    public ControladorTrabajador(ControladorMain mc) {
        GestTrab = new GestorTrabajador(mc);
    }

    public Trabajador buscarTrabajador(String n) {
        Trabajador v = new Trabajador();
        try {
            v = GestTrab.buscarTrabajador(n);
        } catch (Exception e) {
            e.printStackTrace();
            v = null;
        }
        return v;
    }

    public String[][] buscarTrabajadorArreglo() {
        String[][] dato;
        try {
            dato = GestTrab.buscarTrabajadores();
        } catch (Exception e) {
            e.printStackTrace();
            dato = null;
        }
        return dato;
    }

    public String[][] BuscarTrabajadoresPorNombre(String n) {
        String[][] dato;
        try {
            dato = GestTrab.buscarTrabajadoresPorNombre(n);
        } catch (Exception e) {
            e.printStackTrace();
            dato = null;
        }
        return dato;
    }
    
    
    public String[][] buscarTrabajadoresPorCargo(String n) {
        String[][] dato;
        try {
            dato = GestTrab.buscarTrabajadoresPorCargo(n);
        } catch (Exception e) {
            e.printStackTrace();
            dato = null;
        }
        return dato;
    }

    public String agregarTrabajador(Trabajador v) {
        String msg = "";
        try {
            boolean add = GestTrab.agregarTrabajador(v);
            if (add) {
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

    public String eliminarTrabajador(String n) {
        String msg = "";
        try {
            boolean res = GestTrab.eliminarTrabajador(n);
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

    public String editarTrabajador(Trabajador v) {
        String msg = "";
        try {
            boolean add = GestTrab.actualizarTrabajador(v);
            if (add) {
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

}
