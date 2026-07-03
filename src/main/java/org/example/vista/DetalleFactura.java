package org.example.vista;

import javax.swing.*;

public class DetalleFactura extends JFrame {
    private JPanel panelPrincipal;
    private JPanel panelTitulo;
    private JTextField txfCodigo;
    private JTextField txfCantidad;
    private JTextField txfPrecioUnitario;
    private JPanel panelTotal;
    private JTextField txfSubtotal;
    private JTextField txfIVA;
    private JTextField txfTotal;
    private JButton volverButton;
    private JButton gestionDeServiciosButton;

    public DetalleFactura() {
        setTitle("Detalle de Factura");
        setContentPane(panelPrincipal);
        setSize(750, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        volverButton.addActionListener(e -> {
            ListadoYAnulacionFac listado = new ListadoYAnulacionFac();
            listado.setVisible(true);
            dispose();
        });

        gestionDeServiciosButton.addActionListener(e -> {
            GestionServicios gestionServicios = new GestionServicios();
            gestionServicios.setVisible(true);
            dispose();
        });
    }
}