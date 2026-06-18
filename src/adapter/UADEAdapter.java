package adapter;

import model.IAlumnoRepository;
import model.Alumno;
import model.RegistroAcademico;
import service.SistemaUadeAPI;

import java.util.List;

public class UADEAdapter implements IAlumnoRepository {
    private SistemaUadeAPI cliente;

    @Override
    public Alumno buscarPorLegajo(String legajo) {
        // Lógica para adaptar la respuesta del sistema UADE al formato de Alumno
        var datosAlumnoAPI = cliente.obtenerDatosEstudiante(legajo);
        return MapToDomain(datosAlumnoAPI);
    }

    @Override
    public List<RegistroAcademico> obtenerRegistros(String legajo) {
        // Lógica para adaptar la respuesta del sistema UADE al formato de RegistroAcademico
        return List.of();
    }
}
