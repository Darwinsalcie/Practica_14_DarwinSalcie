package com.mainpackage;

public class Carrera {
    private String nombre;
    private int id;
    private int cantidadEstudiantes;

    public Carrera(String nombre, int id, int cantidadEstudiantes) {
        this.nombre = nombre;
        this.id = id;
        this.cantidadEstudiantes = cantidadEstudiantes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidadEstudiantes() {
        return cantidadEstudiantes;
    }

    public void setCantidadEstudiantes(int cantidadEstudiantes) {
        this.cantidadEstudiantes = cantidadEstudiantes;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
