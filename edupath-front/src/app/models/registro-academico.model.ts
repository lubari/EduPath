import { Materia } from './materia.model';

export interface Estado {
  nombre: string;
  aprobada: boolean;
}

export interface RegistroAcademico {
  materia: Materia;
  cuatrimestre: string;
  nota: number;
  estado: Estado;
  aprobada: boolean;
}
