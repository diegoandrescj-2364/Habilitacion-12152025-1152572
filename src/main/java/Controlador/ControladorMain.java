/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.*;
import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USUARIO
 */
public class ControladorMain implements ActionListener {

    public VistaPrincipal visPri;

    private VistaRegistroARegistrar visTrabReg;
    private VistaRegistroAActualizar visTrabAct;



    private VistaRegistrarIncidente visRegInc;



    private VistaBuscarTrabajador visBusTra;

    private VistaBuscarTrabajadores visBusTraTabla;

    private VistaRegistrarEvaluacion visRegEva;

    private VistaBuscarEvaluaciones visBusEva;

    private VistaEditarEvaluacion visEdiEva;

    private VistaEditarIncidente visEdiInc;

    private VistaEditarSupervisor visEdiSup;

    private VistaRegistroSupervisor visRegSup;

    public ControladorTrabajador conTra;
    public ControladorEvaluacionSalud conEva;
    public ControladorIncidente conInc;
    public ControladorSupervisor conSup;

    public ControladorMain() {

        visPri = new VistaPrincipal();
        visPri.agregarListener(this);
        visPri.setVisible(true);

        conTra = new ControladorTrabajador(this);
        conEva = new ControladorEvaluacionSalud(this);
        conInc = new ControladorIncidente(this);
        conSup = new ControladorSupervisor(this);

        llenarTablaRegistroA();
        llenarTablaincidentes();
         llenarTablaSupervisores();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (visPri != null) {

            //PESTAÑA TRABAJADORES
            if (e.getSource() == visPri.btRegistroA) {
                agregarRegistroA();
            }

            if (e.getSource() == visPri.btActRegistroA) {
                abrirVistaActualizarRegistroA();
            }

            if (e.getSource() == visPri.btElimRegistroA) {
                eliminarRegistroA();
            }

            if (e.getSource() == visPri.btId) {
                buscarTrabajadorPorId();
            }

            if (e.getSource() == visPri.btNombre) {

                BuscarTrabajadoresPorNombre();
            }

            if (e.getSource() == visPri.btCargo) {

                BuscarTrabajadoresPorCargo();
            }

            if (e.getSource() == visPri.btRegistroE) {

                registrarEvaluacionTrabajador();
            }

            if (e.getSource() == visPri.btBusEvaMedica) {

                buscarEvaluacionMedica();
            }

            if (e.getSource() == visPri.btRegInc) {

                registrarIncidente();
            }

            if (e.getSource() == visPri.btBuscarFecha) {

                BuscarIncidentePorFecha();
            }

            if (e.getSource() == visPri.btBuscarTrabajador) {

                BuscarIncidentePorTrabajador();
            }
            if (e.getSource() == visPri.btBuscarTipo) {

                BuscarIncidentePorTipo();
            }

            if (e.getSource() == visPri.btEditarInc) {

                editarIncidente();
            }

            if (e.getSource() == visPri.btEdiSup) {

                abrirVistaEditarSupervisor();
            }

            if (e.getSource() == visPri.btRegSup) {

                RegistrarSupervisor();
            }

            if (e.getSource() == visPri.btBusNom) {

                BuscarSupervisorPorNombre();
            }

            if (e.getSource() == visPri.btBusCargo) {

                BuscarSupervisorPorCargo();
            }

        }

        //VISTA REGISTRAR TRABAJADORES
        if (visTrabReg != null) {
            if (e.getSource() == visTrabReg.btAtras) {
                visPri.setVisible(true);
                visTrabReg.dispose();
            }

            if (e.getSource() == visTrabReg.btGuardar) {
                guardarRegistroA();
            }
        }

        //VISTA ACTUALIZAR TRABAJADORES
        if (visTrabAct != null) {
            if (e.getSource() == visTrabAct.btAtras) {
                visPri.setVisible(true);
                visTrabAct.dispose();
            }

            if (e.getSource() == visTrabAct.btGuardar) {
                actualizarRegistroA();
            }
        }

       

        if (visBusTra != null) {
            if (e.getSource() == visBusTra.btAtras) {
                visPri.setVisible(true);
                visBusTra.dispose();
            }
        }

        if (visBusTraTabla != null) {
            if (e.getSource() == visBusTraTabla.btAtras) {
                visPri.setVisible(true);
                visBusTraTabla.dispose();
            }
        }

        if (visRegEva != null) {
            if (e.getSource() == visRegEva.btAtras) {
                visPri.setVisible(true);
                visRegEva.dispose();
            }

            if (e.getSource() == visRegEva.btGuardar) {
                guardarEvaluacionTrabajador();
            }
        }

        if (visBusEva != null) {
            if (e.getSource() == visBusEva.btAtras) {
                visPri.setVisible(true);
                visBusEva.dispose();
            }

            if (e.getSource() == visBusEva.btEditar) {
                visBusEva.setVisible(false);
                editarEvaluacion();
            }
        }

        if (visEdiEva != null) {
            if (e.getSource() == visEdiEva.btAtras) {
                visBusEva.setVisible(true);
                visEdiEva.dispose();
            }

            if (e.getSource() == visEdiEva.btGuardar) {
                actualizarEvaluacion();
            }
        }

        if (visRegInc != null) {
            if (e.getSource() == visRegInc.btAtras) {
                visPri.setVisible(true);
                visRegInc.dispose();
            }

            if (e.getSource() == visRegInc.btGuardar) {
                guardarIncidente();
            }
        }

        if (visEdiInc != null) {
            if (e.getSource() == visEdiInc.btAtras) {
                visPri.setVisible(true);
                visEdiInc.dispose();
            }

            if (e.getSource() == visEdiInc.btGuardar) {
                actualizarIncidente();
            }
        }

        if (visRegSup != null) {
            if (e.getSource() == visRegSup.btAtras) {
                visPri.setVisible(true);
                visRegSup.dispose();
            }

            if (e.getSource() == visRegSup.btGuardar) {
                registrarSupervisor();
            }
        }

        if (visEdiSup != null) {
            if (e.getSource() == visEdiSup.btAtras) {
                visPri.setVisible(true);
                visEdiSup.dispose();
            }

            if (e.getSource() == visEdiSup.btGuardar) {
                editarSupervisor();
            }
        }

    }

