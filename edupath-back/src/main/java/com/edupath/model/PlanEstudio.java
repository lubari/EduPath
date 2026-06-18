package com.edupath.model;

import java.util.List;

public class PlanEstudio {
    private String codigo;
    private int anioVigencia;
    private List<Materia> materias;

    public PlanEstudio(String codigo, int anioVigencia, List<Materia> materias) {
        this.codigo = codigo;
        this.anioVigencia = anioVigencia;
        this.materias = materias;
    }

    public String getCodigo() { return codigo; }
    public int getAnioVigencia() { return anioVigencia; }

    public List<Materia> getMaterias() {
        return materias;
    }

    public List<Materia> getCorrelativasDe(Materia materia) {
        return materia.getCorrelativas();
    }
}
