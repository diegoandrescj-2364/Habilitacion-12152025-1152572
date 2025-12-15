/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Supervisor;
import Modelo.Trabajador;
import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class ControladorRegistroD {

    ControladorMain controladorMain;
    ArrayList<Supervisor> registrosD;

    public ControladorRegistroD(ControladorMain cm) {
        controladorMain = cm;
        registrosD = new ArrayList<>();
    }

    public Supervisor buscarRegistroD(String nombre) {
        for (Supervisor v : registrosD) {
            if (v.getNombre().equals(nombre)) {
                return v;
            }
        }
        return null;
    }

    public String[][] buscarRegistrosD() {
        String[][] datos = new String[registrosD.size()][4];

        for (int i = 0; i < registrosD.size(); i++) {
            Supervisor v = registrosD.get(i);
            datos[i][0] = v.getNombre();
            datos[i][1] = v.getCargo();
            datos[i][2] = v.getEspecialidad();
            datos[i][3] = v.getHorario();
        }
        return datos;
    }

    public String insertarRegistroD(Supervisor v) {
        if (ControladorRegistroD.this.buscarRegistroD(v.getNombre()) == null) {
            registrosD.add(v);
            return "Registro guardado";
        }
        return "Error: El registro ya existe";
    }
    
    

}
