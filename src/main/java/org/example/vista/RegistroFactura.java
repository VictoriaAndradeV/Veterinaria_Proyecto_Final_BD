package org.example.vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class RegistroFactura extends JFrame {
    private JPanel panelPrincipal;
    private JPanel panelTitulo;

    // Datos de factura
    private JTextField textField1;  // Código factura
    private JTextField textField2;  // Número factura
    private JTextField textField3;  // Fecha

    // Cliente
    private JTextField textField4;  // Cédula cliente
    private JTextField textField5;  // Código cliente
    private JTextField textField6;  // Nombre cliente
    private JButton buscarButton;
    private JTextField textField7;  // Teléfono
    private JTextField textField8;  // Correo

    // Usuario que genera factura
    private JTextField textField9;   // Código usuario
    private JTextField textField10;  // Usuario
    private JTextField textField11;  // Rol

    // Servicios
    private JButton agregarServicioButton;
    private JButton editarDetalleButton;
    private JButton eliminarServicioButton;
    private JButton verDetalleButton;
    private JTable table1;

    // Totales
    private JTextField textField12;  // Subtotal
    private JTextField textField13;  // Total IVA
    private JTextField textField14;  // Total factura

    // Botones finales
    private JButton generarFacturaButton;
    private JButton limpiarButton;
    private JButton volverButton;

    public RegistroFactura() {
        configurarVentana();
        ajustarDiseno();
        configurarCampos();
        configurarTabla();
    }

    private void configurarVentana() {
        setTitle("Sistema de Gestión Veterinaria - Registro de Facturas");
        setContentPane(panelPrincipal);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Más ancho para que no se corten los campos de la derecha
        setSize(1120, 760);

        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void ajustarDiseno() {
        // Margen general para que nada quede pegado al borde de la ventana
        panelPrincipal.setBorder(new EmptyBorder(18, 35, 25, 35));

        // Tamaños más controlados para que no se estiren demasiado
        Dimension campoFactura = new Dimension(260, 30);
        Dimension campoCliente = new Dimension(360, 30);
        Dimension campoUsuario = new Dimension(280, 30);
        Dimension campoTotal = new Dimension(390, 30);

        textField1.setPreferredSize(campoFactura);
        textField2.setPreferredSize(campoFactura);
        textField3.setPreferredSize(campoFactura);

        textField4.setPreferredSize(campoCliente);
        textField5.setPreferredSize(campoCliente);
        textField6.setPreferredSize(campoCliente);
        textField7.setPreferredSize(campoCliente);
        textField8.setPreferredSize(campoCliente);

        textField9.setPreferredSize(campoUsuario);
        textField10.setPreferredSize(campoUsuario);
        textField11.setPreferredSize(campoUsuario);

        textField12.setPreferredSize(campoTotal);
        textField13.setPreferredSize(campoTotal);
        textField14.setPreferredSize(campoTotal);

        // Botones superiores y de servicios
        buscarButton.setPreferredSize(new Dimension(110, 36));
        agregarServicioButton.setPreferredSize(new Dimension(155, 38));
        editarDetalleButton.setPreferredSize(new Dimension(145, 38));
        eliminarServicioButton.setPreferredSize(new Dimension(155, 38));
        verDetalleButton.setPreferredSize(new Dimension(135, 38));

        // Botones inferiores
        generarFacturaButton.setPreferredSize(new Dimension(160, 38));
        limpiarButton.setPreferredSize(new Dimension(120, 38));
        volverButton.setPreferredSize(new Dimension(120, 38));

        JButton[] botones = {
                buscarButton,
                agregarServicioButton,
                editarDetalleButton,
                eliminarServicioButton,
                verDetalleButton,
                generarFacturaButton,
                limpiarButton,
                volverButton
        };

        for (JButton boton : botones) {
            boton.setFocusPainted(false);
            boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
    }

    private void configurarCampos() {
        // Datos de factura: se generan o cargan desde el sistema
        textField1.setEditable(false);
        textField2.setEditable(false);
        textField3.setEditable(false);

        // Datos del cliente: se cargan al buscar por cédula
        textField5.setEditable(false);
        textField6.setEditable(false);
        textField7.setEditable(false);
        textField8.setEditable(false);

        // Usuario que genera la factura: viene del inicio de sesión
        textField9.setEditable(false);
        textField10.setEditable(false);
        textField11.setEditable(false);

        // Totales: se calculan automáticamente
        textField12.setEditable(false);
        textField13.setEditable(false);
        textField14.setEditable(false);

        limpiarCampos();
    }

    private void configurarTabla() {
        DefaultTableModel modeloTabla = new DefaultTableModel(
                new Object[]{
                        "Código",
                        "Servicio",
                        "Cantidad",
                        "Precio Unitario",
                        "Subtotal",
                        "IVA",
                        "Total"
                },
                0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table1.setModel(modeloTabla);
        table1.setRowHeight(26);
        table1.getTableHeader().setReorderingAllowed(false);
        table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        // Ayuda a que la tabla tenga una altura visual más ordenada
        table1.setPreferredScrollableViewportSize(new Dimension(950, 120));
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
        textField10.setText("");
        textField11.setText("");
        textField12.setText("");
        textField13.setText("");
        textField14.setText("");
    }
}