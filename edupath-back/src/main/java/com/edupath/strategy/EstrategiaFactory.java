package com.edupath.strategy;

import com.edupath.interfaces.IEstrategiaRecomendacion;

public class EstrategiaFactory {

    public static IEstrategiaRecomendacion crear(String tipo) {
        return switch (tipo) {
            case "rapida"  -> new EstrategiaCursadaRapida();
            case "minima"  -> new EstrategiaCursadaMinima();
            case "porAnio" -> new EstrategiaMateriasPorAnio();
            default -> throw new IllegalArgumentException("Estrategia desconocida: " + tipo);
        };
    }
}
