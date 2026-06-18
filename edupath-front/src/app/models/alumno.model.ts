import { Carrera } from './carrera.model';
import { RegistroAcademico } from './registro-academico.model';
import { Materia } from './materia.model';

export interface Alumno {
  legajo: string;
  nombre: string;
  promedio: number;
  carrera: Carrera;
  registros: RegistroAcademico[];
  materiasAprobadas: Materia[];
  materiasDisponibles: Materia[];
  porcentajeAvance: number;
  cantidadAprobadas: number;
}
