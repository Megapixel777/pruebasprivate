package Controlador;

import Modelo.Centro;
import Modelo.ConsultasCentro;
import Vista.frmCentro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CtrlCentro implements ActionListener {

    private Centro mod;
    private ConsultasCentro modC;
    private frmCentro frm;

    public CtrlCentro(Centro mod, ConsultasCentro modC, frmCentro frm) {
        this.mod = mod;
        this.modC = modC;
        this.frm = frm;
        this.frm.jButtonGuardar.addActionListener(this);
        this.frm.jButtonModificar.addActionListener(this);
        this.frm.jButtonEliminar.addActionListener(this);
        this.frm.jButtonLimpiar.addActionListener(this);
        this.frm.jButtonBuscar.addActionListener(this);
    }

    public void iniciar() {
        frm.setTitle("Gestion Centros");
        frm.setLocationRelativeTo(null);
        frm.jTextFieldId.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frm.jButtonGuardar) {
            
            mod.setId_administrador(Integer.parseInt(frm.jTextFieldId_administrador.getText()));
            mod.setNombre(frm.jTextFieldNombre.getText());
            mod.setMax_procesamiento(Float.parseFloat(frm.jTextFieldMax_procesamiento.getText()));
            mod.setMax_cola(Integer.parseInt(frm.jTextFieldMax_cola.getText()));

            if (modC.registrar(mod)) {
                JOptionPane.showMessageDialog(null, "Centro Guardado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar Centro");
                limpiar();
            }
        }
        if (e.getSource() == frm.jButtonModificar) {
            mod.setId(Integer.parseInt(frm.jTextFieldId.getText()));
            mod.setId_administrador(Integer.parseInt(frm.jTextFieldId_administrador.getText()));
            mod.setNombre(frm.jTextFieldNombre.getText());
            mod.setMax_procesamiento(Float.parseFloat(frm.jTextFieldMax_procesamiento.getText()));
            mod.setMax_cola(Integer.parseInt(frm.jTextFieldMax_cola.getText()));
            


            if (modC.modificar(mod)) {
                JOptionPane.showMessageDialog(null, "Centro Modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Modificar Centro");
                limpiar();
            }
        }

        if (e.getSource() == frm.jButtonEliminar) {
            mod.setId(Integer.parseInt(frm.jTextFieldId.getText()));

            if (modC.eliminar(mod)) {
                JOptionPane.showMessageDialog(null, "Centro Eliminado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar Centro");
                limpiar();
            }
        }

        if (e.getSource() == frm.jButtonBuscar) {
            mod.setNombre(frm.jTextFieldNombre.getText());

            if (modC.buscar(mod)) {
                frm.jTextFieldId.setText(String.valueOf(mod.getId()));
                frm.jTextFieldId_administrador.setText(String.valueOf(mod.getId_administrador()));
                frm.jTextFieldNombre.setText(mod.getNombre());
                frm.jTextFieldMax_procesamiento.setText(String.valueOf(mod.getMax_procesamiento()));
                frm.jTextFieldMax_cola.setText(String.valueOf(mod.getMax_cola()));
                
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el centro");
                limpiar();
            }
        }

        if (e.getSource() == frm.jButtonLimpiar) {
            limpiar();
        }
    }

    public void limpiar() {
        frm.jTextFieldId.setText(null);
        frm.jTextFieldId_administrador.setText(null);
        frm.jTextFieldNombre.setText(null);
        frm.jTextFieldMax_procesamiento.setText(null);
        frm.jTextFieldMax_cola.setText(null);

    }
}