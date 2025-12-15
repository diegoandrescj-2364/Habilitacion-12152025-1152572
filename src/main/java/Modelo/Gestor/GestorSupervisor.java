/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Gestor;

import Controlador.ControladorMain;
import Modelo.Supervisor;
import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class GestorSupervisor {

    ControladorMain controladorMain;
    ArrayList<Supervisor> supervisores;

    public GestorSupervisor(ControladorMain mc) {
        controladorMain = mc;
    }

    public Supervisor buscarSupervisor(String codigo) {
        for (Supervisor v : supervisores) {
            if (v.getNombre().equals(codigo)) {
                return v;
            }
        }
        return null;
    }

    public String[][] buscarSupervisores() {
        String[][] datos = new String[supervisores.size()][4];

        for (int i = 0; i < supervisores.size(); i++) {
            Supervisor v = supervisores.get(i);
            datos[i][0] = v.getNombre();
            datos[i][1] = v.getCargo();
            datos[i][2] = v.getEspecialidad();
            datos[i][3] = v.getHorario();
        }
        return datos;
    }

    public boolean agregarSupervisor(Supervisor v) {
        if (buscarSupervisor(v.getNombre()) == null) {
            supervisores.add(v);
            return true;
        }

        return false;
    }

    public boolean eliminarSupervisor(String n) {
        for (int i = 0; i < supervisores.size(); i++) {
            if (supervisores.get(i).getNombre().equals(n)) {
                supervisores.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean actualizarSupervisor(Supervisor v) {
        eliminarSupervisor(v.getNombre());
        return agregarSupervisor(v);
    }

    public String[][] buscarSupervisorPorNombre(String n) {

        int total = 0;
        for (Supervisor v : supervisores) {
            if (v.getNombre().equals(n)) {
                total++;
            }
        }

        String[][] datosNombre = new String[total][7];

        int j = 0;
        for (Supervisor v : supervisores) {
            if (v.getNombre().equals(n)) {
                datosNombre[j][0] = v.getNombre();
                datosNombre[j][1] = v.getCargo();
                datosNombre[j][2] = v.getEspecialidad();
                datosNombre[j][3] = v.getHorario();
                j++;
            }
        }

        return datosNombre;
    }
    
    public String[][] buscarSupervisorPorCargo(String n) {

        int total = 0;
        for (Supervisor v : supervisores) {
            if (v.getCargo().equals(n)) {
                total++;
            }
        }

        String[][] datosNombre = new String[total][7];

        int j = 0;
        for (Supervisor v : supervisores) {
            if (v.getCargo().equals(n)) {
                datosNombre[j][0] = v.getNombre();
                datosNombre[j][1] = v.getCargo();
                datosNombre[j][2] = v.getEspecialidad();
                datosNombre[j][3] = v.getHorario();
                j++;
            }
        }

        return datosNombre;
    }

}
