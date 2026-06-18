import { Materia } from './materia.model';

export interface Recomendacion {
  materias: Materia[];
  fechaEgresoEstimada: string;
}

export interface Alerta {
  tipo: 'warning' | 'danger' | 'info';
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

export interface Estadisticas {
  aprobadas: number;
  totalMaterias: number;
  porcentaje: number;
  promedio: number;
  fechaEgresoEstimada: string;
  estrategia: TipoEstrategia;
}
