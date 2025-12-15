/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Incidente;
import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class ControladorRegistroC {

    ControladorMain controladorMain;
    ArrayList<Incidente> registrosC;

    public ControladorRegistroC(ControladorMain cm) {
        controladorMain = cm;
        registrosC = new ArrayList<>();
    }

    public Incidente buscarRegistroC(String nombre) {
        for (Incidente v : registrosC) {
            if (v.getTrabajador().equals(nombre)) {
                return v;
            }
        }
        return null;
    }

    public String[][] buscarRegistrosC() {
        String[][] datos = new String[registrosC.size()][4];

        for (int i = 0; i < registrosC.size(); i++) {
            Incidente v = registrosC.get(i);
            datos[i][0] = v.getTipo();
            datos[i][1] = v.getFecha();
            datos[i][2] = v.getDescripcion();
            datos[i][3] = v.getTrabajador();
        }
        return datos;
    }

    public String insertarRegistroC(Incidente v) {
        if (buscarRegistroC(v.getTipo()) == null) {
            registrosC.add(v);
            return "Registro guardado";
        }
        return "Error: El registro ya existe";
    }
}
