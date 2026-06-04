package model;

import java.util.List;

public class Materia {
    private String codigo;
    private String nombre;
    private int anio;
    private String estado;
    private int cargaHoraria;
    private List<Materia> correlativas;

    public Materia(String codigo, String nombre, int anio, String estado, int cargaHoraria, List<Materia> correlativas) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.anio = anio;
        this.estado = estado;
        this.cargaHoraria = cargaHoraria;
        this.correlativas = correlativas;
    }

    public List<Materia> getCorrelativas() {
        // Implementar lógica para obtener las correlativas de la materia
        return correlativas;
    }

    public boolean estaDisponible(List<Materia> aprobadas) {
        // Implementar lógica para verificar si la materia está disponible
        return false;
    }
}
