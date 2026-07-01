package org.example.vista;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

    public IniciarSesion() {
        configurarVentana();
        configurarEstilos();
        configurarEventos();
    }

    private void configurarVentana() {
        setTitle("Sistema de Gestión Veterinaria - Inicio de Sesión");
        setContentPane(panelPrincipal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Tamaño más cómodo para que no se vea apretado.
        setSize(780, 570);

        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void configurarEstilos() {
        /*
         * PALETA BASADA EN LA IMAGEN DE REFERENCIA
         * Crema + amarillo pastel + lila suave + texto oscuro.
         */
        Color fondoCrema = new Color(255, 250, 232);        // Fondo general
        Color fondoCampo = new Color(255, 253, 245);        // Campos de texto
        Color amarilloPastel = new Color(246, 211, 74);     // Botón iniciar sesión
        Color amarilloHover = new Color(238, 198, 45);      // Hover botón iniciar
        Color lilaClaro = new Color(238, 232, 255);         // Panel central
        Color lilaPastel = new Color(202, 190, 239);        // Borde panel central
        Color textoOscuro = new Color(28, 28, 28);          // Texto principal
        Color textoSecundario = new Color(75, 75, 75);      // Texto secundario
        Color bordeCampo = new Color(222, 216, 196);        // Borde campos
        Color rojoSalir = new Color(221, 83, 83);           // Botón salir
        Color rojoSalirHover = new Color(198, 65, 65);      // Hover salir

        // Fondo uniforme de toda la ventana.
        panelPrincipal.setBackground(fondoCrema);
        panelSuperior.setBackground(fondoCrema);
        panelCentral.setBackground(lilaClaro);
        panelInferior.setBackground(fondoCrema);
        panelImagen.setBackground(fondoCrema);

        // Márgenes generales.
        panelPrincipal.setBorder(new EmptyBorder(25, 45, 25, 45));
        panelSuperior.setBorder(new EmptyBorder(5, 0, 12, 0));
        panelInferior.setBorder(new EmptyBorder(12, 0, 5, 0));

        // Panel central tipo tarjeta suave.
        panelCentral.setBorder(new CompoundBorder(
                new LineBorder(lilaPastel, 1, true),
                new EmptyBorder(18, 130, 18, 130)
        ));

        // Título principal.
        labelTitulo.setText("Sistema de Gestión Veterinaria");
        labelTitulo.setForeground(textoOscuro);
        labelTitulo.setFont(new Font("Segoe UI", Font.BOLD, 31));
        labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);

        // Subtítulo.
        labelInicioSesion.setText("Inicio de Sesión");
        labelInicioSesion.setForeground(textoOscuro);
        labelInicioSesion.setFont(new Font("Segoe UI", Font.BOLD, 24));
        labelInicioSesion.setHorizontalAlignment(SwingConstants.CENTER);

        // Etiquetas.
        labelUsuario.setForeground(textoOscuro);
        labelUsuario.setFont(new Font("Segoe UI", Font.BOLD, 16));

        labelContrasenia.setForeground(textoOscuro);
        labelContrasenia.setFont(new Font("Segoe UI", Font.BOLD, 16));

        // Campos.
        configurarCampo(txtUsuario, fondoCampo, bordeCampo, textoSecundario);
        configurarCampo(txtContrasenia, fondoCampo, bordeCampo, textoSecundario);

        // Botones.
        configurarBoton(btnIniciarSesion, amarilloPastel, amarilloHover, textoOscuro);
        configurarBoton(btnSalir, rojoSalir, rojoSalirHover, Color.WHITE);

        // Logo.
        cargarLogo();
    }

    private void configurarCampo(JTextField campo, Color fondo, Color borde, Color texto) {
        campo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        campo.setPreferredSize(new Dimension(390, 40));
        campo.setMinimumSize(new Dimension(390, 40));
        campo.setMaximumSize(new Dimension(390, 40));

        campo.setBackground(fondo);
        campo.setForeground(texto);
        campo.setCaretColor(new Color(28, 28, 28));
        campo.setOpaque(true);

        campo.setBorder(new CompoundBorder(
                new LineBorder(borde, 1, true),
                new EmptyBorder(7, 12, 7, 12)
        ));
    }

    private void configurarBoton(JButton boton, Color fondo, Color fondoHover, Color texto) {
        boton.setPreferredSize(new Dimension(190, 43));
        boton.setMinimumSize(new Dimension(190, 43));
        boton.setMaximumSize(new Dimension(190, 43));

        boton.setBackground(fondo);
        boton.setForeground(texto);
        boton.setFont(new Font("Segoe UI", Font.BOLD, 15));

        boton.setFocusPainted(false);
        boton.setBorderPainted(false);
        boton.setContentAreaFilled(true);
        boton.setOpaque(true);
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        boton.setBorder(new EmptyBorder(9, 18, 9, 18));

        // Efecto visual al pasar el mouse.
        boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                boton.setBackground(fondoHover);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                boton.setBackground(fondo);
            }
        });
    }

    private void cargarLogo() {
        URL urlLogo = getClass().getResource("/imagenes/logo.png");

        if (urlLogo == null) {
            JOptionPane.showMessageDialog(
                    this,
                    "No se encontró la imagen del logo.\nVerifica que esté en: src/main/resources/imagenes/logo.png",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        ImageIcon iconoOriginal = new ImageIcon(urlLogo);

        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(
                120,
                120,
                Image.SCALE_SMOOTH
        );

        JLabel labelLogo = new JLabel(new ImageIcon(imagenEscalada));
        labelLogo.setHorizontalAlignment(SwingConstants.CENTER);
        labelLogo.setVerticalAlignment(SwingConstants.CENTER);

        panelImagen.removeAll();
        panelImagen.setLayout(new BorderLayout());
        panelImagen.setBackground(new Color(255, 250, 232));
        panelImagen.add(labelLogo, BorderLayout.CENTER);

        panelImagen.revalidate();
        panelImagen.repaint();
    }

    private void configurarEventos() {
        btnSalir.addActionListener(e -> System.exit(0));

        btnIniciarSesion.addActionListener(e -> {
            String usuario = txtUsuario.getText().trim();
            String contrasenia = new String(txtContrasenia.getPassword()).trim();

            if (usuario.isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Debe ingresar el usuario.",
                        "Campo obligatorio",
                        JOptionPane.WARNING_MESSAGE
                );
                txtUsuario.requestFocus();
                return;
            }

            if (contrasenia.isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Debe ingresar la contraseña.",
                        "Campo obligatorio",
                        JOptionPane.WARNING_MESSAGE
                );
                txtContrasenia.requestFocus();
                return;
            }

            JOptionPane.showMessageDialog(
                    this,
                    "Validando credenciales del usuario...",
                    "Inicio de sesión",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });
    }
}