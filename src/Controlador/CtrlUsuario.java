package Controlador;

import Modelo.ConsultasUsuario;
import Modelo.Usuario;
import Vista.frmUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CtrlUsuario implements ActionListener {

    private Usuario mod;
    private ConsultasUsuario modC;
    private frmUsuario frm;

    public CtrlUsuario(Usuario mod, ConsultasUsuario modC, frmUsuario frm) {
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
        frm.setTitle("Gestion Usuarios");
        frm.setLocationRelativeTo(null);
        frm.jTextFieldId.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frm.jButtonGuardar) {
            
            mod.setNombre(frm.jTextFieldNombre.getText());
            mod.setPassword(frm.jTextFieldPassword.getText());
            mod.setTipo(Integer.parseInt(frm.jTextFieldTipo.getText()));
            mod.setEstado(Integer.parseInt(frm.jTextFieldEstado.getText()));

            if (modC.registrar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar");
                limpiar();
            }
        }
        if (e.getSource() == frm.jButtonModificar) {
            mod.setId(Integer.parseInt(frm.jTextFieldId.getText()));
            mod.setNombre(frm.jTextFieldNombre.getText());
            mod.setPassword(frm.jTextFieldPassword.getText());
            mod.setTipo(Integer.parseInt(frm.jTextFieldTipo.getText()));
            mod.setEstado(Integer.parseInt(frm.jTextFieldEstado.getText()));

            if (modC.modificar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro Modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Modificar");
                limpiar();
            }
        }

        if (e.getSource() == frm.jButtonEliminar) {
            mod.setId(Integer.parseInt(frm.jTextFieldId.getText()));

            if (modC.eliminar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
                limpiar();
            }
        }

        if (e.getSource() == frm.jButtonBuscar) {
            mod.setNombre(frm.jTextFieldNombre.getText());

            if (modC.buscar(mod)) {
                frm.jTextFieldId.setText(String.valueOf(mod.getId()));
                frm.jTextFieldNombre.setText(mod.getNombre());
                frm.jTextFieldPassword.setText(mod.getPassword());
                frm.jTextFieldTipo.setText(String.valueOf(mod.getTipo()));
                frm.jTextFieldEstado.setText(String.valueOf(mod.getEstado()));

              
            } else {
                JOptionPane.showMessageDialog(null, "NO se encontró el registro");
                limpiar();
            }
        }

        if (e.getSource() == frm.jButtonLimpiar) {
            limpiar();
        }
    }

    public void limpiar() {
        frm.jTextFieldId.setText(null);
        frm.jTextFieldNombre.setText(null);
        frm.jTextFieldPassword.setText(null);
        frm.jTextFieldTipo.setText(null);
        frm.jTextFieldEstado.setText(null);
    }
}
