package org.example.vista;

import javax.swing.*;

public class ListadoYAnulacionFac extends JFrame {
    private JPanel panelPrincipal;
    private JPanel panelDatos;
    private JTextField txfCliente;
    private JTextField txfFecha;
    private JTextField txfEstado;
    private JButton btnVerDetalle;
    private JButton btnAnular;
    private JButton btnLimpiar;
    private JPanel panelTabla;
    private JPanel panelBuscar;
    private JTextField txfBuscar;
    private JButton btnBuscar;
    private JButton btnVolver;
    private JTable tablaDatosFactura;

    public ListadoYAnulacionFac() {
        setTitle("Listado y Anulación de Facturas");
        setContentPane(panelPrincipal);
        setSize(900, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnVolver.addActionListener(e -> {
            VistaAdmin vistaAdmin = new VistaAdmin();
            vistaAdmin.setVisible(true);
            dispose();
        });

        btnVerDetalle.addActionListener(e -> {
            DetalleFactura detalleFactura = new DetalleFactura();
            detalleFactura.setVisible(true);
            dispose();
        });

        btnAnular.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Factura anulada");
        });

        btnLimpiar.addActionListener(e -> {
            txfCliente.setText("");
            txfFecha.setText("");
            txfEstado.setText("");
            txfBuscar.setText("");
        });

        btnBuscar.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Buscando factura...");
        });
    }
}