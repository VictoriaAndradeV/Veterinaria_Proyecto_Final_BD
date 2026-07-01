package org.example;

import org.example.vista.IniciarSesion;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            IniciarSesion ventana = new IniciarSesion();
            ventana.setVisible(true);
        });
    }
}