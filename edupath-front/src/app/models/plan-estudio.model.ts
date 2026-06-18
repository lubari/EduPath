import { Materia } from './materia.model';

export interface PlanEstudio {
  codigo: string;
  anioVigencia: number;
  materias: Materia[];
}