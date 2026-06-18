package com.edupath.interfaces;

import com.edupath.model.Alumno;
import com.edupath.model.RegistroAcademico;

import java.util.List;

public interface IAlumnoRepository {
    Alumno buscarPorLegajo(String legajo);
    List<RegistroAcademico> obtenerRegistros(String legajo);
}
