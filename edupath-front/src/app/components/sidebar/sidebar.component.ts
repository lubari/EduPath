import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Alumno } from '../../models/alumno.model';
import { Estadisticas } from '../../models/plan.model';

@Component({
  selector: 'app-sidebar',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css'],
})
export class SidebarComponent {
  @Input() alumno: Alumno | null = null;
  @Input() estadisticas: Estadisticas | null = null;

  menuItems = [
    { icon: 'layout-dashboard', label: 'Dashboard' },
    { icon: 'book', label: 'Materias' },
    { icon: 'sparkles', label: 'Recomendación' },
    { icon: 'bell', label: 'Alertas' },
    { icon: 'file-export', label: 'Exportar PDF' },
  ];
}
