/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Gestor;

import Controlador.ControladorMain;
import Modelo.EvaluacionSalud;
import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class GestorEvaluacionSalud {
    ControladorMain controladorMain;
    ArrayList<EvaluacionSalud> evaluacionesSalud;

    public GestorEvaluacionSalud(ControladorMain mc) {
        controladorMain = mc;
        this.evaluacionesSalud = new ArrayList<EvaluacionSalud>();
    }

    public EvaluacionSalud buscarEvaluacionSalud(String n) {
        for (EvaluacionSalud v : evaluacionesSalud) {
            if (v.getTrabajador().equals(n)) {
                return v;
            }
        }
        return null;
    }
    
    public EvaluacionSalud buscarEvaluacionSaludPorPosicion(int n) {
        
        return evaluacionesSalud.get(n);
    }
    
    

    public String[][] buscarEvaluacionesSalud() {
        String[][] datos = new String[evaluacionesSalud.size()][3];

        for (int i = 0; i < evaluacionesSalud.size(); i++) {
            EvaluacionSalud v = evaluacionesSalud.get(i);
            datos[i][0] = v.getEstado();
            datos[i][1] = v.getRiesgo();
            datos[i][2] = v.getTrabajador();
        }
        return datos;
    }

    public boolean agregarEvaluacionSalud(EvaluacionSalud v) {
        evaluacionesSalud.add(v);
        return true;
    }

    public boolean eliminarEvaluacionSalud(String n) {
        for (int i = 0; i < evaluacionesSalud.size(); i++) {
            if (evaluacionesSalud.get(i).getTrabajador().equals(n)) {
                evaluacionesSalud.remove(i);
                return true;
            }
        }
        return false;
    }
    
    public boolean actualizarEvaluacionSalud(EvaluacionSalud v) {
        eliminarEvaluacionSalud(v.getTrabajador());
        return agregarEvaluacionSalud(v);
    }
    
    
    public String[][] buscarTrabajadoresPorNombre(String n) {

        int total = 0;

        for (EvaluacionSalud v : evaluacionesSalud) {
            if (v.getTrabajador().equals(n)) {
                total++;
            }
        }

        String[][] datosNombre = new String[total][3];

        int i = 0;
        for (EvaluacionSalud v : evaluacionesSalud) {

            if (v.getTrabajador().equals(n)) {

                datosNombre[i][0] = v.getTrabajador();
                datosNombre[i][1] = v.getEstado();
                datosNombre[i][2] = v.getRiesgo();
                i++;
            }
        }
        return datosNombre;
    }
    
}
