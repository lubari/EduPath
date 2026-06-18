package interfaces;

import model.Alumno;
import model.PlanEstudio;
import model.Recomendacion;

public interface IEstrategiaRecomendacion {
    Recomendacion recomendar(Alumno alumno, PlanEstudio plan);
}
