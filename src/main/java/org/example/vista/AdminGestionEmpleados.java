package org.example.vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AdminGestionEmpleados extends JFrame {
    private JPanel panelPrincipal;

    private JTextField textField1; // Cédula búsqueda
    private JButton buscarButton;

    private JTextField textField2; // Código empleado
    private JTextField textField3; // Empleado
    private JTextField textField4; // Tipo empleado
    private JTextField textField5; // Correo

    private JTextField textField6; // Código usuario
    private JTextField textField7; // Nombre de usuario

    private JComboBox<String> comboBox1; // Tipo de permiso
    private JComboBox<String> comboBox2; // Estado

    private JPasswordField passwordField1; // Contraseña
    private JPasswordField passwordField2; // Confirmar contraseña

    private JButton crearButton;
    private JButton actualizarButton;
    private JButton eliminarButton;
    private JButton limpiarButton;
    private JButton volverButton;
    private JButton listarButton;

    public AdminGestionEmpleados() {
        configurarVentana();
        ajustarDiseno();
        configurarComponentes();
        configurarEventosBasicos();
    }

    private void configurarVentana() {
        setTitle("Sistema de Gestión Veterinaria - Gestión de Usuarios y Roles");
        setContentPane(panelPrincipal);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setSize(740, 760);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void ajustarDiseno() {
        panelPrincipal.setBorder(new EmptyBorder(18, 28, 22, 28));

        Dimension tamanioCampos = new Dimension(430, 32);
        Dimension tamanioBusqueda = new Dimension(360, 32);
        Dimension tamanioBoton = new Dimension(115, 38);

        textField1.setPreferredSize(tamanioBusqueda);

        textField2.setPreferredSize(tamanioCampos);
        textField3.setPreferredSize(tamanioCampos);
        textField4.setPreferredSize(tamanioCampos);
        textField5.setPreferredSize(tamanioCampos);
        textField6.setPreferredSize(tamanioCampos);
        textField7.setPreferredSize(tamanioCampos);

        passwordField1.setPreferredSize(tamanioCampos);
        passwordField2.setPreferredSize(tamanioCampos);

        comboBox1.setPreferredSize(tamanioCampos);
        comboBox2.setPreferredSize(tamanioCampos);

        JButton[] botones = {
                buscarButton,
                crearButton,
                actualizarButton,
                listarButton,
                eliminarButton,
                limpiarButton,
                volverButton
        };

        for (JButton boton : botones) {
            boton.setPreferredSize(tamanioBoton);
            boton.setFocusPainted(false);
            boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
    }

    private void configurarComponentes() {
        // Datos del empleado: se cargan al buscar, no se escriben manualmente.
        textField2.setEditable(false);
        textField3.setEditable(false);
        textField4.setEditable(false);
        textField5.setEditable(false);

        textField2.setFocusable(false);
        textField3.setFocusable(false);
        textField4.setFocusable(false);
        textField5.setFocusable(false);

        // Código usuario generado automáticamente por la base de datos.
        textField6.setEditable(false);
        textField6.setFocusable(false);

        comboBox1.removeAllItems();
        comboBox1.addItem("ADMINISTRADOR");
        comboBox1.addItem("EMPLEADO GENERAL");

        comboBox2.removeAllItems();
        comboBox2.addItem("ACTIVO");
        comboBox2.addItem("INACTIVO");

        bloquearDatosUsuario(true);
    }

    private void bloquearDatosUsuario(boolean bloquear) {
        textField7.setEditable(!bloquear);
        passwordField1.setEditable(!bloquear);
        passwordField2.setEditable(!bloquear);
        comboBox1.setEnabled(!bloquear);
        comboBox2.setEnabled(!bloquear);
    }

    private void configurarEventosBasicos() {
        buscarButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(
                    this,
                    "Aquí se buscará el empleado de atención al cliente por cédula.",
                    "Buscar empleado",
                    JOptionPane.INFORMATION_MESSAGE
            );

            // Simula que después de buscar ya se puede crear o actualizar usuario.
            bloquearDatosUsuario(false);
            textField7.requestFocus();
        });

        crearButton.addActionListener(e -> {
            bloquearDatosUsuario(false);
            textField7.requestFocus();
        });

        limpiarButton.addActionListener(e -> {
            limpiarCampos();
            bloquearDatosUsuario(true);
        });

        volverButton.addActionListener(e -> dispose());
    }

    private void limpiarCampos() {
        textField1.setText("");

        textField2.setText("");
        textField3.setText("");
        textField4.setText("");
        textField5.setText("");

        textField6.setText("");
        textField7.setText("");

        passwordField1.setText("");
        passwordField2.setText("");

        comboBox1.setSelectedIndex(0);
        comboBox2.setSelectedIndex(0);

        textField1.requestFocus();
    }
}