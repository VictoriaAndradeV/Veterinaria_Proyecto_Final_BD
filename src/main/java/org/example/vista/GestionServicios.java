package org.example.vista;

import javax.swing.*;

public class GestionServicios extends JFrame {
    private JPanel panelPrincipal;
    private JPanel panelTitulo;
    private JPanel panelDatos;
    private JPanel panelBotones;
    private JTextField txfCodigo;
    private JTextField txfNombre;
    private JTextField txfPrecio;
    private JTextField txfIVA;
    private JTextField txfEstado;
    private JButton btnCrear;
    private JButton btnActualizar;
    private JButton btnBorrar;
    private JButton btnBuscar;
    private JTextField txfBuscar;
    private JPanel panelTabla;
    private JPanel panelBuscar;
    private JButton btnVolver;
    private JTable tablaServicios;

    public GestionServicios() {
        setTitle("Gestión de Servicios");
        setContentPane(panelPrincipal);
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnVolver.addActionListener(e -> {
            VistaAdmin vistaAdmin = new VistaAdmin();
            vistaAdmin.setVisible(true);
            dispose();
        });

        btnCrear.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Botón Crear presionado");
        });

        btnActualizar.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Botón Actualizar presionado");
        });

        btnBorrar.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Botón Borrar presionado");
        });

        btnBuscar.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Botón Buscar presionado");
        });
    }
}