package service;

import model.Alumno;
import model.Estadisticas;
import model.Materia;
import model.Recomendacion;

import java.util.List;

public class RecomendacionService {
    private EstrategiaFactory estrategiaFactory;

    public Recomendacion generarPlan(Alumno alumno){
        // Implementar lógica para generar un plan de estudio basado en el alumno
        return null;
    }

    public Estadisticas calcularProgreso(String legajo){
        return null;
    }

    public List<Materia> materiasDisponibles(String legajo){
        return null;
    }

    public void sincronizarDatos(String legajo){
        return;
    }
}
