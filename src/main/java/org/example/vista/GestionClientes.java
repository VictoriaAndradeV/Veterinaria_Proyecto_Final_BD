package org.example.vista;

import javax.swing.*;
import java.awt.*;

public class GestionClientes extends JFrame {
    private JTextField txtCedula;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtDireccion;
    private JTextField txtTelefono;
    private JTextField txtCorreo;
    private JComboBox<String> comboBoxEstado;
    private JButton buscarButton;
    private JLabel labelTitulo;
    private JTextField txtCodigo;
    private JButton btnGuardar;
    private JButton actualizarGuardarButton;
    private JButton eliminarButton;
    private JButton limpiarButton;
    private JButton volverButton;
    private JPanel panelTitulo;
    private JPanel panelDatosCliente;
    private JPanel panelInferiorBotones;
    private JPanel panelPrincipal;

    public GestionClientes() {
        configurarVentana();
        configurarComponentes();
        ajustarProporciones();
        ajustarTamanioBotones();
        configurarEventos();
    }

    private void configurarVentana() {
        setTitle("Sistema de Gestión Veterinaria - Gestión de Clientes");
        setContentPane(panelPrincipal);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(950, 620);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void configurarComponentes() {
        // El código no debe escribirse manualmente.
        txtCodigo.setEditable(false);
        txtCodigo.setFocusable(false);

        // Opciones del estado del cliente.
        comboBoxEstado.removeAllItems();
        comboBoxEstado.addItem("ACTIVO");
        comboBoxEstado.addItem("INACTIVO");
        comboBoxEstado.setSelectedItem("ACTIVO");

        limpiarCampos();
    }

    private void ajustarProporciones() {
        panelTitulo.setPreferredSize(new Dimension(900, 90));
        panelDatosCliente.setPreferredSize(new Dimension(900, 390));
        panelInferiorBotones.setPreferredSize(new Dimension(900, 85));

        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(15, 35, 20, 35));
        panelTitulo.setBorder(BorderFactory.createEmptyBorder(20, 0, 15, 0));
        panelDatosCliente.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        panelInferiorBotones.setBorder(BorderFactory.createEmptyBorder(15, 0, 10, 0));

        Dimension tamanioCampos = new Dimension(610, 28);

        txtCodigo.setPreferredSize(tamanioCampos);
        txtCedula.setPreferredSize(tamanioCampos);
        txtNombre.setPreferredSize(tamanioCampos);
        txtApellido.setPreferredSize(tamanioCampos);
        txtDireccion.setPreferredSize(tamanioCampos);
        txtTelefono.setPreferredSize(tamanioCampos);
        txtCorreo.setPreferredSize(tamanioCampos);
        comboBoxEstado.setPreferredSize(tamanioCampos);

        txtCodigo.setMaximumSize(tamanioCampos);
        txtCedula.setMaximumSize(tamanioCampos);
        txtNombre.setMaximumSize(tamanioCampos);
        txtApellido.setMaximumSize(tamanioCampos);
        txtDireccion.setMaximumSize(tamanioCampos);
        txtTelefono.setMaximumSize(tamanioCampos);
        txtCorreo.setMaximumSize(tamanioCampos);
        comboBoxEstado.setMaximumSize(tamanioCampos);
    }

    private void ajustarTamanioBotones() {
        Dimension tamanioBotonesInferiores = new Dimension(165, 38);
        Dimension tamanioBotonBuscar = new Dimension(110, 38);

        buscarButton.setPreferredSize(tamanioBotonBuscar);
        buscarButton.setMinimumSize(tamanioBotonBuscar);
        buscarButton.setMaximumSize(tamanioBotonBuscar);

        JButton[] botones = {
                btnGuardar,
                actualizarGuardarButton,
                eliminarButton,
                limpiarButton,
                volverButton
        };

        for (JButton boton : botones) {
            boton.setPreferredSize(tamanioBotonesInferiores);
            boton.setMinimumSize(tamanioBotonesInferiores);
            boton.setMaximumSize(tamanioBotonesInferiores);
            boton.setFocusPainted(false);
            boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }

        buscarButton.setFocusPainted(false);
        buscarButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private void configurarEventos() {
        buscarButton.addActionListener(e -> buscarCliente());

        btnGuardar.addActionListener(e -> {
            if (validarCampos()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Cliente registrado correctamente.",
                        "Registro de cliente",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        });

        actualizarGuardarButton.addActionListener(e -> {
            if (validarCampos()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Datos del cliente actualizados correctamente.",
                        "Actualización de cliente",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        });

        eliminarButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(
                    this,
                    "Si el cliente no tiene facturas asociadas, se eliminará.\n" +
                            "Si tiene facturas asociadas, se cambiará su estado a INACTIVO.",
                    "Eliminar / Desactivar cliente",
                    JOptionPane.INFORMATION_MESSAGE
            );
            comboBoxEstado.setSelectedItem("INACTIVO");
        });

        limpiarButton.addActionListener(e -> limpiarCampos());

        volverButton.addActionListener(e -> dispose());
    }

    private void buscarCliente() {
        String cedula = txtCedula.getText().trim();

        if (cedula.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Ingrese la cédula del cliente que desea buscar.",
                    "Búsqueda de cliente",
                    JOptionPane.WARNING_MESSAGE
            );
            txtCedula.requestFocus();
            return;
        }

        JOptionPane.showMessageDialog(
                this,
                "No existe ningún cliente registrado con la cédula ingresada.\n" +
                        "Puede completar los datos para crear un nuevo cliente.",
                "Cliente no encontrado",
                JOptionPane.INFORMATION_MESSAGE
        );

        txtNombre.requestFocus();
    }

    private boolean validarCampos() {
        if (txtCedula.getText().trim().isEmpty()) {
            mostrarCampoObligatorio("cédula", txtCedula);
            return false;
        }

        if (txtNombre.getText().trim().isEmpty()) {
            mostrarCampoObligatorio("nombre", txtNombre);
            return false;
        }

        if (txtApellido.getText().trim().isEmpty()) {
            mostrarCampoObligatorio("apellido", txtApellido);
            return false;
        }

        if (txtTelefono.getText().trim().isEmpty()) {
            mostrarCampoObligatorio("teléfono", txtTelefono);
            return false;
        }

        if (txtCorreo.getText().trim().isEmpty()) {
            mostrarCampoObligatorio("correo", txtCorreo);
            return false;
        }

        return true;
    }

    private void mostrarCampoObligatorio(String campo, JTextField textField) {
        JOptionPane.showMessageDialog(
                this,
                "Debe ingresar el " + campo + " del cliente.",
                "Campo obligatorio",
                JOptionPane.WARNING_MESSAGE
        );
        textField.requestFocus();
    }

    private void limpiarCampos() {
        txtCodigo.setText("");
        txtCedula.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
        comboBoxEstado.setSelectedItem("ACTIVO");

        txtCedula.requestFocus();
    }
}