package model;

public class PlanEstudio {
    private String codigo;
    private int añoVigencia;
    private List<Materia> materias;

     public void getMaterias(List<Materia> materias) {
         // Implementar lógica para obtener las materias del plan de estudio
     }

     public List<Materia> getCorrelativasDe(Materia materia) {
         // Implementar lógica para obtener las correlativas de una materia
         return new ArrayList<>();
     }
}
