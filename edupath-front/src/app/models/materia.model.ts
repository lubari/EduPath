export type EstadoMateria = 'aprobada' | 'cursando' | 'desaprobada' | 'disponible' | 'proxima';

export interface Materia {
  codigo: string;
  nombre: string;
  anio: number;
  cargaHoraria: number;
  estado: EstadoMateria;
  correlativas: string[]; // códigos de materias correlativas
}
