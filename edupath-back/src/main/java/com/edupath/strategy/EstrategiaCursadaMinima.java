package com.edupath.strategy;

import com.edupath.interfaces.IEstrategiaRecomendacion;
import com.edupath.model.Alumno;
import com.edupath.model.PlanEstudio;
import com.edupath.model.Recomendacion;

import java.time.LocalDate;

public class EstrategiaCursadaMinima implements IEstrategiaRecomendacion {

    @Override
    public Recomendacion recomendar(Alumno alumno, PlanEstudio plan) {
        Recomendacion recomendacion = new Recomendacion();
        recomendacion.setMaterias(alumno.getMateriasDisponibles().stream().limit(2).toList());
        recomendacion.setFechaEgresoEstimada(LocalDate.of(2031, 7, 1));
        return recomendacion;
    }
}
