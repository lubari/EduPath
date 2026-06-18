package com.edupath.adapter;

import com.edupath.interfaces.IAlumnoRepository;
import com.edupath.model.Alumno;
import com.edupath.model.RegistroAcademico;
import com.edupath.service.SistemaUadeAPI;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UADEAdapter implements IAlumnoRepository {

    private final SistemaUadeAPI cliente;

    public UADEAdapter(SistemaUadeAPI cliente) {
        this.cliente = cliente;
    }

    @Override
    public Alumno buscarPorLegajo(String legajo) {
        return cliente.getHistorialAlumno(legajo);
    }

    @Override
    public List<RegistroAcademico> obtenerRegistros(String legajo) {
        return cliente.getRegistrosAlumno(legajo);
    }
}
