package com.edupath.service;

import com.edupath.model.Recomendacion;
import org.springframework.stereotype.Service;

@Service
public class GeneradorPDF {

    public void generarPDF(Recomendacion recomendacion) {
        // Placeholder: aquí se integraría iText o JasperReports
        System.out.println("Generando PDF con " + recomendacion.getMaterias().size() + " materias.");
        System.out.println("Egreso estimado: " + recomendacion.getFechaEgresoEstimada());
    }
}
