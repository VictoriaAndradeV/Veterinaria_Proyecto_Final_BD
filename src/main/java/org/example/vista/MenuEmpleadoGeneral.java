package org.example.vista;

import javax.swing.*;
import java.awt.*;

public class MenuEmpleadoGeneral extends JFrame {
    private JPanel panel1;
    private JButton btnGestionarCliente;
    private JButton btnFacturar;
    private JButton btnCerrarSesion;
    private JLabel labelTitulo;

    public MenuEmpleadoGeneral() {
        configurarVentana();
        ajustarTamanioBotones();
        configurarEventos();
    }

    private void configurarVentana() {
        setTitle("Sistema de Gestión Veterinaria - Menú Empleado General");
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Tamaño más adecuado para este menú
        setSize(500, 360);

        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void ajustarTamanioBotones() {
        // Botones principales del menú
        Dimension tamanioBotonesPrincipales = new Dimension(230, 36);

        btnGestionarCliente.setPreferredSize(tamanioBotonesPrincipales);
        btnGestionarCliente.setMinimumSize(tamanioBotonesPrincipales);
        btnGestionarCliente.setMaximumSize(tamanioBotonesPrincipales);

        btnFacturar.setPreferredSize(tamanioBotonesPrincipales);
        btnFacturar.setMinimumSize(tamanioBotonesPrincipales);
        btnFacturar.setMaximumSize(tamanioBotonesPrincipales);

        // Botón secundario
        Dimension tamanioBotonCerrar = new Dimension(150, 32);

        btnCerrarSesion.setPreferredSize(tamanioBotonCerrar);
        btnCerrarSesion.setMinimumSize(tamanioBotonCerrar);
        btnCerrarSesion.setMaximumSize(tamanioBotonCerrar);
    }

    private void configurarEventos() {

        btnGestionarCliente.addActionListener(e -> {
            // Aquí luego abres la ventana de gestión de clientes
            // new GestionClientes().setVisible(true);
            // this.dispose();
        });

        btnFacturar.addActionListener(e -> {
            // Aquí luego abres la ventana de registro de facturas
            // new RegistroFacturas().setVisible(true);
            // this.dispose();
        });

        btnCerrarSesion.addActionListener(e -> volverInicioSesion());
    }

    private void volverInicioSesion() {
        IniciarSesion iniciarSesion = new IniciarSesion();
        iniciarSesion.setVisible(true);
        this.dispose();
    }
}