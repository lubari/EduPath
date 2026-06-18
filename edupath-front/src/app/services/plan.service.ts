import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, map } from 'rxjs';

import { UadeAdapter } from '../repositories/uade.adapter';
import { Alumno } from '../models/alumno.model';
import { Materia } from '../models/materia.model';
import { Estadisticas, Recomendacion, Alerta, OpcionEstrategia, TipoEstrategia } from '../models/plan.model';

const API = 'http://localhost:8080/api/plan';

@Injectable({ providedIn: 'root' })
export class PlanService {

  constructor(
    private repo: UadeAdapter,
    private http: HttpClient,
  ) {}

  getAlumno(legajo: string): Observable<Alumno> {
    return this.repo.buscarPorLegajo(legajo);
  }

  getMateriasDisponibles(legajo: string): Observable<Materia[]> {
    return this.http.get<Materia[]>(`${API}/${legajo}/materias`);
  }

  getAlertas(legajo: string): Observable<Alerta[]> {
    return this.http.get<Alerta[]>(`${API}/${legajo}/alertas`);
  }

  getOpcionesEstrategia(): Observable<OpcionEstrategia[]> {
    return this.http.get<OpcionEstrategia[]>(`${API}/estrategias`);
  }

  getEstadisticas(legajo: string, estrategia: TipoEstrategia = 'rapida'): Observable<Estadisticas> {
    return this.repo.buscarPorLegajo(legajo).pipe(
      map(alumno => ({
        aprobadas: alumno.cantidadAprobadas,
        totalMaterias: alumno.carrera.totalMaterias,
        porcentaje: alumno.porcentajeAvance,
        promedio: alumno.promedio,
        fechaEgresoEstimada: '',
        estrategia,
      }))
    );
  }

  simularCarrera(legajo: string, tipo: TipoEstrategia): Observable<Recomendacion> {
    return this.http.post<Recomendacion>(`${API}/${legajo}/simular`, { tipo });
  }

  exportarPDF(legajo: string): Observable<void> {
    return this.http.post<void>(`${API}/${legajo}/exportar-pdf`, {});
  }
}
