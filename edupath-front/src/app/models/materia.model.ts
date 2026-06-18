export type EstadoMateria = 'aprobada' | 'cursando' | 'desaprobada' | 'disponible' | 'proxima';

export interface Materia {
  codigo: string;
  nombre: string;
  cargaHoraria: number;
  correlativas: Materia[];
  anio: number;
  estado: EstadoMateria;
}
