import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { IAlumnoRepository } from './i-alumno.repository';
import { Alumno } from '../models/alumno.model';
import { RegistroAcademico } from '../models/registro-academico.model';

const API = 'http://localhost:8080/api/plan';

@Injectable({ providedIn: 'root' })
export class UadeAdapter implements IAlumnoRepository {

  constructor(private http: HttpClient) {}

  buscarPorLegajo(legajo: string): Observable<Alumno> {
    return this.http.get<Alumno>(`${API}/${legajo}/alumno`);
  }

  obtenerRegistros(legajo: string): Observable<RegistroAcademico[]> {
    return this.http.get<RegistroAcademico[]>(`${API}/${legajo}/registros`);
  }
}
