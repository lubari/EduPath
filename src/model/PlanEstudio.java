package model;

import java.util.ArrayList;
import java.util.List;

public class PlanEstudio {
    private String codigo;
    private int añoVigencia;
    private List<Materia> materias;

     public List<Materia> getCorrelativasDe(Materia materia) {
         // Implementar lógica para obtener las correlativas de una materia
         return new ArrayList<>();
     }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }
}
