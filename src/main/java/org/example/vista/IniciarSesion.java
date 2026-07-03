package org.example.vista;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class IniciarSesion extends JFrame {

    private JPanel panelPrincipal;
    private JPanel panelSuperior;
    private JPanel panelCentral;
    private JPanel panelInferior;
    private JPanel panelImagen;

    private JLabel labelTitulo;
    private JLabel labelInicioSesion;
    private JLabel labelUsuario;
    private JLabel labelContrasenia;

    private JTextField txtUsuario;
    private JPasswordField txtContrasenia;

    private JButton btnIniciarSesion;
    private JButton btnSalir;
    private JButton verButton;

    public IniciarSesion() {
        configurarVentana();
        configurarEstilos();
        configurarEventos();
    }

    private void configurarVentana() {
        setTitle("Sistema de Gestión Veterinaria - Inicio de Sesión");
        setContentPane(panelPrincipal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(780, 670);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void configurarEstilos() {
        ajustarProporciones();
        cargarLogo();
    }

    private void ajustarProporciones() {

        // Tamaño general de cada zona de la ventana
        panelSuperior.setPreferredSize(new Dimension(780, 350));
        panelCentral.setPreferredSize(new Dimension(780, 220));
        panelInferior.setPreferredSize(new Dimension(780, 100));

        // Espacios internos de cada panel
        panelSuperior.setBorder(BorderFactory.createEmptyBorder(35, 0, 20, 0));
        panelCentral.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        panelInferior.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));

        // Tamaño del panel donde va el logo
        panelImagen.setPreferredSize(new Dimension(180, 180));

        // Botones iguales
        Dimension tamanioBotones = new Dimension(140, 32);

        btnIniciarSesion.setPreferredSize(tamanioBotones);
        btnSalir.setPreferredSize(tamanioBotones);

        btnIniciarSesion.setMinimumSize(tamanioBotones);
        btnSalir.setMinimumSize(tamanioBotones);

        btnIniciarSesion.setMaximumSize(tamanioBotones);
        btnSalir.setMaximumSize(tamanioBotones);
    }

    private void cargarLogo() {
        URL urlLogo = getClass().getResource("/imagenes/logo22.png");

        if (urlLogo == null) {
            JOptionPane.showMessageDialog(
                    this,
                    "No se encontró la imagen del logo.\nVerifica que esté en: src/main/resources/imagenes/logo22.png",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        ImageIcon iconoOriginal = new ImageIcon(urlLogo);

        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(
                190,
                190,
                Image.SCALE_SMOOTH
        );

        JLabel labelLogo = new JLabel(new ImageIcon(imagenEscalada));
        labelLogo.setHorizontalAlignment(SwingConstants.CENTER);
        labelLogo.setVerticalAlignment(SwingConstants.CENTER);

        panelImagen.removeAll();
        panelImagen.setLayout(new BorderLayout());
        panelImagen.add(labelLogo, BorderLayout.CENTER);

        panelImagen.revalidate();
        panelImagen.repaint();
    }

    private void configurarEventos() {
        btnSalir.addActionListener(e -> System.exit(0));

    }
}