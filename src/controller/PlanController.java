package controller;

import interfaces.IAlumnoRepository;
import model.Alerta;
import model.Recomendacion;
import service.AlertaService;
import service.GeneradorPDF;
import service.RecomendacionService;

import java.util.List;

public class PlanController {
    private RecomendacionService service;
    private IAlumnoRepository repo;
    private GeneradorPDF generador;
    private AlertaService alertaService;

    public void actualizarDatos(String legajo){
        return;
    }

    public Recomendacion simularCarrera(String legajo, String tipo) {
        // Implementar lógica para simular la carrera del alumno
        return null;
    }

    public String getEstadisticas(String legajo) {
        // Implementar lógica para obtener estadísticas del alumno
        return "";
    }

    public void exportarPDF(String legajo) {
        // Implementar lógica para exportar el plan de estudio en formato PDF
    }

    public List<Alerta> getAlertas(String legajo) {
        // Implementar lógica para obtener las alertas del alumno
        return null;
    }
}
