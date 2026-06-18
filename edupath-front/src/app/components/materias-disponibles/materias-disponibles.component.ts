import { Component, Input, OnChanges } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Materia } from '../../models/materia.model';

const ESTADO_LABELS: Record<string, string> = {
  disponible:  'Disponible',
  proxima:     'Próxima',
  cursando:    'Cursando',
  aprobada:    'Aprobada',
  desaprobada: 'Desaprobada',
};

@Component({
  selector: 'app-materias-disponibles',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './materias-disponibles.component.html',
  styleUrls: ['./materias-disponibles.component.css'],
})
export class MateriasDisponiblesComponent implements OnChanges {
  @Input() materias: Materia[] = [];

  busqueda = '';
  materiasFiltradas: Materia[] = [];

  ngOnChanges(): void {
    this.filtrar();
  }

  filtrar(): void {
    const visibles = this.materias.filter(m => m.estado === 'disponible' || m.estado === 'proxima');
    const term = this.busqueda.trim().toLowerCase();
    this.materiasFiltradas = term
      ? visibles.filter(m => m.nombre.toLowerCase().includes(term))
      : visibles;
  }

  estadoLabel(estado: string): string {
    return ESTADO_LABELS[estado] ?? estado;
  }

  verDetalle(materia: Materia): void {
    console.log('Ver detalle de', materia.nombre);
  }
}
