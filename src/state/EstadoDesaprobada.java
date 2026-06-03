package state;

import interfaces.IEstado;

public class EstadoDesaprobada implements IEstado {
    @Override
    public String getNombre() {
        return "Desaprobada";
    }

    @Override
    public boolean estaAprobada() {
        return false;
    }
}
