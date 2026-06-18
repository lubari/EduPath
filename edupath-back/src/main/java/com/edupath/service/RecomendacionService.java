package com.edupath.service;

import com.edupath.interfaces.IEstrategiaRecomendacion;
import com.edupath.model.Alumno;
import com.edupath.model.Recomendacion;
import com.edupath.strategy.EstrategiaFactory;
import org.springframework.stereotype.Service;

@Service
public class RecomendacionService {

    public Recomendacion generarPlan(Alumno alumno, String tipo) {
        IEstrategiaRecomendacion estrategia = EstrategiaFactory.crear(tipo);
        return estrategia.recomendar(alumno, alumno.getCarrera().getPlanEstudio());
    }
}
