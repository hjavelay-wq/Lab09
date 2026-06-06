package com.ucv.labt09;

import java.io.Serializable;

public abstract class Estudiante implements Serializable, IDescuentos {

    private static final long serialVersionUID = 1L;

    private String codigo;
    private String apellidos;
    private String nombres;
    private String semestreIngreso;

    public Estudiante() {}

    public Estudiante(String codigo, String apellidos, String nombres, String semestreIngreso) {
        this.codigo = codigo;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.semestreIngreso = semestreIngreso;
    }

    // Getters y Setters
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public String getNombres() { return nombres; }
    public void setNombres(String nombres) { this.nombres = nombres; }

    public String getSemestreIngreso() { return semestreIngreso; }
    public void setSemestreIngreso(String s) { this.semestreIngreso = s; }

    // Métodos abstractos
    public abstract double pagoParcialPension();
    public abstract double descuentos();

    // Método concreto
    public double pagoFinalPension() {
        return pagoParcialPension() - descuentos();
    }
}