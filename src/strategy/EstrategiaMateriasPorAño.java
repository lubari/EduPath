package strategy;

import model.Alumno;
import model.PlanEstudio;
import model.Recomendacion;

public class EstrategiaMateriasPorAño implements IEstrategiaRecomendacion {
    @Override
    public Recomendacion recomendar(Alumno alumno, PlanEstudio plan) {
        // Lógica para recomendar materias basándose en el año de estudio del alumno
        //  Esto podría incluir:
        // - Identificar el año de estudio actual del alumno
        // - Priorizar materias que son típicamente cursadas en ese año
        // - Considerar la carga horaria y la dificultad de las materias
        // - Evaluar el rendimiento académico del alumno para recomendar materias adecuadas a su nivel

        Recomendacion recomendacion = new Recomendacion();
        // Llenar la recomendación con las materias seleccionadas y la fecha estimada de
        return recomendacion;
    }
}
