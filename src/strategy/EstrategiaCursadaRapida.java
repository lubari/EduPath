package strategy;

import model.Alumno;
import model.PlanEstudio;
import model.Recomendacion;

public class EstrategiaCursadaRapida implements IEstrategiaRecomendacion {
        @Override
        public Recomendacion recomendar(Alumno alumno, PlanEstudio plan) {
            // Lógica para recomendar materias basándose en la cursada rápida
            // Esto podría incluir:
            // - Identificar las materias que el alumno ya ha cursado y aprobado
            // - Priorizar materias que el alumno puede cursar simultáneamente sin sobrecargar su carga horaria
            // - Considerar la posibilidad de cursar materias optativas o electivas que puedan ser aprobadas rápidamente
            // - Evaluar el rendimiento académico del alumno para recomendar materias que se ajusten a su nivel y ritmo de aprendizaje

            Recomendacion recomendacion = new Recomendacion();
            // Llenar la recomendación con las materias seleccionadas y la fecha estimada de egreso
            return recomendacion;
        }
}
