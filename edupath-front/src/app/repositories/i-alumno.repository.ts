import { Observable } from 'rxjs';
import { Alumno } from '../models/alumno.model';
import { RegistroAcademico } from '../models/registro-academico.model';

export interface IAlumnoRepository {
  buscarPorLegajo(legajo: string): Observable<Alumno>;
  obtenerRegistros(legajo: string): Observable<RegistroAcademico[]>;
}

export const I_ALUMNO_REPOSITORY = 'IAlumnoRepository';
