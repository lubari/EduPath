import { Materia } from './materia.model';

export interface RegistroAcademico {
  materia: Materia;
  cuatrimestre: string;
  nota: number;
  estado: 'Aprobada' | 'Cursando' | 'Desaprobada';
}

export interface Alumno {
  legajo: string;
  nombre: string;
  promedio: number;
  carrera: string;
  registros: RegistroAcademico[];
}
