package com.edupath.controller;

import com.edupath.interfaces.IAlumnoRepository;
import com.edupath.model.Alerta;
import com.edupath.model.Alumno;
import com.edupath.model.Materia;
import com.edupath.model.OpcionEstrategia;
import com.edupath.model.Recomendacion;
import com.edupath.service.AlertaService;
import com.edupath.service.GeneradorPDF;
import com.edupath.service.RecomendacionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/plan")
@CrossOrigin(origins = "*")
public class PlanController {

    private final RecomendacionService service;
    private final IAlumnoRepository repo;
    private final GeneradorPDF generador;
    private final AlertaService alertaService;

    public PlanController(RecomendacionService service, IAlumnoRepository repo,
                          GeneradorPDF generador, AlertaService alertaService) {
        this.service = service;
        this.repo = repo;
        this.generador = generador;
        this.alertaService = alertaService;
    }

    @GetMapping("/{legajo}/alumno")
    public Alumno getAlumno(@PathVariable String legajo) {
        return repo.buscarPorLegajo(legajo);
    }

    @GetMapping("/{legajo}/materias")
    public List<Materia> getMateriasDisponibles(@PathVariable String legajo) {
        return repo.buscarPorLegajo(legajo).getMateriasDisponibles();
    }

    @GetMapping("/{legajo}/alertas")
    public List<Alerta> getAlertas(@PathVariable String legajo) {
        return alertaService.getAlertas(repo.buscarPorLegajo(legajo));
    }

    @PostMapping("/{legajo}/simular")
    public Recomendacion simularCarrera(@PathVariable String legajo,
                                        @RequestBody Map<String, String> body) {
        Alumno alumno = repo.buscarPorLegajo(legajo);
        return service.generarPlan(alumno, body.get("tipo"));
    }

    @PostMapping("/{legajo}/exportar-pdf")
    public void exportarPDF(@PathVariable String legajo) {
        Alumno alumno = repo.buscarPorLegajo(legajo);
        Recomendacion rec = service.generarPlan(alumno, "rapida");
        generador.generarPDF(rec);
    }

    @GetMapping("/estrategias")
    public List<OpcionEstrategia> getEstrategias() {
        return List.of(
            new OpcionEstrategia("rapida",  "Cursada rápida",   "Alta",  "Prioriza cantidad de materias y adelanta el egreso.",        "2029-12-01"),
            new OpcionEstrategia("minima",  "Cursada mínima",   "Baja",  "Reduce riesgo académico y distribuye mejor la carga.",       "2031-07-01"),
            new OpcionEstrategia("porAnio", "Materias por año", "Media", "Ordena la cursada por año sugerido del plan.",               "2030-07-01")
        );
    }

    public String getEstadisticas(String legajo) {
        Alumno alumno = repo.buscarPorLegajo(legajo);
        return "Aprobadas: " + alumno.getCantidadAprobadas() +
               " | Avance: " + alumno.getPorcentajeAvance() + "%" +
               " | Promedio: " + alumno.getPromedio();
    }
}
