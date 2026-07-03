package org.example.vista;

import javax.swing.*;

public class RegistroCitas extends JFrame {
    private JPanel panelPrincipal;
    private JPanel panelTitulo;
    private JPanel panelDatos;
    private JTextField txfNombre;
    private JTextField txfMascota;
    private JComboBox cbxVeterinario;
    private JComboBox cbxFecha;
    private JTextField txfTipoMascota;
    private JComboBox cbxHora;
    private JButton limpiarButton;
    private JButton agendarButton;
    private JPanel panelBotones;
    private JPanel panelTabla;
    private JButton btnVolvern;
    private JTable table1;
    private JTextField txfEstado;
    private JButton btnCancelar;

    public RegistroCitas() {
        setTitle("Registro de Citas");
        setContentPane(panelPrincipal);
        setSize(850, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnVolvern.addActionListener(e -> {
            VistaAdmin vistaAdmin = new VistaAdmin();
            vistaAdmin.setVisible(true);
            dispose();
        });

        agendarButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Cita agendada correctamente");
        });

        limpiarButton.addActionListener(e -> {
            txfNombre.setText("");
            txfMascota.setText("");
            txfTipoMascota.setText("");
        });
    }
}