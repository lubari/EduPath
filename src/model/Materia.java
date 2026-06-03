package model;

import java.util.List;

public class Materia {
    private String codigo;
    private String nombre;
    private int cargoHoraria;
    private List<Materia> correlativas;

    public List<Materia> getCorrelativas() {
        // Implementar lógica para obtener las correlativas de la materia
        return correlativas;
    }

    public boolean estaDisponible(List<Materia> aprobadas) {
        // Implementar lógica para verificar si la materia está disponible
        return false;
    }
}
