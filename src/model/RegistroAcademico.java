package model;

import interfaces.IEstado;

public class RegistroAcademico {
    private Materia materia;
    private String cuatrimestre;
    private int nota;
    private IEstado estado;

    public boolean estaAprobada() {
        // Implementar lógica para verificar si la materia está aprobada
        return false;
    }

    public int getNota() {
        return nota;
    }

    public Materia getMateria() {
        return materia;
    }
}
