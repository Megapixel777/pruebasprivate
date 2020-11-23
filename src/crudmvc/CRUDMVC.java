package crudmvc;

import Controlador.CtrlCentro;
import Controlador.CtrlUsuario;
import Modelo.Centro;
import Modelo.ConsultasCentro;
import Modelo.ConsultasUsuario;
import Modelo.Usuario;
import Vista.frmCentro;
import Vista.frmUsuario;
import java.util.Scanner;

public class CRUDMVC {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("1: Introducir usuario, 2: Introducir centro");
        int seleccion = Integer.parseInt(entrada.nextLine());

        if (seleccion == 1) {
            try {

                Usuario mod = new Usuario();
                ConsultasUsuario modC = new ConsultasUsuario();
                frmUsuario frm = new frmUsuario();

                CtrlUsuario ctrl;
                ctrl = new CtrlUsuario(mod, modC, frm);
                ctrl.iniciar();
                frm.setVisible(true);

            } catch (Exception e) {
                System.out.println(e);
            }
        }

        if (seleccion == 2) {
            try {

                Centro mod = new Centro();
                ConsultasCentro modC = new ConsultasCentro();
                frmCentro frm = new frmCentro();

                CtrlCentro ctrl;
                ctrl = new CtrlCentro(mod, modC, frm);
                ctrl.iniciar();
                frm.setVisible(true);

            } catch (Exception e) {
                System.out.println(e);
            }

        }

    }
}
