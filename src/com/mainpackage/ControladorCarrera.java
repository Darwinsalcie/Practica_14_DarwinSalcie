package com.mainpackage;

//import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ControladorCarrera {
    private List<Carrera> carreras;

    public ControladorCarrera() {
        carreras = new ArrayList<>();
    }

    public void agregarCarrera(String nombre, int id, int cantidadEstudiantes) {
        carreras.add(new Carrera(nombre, id, cantidadEstudiantes));
    }

    public void modificarCarrera(int index, String nombre, int id, int cantidadEstudiantes) {
        if (index >= 0 && index < carreras.size()) {
            Carrera carrera = carreras.get(index);
            carrera.setNombre(nombre);
            carrera.setId(id);
            carrera.setCantidadEstudiantes(cantidadEstudiantes);
        }
    }

    public void eliminarCarrera(int index) {
        if (index >= 0 && index < carreras.size()) {
            carreras.remove(index);
        }
    }

    public List<Carrera> obtenerCarreras() {
        return carreras;
    }

    public Carrera consultarCarrera(int index) {
        if (index >= 0 && index < carreras.size()) {
            return carreras.get(index);
        }
        return null;
    }
}
