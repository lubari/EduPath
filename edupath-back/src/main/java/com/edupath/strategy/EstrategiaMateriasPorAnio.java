package com.edupath.strategy;

import com.edupath.interfaces.IEstrategiaRecomendacion;
import com.edupath.model.Alumno;
import com.edupath.model.Materia;
import com.edupath.model.PlanEstudio;
import com.edupath.model.Recomendacion;

import java.time.LocalDate;
import java.util.List;

public class EstrategiaMateriasPorAnio implements IEstrategiaRecomendacion {

    @Override
    public Recomendacion recomendar(Alumno alumno, PlanEstudio plan) {
        List<Materia> disponibles = alumno.getMateriasDisponibles();
        int anioActual = disponibles.stream().mapToInt(Materia::getAnio).min().orElse(1);
        Recomendacion recomendacion = new Recomendacion();
        recomendacion.setMaterias(disponibles.stream().filter(m -> m.getAnio() == anioActual).toList());
        recomendacion.setFechaEgresoEstimada(LocalDate.of(2030, 7, 1));
        return recomendacion;
    }
}
