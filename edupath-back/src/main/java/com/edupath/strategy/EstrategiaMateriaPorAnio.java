package com.edupath.strategy;

import com.edupath.model.Alumno;
import com.edupath.model.Materia;
import com.edupath.model.PlanEstudio;
import com.edupath.model.Recomendacion;

import java.time.LocalDate;
import java.util.List;

public class EstrategiaMateriaPorAnio implements IEstrategiaRecomendacion {

    @Override
    public Recomendacion recomendar(Alumno alumno, PlanEstudio plan) {
        List<Materia> disponibles = alumno.getMateriasDisponibles();
        int anioActual = disponibles.stream()
                .mapToInt(Materia::getAnio)
                .min()
                .orElse(1);
        List<Materia> seleccion = disponibles.stream()
                .filter(m -> m.getAnio() == anioActual)
                .toList();
        return new Recomendacion(seleccion, LocalDate.of(2030, 7, 1));
    }
}
