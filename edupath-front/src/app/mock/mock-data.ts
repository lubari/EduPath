import { Alumno } from '../models/alumno.model';
import { Materia } from '../models/materia.model';

// Catálogo de materias (simula PlanEstudio.getMaterias())
export const MOCK_MATERIAS: Materia[] = [
  { codigo: 'IS-101', nombre: 'Análisis Matemático I', anio: 1, cargaHoraria: 64, estado: 'aprobada', correlativas: [] },
  { codigo: 'IS-102', nombre: 'Programación I', anio: 1, cargaHoraria: 64, estado: 'aprobada', correlativas: [] },
  { codigo: 'IS-103', nombre: 'Inglés I', anio: 1, cargaHoraria: 32, estado: 'aprobada', correlativas: [] },
  { codigo: 'IS-201', nombre: 'Análisis Matemático II', anio: 2, cargaHoraria: 64, estado: 'aprobada', correlativas: ['IS-101'] },
  { codigo: 'IS-202', nombre: 'Programación II', anio: 2, cargaHoraria: 64, estado: 'aprobada', correlativas: ['IS-102'] },
  { codigo: 'IS-203', nombre: 'Base de Datos', anio: 2, cargaHoraria: 64, estado: 'aprobada', correlativas: ['IS-202'] },
  { codigo: 'IS-204', nombre: 'Sistemas y Organizaciones', anio: 2, cargaHoraria: 48, estado: 'desaprobada', correlativas: [] },
  { codigo: 'IS-301', nombre: 'Arquitectura de Software', anio: 3, cargaHoraria: 64, estado: 'disponible', correlativas: ['IS-203'] },
  { codigo: 'IS-302', nombre: 'Programación III', anio: 3, cargaHoraria: 64, estado: 'disponible', correlativas: ['IS-202'] },
  { codigo: 'IS-303', nombre: 'Probabilidad y Estadística', anio: 3, cargaHoraria: 64, estado: 'disponible', correlativas: ['IS-201'] },
  { codigo: 'IS-304', nombre: 'Inglés IV', anio: 3, cargaHoraria: 32, estado: 'disponible', correlativas: ['IS-103'] },
  { codigo: 'IS-305', nombre: 'Redes II', anio: 3, cargaHoraria: 64, estado: 'disponible', correlativas: ['IS-203'] },
  { codigo: 'IS-401', nombre: 'Ingeniería de Requerimientos', anio: 4, cargaHoraria: 48, estado: 'disponible', correlativas: ['IS-301', 'IS-303', 'IS-204'] },
  { codigo: 'IS-402', nombre: 'Proyecto Final', anio: 4, cargaHoraria: 96, estado: 'proxima', correlativas: ['IS-301', 'IS-302', 'IS-305', 'IS-401'] },
];

// Simula la respuesta de IAlumnoRepository.buscarPorLegajo()
export const MOCK_ALUMNO: Alumno = {
  legajo: '123456',
  nombre: 'Juan Pérez',
  promedio: 7.9,
  carrera: 'Ingeniería en Sistemas',
  registros: MOCK_MATERIAS
    .filter(m => m.estado === 'aprobada' || m.estado === 'desaprobada')
    .map(m => ({
      materia: m,
      cuatrimestre: '1C2025',
      nota: m.estado === 'aprobada' ? 8 : 3,
      estado: m.estado === 'aprobada' ? 'Aprobada' : 'Desaprobada',
    })),
};
