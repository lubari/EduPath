package com.edupath.service;

import com.edupath.model.*;
import com.edupath.state.EstadoAprobada;
import com.edupath.state.EstadoCursando;
import com.edupath.state.EstadoDesaprobada;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SistemaUadeAPI {

    private final Map<String, Alumno> historial;

    public SistemaUadeAPI() {
        this.historial = Map.of("123456", crearAlumnoJuanPerez());
    }

    public Alumno getHistorialAlumno(String id) {
        Alumno alumno = historial.get(id);
        if (alumno == null) throw new RuntimeException("Alumno " + id + " no encontrado en UADE");
        return alumno;
    }

    public List<RegistroAcademico> getRegistrosAlumno(String id) {
        return getHistorialAlumno(id).getRegistros();
    }

    // -----------------------------------------------------------------------
    // Mock: simula los datos que devolvería el WebCampus de UADE
    // -----------------------------------------------------------------------

    private Alumno crearAlumnoJuanPerez() {
        Materia is101 = new Materia("IS-101", "Análisis Matemático I",        64, List.of(),                         1, "aprobada");
        Materia is102 = new Materia("IS-102", "Programación I",               64, List.of(),                         1, "aprobada");
        Materia is103 = new Materia("IS-103", "Inglés I",                     32, List.of(),                         1, "aprobada");
        Materia is201 = new Materia("IS-201", "Análisis Matemático II",       64, List.of(is101),                    2, "aprobada");
        Materia is202 = new Materia("IS-202", "Programación II",              64, List.of(is102),                    2, "aprobada");
        Materia is203 = new Materia("IS-203", "Base de Datos",                64, List.of(is202),                    2, "aprobada");
        Materia is204 = new Materia("IS-204", "Sistemas y Organizaciones",    48, List.of(),                         2, "desaprobada");
        Materia is301 = new Materia("IS-301", "Arquitectura de Software",     64, List.of(is203),                    3, "disponible");
        Materia is302 = new Materia("IS-302", "Programación III",             64, List.of(is202),                    3, "disponible");
        Materia is303 = new Materia("IS-303", "Probabilidad y Estadística",   64, List.of(is201),                    3, "disponible");
        Materia is304 = new Materia("IS-304", "Inglés IV",                    32, List.of(is103),                    3, "disponible");
        Materia is305 = new Materia("IS-305", "Redes II",                     64, List.of(is203),                    3, "disponible");
        Materia is401 = new Materia("IS-401", "Ingeniería de Requerimientos", 48, List.of(is301, is303, is204),      4, "disponible");
        Materia is402 = new Materia("IS-402", "Proyecto Final",               96, List.of(is301, is302, is305, is401), 4, "proxima");

        PlanEstudio plan  = new PlanEstudio("IS-2020", 2020,
                List.of(is101,is102,is103,is201,is202,is203,is204,is301,is302,is303,is304,is305,is401,is402));
        Carrera carrera   = new Carrera("IS", 2020, "Ingeniería en Sistemas", plan);

        List<RegistroAcademico> registros = List.of(
                new RegistroAcademico(is101, "1C2023", 9, new EstadoAprobada()),
                new RegistroAcademico(is102, "1C2023", 8, new EstadoAprobada()),
                new RegistroAcademico(is103, "1C2023", 7, new EstadoAprobada()),
                new RegistroAcademico(is201, "2C2023", 8, new EstadoAprobada()),
                new RegistroAcademico(is202, "2C2023", 9, new EstadoAprobada()),
                new RegistroAcademico(is203, "1C2024", 8, new EstadoAprobada()),
                new RegistroAcademico(is204, "1C2024", 3, new EstadoDesaprobada()),
                new RegistroAcademico(is301, "2C2024", 0, new EstadoCursando())
        );

        return new Alumno("123456", "Juan Pérez", 7.9, carrera, registros);
    }
}
