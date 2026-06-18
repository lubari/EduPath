import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PlanService } from '../../services/plan.service';
import { Alumno } from '../../models/alumno.model';
import { Materia } from '../../models/materia.model';
import { Estadisticas, Alerta, OpcionEstrategia, Recomendacion, TipoEstrategia } from '../../models/plan.model';

import { SidebarComponent } from '../sidebar/sidebar.component';
import { MateriasDisponiblesComponent } from '../materias-disponibles/materias-disponibles.component';
import { SimulacionCarreraComponent } from '../simulacion-carrera/simulacion-carrera.component';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [CommonModule, SidebarComponent, MateriasDisponiblesComponent, SimulacionCarreraComponent],
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css'],
})
export class DashboardComponent implements OnInit {
  alumno: Alumno | null = null;
  materias: Materia[] = [];
  estadisticas: Estadisticas | null = null;
  alertas: Alerta[] = [];
  opcionesEstrategia: OpcionEstrategia[] = [];
  recomendacion: Recomendacion | null = null;

  estrategiaSeleccionada: TipoEstrategia = 'rapida';
  loadingSimulacion = false;
  exportando = false;

  constructor(private planService: PlanService) {}

  ngOnInit(): void {
    const legajo = '123456'; // En un caso real vendría de auth/sesión

    this.planService.getAlumno(legajo).subscribe(alumno => (this.alumno = alumno));
    this.planService.getMateriasDisponibles(legajo).subscribe(materias => (this.materias = materias));
    this.planService.getAlertas(legajo).subscribe(alertas => (this.alertas = alertas));
    this.planService.getOpcionesEstrategia().subscribe(opciones => (this.opcionesEstrategia = opciones));

    this.cargarEstadisticas(legajo);
    this.simular(legajo, this.estrategiaSeleccionada);
  }

  private cargarEstadisticas(legajo: string): void {
    this.planService.getEstadisticas(legajo, this.estrategiaSeleccionada).subscribe(stats => (this.estadisticas = stats));
  }

  onSeleccionarEstrategia(tipo: TipoEstrategia): void {
    this.estrategiaSeleccionada = tipo;
    const legajo = this.alumno?.legajo ?? '123456';
    this.cargarEstadisticas(legajo);
    this.simular(legajo, tipo);
  }

  private simular(legajo: string, tipo: TipoEstrategia): void {
    this.loadingSimulacion = true;
    this.planService.simularCarrera(legajo, tipo).subscribe(rec => {
      this.recomendacion = rec;
      this.loadingSimulacion = false;
    });
  }

  exportarPDF(): void {
    const legajo = this.alumno?.legajo ?? '123456';
    this.exportando = true;
    this.planService.exportarPDF(legajo).subscribe(() => {
      this.exportando = false;
      console.log('PDF exportado (mock)');
    });
  }

  generarSimulacion(): void {
    const legajo = this.alumno?.legajo ?? '123456';
    this.simular(legajo, this.estrategiaSeleccionada);
  }
}
