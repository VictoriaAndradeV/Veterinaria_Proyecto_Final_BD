package org.example;

import org.example.vista.*;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            IniciarSesion iniciarSesion = new IniciarSesion();
            iniciarSesion.setVisible(true);

            // GESTIÓN DE CLIENTES
            GestionClientes gestionClientes = new GestionClientes();
            //gestionClientes.setVisible(true);

            // LISTA DE CLIENTES ADMIN
            AdminListaClientes adminListaClientes = new AdminListaClientes();
            //adminListaClientes.setVisible(true);

            // GESTIÓN DE EMPLEADOS
            GestionEmpleados gestionEmpleados = new GestionEmpleados();
            //gestionEmpleados.setVisible(true);

            // GESTIÓN DE USUARIOS ADMIN
            AdminGestionEmpleados adminGestionEmpleados = new AdminGestionEmpleados();
            //adminGestionEmpleados.setVisible(true);

            // LISTA DE EMPLEADOS ADMIN
            AdminListaEmpleados adminListaEmpleados = new AdminListaEmpleados();
            //adminListaEmpleados.setVisible(true);

            // LISTA DE USUARIOS ADMIN
            AdminListarUsuarios adminListarUsuarios = new AdminListarUsuarios();
            //adminListarUsuarios.setVisible(true);

            // REGISTRO DE FACTURA
            RegistroFactura registroFactura = new RegistroFactura();
            //registroFactura.setVisible(true);

        });
    }
}