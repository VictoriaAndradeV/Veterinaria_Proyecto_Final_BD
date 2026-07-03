package org.example.vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GestionEmpleados extends JFrame {
    private JPanel panelPrincipal;
    private JTextField textField1; // Cédula búsqueda
    private JButton buscarButton;

    private JTextField textField2; // Código
    private JTextField textField3; // Cédula
    private JTextField textField4; // Nombres
    private JTextField textField5; // Apellidos
    private JTextField textField6; // Dirección
    private JTextField textField7; // Teléfono
    private JTextField textField8; // Correo
    private JTextField textField9; // Tipo de empleado

    private JPanel panelBuscar;
    private JPanel panelDatos;
    private JPanel panelBotones;

    private JButton crearButton;
    private JButton actualizarButton;
    private JButton eliminarButton;
    private JButton listarButton;
    private JButton limpiarButton;
    private JButton volverButton;

    public GestionEmpleados() {
        configurarVentana();
        ajustarDiseno();
        configurarCampos();
        configurarEventosBasicos();
    }

    private void configurarVentana() {
        setTitle("Sistema de Gestión Veterinaria - Gestión de Empleados");
        setContentPane(panelPrincipal);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setSize(760, 700);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void ajustarDiseno() {
        // Margen general para que nada quede pegado al borde
        panelPrincipal.setBorder(new EmptyBorder(18, 28, 22, 28));

        // Márgenes internos por sección
        panelBuscar.setBorder(new EmptyBorder(8, 5, 8, 5));
        panelDatos.setBorder(new EmptyBorder(10, 5, 10, 5));
        panelBotones.setBorder(new EmptyBorder(12, 5, 8, 5));

        // Tamaño de campos
        Dimension tamanioCampos = new Dimension(500, 32);
        Dimension tamanioBusqueda = new Dimension(460, 32);

        textField1.setPreferredSize(tamanioBusqueda);

        textField2.setPreferredSize(tamanioCampos);
        textField3.setPreferredSize(tamanioCampos);
        textField4.setPreferredSize(tamanioCampos);
        textField5.setPreferredSize(tamanioCampos);
        textField6.setPreferredSize(tamanioCampos);
        textField7.setPreferredSize(tamanioCampos);
        textField8.setPreferredSize(tamanioCampos);
        textField9.setPreferredSize(tamanioCampos);

        // Tamaño de botones
        Dimension tamanioBoton = new Dimension(140, 38);
        Dimension tamanioBotonBuscar = new Dimension(110, 38);

        buscarButton.setPreferredSize(tamanioBotonBuscar);

        JButton[] botones = {
                crearButton,
                actualizarButton,
                eliminarButton,
                listarButton,
                limpiarButton,
                volverButton
        };

        for (JButton boton : botones) {
            boton.setPreferredSize(tamanioBoton);
            boton.setFocusPainted(false);
            boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }

        buscarButton.setFocusPainted(false);
        buscarButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private void configurarCampos() {
        // El código no debe escribirse manualmente
        textField2.setEditable(false);
        textField2.setFocusable(false);

        // Al iniciar, los datos quedan bloqueados hasta presionar Crear o Buscar
        bloquearCamposDatos(true);
    }

    private void bloquearCamposDatos(boolean bloquear) {
        textField3.setEditable(!bloquear);
        textField4.setEditable(!bloquear);
        textField5.setEditable(!bloquear);
        textField6.setEditable(!bloquear);
        textField7.setEditable(!bloquear);
        textField8.setEditable(!bloquear);
        textField9.setEditable(!bloquear);
    }

    private void configurarEventosBasicos() {
        crearButton.addActionListener(e -> {
            limpiarCampos();
            bloquearCamposDatos(false);
            textField3.requestFocus();
        });

        buscarButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(
                    this,
                    "Aquí se buscará el empleado por cédula.",
                    "Buscar empleado",
                    JOptionPane.INFORMATION_MESSAGE
            );

            bloquearCamposDatos(false);
        });

        limpiarButton.addActionListener(e -> {
            limpiarCampos();
            bloquearCamposDatos(true);
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
        textField8.setText("");
        textField9.setText("");

        textField1.requestFocus();
    }
}