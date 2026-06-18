import { Materia } from './materia.model';

export interface Estadisticas {
  aprobadas: number;
  totalMaterias: number;
  porcentaje: number;
  promedio: number;
  fechaEgresoEstimada: string; // ISO date string
  estrategia: TipoEstrategia;
}

export interface Recomendacion {
  materias: Materia[];
  aniosCursados: number;
  fechaEgresoEstimada: string; // ISO date string
}

export interface Alerta {
  id: string;
  tipo: 'warning' | 'danger' | 'info';
  titulo: string;
  mensaje: string;
}

export type TipoEstrategia = 'rapida' | 'minima' | 'porAnio';

export interface OpcionEstrategia {
  tipo: TipoEstrategia;
  nombre: string;
  riesgo: 'Alta' | 'Media' | 'Baja';
  descripcion: string;
  fechaEgresoEstimada: string;
}
