package com.edupath.model;

public class Alerta {
    private String tipo;
    private String mensaje;

    public Alerta(String tipo, String mensaje) {
        this.tipo = tipo;
        this.mensaje = mensaje;
    }

    public String getTipo() { return tipo; }
    public String getMensaje() { return mensaje; }
}
