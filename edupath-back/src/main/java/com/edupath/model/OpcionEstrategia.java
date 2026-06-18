package com.edupath.model;

public class OpcionEstrategia {
    private String tipo;
    private String nombre;
    private String riesgo;
    private String descripcion;
    private String fechaEgresoEstimada;

    public OpcionEstrategia(String tipo, String nombre, String riesgo, String descripcion, String fechaEgresoEstimada) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.riesgo = riesgo;
        this.descripcion = descripcion;
        this.fechaEgresoEstimada = fechaEgresoEstimada;
    }

    public String getTipo() { return tipo; }
    public String getNombre() { return nombre; }
    public String getRiesgo() { return riesgo; }
    public String getDescripcion() { return descripcion; }
    public String getFechaEgresoEstimada() { return fechaEgresoEstimada; }
}
