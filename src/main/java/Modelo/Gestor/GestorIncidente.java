/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Gestor;

import Controlador.ControladorMain;
import Modelo.Incidente;
import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class GestorIncidente {
    ControladorMain controladorMain;
    ArrayList<Incidente> incidentes;

    public GestorIncidente(ControladorMain mc) {
        controladorMain = mc;
        this.incidentes = new ArrayList<Incidente>();
    }

    public Incidente buscarIncidente(String t, String f, String d, String n) {
        for (Incidente v : incidentes) {
            if (v.getTipo().equals(t) && v.getFecha().equals(f) && v.getDescripcion().equals(d) && v.getTrabajador().equals(n)) {
                return v;
            }
        }
        return null;
    }

    public String[][] buscarIncidentes() {
        String[][] datos = new String[incidentes.size()][4];

        for (int i = 0; i < incidentes.size(); i++) {
            Incidente v = incidentes.get(i);
            datos[i][0] = v.getTipo();
            datos[i][1] = v.getFecha();
            datos[i][2] = v.getDescripcion();
            datos[i][3] = v.getTrabajador();
        }
        return datos;
    }

    public boolean agregarIncidente(Incidente v) {
        if(buscarIncidente(v.getTipo(), v.getFecha(), v.getDescripcion(), v.getTrabajador()) == null){
            incidentes.add(v);
            return true;
        }

        return false;
    }

    public boolean eliminarIncidente(String n) {
        for (int i = 0; i < incidentes.size(); i++) {
            if (incidentes.get(i).getTrabajador().equals(n)) {
                incidentes.remove(i);
                return true;
            }
        }
        return false;
    }
    
    public boolean actualizarIncidente(Incidente v) {
        eliminarIncidente(v.getTrabajador());
        return agregarIncidente(v);
    }
    
    
   
    
    
    public String[][] buscarIncindentesPorTipo(String n) {

        int total = 0;

        for (Incidente v : incidentes) {
            if (v.getTipo().equals(n)) {
                total++;
            }
        }

        String[][] datosNombre = new String[total][4];

        int i = 0;
        for (Incidente v : incidentes) {

            if (v.getTipo().equals(n)) {
        
                datosNombre[i][0] = v.getTipo();
                datosNombre[i][1] = v.getFecha();
                datosNombre[i][2] = v.getDescripcion();
                datosNombre[i][3] = v.getTrabajador();
               
                i++;
            }
        }
        return datosNombre;
    }
    
    
    public String[][] BuscarIncidentePorFecha(String n) {

        int total = 0;

        for (Incidente v : incidentes) {
            if (v.getFecha().equals(n)) {
                total++;
            }
        }

        String[][] datosNombre = new String[total][4];

        int i = 0;
        for (Incidente v : incidentes) {

            if (v.getFecha().equals(n)) {
        
                datosNombre[i][0] = v.getTipo();
                datosNombre[i][1] = v.getFecha();
                datosNombre[i][2] = v.getDescripcion();
                datosNombre[i][3] = v.getTrabajador();
               
                i++;
            }
        }
        return datosNombre;
    }
    
    public String[][] BuscarIncidentePorTrabajador(String n) {

        int total = 0;

        for (Incidente v : incidentes) {
            if (v.getTrabajador().equals(n)) {
                total++;
            }
        }

        String[][] datosNombre = new String[total][4];

        int i = 0;
        for (Incidente v : incidentes) {

            if (v.getTrabajador().equals(n)) {
        
                datosNombre[i][0] = v.getTipo();
                datosNombre[i][1] = v.getFecha();
                datosNombre[i][2] = v.getDescripcion();
                datosNombre[i][3] = v.getTrabajador();
               
                i++;
            }
        }
        return datosNombre;
    }
    
    
}
