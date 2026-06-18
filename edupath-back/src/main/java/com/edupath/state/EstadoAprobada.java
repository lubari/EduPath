package com.edupath.state;

import com.edupath.interfaces.IEstado;

public class EstadoAprobada implements IEstado {
    @Override
    public boolean estaAprobada() { return true; }

    @Override
    public String getNombre() { return "Aprobada"; }
}
