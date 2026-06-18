package strategy;

import model.Alumno;
import model.PlanEstudio;
import model.Recomendacion;

public class EstrategiaCursadaMinima implements IEstrategiaRecomendacion {
    @Override
    public Recomendacion recomendar(Alumno alumno, PlanEstudio plan) {
        // Lógica para recomendar materias basándose en la cursada mínima
        // Esto podría incluir:
        // - Identificar las materias obligatorias que el alumno aún no ha cursado
        // - Priorizar materias que son prerequisitos para otras
        // - Considerar la carga horaria y la dificultad de las materias
        // - Evaluar el rendimiento académico del alumno para recomendar materias adecuadas a su nivel

        Recomendacion recomendacion = new Recomendacion();
        // Llenar la recomendación con las materias seleccionadas y la fecha estimada de egreso
        return recomendacion;
    }
}
