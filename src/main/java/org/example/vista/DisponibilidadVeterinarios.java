package org.example.vista;

import javax.swing.*;

public class DisponibilidadVeterinarios extends JFrame {
    private JPanel panelPrincipal;
    private JPanel panelVet;
    private JPanel panelConsultas;
    private JButton btnDisponibilidad;
    private JButton btnAgendarCita;
    private JButton btnVolver;
    private JTextField txfVeterinario;
    private JComboBox cbxFecha;
    private JButton btnLimpiar;
    private JTable tablaVeterinarios;
    private JTable tblHorariosVet;

    public DisponibilidadVeterinarios() {
        setTitle("Disponibilidad de Veterinarios");
        setContentPane(panelPrincipal);
        setSize(850, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnVolver.addActionListener(e -> {
            VistaAdmin vistaAdmin = new VistaAdmin();
            vistaAdmin.setVisible(true);
            dispose();
        });

        btnAgendarCita.addActionListener(e -> {
            RegistroCitas registroCitas = new RegistroCitas();
            registroCitas.setVisible(true);
            dispose();
        });

        btnDisponibilidad.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Consultando disponibilidad...");
        });
    }
}