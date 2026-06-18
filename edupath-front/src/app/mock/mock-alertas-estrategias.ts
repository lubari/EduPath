import { Alerta, OpcionEstrategia, TipoEstrategia, Recomendacion } from '../models/plan.model';
import { MOCK_MATERIAS } from './mock-data';

// Simula AlertaService.getAlertas()
export const MOCK_ALERTAS: Alerta[] = [
  {
    id: 'a1',
    tipo: 'warning',
    titulo: 'Correlatividad próxima a vencer',
    mensaje: 'Necesitás aprobar "Análisis Matemático II" para cursar "Probabilidad y Estadística" el año que viene.',
  },
  {
    id: 'a2',
    tipo: 'danger',
    titulo: 'Materia desaprobada',
    mensaje: '"Sistemas y Organizaciones" quedó desaprobada en 2do cuatrimestre 2025. Recomendamos recursarla.',
  },
  {
    id: 'a3',
    tipo: 'info',
    titulo: 'Sincronización pendiente',
    mensaje: 'Tu última sincronización con el sistema UADE fue hace 6 días.',
  },
];

// Simula EstrategiaFactory + cada IEstrategiaRecomendacion.recomendar()
export const MOCK_OPCIONES_ESTRATEGIA: OpcionEstrategia[] = [
  {
    tipo: 'rapida',
    nombre: 'Cursada rápida',
    riesgo: 'Alta',
    descripcion: 'Prioriza cantidad de materias y adelanta el egreso.',
    fechaEgresoEstimada: '2029-12-01',
  },
  {
    tipo: 'minima',
    nombre: 'Cursada mínima',
    riesgo: 'Baja',
    descripcion: 'Reduce riesgo académico y distribuye mejor la carga.',
    fechaEgresoEstimada: '2031-07-01',
  },
  {
    tipo: 'porAnio',
    nombre: 'Materias por año',
    riesgo: 'Media',
    descripcion: 'Ordena la cursada por año sugerido del plan.',
    fechaEgresoEstimada: '2030-07-01',
  },
];

const disponibles = MOCK_MATERIAS.filter(m => m.estado === 'disponible');

// Simula RecomendacionService.generarPlan() para cada estrategia
export const MOCK_RECOMENDACIONES: Record<TipoEstrategia, Recomendacion> = {
  rapida: {
    materias: disponibles, // todas: máxima carga
    aniosCursados: 3,
    fechaEgresoEstimada: '2029-12-01',
  },
  minima: {
    materias: disponibles.slice(0, 2), // pocas materias por cuatrimestre
    aniosCursados: 5,
    fechaEgresoEstimada: '2031-07-01',
  },
  porAnio: {
    materias: disponibles.filter(m => m.anio === 3), // materias del año actual
    aniosCursados: 4,
    fechaEgresoEstimada: '2030-07-01',
  },
};
