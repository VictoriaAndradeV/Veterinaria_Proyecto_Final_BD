package org.example.vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AdminListarUsuarios extends JFrame {
    private JPanel panel1;
    private JTextField textField1;
    private JButton buscarButton;
    private JTable table1;
    private JButton listarTodosButton;
    private JButton limpiarButton;
    private JButton volverButton;

    public AdminListarUsuarios() {
        configurarVentana();
        ajustarDiseno();
        configurarTabla();
        configurarEventosBasicos();
    }

    private void configurarVentana() {
        setTitle("Sistema de Gestión Veterinaria - Listado de Usuarios");
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setSize(780, 600);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void ajustarDiseno() {
        // Margen general para que los elementos no queden pegados al borde.
        panel1.setBorder(new EmptyBorder(18, 28, 22, 28));

        // Tamaño del campo de búsqueda.
        textField1.setPreferredSize(new Dimension(500, 30));

        // Tamaño de botones.
        buscarButton.setPreferredSize(new Dimension(110, 35));
        listarTodosButton.setPreferredSize(new Dimension(140, 35));
        limpiarButton.setPreferredSize(new Dimension(110, 35));
        volverButton.setPreferredSize(new Dimension(110, 35));

        JButton[] botones = {
                buscarButton,
                listarTodosButton,
                limpiarButton,
                volverButton
        };

        for (JButton boton : botones) {
            boton.setFocusPainted(false);
            boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
    }

    private void configurarTabla() {
        DefaultTableModel modelo = new DefaultTableModel(
                new Object[]{
                        "Código",
                        "Empleado",
                        "Usuario",
                        "Tipo permiso",
                        "Estado"
                },
                0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table1.setModel(modelo);
        table1.setRowHeight(26);
        table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table1.getTableHeader().setReorderingAllowed(false);
        table1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    }

    private void configurarEventosBasicos() {
        limpiarButton.addActionListener(e -> textField1.setText(""));
        volverButton.addActionListener(e -> dispose());
    }
}