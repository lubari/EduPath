package com.edupath.model;

import com.edupath.interfaces.IEstado;

public class RegistroAcademico {
    private Materia materia;
    private String cuatrimestre;
    private int nota;
    private IEstado estado;

    public RegistroAcademico(Materia materia, String cuatrimestre, int nota, IEstado estado) {
        this.materia = materia;
        this.cuatrimestre = cuatrimestre;
        this.nota = nota;
        this.estado = estado;
    }

    public boolean estaAprobada() {
        return estado.estaAprobada();
    }

    public int getNota() { return nota; }
    public Materia getMateria() { return materia; }
    public IEstado getEstado() { return estado; }
    public String getCuatrimestre() { return cuatrimestre; }
}
