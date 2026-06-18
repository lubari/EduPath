package com.edupath.model;

import java.time.LocalDate;
import java.util.List;

public class Recomendacion {
    private List<Materia> materias;
    private LocalDate fechaEgresoEstimada;

    public Recomendacion() {}

    public Recomendacion(List<Materia> materias, LocalDate fechaEgresoEstimada) {
        this.materias = materias;
        this.fechaEgresoEstimada = fechaEgresoEstimada;
    }

    public List<Materia> getMaterias() { return materias; }
    public LocalDate getFechaEgresoEstimada() { return fechaEgresoEstimada; }
    public void setMaterias(List<Materia> materias) { this.materias = materias; }
    public void setFechaEgresoEstimada(LocalDate fecha) { this.fechaEgresoEstimada = fecha; }
}
