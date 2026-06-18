package interfaces;

import model.Alumno;
import model.RegistroAcademico;

import java.util.List;

public interface IAlumnoRepository {
    Alumno buscarPorLegajo(String legajo);
    List<RegistroAcademico> obtenerRegistros(String legajo);
}
