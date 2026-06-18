package com.edupath.model;

public class Carrera {
    private String codigo;
    private int anioVigencia;
    private String nombre;
    private PlanEstudio plan;

    public Carrera(String codigo, int anioVigencia, String nombre, PlanEstudio plan) {
        this.codigo = codigo;
        this.anioVigencia = anioVigencia;
        this.nombre = nombre;
        this.plan = plan;
    }

    public String getCodigo() { return codigo; }
    public int getAnioVigencia() { return anioVigencia; }
    public String getNombre() { return nombre; }

    public PlanEstudio getPlanEstudio() {
        return plan;
    }

    public int getTotalMaterias() {
        return plan.getMaterias().size();
    }
}
