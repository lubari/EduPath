package model;

import java.time.LocalDate;
import java.util.List;

public class Recomendacion {
    private List<Materia> materias;
    private int aniosCursados;
    private LocalDate fechaEgresoEstimada;

    public List<Materia> getMaterias() {
        return materias;
    }

    public LocalDate getFechaEgresoEstimada() {
        return fechaEgresoEstimada;
    }
}
