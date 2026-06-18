package com.edupath.state;

import com.edupath.interfaces.IEstado;

public class EstadoDesaprobada implements IEstado {
    @Override
    public boolean estaAprobada() { return false; }

    @Override
    public String getNombre() { return "Desaprobada"; }
}
