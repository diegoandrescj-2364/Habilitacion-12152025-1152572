/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Trabajador;
import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class xxControladorRegistroA {

    ControladorMain controladorMain;
    ArrayList<Trabajador> registrosA;

    public xxControladorRegistroA(ControladorMain cm) {
        controladorMain = cm;
        registrosA = new ArrayList<>();
    }

    public Trabajador buscarRegistroA(String codigo) {
        for (Trabajador v : registrosA) {
            if (v.getId().equals(codigo)) {
                return v;
            }
        }
        return null;
    }

    public String[][] buscarRegistrosA() {
        String[][] datos = new String[registrosA.size()][7];

        for (int i = 0; i < registrosA.size(); i++) {
            Trabajador v = registrosA.get(i);
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

    public String insertarRegistroA(Trabajador v) {
        if (buscarRegistroA(v.getId()) == null) {
            registrosA.add(v);

            return "Registro guardado";
        }
        return "Error: El registro ya existe";
    }

    public String eliminarRegistroA(String codigo) {
        for (int i = 0; i < registrosA.size(); i++) {
            if (registrosA.get(i).getId().equals(codigo)) {
                registrosA.remove(i);
                return "Registro eliminado";
            }
        }
        return "Error: El registro no pudo ser eliminado";
    }

    public String actualizarRegistroA(Trabajador v) {
        eliminarRegistroA(v.getId());
        return insertarRegistroA(v);
    }

    public String[][] buscarRegistrosAPorId(String n) {

        int total = 0;
        for (int i = 0; i < registrosA.size(); i++) {
            Trabajador v = registrosA.get(i);
            if (v.getId().equals(n)) {
                total++;
            }
        }

        String[][] datosId = new String[total][7];

        for (int i = 0; i < registrosA.size(); i++) {
            Trabajador v = registrosA.get(i);
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

    public String[][] buscarRegistrosAPorNombre(String n) {

        int total = 0;

        for (Trabajador v : registrosA) {
            if (v.getNombre().equals(n)) {
                total++;
            }
        }

        String[][] datosNombre = new String[total][7];

        int i = 0;
        for (Trabajador v : registrosA) {

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

    public String[][] buscarRegistrosAPorCargo(String n) {

        int total = 0;

        for (Trabajador v : registrosA) {
            if (v.getCargo().equals(n)) {
                total++;
            }
        }

        String[][] datosNombre = new String[total][7];

        int i = 0;
        for (Trabajador v : registrosA) {

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
