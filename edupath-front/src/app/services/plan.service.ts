import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { delay } from 'rxjs/operators';

import { Alumno } from '../models/alumno.model';
import { Materia } from '../models/materia.model';
import { Estadisticas, Recomendacion, Alerta, OpcionEstrategia, TipoEstrategia } from '../models/plan.model';

import { MOCK_ALUMNO, MOCK_MATERIAS } from '../mock/mock-data';
import { MOCK_ALERTAS, MOCK_OPCIONES_ESTRATEGIA, MOCK_RECOMENDACIONES } from '../mock/mock-alertas-estrategias';

/**
 * Servicio que simula los endpoints expuestos por PlanController.
 * Cuando el back tenga los métodos implementados y un @RestController,
 * reemplazar los `of(...)` por llamadas a HttpClient apuntando a la API real
 * (ej: this.http.get<Alumno>(`/api/plan/${legajo}/alumno`)).
 */
@Injectable({ providedIn: 'root' })
export class PlanService {
  private readonly LATENCY = 300;

  /** Simula IAlumnoRepository.buscarPorLegajo() */
  getAlumno(legajo: string): Observable<Alumno> {
    return of(MOCK_ALUMNO).pipe(delay(this.LATENCY));
  }

  /** Simula RecomendacionService.materiasDisponibles() */
  getMateriasDisponibles(legajo: string): Observable<Materia[]> {
    return of(MOCK_MATERIAS).pipe(delay(this.LATENCY));
  }

  /** Simula RecomendacionService.calcularProgreso() */
  getEstadisticas(legajo: string, estrategia: TipoEstrategia = 'rapida'): Observable<Estadisticas> {
    const aprobadas = MOCK_MATERIAS.filter(m => m.estado === 'aprobada').length;
    const total = MOCK_MATERIAS.length;
    const opcion = MOCK_OPCIONES_ESTRATEGIA.find(o => o.tipo === estrategia)!;

    const stats: Estadisticas = {
      aprobadas,
      totalMaterias: total,
      porcentaje: Math.round((aprobadas / total) * 100),
      promedio: MOCK_ALUMNO.promedio,
      fechaEgresoEstimada: opcion.fechaEgresoEstimada,
      estrategia,
    };
    return of(stats).pipe(delay(this.LATENCY));
  }

  /** Simula PlanController.getAlertas() */
  getAlertas(legajo: string): Observable<Alerta[]> {
    return of(MOCK_ALERTAS).pipe(delay(this.LATENCY));
  }

  /** Simula EstrategiaFactory + opciones disponibles para "Simulación de carrera" */
  getOpcionesEstrategia(): Observable<OpcionEstrategia[]> {
    return of(MOCK_OPCIONES_ESTRATEGIA).pipe(delay(this.LATENCY));
  }

  /** Simula PlanController.simularCarrera(legajo, tipo) */
  simularCarrera(legajo: string, tipo: TipoEstrategia): Observable<Recomendacion> {
    return of(MOCK_RECOMENDACIONES[tipo]).pipe(delay(this.LATENCY));
  }

  /** Simula PlanController.exportarPDF() */
  exportarPDF(legajo: string): Observable<void> {
    return of(void 0).pipe(delay(this.LATENCY));
  }

  /** Simula PlanController.actualizarDatos() / RecomendacionService.sincronizarDatos() */
  sincronizarDatos(legajo: string): Observable<void> {
    return of(void 0).pipe(delay(this.LATENCY));
  }
}
