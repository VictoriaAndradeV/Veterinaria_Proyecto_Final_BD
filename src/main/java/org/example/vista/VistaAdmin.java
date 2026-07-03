package org.example.vista;

import javax.swing.*;

public class VistaAdmin extends JFrame {

    private JPanel panelPrincipal1;
    private JPanel panelPrincipal;
    private JPanel panelTitulo;
    private JButton btnRegistrarClientes;
    private JButton btnGestionarServicios;
    private JButton BtnRegistrarCita;
    private JButton btnDisponibilidadVeterinarios;
    private JButton btnFacturacion;
    private JButton BtnFacturas;
    private JButton btnEmpleadosUsuarios;
    private JButton btnCerrarSesion;

    public VistaAdmin() {

        setTitle("Menú Administrador");
        setContentPane(panelPrincipal1);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnGestionarServicios.addActionListener(e -> {
            GestionServicios gestionServicios = new GestionServicios();
            gestionServicios.setVisible(true);
            dispose();
        });

        BtnRegistrarCita.addActionListener(e -> {
            RegistroCitas registroCitas = new RegistroCitas();
            registroCitas.setVisible(true);
            dispose();
        });

        btnDisponibilidadVeterinarios.addActionListener(e -> {
            DisponibilidadVeterinarios disponibilidad = new DisponibilidadVeterinarios();
            disponibilidad.setVisible(true);
            dispose();
        });

        BtnFacturas.addActionListener(e -> {
            ListadoYAnulacionFac facturas = new ListadoYAnulacionFac();
            facturas.setVisible(true);
            dispose();
        });

        btnCerrarSesion.addActionListener(e -> {
            dispose();
        });

    }

}
