package adapter;

import interfaces.IAlumnoRepository;
import model.Alumno;
import model.RegistroAcademico;
import service.SistemaUadeAPI;

import java.util.List;

public class UADEAdapter implements IAlumnoRepository {
    private SistemaUadeAPI cliente;

    @Override
    public Alumno buscarPorLegajo(String legajo) {
        // Lógica para adaptar la respuesta del sistema UADE al formato de Alumno
        return null;
    }

    @Override
    public List<RegistroAcademico> obtenerRegistros(String legajo) {
        // Lógica para adaptar la respuesta del sistema UADE al formato de RegistroAcademico
        return List.of();
    }
}