    //OPERACIONES RegistroA
    private void llenarTablaRegistroA() {
        String datos[][] = conTra.buscarTrabajadorArreglo();
        String[] filaEtiquetas = {"Id", "Nombre", "Direccion", "Telefono", "Cargo", "Fecha de ingreso", "Capacitaciones"};
        DefaultTableModel tablaTrabajadors = new DefaultTableModel();
        tablaTrabajadors.setDataVector(datos, filaEtiquetas);
        visPri.tbRegistroA.setModel(tablaTrabajadors);
    }

    private void agregarRegistroA() {
        visTrabReg = new VistaRegistroARegistrar();
        visPri.setVisible(false);
        visTrabReg.setVisible(true);
        visTrabReg.agregarListener(this);
    }

    private void guardarRegistroA() {
        Trabajador trabajador = new Trabajador(visTrabReg.txId.getText(), visTrabReg.txNombre.getText(), visTrabReg.txDireccion.getText(), visTrabReg.txTel.getText(), visTrabReg.txCargo.getText(), visTrabReg.txFecha.getText(), visTrabReg.txCapacitaciones.getText());
        String msg = conTra.agregarTrabajador(trabajador);
        JOptionPane.showMessageDialog(null, msg);

        if (!msg.contains("Error")) {
            visTrabReg.dispose();
            visPri.setVisible(true);
            llenarTablaRegistroA();
        }
    }

