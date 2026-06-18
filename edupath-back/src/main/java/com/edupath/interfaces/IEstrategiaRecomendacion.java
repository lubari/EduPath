package com.edupath.interfaces;

import com.edupath.model.Alumno;
import com.edupath.model.PlanEstudio;
import com.edupath.model.Recomendacion;

public interface IEstrategiaRecomendacion {
    Recomendacion recomendar(Alumno alumno, PlanEstudio plan);
}
