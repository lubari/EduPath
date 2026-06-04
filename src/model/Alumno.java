package model;

import java.util.ArrayList;
import java.util.List;

public class Alumno {
    private String legajo;
    private String nombre;
    private double promedio;
    private Carrera carrera;
    private List<RegistroAcademico> registros;

    public Alumno(String legajo, String nombre, double promedio, Carrera carrera, List<RegistroAcademico> registros){
        this.legajo = legajo;
        this.nombre = nombre;
        this.promedio = promedio;
        this.carrera = carrera;
        this.registros = (registros != null) ? new ArrayList<>(registros) : new ArrayList<>();
    }

    public void getMateriasAprobadas(List<Materia> materias) {
        // Implementar lógica para obtener las materias aprobadas
    }

    public void getMateriasDisponibles(List<Materia> materias) {
        // Implementar lógica para obtener las materias disponibles
    }

    public double getPorcentajeAvance(){
        // Implementar lógica para calcular el porcentaje de avance
        return 0.0;
    }

    public int getCantidadMateriasAprobadas(){
        // Implementar lógica para contar la cantidad de materias aprobadas
        return 0;
    }

    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }
}
