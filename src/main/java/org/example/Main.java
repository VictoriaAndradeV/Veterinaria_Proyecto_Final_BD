package org.example;

import org.example.vista.GestionClientes;
import org.example.vista.IniciarSesion;
import org.example.vista.MenuEmpleadoGeneral;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            //IniciarSesion iniciarSesion = new IniciarSesion();
            //iniciarSesion.setVisible(true);
            //MenuEmpleadoGeneral menuEmpleadoGeneral = new MenuEmpleadoGeneral();
            //menuEmpleadoGeneral.setVisible(true);
            GestionClientes gestionClientes = new GestionClientes();
            gestionClientes.setVisible(true);
        });
    }
}