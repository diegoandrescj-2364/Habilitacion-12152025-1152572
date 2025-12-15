/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Gestor;

import Controlador.ControladorMain;
import Modelo.Trabajador;
import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class GestorTrabajador {

    ControladorMain controladorMain;
    ArrayList<Trabajador> trabajadores;

    public GestorTrabajador(ControladorMain mc) {
        controladorMain = mc;
        this.trabajadores = new ArrayList<Trabajador>();
    }

    public Trabajador buscarTrabajador(String codigo) {
        for (Trabajador v : trabajadores) {
            if (v.getId().equals(codigo)) {
                return v;
            }
        }
        return null;
    }

    public String[][] buscarTrabajadores() {
        String[][] datos = new String[trabajadores.size()][7];

        for (int i = 0; i < trabajadores.size(); i++) {
            Trabajador v = trabajadores.get(i);
            datos[i][0] = v.getId();
            datos[i][1] = v.getNombre();
            datos[i][2] = v.getDireccion();
            datos[i][3] = v.getTelefono();
            datos[i][4] = v.getCargo();
            datos[i][5] = v.getFecha();
            datos[i][6] = v.getCapacitaciones();
        }
        return datos;
    }

    public boolean agregarTrabajador(Trabajador v) {
        if(buscarTrabajador(v.getId()) == null){
            trabajadores.add(v);
            return true;
        }

        return false;
    }

    public boolean eliminarTrabajador(String n) {
        for (int i = 0; i < trabajadores.size(); i++) {
            if (trabajadores.get(i).getId().equals(n)) {
                trabajadores.remove(i);
                return true;
            }
        }
        return false;
    }
    
    public boolean actualizarTrabajador(Trabajador v) {
        eliminarTrabajador(v.getId());
        return agregarTrabajador(v);
    }
    
    
    public String[][] buscarTrabajadorPorId(String n) {

        int total = 0;
        for (int i = 0; i < trabajadores.size(); i++) {
            Trabajador v = trabajadores.get(i);
            if (v.getId().equals(n)) {
                total++;
            }
        }

        String[][] datosId = new String[total][7];

        for (int i = 0; i < trabajadores.size(); i++) {
            Trabajador v = trabajadores.get(i);
            if (v.getId().equals(n)) {
                datosId[i][0] = v.getId();
                datosId[i][1] = v.getNombre();
                datosId[i][2] = v.getDireccion();
                datosId[i][3] = v.getTelefono();
                datosId[i][4] = v.getCargo();
                datosId[i][5] = v.getFecha();
                datosId[i][6] = v.getCapacitaciones();
            }
        }
        return datosId;
    }
    
    public String[][] buscarTrabajadoresPorNombre(String n) {

        int total = 0;

        for (Trabajador v : trabajadores) {
            if (v.getNombre().equals(n)) {
                total++;
            }
        }

        String[][] datosNombre = new String[total][7];

        int i = 0;
        for (Trabajador v : trabajadores) {

            if (v.getNombre().equals(n)) {

                datosNombre[i][0] = v.getId();
                datosNombre[i][1] = v.getNombre();
                datosNombre[i][2] = v.getDireccion();
                datosNombre[i][3] = v.getTelefono();
                datosNombre[i][4] = v.getCargo();
                datosNombre[i][5] = v.getFecha();
                datosNombre[i][6] = v.getCapacitaciones();
                i++;
            }
        }
        return datosNombre;
    }

    public String[][] buscarTrabajadoresPorCargo(String n) {

        int total = 0;

        for (Trabajador v : trabajadores) {
            if (v.getCargo().equals(n)) {
                total++;
            }
        }

        String[][] datosNombre = new String[total][7];

        int i = 0;
        for (Trabajador v : trabajadores) {

            if (v.getCargo().equals(n)) {

                datosNombre[i][0] = v.getId();
                datosNombre[i][1] = v.getNombre();
                datosNombre[i][2] = v.getDireccion();
                datosNombre[i][3] = v.getTelefono();
                datosNombre[i][4] = v.getCargo();
                datosNombre[i][5] = v.getFecha();
                datosNombre[i][6] = v.getCapacitaciones();
                i++;
            }
        }
        return datosNombre;
    }
    
}
