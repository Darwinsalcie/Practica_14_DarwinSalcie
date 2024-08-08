package com.mainpackage;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ControladorCarrera controlador = new ControladorCarrera();
                new VistaCarrera(controlador).setVisible(true);
            }
        });
    }
}