    private void abrirVistaActualizarRegistroA() {
        int fila = visPri.tbRegistroA.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un registro");
        } else {
            Trabajador trabajador = conTra.buscarTrabajador("" + visPri.tbRegistroA.getValueAt(fila, 0));

            visTrabAct = new VistaRegistroAActualizar();
            visPri.setVisible(false);
            visTrabAct.setVisible(true);
            visTrabAct.agregarListener(this);

            visTrabAct.txId.setText(trabajador.getId());
            visTrabAct.txNombre.setText(trabajador.getNombre());
            visTrabAct.txDireccion.setText(trabajador.getDireccion());
            visTrabAct.txTel.setText(trabajador.getTelefono());
            visTrabAct.txCargo.setText(trabajador.getCargo());
            visTrabAct.txFecha.setText(trabajador.getCargo());
            visTrabAct.txCapacitaciones.setText(trabajador.getCapacitaciones());
        }
    }

    private void actualizarRegistroA() {
        Trabajador trabajador = new Trabajador(visTrabAct.txId.getText(), visTrabAct.txNombre.getText(), visTrabAct.txDireccion.getText(), visTrabAct.txTel.getText(), visTrabAct.txCargo.getText(), visTrabAct.txFecha.getText(), visTrabAct.txCapacitaciones.getText());
        String msg = conTra.editarTrabajador(trabajador);
        JOptionPane.showMessageDialog(null, msg);

        if (!msg.contains("Error")) {
            visTrabAct.dispose();
            visPri.setVisible(true);
            llenarTablaRegistroA();
        }
    }

    private void eliminarRegistroA() {

        int fila = visPri.tbRegistroA.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un registro");
        } else {
            String codigoTrabajador = "" + visPri.tbRegistroA.getValueAt(fila, 0);
            int opcion = JOptionPane.showConfirmDialog(null, "El registro se eliminará, ¿desea continuar?", "Eliminar registro", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (opcion == JOptionPane.YES_OPTION) {
                String msg = conTra.eliminarTrabajador(codigoTrabajador);
                JOptionPane.showMessageDialog(null, msg);
                llenarTablaRegistroA();
            }
        }
    }

    private void buscarTrabajadorPorId() {

        Trabajador ra = conTra.buscarTrabajador(visPri.txId.getText());

        if (ra != null) {

            visBusTra = new VistaBuscarTrabajador();
            visPri.setVisible(false);
            visBusTra.setVisible(true);
            visBusTra.agregarListener(this);

            visBusTra.txCargo.setText(ra.getCargo());
            visBusTra.txDireccion.setText(ra.getDireccion());
            visBusTra.txFecha.setText(ra.getFecha());
            visBusTra.txId.setText(ra.getId());
            visBusTra.txNombre.setText(ra.getNombre());
            visBusTra.txTel.setText(ra.getTelefono());
            visBusTra.txCapacitaciones.setText(ra.getCapacitaciones());
        } else {
            JOptionPane.showMessageDialog(null, "No se encontro el registro");
        }

    }

    private void BuscarTrabajadoresPorNombre() {

        visBusTraTabla = new VistaBuscarTrabajadores();
        visPri.setVisible(false);
        visBusTraTabla.setVisible(true);
        visBusTraTabla.agregarListener(this);

        String datos[][] = conTra.BuscarTrabajadoresPorNombre(visPri.txTrabBusNombre.getText());
        String[] filaEtiquetas = {"Id", "Nombre", "Direccion", "Telefono", "Cargo", "Fecha de ingreso", "Capacitaciones"};
        DefaultTableModel tabla = new DefaultTableModel();
        tabla.setDataVector(datos, filaEtiquetas);
        visBusTraTabla.tbRegistroA.setModel(tabla);

    }

    private void BuscarTrabajadoresPorCargo() {

        visBusTraTabla = new VistaBuscarTrabajadores();
        visPri.setVisible(false);
        visBusTraTabla.setVisible(true);
        visBusTraTabla.agregarListener(this);

        String datos[][] = conTra.buscarTrabajadoresPorCargo(visPri.txTrabBusCargo.getText());
        String[] filaEtiquetas = {"Id", "Nombre", "Direccion", "Telefono", "Cargo", "Fecha de ingreso", "Capacitaciones"};
        DefaultTableModel tabla = new DefaultTableModel();
        tabla.setDataVector(datos, filaEtiquetas);
        visBusTraTabla.tbRegistroA.setModel(tabla);
    }

    private void registrarEvaluacionTrabajador() {

        int fila = visPri.tbRegistroA.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un registro");

        } else {
            visRegEva = new VistaRegistrarEvaluacion();

            String codigo = "" + visPri.tbRegistroA.getValueAt(fila, 0);
            Trabajador t = conTra.buscarTrabajador(codigo);

            visRegEva.txId.setText(codigo);
            visRegEva.txNombre.setText(t.getNombre());

            visPri.setVisible(false);
            visRegEva.setVisible(true);
            visRegEva.agregarListener(this);
        }

    }

    private void guardarEvaluacionTrabajador() {
        visPri.tbRegistroA.clearSelection();

        EvaluacionSalud rb = new EvaluacionSalud(visRegEva.txId.getText(), visRegEva.txEstado.getText(), visRegEva.txRiesgos.getText());

        String msg = conEva.agregarEvaluacionSalud(rb);
        JOptionPane.showMessageDialog(null, msg);
    }

    private void buscarEvaluacionMedica() {

        int fila = visPri.tbRegistroA.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un registro");
        } else {

            visBusEva = new VistaBuscarEvaluaciones();
            visPri.setVisible(false);
            visBusEva.setVisible(true);
            visBusEva.agregarListener(this);

            String codigoTrabajador = "" + visPri.tbRegistroA.getValueAt(fila, 0);
            String datos[][] = conEva.BuscarEvaluacionPorTrabajador(codigoTrabajador);
            String[] filaEtiquetas = {"Trabaajdor", "Estado", "Riesgo"};
            DefaultTableModel tabla = new DefaultTableModel();
            tabla.setDataVector(datos, filaEtiquetas);
            visBusEva.tbRegistroA.setModel(tabla);
        }
    }

    private void editarEvaluacion() {

        int fila = visBusEva.tbRegistroA.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un registro");
        } else {

            EvaluacionSalud eva = conEva.buscarEvaluacionSaludPorPosicion(fila);

            if (eva != null) {

                visEdiEva = new VistaEditarEvaluacion();
                visPri.setVisible(false);
                visEdiEva.setVisible(true);
                visEdiEva.agregarListener(this);

                visEdiEva.txEstado.setText(eva.getEstado());
                visEdiEva.txRiesgos.setText(eva.getRiesgo());

            } else {
                JOptionPane.showMessageDialog(null, "No se encontro el registro");
            }
        }
    }

    private void actualizarEvaluacion() {

        int fila = visBusEva.tbRegistroA.getSelectedRow();
        String codigo = "" + visBusEva.tbRegistroA.getValueAt(fila, 0);
        EvaluacionSalud eva = new EvaluacionSalud(codigo, visEdiEva.txEstado.getText(), visEdiEva.txRiesgos.getText());
        String msg = conEva.editarEvaluacionSalud(eva);
        JOptionPane.showMessageDialog(null, msg);

        if (!msg.contains("Error")) {
            visBusEva.dispose();
            visBusEva.setVisible(true);
            buscarEvaluacionMedica();
        }
    }

    private void registrarIncidente() {

        int fila = visPri.tbRegistroA.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un registro");
        } else {

            String codigoTrabajador = "" + visPri.tbRegistroA.getValueAt(fila, 0);

            visRegInc = new VistaRegistrarIncidente();
            visPri.setVisible(false);
            visRegInc.setVisible(true);
            visRegInc.agregarListener(this);

            visRegInc.txTrab.setText(codigoTrabajador);

        }
    }

    private void guardarIncidente() {

        Incidente inc = new Incidente(visRegInc.txTipo.getText(), visRegInc.txFech.getText(), visRegInc.txDes.getText(), visRegInc.txTrab.getText());

        String msg = conInc.agregarIncidente(inc);
        JOptionPane.showMessageDialog(null, msg);
        llenarTablaincidentes();
        visRegInc.dispose();
        visPri.setVisible(true);

    }

    private void llenarTablaincidentes() {

        String datos[][] = conInc.buscarIncidenteArreglo();
        String[] filaEtiquetas = {"Tipo", "Fecha", "Descripcion", "Id Trabajador"};
        DefaultTableModel tablaIncidentes = new DefaultTableModel();
        tablaIncidentes.setDataVector(datos, filaEtiquetas);
        visPri.tbIncidentes.setModel(tablaIncidentes);

    }

    private void BuscarIncidentePorFecha() {
        visBusTraTabla = new VistaBuscarTrabajadores();
        visPri.setVisible(false);
        visBusTraTabla.setVisible(true);
        visBusTraTabla.agregarListener(this);

        String datos[][] = conInc.buscarIncindentesPorFecha(visPri.txDato.getText());
        String[] filaEtiquetas = {"Tipo", "Fecha", "Descripcion", "Id Trabajador"};
        DefaultTableModel tabla = new DefaultTableModel();
        tabla.setDataVector(datos, filaEtiquetas);
        visBusTraTabla.tbRegistroA.setModel(tabla);
    }

    private void BuscarIncidentePorTrabajador() {
        visBusTraTabla = new VistaBuscarTrabajadores();
        visPri.setVisible(false);
        visBusTraTabla.setVisible(true);
        visBusTraTabla.agregarListener(this);

        String datos[][] = conInc.BuscarIncidentePorTrabajador(visPri.txDato.getText());
        String[] filaEtiquetas = {"Tipo", "Fecha", "Descripcion", "Id Trabajador"};
        DefaultTableModel tabla = new DefaultTableModel();
        tabla.setDataVector(datos, filaEtiquetas);
        visBusTraTabla.tbRegistroA.setModel(tabla);
    }

    private void BuscarIncidentePorTipo() {
        visBusTraTabla = new VistaBuscarTrabajadores();
        visPri.setVisible(false);
        visBusTraTabla.setVisible(true);
        visBusTraTabla.agregarListener(this);

        String datos[][] = conInc.BuscarIncidentePorTipo(visPri.txDato.getText());
        String[] filaEtiquetas = {"Tipo", "Fecha", "Descripcion", "Id Trabajador"};
        DefaultTableModel tabla = new DefaultTableModel();
        tabla.setDataVector(datos, filaEtiquetas);
        visBusTraTabla.tbRegistroA.setModel(tabla);
    }

    private void abrirVistaActualizarIncidente() {
        int fila = visPri.tbRegistroA.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un registro");
        } else {
            Trabajador trabajador = conTra.buscarTrabajador("" + visPri.tbRegistroA.getValueAt(fila, 0));

            visTrabAct = new VistaRegistroAActualizar();
            visPri.setVisible(false);
            visTrabAct.setVisible(true);
            visTrabAct.agregarListener(this);

            visTrabAct.txId.setText(trabajador.getId());
            visTrabAct.txNombre.setText(trabajador.getNombre());
            visTrabAct.txDireccion.setText(trabajador.getDireccion());
            visTrabAct.txTel.setText(trabajador.getTelefono());
            visTrabAct.txCargo.setText(trabajador.getCargo());
            visTrabAct.txFecha.setText(trabajador.getCargo());
            visTrabAct.txCapacitaciones.setText(trabajador.getCapacitaciones());
        }
    }

    private void ActualizarIncidente() {
        Trabajador trabajador = new Trabajador(visTrabAct.txId.getText(), visTrabAct.txNombre.getText(), visTrabAct.txDireccion.getText(), visTrabAct.txTel.getText(), visTrabAct.txCargo.getText(), visTrabAct.txFecha.getText(), visTrabAct.txCapacitaciones.getText());
        String msg = conTra.editarTrabajador(trabajador);
        JOptionPane.showMessageDialog(null, msg);

        if (!msg.contains("Error")) {
            visTrabAct.dispose();
            visPri.setVisible(true);
            llenarTablaRegistroA();
        }
    }

    private void editarIncidente() {
        int fila = visPri.tbIncidentes.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un registro");
        } else {
            Incidente inc = conInc.buscarIncidente("" + visPri.tbIncidentes.getValueAt(fila, 0), "" + visPri.tbIncidentes.getValueAt(fila, 1), "" + visPri.tbIncidentes.getValueAt(fila, 2), "" + visPri.tbIncidentes.getValueAt(fila, 3));

            visEdiInc = new VistaEditarIncidente();
            visPri.setVisible(false);
            visEdiInc.setVisible(true);
            visEdiInc.agregarListener(this);

            visEdiInc.txTipo.setText(inc.getTipo());
            visEdiInc.txFech.setText(inc.getFecha());
            visEdiInc.txDes.setText(inc.getDescripcion());
            visEdiInc.txTrab.setText(inc.getTrabajador());

        }
    }

    private void actualizarIncidente() {
        Incidente inc = new Incidente(visEdiInc.txTipo.getText(), visEdiInc.txFech.getText(), visEdiInc.txDes.getText(), visEdiInc.txTrab.getText());
        String msg = conInc.editarIncidente(inc);
        JOptionPane.showMessageDialog(null, msg);

        if (!msg.contains("Error")) {
            visEdiInc.dispose();
            visPri.setVisible(true);
            llenarTablaincidentes();
        }

    }

    private void abrirVistaEditarSupervisor() {
        int fila = visPri.tbSup.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un registro");

        } else {
            visEdiSup = new VistaEditarSupervisor();

            String codigo = "" + visPri.tbSup.getValueAt(fila, 0);
            Supervisor t = conSup.buscarSupervisor(codigo);

            visEdiSup.txNombre.setText(t.getNombre());
            visEdiSup.txCargo.setText(t.getCargo());
            visEdiSup.txEspecialidad.setText(t.getEspecialidad());
            visEdiSup.txHorario.setText(t.getHorario());

            visPri.setVisible(false);
            visEdiSup.setVisible(true);
            visEdiSup.agregarListener(this);
        }

    }

    private void RegistrarSupervisor() {
                  
            visRegSup = new VistaRegistroSupervisor();
            visPri.setVisible(false);
            visRegSup.setVisible(true);
            visRegSup.agregarListener(this);

      }

    private void registrarSupervisor() {

        Supervisor t = new Supervisor(visRegSup.txNombre.getText(), visRegSup.txCargo.getText(), visRegSup.txEspecialidad.getText(), visRegSup.txHorario.getText());
        String msg = conSup.agregarSupervisor(t);
        JOptionPane.showMessageDialog(null, msg);

        if (!msg.contains("Error")) {
            visRegSup.dispose();
            visPri.setVisible(true);
            llenarTablaSupervisores();
        }
    }

    private void editarSupervisor() {

        Supervisor t = new Supervisor(visEdiSup.txNombre.getText(), visEdiSup.txCargo.getText(), visEdiSup.txEspecialidad.getText(), visEdiSup.txHorario.getText());
        String msg = conSup.editarSupervisor(t);

        visPri.setVisible(true);
        visEdiSup.dispose();

        llenarTablaSupervisores();

    }

    private void llenarTablaSupervisores() {

        String datos[][] = conSup.buscarSupervisorArreglo();
        String[] filaEtiquetas = {"Nombre", "Cargo", "Esoecialidad", "Horario"};
        DefaultTableModel tablaIncidentes = new DefaultTableModel();
        tablaIncidentes.setDataVector(datos, filaEtiquetas);
        visPri.tbSup.setModel(tablaIncidentes);
    }

    private void BuscarSupervisorPorNombre() {

        visBusTraTabla = new VistaBuscarTrabajadores();
        visPri.setVisible(false);
        visBusTraTabla.setVisible(true);
        visBusTraTabla.agregarListener(this);

        String datos[][] = conSup.buscarSupervisorPorNombre(visPri.txSup.getText());
        String[] filaEtiquetas = {"Nombre", "Cargo", "Esoecialidad", "Horario"};
        DefaultTableModel tabla = new DefaultTableModel();
        tabla.setDataVector(datos, filaEtiquetas);
        visBusTraTabla.tbRegistroA.setModel(tabla);
    }

    private void BuscarSupervisorPorCargo() {
        visBusTraTabla = new VistaBuscarTrabajadores();
        visPri.setVisible(false);
        visBusTraTabla.setVisible(true);
        visBusTraTabla.agregarListener(this);

        String datos[][] = conSup.buscarSupervisorPorCargo(visPri.txSup.getText());
        String[] filaEtiquetas = {"Nombre", "Cargo", "Esoecialidad", "Horario"};
        DefaultTableModel tabla = new DefaultTableModel();
        tabla.setDataVector(datos, filaEtiquetas);
        visBusTraTabla.tbRegistroA.setModel(tabla);

    }

}
