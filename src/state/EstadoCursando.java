package state;

public class EstadoCursando implements IEstado {
    @Override
    public String getNombre() {
        return "Cursando";
    }

    @Override
    public boolean estaAprobada() {
        return false;
    }
}
