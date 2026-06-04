package model;

public class Carrera {
    private String codigo;
    private int añoVigencia;
    private String nombre;
    private PlanEstudio plan;

    public int getTotalMaterias() {
        // Implementar lógica para obtener el total de materias
        return 0;
    }

    public PlanEstudio getPlanEstudio() {
        return plan;
    }

    public void setPlanEstudio(PlanEstudio plan) {
        this.plan = plan;
    }
}
