package com.mainpackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaCarrera extends JFrame {
    private ControladorCarrera controlador;
    private DefaultListModel<Carrera> modeloListaCarreras;
    private JList<Carrera> listaCarreras;
    private JTextField campoNombre;
    private JTextField campoId;
    private JTextField campoCantidadEstudiantes;

    public VistaCarrera(ControladorCarrera controlador) {
        this.controlador = controlador;

        setTitle("Mantenimiento de Carreras UNAPEC");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        modeloListaCarreras = new DefaultListModel<>();
        listaCarreras = new JList<>(modeloListaCarreras);
        campoNombre = new JTextField(15);
        campoId = new JTextField(5);
        campoCantidadEstudiantes = new JTextField(5);

        JButton botonAgregar = new JButton("Agregar");
        JButton botonModificar = new JButton("Modificar");
        JButton botonEliminar = new JButton("Eliminar");
        JButton botonConsultar = new JButton("Consultar");

        botonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = campoNombre.getText();
                int id = Integer.parseInt(campoId.getText());
                int cantidadEstudiantes = Integer.parseInt(campoCantidadEstudiantes.getText());
                if (!nombre.isEmpty()) {
                    controlador.agregarCarrera(nombre, id, cantidadEstudiantes);
                    actualizarLista();
                    campoNombre.setText("");
                    campoId.setText("");
                    campoCantidadEstudiantes.setText("");
                }
            }
        });

        botonModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = listaCarreras.getSelectedIndex();
                if (index != -1) {
                    String nombre = campoNombre.getText();
                    int id = Integer.parseInt(campoId.getText());
                    int cantidadEstudiantes = Integer.parseInt(campoCantidadEstudiantes.getText());
                    if (!nombre.isEmpty()) {
                        controlador.modificarCarrera(index, nombre, id, cantidadEstudiantes);
                        actualizarLista();
                        campoNombre.setText("");
                        campoId.setText("");
                        campoCantidadEstudiantes.setText("");
                    }
                }
            }
        });

        botonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = listaCarreras.getSelectedIndex();
                if (index != -1) {
                    controlador.eliminarCarrera(index);
                    actualizarLista();
                }
            }
        });

        // **Cambios aquí**
        botonConsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = listaCarreras.getSelectedIndex();
                if (index != -1) {
                    Carrera carrera = controlador.consultarCarrera(index);
                    JOptionPane.showMessageDialog(VistaCarrera.this, 
                        "Nombre: " + carrera.getNombre() + "\n" +
                        "ID: " + carrera.getId() + "\n" +
                        "Cantidad de Estudiantes: " + carrera.getCantidadEstudiantes(),
                        "Información de Carrera",
                        JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(VistaCarrera.this,
                        "Por favor, seleccione una carrera para consultar.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(new JScrollPane(listaCarreras), BorderLayout.CENTER);

        JPanel panelCampos = new JPanel();
        panelCampos.setLayout(new GridLayout(4, 2));
        panelCampos.add(new JLabel("Nombre:"));
        panelCampos.add(campoNombre);
        panelCampos.add(new JLabel("ID:"));
        panelCampos.add(campoId);
        panelCampos.add(new JLabel("Cantidad de Estudiantes:"));
        panelCampos.add(campoCantidadEstudiantes);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout()); // Añadir layout para el panel de botones
        panelBotones.add(botonAgregar);
        panelBotones.add(botonModificar);
        panelBotones.add(botonEliminar);
        panelBotones.add(botonConsultar);

        panel.add(panelCampos, BorderLayout.NORTH);
        panel.add(panelBotones, BorderLayout.SOUTH);

        add(panel);
    }

    private void actualizarLista() {
        modeloListaCarreras.clear();
        for (Carrera carrera : controlador.obtenerCarreras()) {
            modeloListaCarreras.addElement(carrera);
        }
    }
}
