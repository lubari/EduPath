package state;

import interfaces.IEstado;

public class EstadoAprobada implements IEstado {
    @Override
    public String getNombre() {
        return "Aprobada";
    }

    @Override
    public boolean estaAprobada() {
        return true;
    }
}
