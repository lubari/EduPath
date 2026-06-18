import { PlanEstudio } from './plan-estudio.model';

export interface Carrera {
  codigo: string;
  anioVigencia: number;
  nombre: string;
  planEstudio: PlanEstudio;
  totalMaterias: number;
}