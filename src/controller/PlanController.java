package controller;

import model.Alumno;
import model.IAlumnoRepository;
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

    public PlanController(RecomendacionService service, IAlumnoRepository repo, GeneradorPDF generador, AlertaService alertaService) {
        this.service = service;
        this.repo = repo;
        this.generador = generador;
        this.alertaService = alertaService;
    }


    public void actualizarDatos(String legajo){
        if(legajo == null || legajo.isEmpty()) return;

        Alumno alumno = repo.buscarPorLegajo(legajo);
        service.sincronizarDatos(legajo);
    }

    public Recomendacion simularCarrera(String legajo, String tipo) {
        if(legajo == null || legajo.isEmpty()) return null;
        Alumno alumno = repo.buscarPorLegajo(legajo);

        if (alumno == null) return null;

        return service.generarPlan(alumno);
    }

    public String getEstadisticas(String legajo) {
        if (legajo == null) return "";
        Alumno alumno = repo.buscarPorLegajo(legajo);

        if (alumno == null) return "Alumno no encontrado";

        return "Progreso: " + alumno.getPorcentajeAvance() + "% | Materias Aprobadas: " + alumno.getCantidadMateriasAprobadas();
    }

    public void exportarPDF(String legajo) {
        if (legajo == null) return;
        Alumno alumno = repo.buscarPorLegajo(legajo);
        Recomendacion recomendacion= service.generarPlan(alumno);
        if (alumno != null){
            generador.generarPDF(recomendacion);
        }
    }

    public List<Alerta> getAlertas(String legajo) {
        if (legajo == null) return null;
        Alumno alumno = repo.buscarPorLegajo(legajo);
        if (alumno == null) return null;
        return alertaService.getAlertas(alumno);
    }
}
