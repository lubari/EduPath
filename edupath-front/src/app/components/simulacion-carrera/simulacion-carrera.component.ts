import { Component, EventEmitter, Input, Output } from '@angular/core';
import { CommonModule, DatePipe } from '@angular/common';
import { OpcionEstrategia, Recomendacion, TipoEstrategia } from '../../models/plan.model';

@Component({
  selector: 'app-simulacion-carrera',
  standalone: true,
  imports: [CommonModule, DatePipe],
  templateUrl: './simulacion-carrera.component.html',
  styleUrls: ['./simulacion-carrera.component.css'],
})
export class SimulacionCarreraComponent {
  @Input() opciones: OpcionEstrategia[] = [];
  @Input() seleccionada: TipoEstrategia = 'rapida';
  @Input() recomendacion: Recomendacion | null = null;
  @Input() loading = false;

  @Output() seleccionar = new EventEmitter<TipoEstrategia>();

  riesgoClass(riesgo: string): string {
    switch (riesgo) {
      case 'Alta':
        return 'riesgo-alta';
      case 'Media':
        return 'riesgo-media';
      default:
        return 'riesgo-baja';
    }
  }

  onSeleccionar(tipo: TipoEstrategia): void {
    this.seleccionar.emit(tipo);
  }

  get nombreEstrategiaSeleccionada(): string {
    return this.opciones.find(o => o.tipo === this.seleccionada)?.nombre ?? '';
  }
}
