/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.EvaluacionSalud;
import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class ControladorRegistroB {

    ControladorMain controladorMain;
    ArrayList<EvaluacionSalud> registrosB;

    public ControladorRegistroB(ControladorMain cm) {
        controladorMain = cm;
        registrosB = new ArrayList<>();
    }

    public EvaluacionSalud buscarRegistroB(String codigo) {
        for (EvaluacionSalud v : registrosB) {
            if (v.getTrabajador().equals(codigo)) {
                return v;
            }
        }
        return null;
    }

    public String[][] buscarRegistrosB() {
        String[][] datos = new String[registrosB.size()][3];

        for (int i = 0; i < registrosB.size(); i++) {
            EvaluacionSalud v = registrosB.get(i);
            datos[i][0] = v.getTrabajador();
            datos[i][1] = v.getEstado();
            datos[i][2] = v.getRiesgo();
        }
        return datos;
    }

    public String insertarRegistroB(EvaluacionSalud v) {
        if (ControladorRegistroB.this.buscarRegistroB(v.getTrabajador()) == null) {
            registrosB.add(v);
            
            return "Registro guardado";
        }
        return "Error: El registro ya existe";
    }
     
}
