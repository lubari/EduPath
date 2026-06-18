package com.edupath.model;

import java.util.List;

public class Alumno {
    private String legajo;
    private String nombre;
    private double promedio;
    private Carrera carrera;
    private List<RegistroAcademico> registros;

    public Alumno(String legajo, String nombre, double promedio, Carrera carrera, List<RegistroAcademico> registros) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.promedio = promedio;
        this.carrera = carrera;
        this.registros = registros;
    }

    public String getLegajo() { return legajo; }
    public String getNombre() { return nombre; }
    public double getPromedio() { return promedio; }
    public Carrera getCarrera() { return carrera; }
    public List<RegistroAcademico> getRegistros() { return registros; }

    public List<Materia> getMateriasAprobadas() {
        return registros.stream()
                .filter(RegistroAcademico::estaAprobada)
                .map(RegistroAcademico::getMateria)
                .toList();
    }

    public List<Materia> getMateriasDisponibles() {
        List<Materia> aprobadas = getMateriasAprobadas();
        List<String> codigosAprobados = aprobadas.stream().map(Materia::getCodigo).toList();
        return carrera.getPlanEstudio().getMaterias().stream()
                .filter(m -> !codigosAprobados.contains(m.getCodigo()))
                .filter(m -> m.estaDisponible(aprobadas))
                .toList();
    }

    public double getPorcentajeAvance() {
        int total = carrera.getTotalMaterias();
        if (total == 0) return 0;
        return Math.round((getCantidadAprobadas() / (double) total) * 100);
    }

    public int getCantidadAprobadas() {
        return getMateriasAprobadas().size();
    }
}
