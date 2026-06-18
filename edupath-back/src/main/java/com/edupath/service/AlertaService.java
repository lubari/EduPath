package com.edupath.service;

import com.edupath.model.Alerta;
import com.edupath.model.Alumno;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlertaService {

    public List<Alerta> getAlertas(Alumno alumno) {
        List<Alerta> alertas = new ArrayList<>();

        boolean tieneDesaprobadas = alumno.getRegistros().stream()
                .anyMatch(r -> r.getEstado().getNombre().equals("Desaprobada"));

        if (tieneDesaprobadas) {
            alertas.add(new Alerta("danger",
                    "Tenés materias desaprobadas. Recomendamos recursarlas antes de avanzar."));
        }

        alumno.getMateriasDisponibles().forEach(m -> {
            if (!m.getCorrelativas().isEmpty()) {
                alertas.add(new Alerta("warning",
                        "Para cursar " + m.getNombre() + " necesitás tener aprobadas sus correlativas."));
            }
        });

        alertas.add(new Alerta("info", "Tu última sincronización con el sistema UADE fue hace 6 días."));

        return alertas;
    }
}
