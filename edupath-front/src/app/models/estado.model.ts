export interface IEstado {
  estaAprobada(): boolean;
  getNombre(): string;
}

export class EstadoAprobada implements IEstado {
  estaAprobada(): boolean { return true; }
  getNombre(): string { return 'Aprobada'; }
}

export class EstadoCursando implements IEstado {
  estaAprobada(): boolean { return false; }
  getNombre(): string { return 'Cursando'; }
}

export class EstadoDesaprobada implements IEstado {
  estaAprobada(): boolean { return false; }
  getNombre(): string { return 'Desaprobada'; }
}
