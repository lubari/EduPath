package com.edupath.model;

import java.util.List;

public class Materia {
    private String codigo;
    private String nombre;
    private int cargaHoraria;
    private List<Materia> correlativas;
    private int anio;
    private String estado;

    public Materia(String codigo, String nombre, int cargaHoraria, List<Materia> correlativas, int anio, String estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cargaHoraria = cargaHoraria;
        this.correlativas = correlativas;
        this.anio = anio;
        this.estado = estado;
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public int getCargaHoraria() { return cargaHoraria; }
    public int getAnio() { return anio; }
    public String getEstado() { return estado; }

    public List<Materia> getCorrelativas() {
        return correlativas;
    }

    public boolean estaDisponible(List<Materia> aprobadas) {
        List<String> codigosAprobados = aprobadas.stream().map(Materia::getCodigo).toList();
        return correlativas.stream().allMatch(c -> codigosAprobados.contains(c.getCodigo()));
    }
}
